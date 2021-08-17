package com.hb.demo.zhajinhua.controller;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.service.ZjhService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * controller请求
 *
 * @author biao_huang
 * @since 2021/08/16
 */
@RestController
@Slf4j
public class ZjhController {

    @Autowired
    ZjhService zjhService;

    /**
     * 发牌
     *
     * @return 结果集
     */
    @PostMapping("/getCard")
    public String getCard(@NotNull PersonBO[] personBOS) {
        PersonBO[] personBOSCards = zjhService.getCard(personBOS);
        log.info("发牌====={}", personBOSCards);
        return JSON.toJSONString(personBOSCards);
    }


    /**
     * 加注
     * 判断是否密牌，仅限第一圈
     *
     * @return 结果集
     */
    @GetMapping("/ante_up")
    public String anteUp() {
        //TODO 加注
        return null;
    }

    /**
     * 开牌，仅限当前话语权玩家开任意玩家牌且第二圈
     * 比大小
     *
     * @return 结果
     */
    @GetMapping("/battle")
    public String battle() {
        //TODO 开牌
        return null;
    }



}


