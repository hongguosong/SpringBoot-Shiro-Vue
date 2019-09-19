package com.heeexy.example.ueditor.upload;

import com.heeexy.example.ueditor.PathFormat;
import com.heeexy.example.ueditor.define.BaseState;
import com.heeexy.example.ueditor.define.FileType;
import com.heeexy.example.ueditor.define.State;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinaryUploader {
    private static Logger log = LoggerFactory.getLogger(BinaryUploader.class);
    public static final State save(HttpServletRequest request, Map<String, Object> conf) {

        FileItemStream fileStream = null;
        boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, 5);
        }

        ServletFileUpload upload = new ServletFileUpload(
                new DiskFileItemFactory());

        if (isAjaxUpload) {
            upload.setHeaderEncoding("UTF-8");
        }
        try {

//            // 创建 list容器用来保存 表单中的所有数据信息
//            List<FileItem> items = new ArrayList<FileItem>();
//
//            // 将表单中的所有数据信息放入 list容器中
//            try {
//                items = upload.parseRequest(request);
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            }
//
//            // 遍历 list容器，处理 每个数据项 中的信息
//            for (FileItem item : items) {
//                // 判断是否是普通项
//                if (item.isFormField()) {
//                    // 处理 普通数据项 信息
//                    //handleFormField(item);
//                    log.info(item.getName());
//                } else {
//                    // 处理 文件数据项 信息
//                    //handleFileField(item);
//                    log.info(item.getName());
//                }
//            }
//
            FileItemIterator iterator = upload.getItemIterator(request);

            while (iterator.hasNext()) {
                fileStream = iterator.next();

                if (!fileStream.isFormField())
                    break;
                fileStream = null;
            }

//            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//            MultipartFile file = multipartRequest.getFile("upfile");

            if (fileStream == null) {
                return new BaseState(false, 7);
            }

            String savePath = (String) conf.get("savePath");
            String originFileName = fileStream.getName();
            String suffix = FileType.getSuffixByFilename(originFileName);

            originFileName = originFileName.substring(0,
                    originFileName.length() - suffix.length());
            savePath = savePath + suffix;

            long maxSize = ((Long) conf.get("maxSize")).longValue();

            if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
                return new BaseState(false, 8);
            }

            savePath = PathFormat.parse(savePath, originFileName);

            String physicalPath = (String) conf.get("rootPath") + savePath;

            InputStream is = fileStream.openStream();
            State storageState = StorageManager.saveFileByInputStream(is,
                    physicalPath, maxSize);
            is.close();

            if (storageState.isSuccess()) {
                storageState.putInfo("url", PathFormat.format(savePath));
                storageState.putInfo("type", suffix);
                storageState.putInfo("original", originFileName + suffix);
            }

            return storageState;
        }
        catch (FileUploadException e) {
            log.error(e.getMessage());
            return new BaseState(false, 6);

        }
        catch (IOException localIOException) {
            log.error(localIOException.getMessage());
        }
        return new BaseState(false, 4);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}