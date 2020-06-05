package com.xl.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xl.gmall.bean.PmsBaseAttrInfo;
import com.xl.gmall.bean.PmsBaseAttrValue;
import com.xl.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 10:43
 * @Description: com.xl.gmall.manage
 * @version: 1.0
 */
@Controller
@CrossOrigin
public class Attrcontroller {
    @Reference
    AttrService attrService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo>  pmsBaseAttrInfoList=  attrService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfoList;
    }

    /**
     * 添加商品属性值
     * @param pmsBaseAttrInfo
     * @return
     */
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
     String success= attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }
    /**
     * 修改商品属性值
     * @param attrId
     * @return
     */
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue>  pmsBaseAttrValueList=  attrService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;
    }
}
