package com.xl.gmall.user.controller;

import com.xl.gmall.bean.UmsMember;
import com.xl.gmall.bean.UmsMemberReceiveAddress;
import com.xl.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    UserService userService;

    /**
     * 通用mapper的条件查询
     * @param memberId
     * @return
     */
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses  = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses ;
    }
    /**
     * 查询UserMember
     *
     * @return
     */
    @RequestMapping("findFallUser")
    @ResponseBody
    public List<UmsMember> findFallUser() {
        List<UmsMember> userMembers = userService.findalluser();
        return userMembers;
    }

    /**
     * 添加
     *
     * @param userMember
     * @return
     */
    @RequestMapping("addUserMember")
    @ResponseBody
    public void addUserMember(UmsMember userMember) {
        userService.addusermember(userMember);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("deleteUserMember")
    @ResponseBody
    public void deleteUserMember(int id) {
       userService.deleteUserMemberById(id);
    }
    /**
     * 修改
     * @param userMember
     * @return
     */
    @RequestMapping("updateusermember")
    @ResponseBody
   public UmsMember updateusermember( UmsMember userMember){
       return userService.updateusermember(userMember);
   }

    /**
     * 根据id查询
     * @param id
     */

    @RequestMapping("findFallByIdUser")
    @ResponseBody
    public void findFallByIdUser(int id) {
       userService.deleteUserMemberById(id);
    }


    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }
}
