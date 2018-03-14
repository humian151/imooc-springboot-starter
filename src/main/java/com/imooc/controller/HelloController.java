package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    Resource resource;

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(){
        return "hello imooc";
    }
    @RequestMapping("/getResource")
    @ResponseBody
    public IMoocJSONResult getResource(){
        IMoocJSONResult bean = new IMoocJSONResult();
        BeanUtils.copyProperties(resource,bean);
        return IMoocJSONResult.ok(bean);
    }
}
