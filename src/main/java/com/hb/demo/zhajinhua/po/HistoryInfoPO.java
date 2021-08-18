package com.hb.demo.zhajinhua.po;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryInfoPO {

    //记录id
    private Long hid;

    //场次id
    private Long cid;

    //房间id
    private Long rNum;

    //玩家id
    private Long uid;

    private Long win;

    private Date createTime;
}
