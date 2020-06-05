package com.xl.gmall.user.mapper;

import com.xl.gmall.bean.UmsMemberReceiveAddress;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 14:14
 * @Description: com.xl.gmall.user.mapper
 * @version: 1.0
 */
public interface UmsMemberReceiveAddressMapper extends Mapper<UmsMemberReceiveAddress> {
    //删除
    UmsMemberReceiveAddress deleteById(int id);
    //修改
    void updateUmsMemberReceiveAddress(UmsMemberReceiveAddress ums);
    //id查询
    UmsMemberReceiveAddress findByIdUmsMemberReceiveAddress(int id);
}
