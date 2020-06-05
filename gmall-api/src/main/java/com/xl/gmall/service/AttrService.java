package com.xl.gmall.service;

import com.xl.gmall.bean.PmsBaseAttrInfo;
import com.xl.gmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/6/5 10:58
 * @Description: com.xl.gmall.service
 * @version: 1.0
 */
public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);
}
