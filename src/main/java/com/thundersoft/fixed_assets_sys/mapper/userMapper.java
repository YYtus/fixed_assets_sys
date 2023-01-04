package com.thundersoft.fixed_assets_sys.mapper;

import com.thundersoft.fixed_assets_sys.entity.Fixed_assets_User;
import org.apache.ibatis.annotations.Select;

public interface userMapper {
    @Select("select * from fixed_assets_user where u_username=#{username}")
    public Fixed_assets_User findUserByUserName(String username);
}
