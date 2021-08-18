package com.hb.demo.zhajinhua.po;

import lombok.Data;

import java.util.Date;

@Data
public class CardInfoPO {

    //场次id
    private int cid;

    //房间id
    private int rNum;

    //玩家id
    private int uid;

    //当前房间回合数
    private int round;

    //当前回合总积分
    private int amount;

    //牌内容大小与颜色组合
    private String cardContent;

    //牌大小
    private String cardSize;

    //牌花色
    private String cardColor;

    //牌分，牌越大分数越大
    private Long cardScore;

    private Date createTime;

}
