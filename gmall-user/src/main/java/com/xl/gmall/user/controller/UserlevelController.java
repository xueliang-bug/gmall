package com.xl.gmall.user.controller;

import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.bean.UserMemberlevel;
import com.xl.gmall.user.service.UserlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 10:12
 * @Description: com.xl.gmall.user.controller
 * @version: 1.0
 */
@Controller
public class UserlevelController {
    @Autowired
    private UserlevelService userlevelService;

    /**
     * 查询所有UserMemberlevel
     * @return
     */
    @RequestMapping("findFallUserlevel")
    @ResponseBody
    public List<UserMemberlevel> findFallUserlevel(){
        List<UserMemberlevel> findalluserlevel = userlevelService.findalluserlevel();
        return findalluserlevel;
    }

}
