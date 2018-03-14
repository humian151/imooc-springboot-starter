package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class IMoocExceptionHandler {
    public static final String IMOOC_ERROR_VIEW = "error";

    /*@ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                    Exception e) throws Exception{
        e.printStackTrace();
        ModelAndView mv = new ModelAndView();
       mv.addObject("exception",e);
       mv.addObject("url",request.getRequestURL());
       mv.setViewName(IMOOC_ERROR_VIEW);
       return mv;

    }*/
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                   Exception e) throws Exception{
        if(isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        }else {
            e.printStackTrace();
            ModelAndView mv = new ModelAndView();
            mv.addObject("exception",e);
            mv.addObject("url",request.getRequestURL());
            mv.setViewName(IMOOC_ERROR_VIEW);
            return mv;
        }


    }

    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.exception
     * @Description: 判断是否是ajax请求
     * Copyright: Copyright (c) 2017
     * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
     *
     * @author leechenxiang
     * @date 2017年12月3日 下午1:40:39
     * @version V1.0
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
