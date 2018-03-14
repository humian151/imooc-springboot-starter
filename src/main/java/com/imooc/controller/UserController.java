package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        User u = new User();
        u.setName("imooc2");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("imooc2");
        u.setDesc(null);

        return u;
    }

    @RequestMapping("/getUserJson")
    public IMoocJSONResult getUserJson() {

        User u = new User();
        u.setName("imooc");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPassword("imooc");
        u.setDesc("hello imooc~~hello imooc~~");

        return IMoocJSONResult.ok(u);
    }

}
