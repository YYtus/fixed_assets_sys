package com.thundersoft.fixed_assets_sys.mapper;


import com.thundersoft.fixed_assets_sys.entity.Fixed_assets_authority;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface authorityMapper {

    @Select("select * from fixed_assets_authority where a_id in(\n" +
            "select a_id from `fixed_assets_role&authority` where r_id in(\n" +
            "select r_id from `fixed_assets_user&role` where u_id =(\n" +
            "select u_id from fixed_assets_user where u_username = #{username})))")
    List<Fixed_assets_authority> findAuthorityByCurrentUser(String username);


    @Select("select * from fixed_assets_authority where a_id in(\n" +
            "select a_id from `fixed_assets_role&authority` where r_id in( \n" +
            "select r_id from `fixed_assets_user&role` where u_id =(\n" +
            "select u_id from fixed_assets_user where u_username = #{username} and a_parent = #{parentId})))")
    List<Fixed_assets_authority> findAuthorityByA_parent(@Param("parentId") Integer parentId, @Param("username") String username);

}
