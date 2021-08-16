package com.hb.demo.zhajinhua.util;

import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.em.CardTypeEnum;

import java.util.List;

public class ZjhUtil {

    //定义牌面大小和牌的类型
    //public static String[] allCardValue = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static String[] allCardValue = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
    //public static String[] allCardType = new String[]{"黑桃", "红桃", "梅花", "方块"};
    //public static String[] allCardType = new String[]{"♠", "♥", "♣", "♦"};
    public static String[] allCardType = new String[]{"-1", "-2", "-3", "-4"};


    /**
     * 为Person对象设置牌型属性
     *
     * @param personBO       玩家牌数据
     * @param singleCardList 玩家手牌字面集合
     * @param colorList      玩家手牌花色集合
     */
    public static void setCardTypeEnum(PersonBO personBO, List <Integer> singleCardList, List <String> colorList) {
        if (isJinTiao(singleCardList)) {
            personBO.setCardTypeEnum(CardTypeEnum.JIN_TIAO);
        } else if (isShunJin(singleCardList, colorList)) {
            personBO.setCardTypeEnum(CardTypeEnum.SHUN_JIN);
        } else if (isJinHua(colorList)) {
            personBO.setCardTypeEnum(CardTypeEnum.JIN_HUA);
        } else if (isShunZi(singleCardList)) {
            personBO.setCardTypeEnum(CardTypeEnum.SHUN_ZI);
        } else if (isDuiZi(singleCardList)) {
            personBO.setCardTypeEnum(CardTypeEnum.DUI_ZI);
        } else {
            personBO.setCardTypeEnum(CardTypeEnum.NORMAL);
        }
    }

    /**
     * 判断是否为金条
     *
     * @param singleCardList 手牌字面集合
     * @return 结果
     */
    public static Boolean isJinTiao(List <Integer> singleCardList) {
        return singleCardList.get(0).equals(singleCardList.get(1)) && singleCardList.get(0).equals(singleCardList.get(2));
    }

    /**
     * 判断是否顺金
     *
     * @param singleCardList 手牌字面集合
     * @param colorList      手牌花色集合
     * @return 结果
     */
    public static Boolean isShunJin(List <Integer> singleCardList, List <String> colorList) {
        Boolean isJinHua = false;
        Boolean isShunzi = false;
        //是否金花
        if (colorList.get(0).equals(colorList.get(1)) && colorList.get(0).equals(colorList.get(2))) {
            isJinHua = true;
        }
        //是否顺子
        if (Math.abs(singleCardList.get(0) - singleCardList.get(1)) == 1 && Math.abs(singleCardList.get(1) - singleCardList.get(2)) == 1) {
            isShunzi = true;
        }
        return isJinHua && isShunzi;
    }

    /**
     * 是否金花
     *
     * @param colorList 手牌花色集合
     * @return 结果
     */
    public static Boolean isJinHua(List <String> colorList) {
        return colorList.get(0).equals(colorList.get(1)) && colorList.get(0).equals(colorList.get(2));
    }

    /**
     * 是否顺子
     *
     * @param singleCardList 手牌字面集合
     * @return 结果
     */
    public static Boolean isShunZi(List <Integer> singleCardList) {
        return Math.abs(singleCardList.get(0) - singleCardList.get(1)) == 1 && Math.abs(singleCardList.get(1) - singleCardList.get(2)) == 1;
    }

    /**
     * 是否对子
     *
     * @param singleCardList 手牌字面集合
     * @return 结果
     */
    public static Boolean isDuiZi(List <Integer> singleCardList) {
        if (singleCardList.get(0).equals(singleCardList.get(1))
                || singleCardList.get(0).equals(singleCardList.get(2))
                || singleCardList.get(1).equals(singleCardList.get(2))) {
            return true;
        }
        return false;
    }


}
