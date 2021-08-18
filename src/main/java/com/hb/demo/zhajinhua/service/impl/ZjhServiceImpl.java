package com.hb.demo.zhajinhua.service.impl;

import com.hb.demo.zhajinhua.bo.PersonBO;
import com.hb.demo.zhajinhua.em.CardTypeEnum;
import com.hb.demo.zhajinhua.em.TransformEnum;
import com.hb.demo.zhajinhua.service.ZjhService;
import com.hb.demo.zhajinhua.util.ZjhUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class ZjhServiceImpl implements ZjhService {
    @Override
    public void addMoney(List <PersonBO> personBOS) {
        personBOS = new ArrayList <>(personBOS);
        Boolean flag=true;
        BigDecimal moneyAll = new BigDecimal(0);
        Scanner scanner = new Scanner(System.in);
        List<String> listName;
        while (flag){
            for(int i=0;i<personBOS.size();i++){
                System.out.println(personBOS.get(i).getName()+" 加多少(单位：元，丢弃按'y')：");
                String scanerNext = scanner.nextLine();
                if("y".equals(scanerNext)){
                    listName = new ArrayList <>();
                    System.out.print(personBOS.get(i).getName()+" 已弃牌，目前还剩玩家：");
                    personBOS.remove(i);
                    for(PersonBO personBO : personBOS){
                        listName.add(personBO.getName());
                    }
                    i--;
                    System.out.println(listName);
                    if(personBOS.size()==1){
                        System.out.println("游戏结束，玩家"+personBOS.get(0).getName()+"获胜，总奖金："+moneyAll+"元");
                        flag=false;
                        break;
                    }
                }else{
                    moneyAll = moneyAll.add(BigDecimal.valueOf(Long.valueOf(scanerNext)));
                    System.out.println(personBOS.get(i).getName()+" 加"+scanerNext+"元，当前奖池："+moneyAll+"元");
                }

            }

        }
    }

    /**
     * 打底
     */
    public void addFirst(List <PersonBO> personBOS){
        for(PersonBO personBO : personBOS){
            //一人打底一分
            personBO.setIntegral(personBO.getIntegral()-1);
        }

    }

    @Override
    public PersonBO[] getScore(PersonBO... personList) {
        for (PersonBO personBO : personList) {
            ArrayList <String> cardList = personBO.getCards();
            //排序，先按牌字面大小进行排序，相同则按花色，黑红梅方
            Collections.sort(cardList, (o1, o2) -> {
                Integer one = Integer.valueOf(o1.substring(2));
                Integer two = Integer.valueOf(o2.substring(2));
                if (one.equals(two)) {
                    one = Integer.valueOf(o1.substring(0, 2));
                    two = Integer.valueOf(o2.substring(0, 2));
                }
                return one - two;
            });
            //获取花色和单张牌的大小
            ArrayList <String> colorList = new ArrayList <>();
            ArrayList <Integer> singleCardList = new ArrayList <>();
            for (String card : cardList) {
                String color = card.substring(0, 2);
                Integer singleCard = Integer.valueOf(card.substring(2));
                colorList.add(color);
                singleCardList.add(singleCard);
            }
            //设置牌型属性
            ZjhUtil.setCardTypeEnum(personBO, singleCardList, colorList);
            //设置分数
            setScore(personBO, singleCardList, colorList);
        }

        return personList;
    }

    @Override
    public List <PersonBO> winner(PersonBO... personList) {
        //获取分数
        personList = getScore(personList);
        //判断分数大小
        List <PersonBO> personBOS = Arrays.asList(personList);
        Collections.sort(personBOS, (o1, o2) -> {
            return (int) (o2.getScore() - o1.getScore());
        });
        for (PersonBO personBO : personBOS) {
            //System.out.println(personBO);
            transformValue(personBO);
            System.out.println(personBO);
        }
        return personBOS;
    }

    @Override
    public PersonBO[] getCard(PersonBO... personBOS) {

        //洗牌
        List <String> allCards = new ArrayList <>(52);
        for (int i = 0; i < ZjhUtil.allCardType.length; i++) {
            String currentCardType = ZjhUtil.allCardType[i];
            for (int j = 0; j < ZjhUtil.allCardValue.length; j++) {
                String currentCardValue = ZjhUtil.allCardValue[j];
                Random rd = new Random();
                int index = rd.nextInt(allCards.size() + 1);
                allCards.add(index, currentCardType + ZjhUtil.allCardValue[j]);
            }
        }
        //限制玩家人数
        int currentPersonSize = personBOS.length;
        int maxPersonSize = 52 / 3;
        if (currentPersonSize > maxPersonSize) {
            log.error("参与人数太多啦，牌不够发啦！请重新确定人数");
            return new PersonBO[]{};
        }
        //发牌
        //发牌使用队列弹出
        Queue <String> queue = new ArrayDeque <>();
        queue.addAll(allCards);
        for (int i = 0; i < 3; i++) {
            for (PersonBO personBO : personBOS) {
                personBO.setAddCard(queue.poll());
            }
        }
        return personBOS;

    }

    @Override
    public void setScore(PersonBO personBO, List <Integer> singleCardList, List <String> colorList) {
        Long score;
        //牌型分应占比最大
        Long resultTypeScore = personBO.getCardTypeEnum().score * 10000L;
        //相同牌型，第二比重应该为最大牌的值
        //PS：对子除外，对子直接比对子的大小
        Long maxCardScore = singleCardList.get(singleCardList.size() - 1) * 100L;
        if (personBO.getCardTypeEnum().equals(CardTypeEnum.DUI_ZI)) {
            Map <Integer, Object> map = new HashMap <>();
            for (int i = 0; i < 3; i++) {
                if (map.containsKey(singleCardList.get(i))) {
                    maxCardScore = singleCardList.get(i) * 100L;
                    break;
                } else {
                    map.put(singleCardList.get(i), i);
                }
            }
        }
        //相同牌型，最大牌也相同，则比较最大牌的花色
        Long maxCardColorScore = Integer.valueOf(colorList.get(colorList.size() - 1)) * 10L;

        personBO.setScore(resultTypeScore + maxCardScore + maxCardColorScore);
    }

    /**
     * 将牌进行转换，因为一开始jqk是数字11,12,13代替的
     *
     * @param personBO 玩家牌信息
     */
    public static void transformValue(PersonBO personBO) {
        ArrayList <String> cardList = personBO.getCards();
        ArrayList <String> newCard = new ArrayList <>();
        //获取花色和单张牌的大小
        for (String cards : cardList) {
            String key = TransformEnum.getValueByKey(cards.substring(0, 2));
            String value = TransformEnum.getValueByKey(cards.substring(2));
            newCard.add(key + value);
        }
        personBO.setCards(newCard);


    }
}
