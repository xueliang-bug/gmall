package com.xl.gmall.user.service.impl;

import com.xl.gmall.user.bean.UserMemberlevel;
import com.xl.gmall.user.mapper.UserMapperlevel;
import com.xl.gmall.user.service.UserlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 10:05
 * @Description: com.xl.gmall.user.service.impl
 * @version: 1.0
 */
@Service
public class UserlevelServiceImpl  implements UserlevelService {
    @Autowired
    private UserMapperlevel userMapperlevel;

    /**
     * 查询所有UserMemberlevel
     * @return
     */
    @Override
    public List<UserMemberlevel> findalluserlevel() {
        List<UserMemberlevel> userMemberlevels = userMapperlevel.selectAll();
        return userMemberlevels;
    }

    /**
     * 添加
     * @param userMemberlevel
     * @return
     */
    @Override
    public UserMemberlevel addUserMemberlevel(UserMemberlevel userMemberlevel) {
        return userMapperlevel.addUserMemberlevel(userMemberlevel);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteUserlevelMemberById(int id) {
    userMapperlevel.deleteUserlevelMemberById(id);
    }

    /**
     * 修改
     * @param userMemberlevel
     * @return
     */
    @Override
    public UserMemberlevel updateuserlevelmember(UserMemberlevel userMemberlevel) {
        return userMapperlevel.updateuserlevelmember(userMemberlevel);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public UserMemberlevel findUserMemberById(int id) {
        return userMapperlevel.findUserlevelMemberById(id);
    }
}
