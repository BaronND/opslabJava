package com.opslab.mybatis.mapper;

import com.opslab.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 定义UserInfo的dao操作接口
 */
public interface IUserInfoMapper {
    @Select("select * from t_userinfo where id=#{id}")
    UserInfo getUserInfoById(String id);

    @Select("select * from t_userinfo")
    List<UserInfo> userInfoAll();

    @Update("update t_userinfo set nick = #{nick} where id=#{id}")
    int changeNick(UserInfo userInfo);
}
