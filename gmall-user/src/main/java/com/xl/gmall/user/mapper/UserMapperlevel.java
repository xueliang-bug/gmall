package com.xl.gmall.user.mapper;

import com.xl.gmall.user.bean.UserMember;
import com.xl.gmall.user.bean.UserMemberlevel;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/25 10:02
 * @Description: com.xl.gmall.user.mapper
 * @version: 1.0
 */
@Primary
public interface UserMapperlevel extends Mapper<UserMemberlevel> {
    /**
     * 查询所有UserMemberlevel
     */
    List<UserMemberlevel> selectalluserlevel();

    /**
     * 添加UserMember
     * @param userMemberlevel
     * @return
     */
    UserMemberlevel addUserMemberlevel(UserMemberlevel userMemberlevel);
    /**
     * 删除
     * @param id
     * @return
     */
    void deleteUserlevelMemberById(int id);
    /**
     * 修改
     * @param userMemberlevel
     * @return
     */
    UserMemberlevel updateuserlevelmember(UserMemberlevel userMemberlevel);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserMemberlevel findUserlevelMemberById(int id);
}
