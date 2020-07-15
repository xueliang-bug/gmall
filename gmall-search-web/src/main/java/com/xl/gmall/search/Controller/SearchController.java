package com.xl.gmall.search.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2020/7/14 15:04
 * @Description: com.xl.gmall.search.Controller
 * @version: 1.0
 */
@Controller
public class SearchController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
