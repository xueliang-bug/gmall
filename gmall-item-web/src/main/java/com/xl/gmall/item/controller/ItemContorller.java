package com.xl.gmall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2020/6/10 17:31
 * @Description: com.xl.gmall.item.controller
 * @version: 1.0
 */
@Controller
public class ItemContorller {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
