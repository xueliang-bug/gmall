package com.xl.gmall.user.controller;

import com.xl.gmall.user.bean.UmsMemberReceiveAddress;
import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 15:28
 * @Description: com.xl.gmall.user.controller
 * @version: 1.0
 */
@Controller
public class UmsMemberReceiveAddressController {
    @Autowired
    UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("allUmsMemberReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> allUmsMemberReceiveAddress() {
        List<UmsMemberReceiveAddress> allUmsMemberReceiveAddress = umsMemberReceiveAddressService.findAllUmsMemberReceiveAddress();
        return allUmsMemberReceiveAddress;
    }

    /**
     * 添加
     * @param ums
     */
    @RequestMapping("addUmsMemberReceiveAddress")
    @ResponseBody
    public void addUmsMemberReceiveAddress(UmsMemberReceiveAddress ums) {
        umsMemberReceiveAddressService.insertUmsMemberReceiveAddress(ums);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("deleteUmsMemberReceiveAddress")
    @ResponseBody
    public void deleteUmsMemberReceiveAddress(int id) {
        umsMemberReceiveAddressService.deleteUmsMemberReceiveAddress(id);
    }

    /**
     * 修改
     * @param ums
     */
    @RequestMapping("updateUmsMemberReceiveAddress")
    @ResponseBody
    public void updatUmsMemberReceiveAddress( UmsMemberReceiveAddress ums){
         umsMemberReceiveAddressService.updateUmsMemberReceiveAddress(ums);
    }

    /**
     * 根据id查询
     * @param id
     */
    @RequestMapping("findFallByIdUmsMemberReceiveAddress")
    @ResponseBody
    public void findFallByIdUmsMemberReceiveAddress(int id) {
        umsMemberReceiveAddressService.findByIdUmsMemberReceiveAddress(id);
    }
}
