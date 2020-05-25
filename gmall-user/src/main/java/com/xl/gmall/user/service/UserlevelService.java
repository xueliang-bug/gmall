package com.xl.gmall.user.service;

import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.bean.UserMemberlevel;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 10:03
 * @Description: com.xl.gmall.user.service
 * @version: 1.0
 */
public interface UserlevelService {
    //查询所有UserMemberlevel
    List<UserMemberlevel> findalluserlevel();
    //添加
    UserMemberlevel addUserMemberlevel(UserMemberlevel userMemberlevel);
    //删除
    void deleteUserlevelMemberById(int id);
    //修改
    UserMemberlevel updateuserlevelmember(UserMemberlevel userMemberlevel);
    //根据id查询
    UserMemberlevel findUserMemberById(int id);
}
