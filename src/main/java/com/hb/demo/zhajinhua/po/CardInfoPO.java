package com.hb.demo.zhajinhua.po;

import lombok.Data;

import java.util.Date;

@Data
public class CardInfoPO {

    //场次id
    private int cid;

    //房间id
    private int rid;

    //玩家id
    private int uid;

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
