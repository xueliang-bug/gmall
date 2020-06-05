package com.xl.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xl.gmall.bean.PmsProductInfo;
import com.xl.gmall.service.PmsProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 16:20
 * @Description: com.xl.gmall.manage.controller
 * @version: 1.0
 */
@Controller
@CrossOrigin
public class Spucontrller {

    @Reference
    PmsProductService pmsProductService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> pmsProductInfos = pmsProductService.spuList(catalog3Id);
        return pmsProductInfos;
    }
}
