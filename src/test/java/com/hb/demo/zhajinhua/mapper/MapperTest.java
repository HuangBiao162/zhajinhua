package com.hb.demo.zhajinhua.mapper;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.BaseTest;
import com.hb.demo.zhajinhua.po.UserInfoPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class MapperTest extends BaseTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void selTest() {
        //userInfoPO.setUid(1);
        UserInfoPO userInfoPO = UserInfoPO.builder().build();
        List <UserInfoPO> userInfoPOS = userInfoMapper.selInfoList(userInfoPO);
        log.info("查询测试结果====" + JSON.toJSONString(userInfoPOS.get(userInfoPOS.size() - 1).getCreateTime()));
    }

    @Test
    public void addTest() {
        UserInfoPO userInfoPO = UserInfoPO.builder().uid(1).name("李四").integral(0).build();
        int result = userInfoMapper.addInfo(userInfoPO);
        log.info("查询测试结果====" + JSON.toJSONString(userInfoPO.getUid()));
    }
}
