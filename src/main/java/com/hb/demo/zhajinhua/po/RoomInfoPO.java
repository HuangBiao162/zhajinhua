package com.hb.demo.zhajinhua.po;

import lombok.Data;

import java.util.Date;

@Data
public class RoomInfoPO {

    //房间号
    private int rid;
    //场次
    private int cid;
    //玩家id
    private int uid;

    private int rNum;

    /**
     * 房间密码，6位数
     * 输入房间密码直接进入房间
     */
    private int password;
    private Date createTime;

}
