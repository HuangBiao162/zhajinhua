package com.hb.demo.zhajinhua.service;

import com.hb.demo.zhajinhua.bo.PersonBO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ZjhService {

    void addMoney(List <PersonBO> personBOS);

    /**
     * 获取并设置Person分数
     *
     * @param personList 参与人信息
     * @return 结果对象
     */
    default PersonBO[] getScore(PersonBO... personList) {
        return new PersonBO[]{};
    }

    /**
     * 判断赢家
     *
     * @param personList 参与人信息
     * @return 结果对象
     */
    default List <PersonBO> winner(PersonBO... personList) {
        return new ArrayList <>();
    }

    /**
     * 发牌
     *
     * @param personBOS 给玩家发牌
     * @return 结果数组
     */
    default PersonBO[] getCard(PersonBO... personBOS) {
        return new PersonBO[]{};
    }

    /**
     * 设置分数
     *
     * @param personBO       玩家信息
     * @param singleCardList 玩家手牌牌型列表 1,2,3
     * @param colorList      玩家手牌花色列表 ♠，♣，♠
     */
    void setScore(PersonBO personBO, List <Integer> singleCardList, List <String> colorList);
}
