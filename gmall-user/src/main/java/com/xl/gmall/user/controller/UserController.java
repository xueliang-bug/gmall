package com.xl.gmall.user.controller;

import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 16:59
 * @Description: com.xl.gmall.user.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询UserMember
     * @return
     */
    @RequestMapping("findFallUser")
    @ResponseBody
    public List<UserMember> findFallUser(){
     List<UserMember> userMembers =userService.findalluser();
        return userMembers;
    }



    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
