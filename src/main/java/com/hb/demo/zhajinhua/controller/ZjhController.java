package com.hb.demo.zhajinhua.controller;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.service.ZjhService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller请求
 *
 * @author biao_huang
 * @since 2021/08/16
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class ZjhController {

    @Autowired
    ZjhService zjhService;

    @GetMapping("/get")
    public String getTest() {
        //玩家获取手牌
        PersonBO p2 = new PersonBO("蒋其");
        PersonBO p3 = new PersonBO("徐荣");
        PersonBO p4 = new PersonBO("曾翔");
        PersonBO[] personBOS = zjhService.getCard(p2, p3, p4);
        //比较大小
        List<PersonBO> winner = zjhService.winner(personBOS);
        zjhService.addMoney(winner);
        log.info("winner====={}", winner);
        return JSON.toJSONString(winner);
    }

}
