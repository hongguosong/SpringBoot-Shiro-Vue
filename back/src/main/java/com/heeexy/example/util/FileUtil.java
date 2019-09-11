package com.heeexy.example.util;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.util </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/9/11 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.heeexy.example.config.exception.CommonJsonException;
import com.heeexy.example.util.constants.ErrorEnum;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class.getName());

    /**
     * 创建临时文件
     * @param basePath
     * @return
     */
    public static File createTmpFile(String basePath) throws CommonJsonException{
        File fileTmp = null;
        try{
            fileTmp = new File(basePath + "/temp.txt");
            if(!fileTmp.exists()){
                fileTmp.createNewFile();
                BufferedWriter buf = new BufferedWriter(new FileWriter(fileTmp));
                buf.write("文件不存在");
                buf.flush();
            }
        } catch (IOException e) {
            LOGGER.error("", e);
            throw new CommonJsonException(ErrorEnum.E_400);
        }
        return fileTmp;
    }

    /**
     * 下载文件
     * @param file
     * @param fileName
     * @param request
     * @param response
     * @throws CommonJsonException
     */
    public static void download(File file, String fileName, HttpServletRequest request, HttpServletResponse response) throws CommonJsonException {
        if(file == null || !file.exists()){
            throw new CommonJsonException(ErrorEnum.E_400);
        }

        try{
            // 中文文件名支持
            String encodeFileName = null;
            String userAgent = request.getHeader("User-Agent");
            if(null != userAgent && -1 != userAgent.indexOf("MSIE")){
                encodeFileName = URLEncoder.encode(fileName, "UTF-8");
            } else if(null != userAgent && -1 != userAgent.indexOf("Mozilla")) {
                encodeFileName = new String(fileName.getBytes("UTF-8"));
            } else {
                encodeFileName = URLEncoder.encode(fileName, "UTF-8");
            }
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", encodeFileName));

            //下载文件
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int byteRead = 0;
            byte[] buffer = new byte[8192];
            while((byteRead = bufferedInputStream.read(buffer, 0, 8192)) != -1){
                bufferedOutputStream.write(buffer, 0, byteRead);
            }
            bufferedOutputStream.flush();
            fileInputStream.close();
            bufferedInputStream.close();
            outputStream.close();
            bufferedOutputStream.close();
        }catch (IOException e){
            LOGGER.error("", e);
        }
    }

    /**
     * 删除文件夹
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir == null) {
            return false;
        }
        if (dir.isDirectory()) {
            File[] childrens = dir.listFiles();
            for(File children: childrens) {
                if(!deleteDir(children)) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 打开文件，而不是选择保存
     * @param currFile
     * @param response
     */
    public static void writeFileToResponse(File currFile, HttpServletResponse response) {
        try {
            String fileDisplay = currFile.getAbsolutePath();
            String type = getContentType(fileDisplay);
            response.setHeader("Content-type", type);
            if(type != null){
                if(type.equals("text/plain")){
                    response.setCharacterEncoding("UTF-8");
                }
            }
            response.setHeader("Content-Length", String.valueOf(currFile.length()));
            InputStream in = new FileInputStream(currFile);
            IOUtils.copy(in, response.getOutputStream());
            response.setStatus(HttpStatus.OK.value());
        } catch (IOException e) {
            LOGGER.error("", e);
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }

    /**
     * 获取图片
     * @param currFile
     * @param response
     * @param suffix
     */
    public static void writeImgToresponse(File currFile, HttpServletResponse response, String suffix) {
        try {
            String fileDispaly = currFile.getAbsolutePath();
            fileDispaly = fileDispaly.substring(fileDispaly.lastIndexOf(File.separator) + 1);
            fileDispaly = URLEncoder.encode(fileDispaly, "UTF-8");

            InputStream in = new FileInputStream(currFile);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileDispaly);
            response.setHeader("Content-type", "image/" + suffix);
            response.setHeader("Content-Length", String.valueOf(currFile.length()));
            response.setStatus(HttpStatus.OK.value());
            IOUtils.copy(in, response.getOutputStream());
            in.close();
            response.flushBuffer();
        } catch (IOException e) {
            LOGGER.error("", e);
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
    }

    /**
     * 把指定的内容追加到文件
     * @param path
     * @param content
     * @param append
     * @param encode
     * @throws IOException
     */
    public static void createFileByContent(String path, String content, boolean append, String encode) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file, append);
        out.write(content.getBytes(encode));
        out.close();
    }

    /**
     * 以字符串的形式读取文件内容
     * @param path
     * @param encode
     * @return
     * @throws IOException
     */
    public static String readFileByStringAndEncode(String path, String encode) throws IOException {
        File file = new File(path);
        if(!file.exists()) {
            throw new FileNotFoundException();
        }
        FileInputStream in = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, encode));
        StringBuffer stringBuffer = new StringBuffer();
        String tempStr = null;
        while ((tempStr = bufferedReader.readLine()) != null) {
            stringBuffer.append(tempStr + "\r\n");
        }
        bufferedReader.close();
        in.close();
        return stringBuffer.toString();
    }

    public static String getFileName(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int index = fileName.lastIndexOf("\\");
        if(index >= 0){
            fileName = fileName.substring(index + 1);
        }
        index = fileName.lastIndexOf("/");
        if(index >= 0){
            fileName = fileName.substring(index + 1);
        }
        return fileName;
    }

    /**
     * 获取文件mime类型
     * @param filePath
     * @return
     */
    public static String getContentType(String filePath) {
        Path path = Paths.get(filePath);
        String type = null;
        try {
            type = Files.probeContentType(path);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return type;
    }
}
