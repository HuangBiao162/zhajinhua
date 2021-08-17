package com.hb.demo.zhajinhua.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoPO {

    //场次id
    private int cid;

    //房间id
    private int rid;

    //玩家id
    private int uid;
    private String name;
    //当前积分
    private int integral;

    private Date createTime;

}
