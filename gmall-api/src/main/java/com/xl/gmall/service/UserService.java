package com.xl.gmall.service;

import com.xl.gmall.bean.UmsMemberReceiveAddress;

import com.xl.gmall.bean.UmsMember;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:00
 * @Description: com.xl.gmall.user.service
 * @version: 1.0
 */
public interface UserService {
    //查询所有UserMember
    List<UmsMember> findalluser();
    /**
     * 添加UserMember
     * @param userMember
     * @return
     */
    UmsMember addusermember(UmsMember userMember);

    /**
     * 删除
     * @param id
     * @return
     */
    void deleteUserMemberById(int id);

    /**
     * 修改
     * @param userMember
     * @return
     */
    UmsMember updateusermember(UmsMember userMember);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UmsMember findUserMemberById(int id);
    //查询UmsMemberReceiveAddress
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
