package com.hb.demo.zhajinhua.service;

import com.hb.demo.zhajinhua.po.UserInfoPO;
import com.hb.demo.zhajinhua.vo.RoomVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家相关服务层
 */
@Service
public interface RoomService {

    /**
     * 输入密码加入房间
     *
     * @param roomVO roomVO
     * @return Boolean
     */
    default List <UserInfoPO> intoRoom(RoomVO roomVO) {
        return new ArrayList <>();
    }

    /**
     * 输入密码加入房间
     *
     * @param roomVO roomVO
     * @return Boolean
     */
    default List <UserInfoPO> createRoom(RoomVO roomVO) {
        return new ArrayList <>();
    }

}
