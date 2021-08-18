package com.hb.demo.zhajinhua.service;

import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.vo.UserInfoVO;
import org.springframework.stereotype.Service;

/**
 * 玩家相关服务层
 */
@Service
public interface UserService {


    /**
     * 玩家注册
     * @param userInfoVO userInfoVO
     * @return 大于0成功否则失败
     */
    default int registUser(UserInfoVO userInfoVO){
        return 0;
    }

    /**
     * 玩家登录
     * @param userInfoVO userInfoVO
     * @return 大于0成功否则失败
     */
    default int loginUser(UserInfoVO userInfoVO){
        return 0;
    }

    /**
     * 第一把开始前设庄，后续胜利的当庄
     *
     * @param personList 玩家数组
     * @return 玩家数组
     */
    default PersonBO[] setMaster(int round, PersonBO... personList) {
        return new PersonBO[]{};
    }

}
