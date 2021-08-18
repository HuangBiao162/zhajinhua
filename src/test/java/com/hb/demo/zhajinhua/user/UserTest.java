package com.hb.demo.zhajinhua.user;

import com.hb.demo.zhajinhua.BaseTest;
import com.hb.demo.zhajinhua.service.impl.UserServiceImpl;
import com.hb.demo.zhajinhua.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserTest extends BaseTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void userRegist(){
        UserInfoVO userInfoVO = UserInfoVO.builder().name("李四").password("123456").build();
        log.info("玩家注册结果：{}",userService.registUser(userInfoVO));
    }
    @Test
    public void loginUser(){
        UserInfoVO userInfoVO = UserInfoVO.builder().name("李四").password("123456").build();
        log.info("玩家登录结果：{}",userService.loginUser(userInfoVO));
    }
}
