package com.hb.demo.zhajinhua.mapper;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.ZhajinhuaApplication;
import com.hb.demo.zhajinhua.po.UserInfoPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = ZhajinhuaApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class mapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void selTest(){
        UserInfoPO userInfoPO = new UserInfoPO();
        //userInfoPO.setUid(1);
        List <UserInfoPO> userInfoPOS = userInfoMapper.selUserInfoList(userInfoPO);
        log.info("查询测试结果===="+JSON.toJSONString(userInfoPOS.get(userInfoPOS.size()-1).getCreateTime()));
    }

    @Test
    public void addTest(){
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUid(1);
        userInfoPO.setName("李四");
        userInfoPO.setIntegral(0);
        int result = userInfoMapper.addUserInfo(userInfoPO);
        log.info("查询测试结果===="+JSON.toJSONString(userInfoPO.getUid()));
    }
}
