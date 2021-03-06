package com.heeexy.example.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.util.constants.ErrorEnum;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: hxy
 * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 * @date: 2017/10/24 10:11
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", ErrorEnum.E_20011.getErrorCode());
        jsonObject.put("returnMsg", ErrorEnum.E_20011.getErrorMsg());
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return true;
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String guide = req.getRequestURI();
//        if(guide.contains("gs-guide-websocket")){
//            HttpServletResponse res = (HttpServletResponse) response;
//            res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
//            res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//            res.setHeader("Access-Control-Max-Age", "3600");
//            res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
//            res.setHeader("Access-Control-Allow-Credentials", "true");
//        }

        HttpServletResponse res = (HttpServletResponse) response;
//        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setHeader("Access-Control-Allow-Methods", "*");
//        res.setHeader("Access-Control-Max-Age", "0");
//        res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
//        res.setHeader("Access-Control-Allow-Credentials", "true");
//        res.setHeader("XDomainRequestAllowed","1");

        return super.onPreHandle(request, response, mappedValue);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        System.out.println(request);
//        HttpServletRequest req = (HttpServletRequest) request;
//        String guide = req.getRequestURI();
//        if(guide.contains("gs-guide-websocket")){
//            return true;
//        }

        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }

            String URL = ((HttpServletRequest)request).getRequestURI();
            if(URL.contains("ueditor") || URL.contains("AgAlarm")) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Bean
    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
