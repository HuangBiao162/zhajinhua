package com.hb.demo.zhajinhua.bo;

import com.hb.demo.zhajinhua.em.CardTypeEnum;
import lombok.Data;

import java.util.ArrayList;

/**
 * 一个人应该有自己的名字，一副牌
 * 牌应该有黑红梅方+数字/英文
 *
 * @author biao_huang
 * @since 2021/08/16
 */
@Data
public class PersonBO {
    private Integer id;
    private String name;
    private ArrayList <String> cards;
    private String addCard;
    private Long score;
    private CardTypeEnum cardTypeEnum;
    //积分
    private Long integral;

    public void setAddCard(String addCard) {
        this.cards.add(addCard);
    }

    public PersonBO() {
        this.cards = new ArrayList <>();
    }

    public PersonBO(String name) {
        this.cards = new ArrayList <>();
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + "他的牌是：" + cards + " --牌分：" + this.getScore() + " --牌种类：" + CardTypeEnum.getCardTypeByEnum(cardTypeEnum);
    }


}
