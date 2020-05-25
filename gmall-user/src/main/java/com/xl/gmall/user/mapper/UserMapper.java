package com.xl.gmall.user.mapper;

import com.xl.gmall.user.bean.UserMember;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/5/21 17:03
 * @Description: com.xl.gmall.user.mapper
 * @version: 1.0
 */
@Primary
public interface UserMapper extends Mapper<UserMember> {
    /**
     * UserMember查询所有
     * @return
     */
    List<UserMember>  selectalluser();

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
    UserMember deleteUserMemberById(int id);

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

}
