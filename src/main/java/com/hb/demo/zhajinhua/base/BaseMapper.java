package com.hb.demo.zhajinhua.base;

import java.util.List;

public interface BaseMapper<T> {

    List <T> selInfoList(T t);

    int addInfo(T t);

    int modInfoById(T t);

    int delInfoById(T t);
}
