package com.hb.demo.zhajinhua.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserInfoVO {

    //场次id
    private int cid;

    //房间id
    private int rid;

    //玩家id
    private int uid;
    private String name;
    private String password;
    //当前积分
    private int integral;

    private Date createTime;

    //是否为庄 默认0，庄为1
    private int master;

}
