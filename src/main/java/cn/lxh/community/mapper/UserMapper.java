package cn.lxh.community.mapper;

import cn.lxh.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,avatar_url) values (" +
            "#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer creator);
}
