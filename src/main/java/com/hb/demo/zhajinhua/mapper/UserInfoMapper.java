package com.hb.demo.zhajinhua.mapper;

import com.hb.demo.zhajinhua.base.BaseMapper;
import com.hb.demo.zhajinhua.po.UserInfoPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {

    List<UserInfoPO> selUserByNameANdPwd(@Param("name")String name, @Param("password")String password);

}
