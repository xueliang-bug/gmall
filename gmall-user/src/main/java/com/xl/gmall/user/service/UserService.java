package com.xl.gmall.user.service;

import com.xl.gmall.user.bean.UmsMemberReceiveAddress;
import com.xl.gmall.user.bean.UserMember;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:00
 * @Description: com.xl.gmall.user.service
 * @version: 1.0
 */
public interface UserService {
    //查询所有UserMember
    List<UserMember> findalluser();
    /**
     * 添加UserMember
     * @param userMember
     * @return
     */
    UserMember addusermember(UserMember userMember);

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
    UserMember updateusermember(UserMember userMember);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserMember findUserMemberById(int id);
    //查询UmsMemberReceiveAddress
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
