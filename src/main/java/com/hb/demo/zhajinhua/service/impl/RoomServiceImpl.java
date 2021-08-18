package com.hb.demo.zhajinhua.service.impl;

import com.alibaba.fastjson.JSON;
import com.hb.demo.zhajinhua.mapper.RoomInfoMapper;
import com.hb.demo.zhajinhua.mapper.UserInfoMapper;
import com.hb.demo.zhajinhua.po.RoomInfoPO;
import com.hb.demo.zhajinhua.po.UserInfoPO;
import com.hb.demo.zhajinhua.service.RoomService;
import com.hb.demo.zhajinhua.util.JSONUtil;
import com.hb.demo.zhajinhua.vo.RoomVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    private static final JSONUtil <RoomInfoPO> jsonUtil = new JSONUtil <>();

    @Override
    public List <UserInfoPO> intoRoom(RoomVO roomVO) {
        //password不能为空
        RoomInfoPO roomInfoPO = jsonUtil.transClass(RoomInfoPO.class, JSON.toJSONString(roomVO));
        List <RoomInfoPO> roomInfoPOS = roomInfoMapper.selInfoList(roomInfoPO);
        //如果没有查询到该房间，则设置该密码的房间；否则查询该房间所有玩家并返回
        if (roomInfoPOS.size() < 1) {
            return createRoom(roomVO);
        }
        //查到房间
        List <UserInfoPO> userInfoPOSList = new ArrayList <>();
        for (RoomInfoPO roomInfoPO1 : roomInfoPOS) {
            UserInfoPO userInfoPO = (UserInfoPO) JSONUtil.transObject(UserInfoPO.class, JSON.toJSONString(roomInfoPO1));
            List <UserInfoPO> userInfoPOS = userInfoMapper.selInfoList(UserInfoPO.builder().uid(userInfoPO.getUid()).build());
            userInfoPOSList.addAll(userInfoPOS);
        }
        log.info("【进入房间】- 进入房间成功,房间内存在玩家：{}", JSON.toJSONString(userInfoPOSList));
        return userInfoPOSList;
    }

    @Override
    public List <UserInfoPO> createRoom(RoomVO roomVO) {
        //password不能为空
        RoomInfoPO roomInfoPO = jsonUtil.transClass(RoomInfoPO.class, JSON.toJSONString(roomVO));
        try {
            int createRoomResult = roomInfoMapper.addInfo(roomInfoPO);
            //创建房间成功
            if (createRoomResult > 0) {
                //房间创建成功，返回该玩家
                UserInfoPO userInfoPO = (UserInfoPO) JSONUtil.transObject(UserInfoPO.class, JSON.toJSONString(roomVO));
                List <UserInfoPO> userInfoPOS = userInfoMapper.selInfoList(userInfoPO);
                log.error("【进入房间】- 创建房间成功,房间号：{}，用户信息{}", roomInfoPO.getRid(), JSON.toJSONString(userInfoPOS));
                return userInfoPOS;
            }
        } catch (Exception e) {
            //创建失败
            log.error("【进入房间】- 创建房间失败,{}", e);
        }
        return new ArrayList <>();
    }
}
