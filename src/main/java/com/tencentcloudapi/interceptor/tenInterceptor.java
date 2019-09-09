package com.tencentcloudapi.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class tenInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(tenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*try {
            logger.info("获取token----------start，token:{}",request.getParameter("TOKEN"));
            TokenRedis tokenRedis=new TokenRedis();
            TokenVo tokenVo = tokenRedis.checkToken(request.getParameter("TOKEN"), request.getRemoteAddr());
            logger.info("获取token----------end,token:{}",request.getParameter("TOKEN"));
            if (tokenVo != null) {
                TCmpUser tCmpUser = tCmpUserService.selectByPrimaryKey(tokenVo.getId());
                if (!tCmpUser.getLoginName().equals(tokenVo.getName())){
                    logger.info("token:{}验证用户名不一致："+tCmpUser.getId(),request.getParameter("TOKEN"));
                    String result = Jsons.objToJson( new WeChatResult(-2, "token失效", null));
                    printJson(response,result);
                    return false;
                }
                if (tCmpUser.getUserStatus()==0){//用戶状态失效
                    logger.info("token:{}用户状态失效，用户ID："+tCmpUser.getId(),request.getParameter("TOKEN"));
                    String result = Jsons.objToJson( new WeChatResult(-2, "用户状态失效", null));
                    printJson(response,result);
                    return false;
                }else {
                    request.setAttribute("tCmpUser", tCmpUser);
                    return true;
                }
            } else {
                logger.error("token:{}无效",request.getParameter("TOKEN"));
                String result = Jsons.objToJson( new WeChatResult(-2, "token无效", null));
                printJson(response,result);
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            logger.info("校验token:{}异常: "+e.getMessage(),request.getParameter("TOKEN"));
            String result = Jsons.objToJson( new WeChatResult(-2, "校验token异常", null));
            printJson(response,result);
            return false;
        }
    }
    private static void printJson(HttpServletResponse response, String code) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(code);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return true;
    }



        @Override
        public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
        modelAndView) throws Exception {
            super.postHandle(request, response, handler, modelAndView);
        }

        @Override
        public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception
        ex) throws Exception {
            super.afterCompletion(request, response, handler, ex);
        }

        @Override
        public void afterConcurrentHandlingStarted (HttpServletRequest request, HttpServletResponse response, Object
        handler) throws Exception {
            super.afterConcurrentHandlingStarted(request, response, handler);
        }
    }
