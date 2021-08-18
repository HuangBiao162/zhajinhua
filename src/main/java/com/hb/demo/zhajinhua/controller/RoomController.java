package com.hb.demo.zhajinhua.controller;

import com.hb.demo.zhajinhua.po.UserInfoPO;
import com.hb.demo.zhajinhua.service.RoomService;
import com.hb.demo.zhajinhua.vo.RoomVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 房间访问层
 */
@RestController
@RequestMapping("/room")
@Slf4j
public class RoomController {

    @Autowired
    RoomService roomService;

    /**
     * 创建房间
     *
     * @param roomVO 请求参数密码password不能为空
     * @return List<UserInfoPO>房间内玩家信息
     */
    @GetMapping("/create_room")
    public List <UserInfoPO> createRoom(@RequestParam("roomVO") RoomVO roomVO) {
        if (roomVO == null || StringUtils.isBlank(roomVO.getPassword())) {
            log.error("【创建房间】- 参数不完整，请确保密码不为空：roomVO{}", roomVO);
        }
        return roomService.createRoom(roomVO);
    }

    /**
     * 加入房间
     *
     * @param roomVO 请求参数密码password不能为空
     * @return List<UserInfoPO>房间内玩家信息
     */
    @GetMapping("/into_room")
    public List <UserInfoPO> intoRoom(@RequestParam("roomVO") RoomVO roomVO) {
        if (roomVO == null || StringUtils.isBlank(roomVO.getPassword())) {
            log.error("【加入房间】- 参数不完整，请确保密码不为空：roomVO{}", roomVO);
        }
        return roomService.createRoom(roomVO);
    }


}
