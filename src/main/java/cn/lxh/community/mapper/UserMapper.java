package cn.lxh.community.mapper;

import cn.lxh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (" +
            "#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user);

}
