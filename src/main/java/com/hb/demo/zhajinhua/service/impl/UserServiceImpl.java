package com.hb.demo.zhajinhua.service.impl;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.mapper.UserInfoMapper;
import com.hb.demo.zhajinhua.po.UserInfoPO;
import com.hb.demo.zhajinhua.service.UserService;
import com.hb.demo.zhajinhua.util.JSONUtil;
import com.hb.demo.zhajinhua.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;
    private static final JSONUtil<UserInfoPO> jsonUtil = new JSONUtil<>();

    public int registUser(UserInfoVO userInfoVO){
        UserInfoPO userInfoPO = jsonUtil.transClass(UserInfoPO.class, JSON.toJSONString(userInfoVO));
        int result = userInfoMapper.addInfo(userInfoPO);
        log.info("【用户注册】- {}注册{} ", userInfoVO.getName(), result > 0 ? "成功" : "失败");
        return result;
    }

    @Override
    public int loginUser(UserInfoVO userInfoVO) {
        UserInfoPO userInfoPO = jsonUtil.transClass(UserInfoPO.class, JSON.toJSONString(userInfoVO));
        int result = userInfoMapper.selUserByNameANdPwd(userInfoPO.getName(), userInfoVO.getPassword()).size();
        log.info("【用户登录】- {}登录{} ", userInfoVO.getName(), result > 0 ? "成功" : "失败");
        return result;
    }

    @Override
    public PersonBO[] setMaster(int round, PersonBO... personList) {
        //第一回合，随机获取庄
        Random random = new Random();
        int index = random.nextInt(personList.length);
        personList[index].setMaster(1);
        log.info("【设庄】- 当前庄为：{}", JSON.toJSONString(personList[index]));
        return personList;
    }

}
