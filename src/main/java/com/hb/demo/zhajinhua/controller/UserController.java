package com.hb.demo.zhajinhua.controller;

import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户访问层
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/setMaster")
    public PersonBO[] setMaster(int round, PersonBO... personBOS) {
        if (round != 1) {
            log.error("【设庄】- round不为1，设庄失败");
            return personBOS;
        }
        return userService.setMaster(round, personBOS);
    }


}
