package com.hzxy.admin.base;

import java.util.List;

public interface BaseService<T> {
    //新增
    int add(T entity);

    //查询所有
    List<T> selectAll();


    //查询总笔数
    int count(T entity);

    //根据id查询记录
   T selectById(Long id);

    //更新
    int update(T entity);

    //根据id查询记录
    int deleteById(Long id);


    //批量删除
    long deleteByList(String ids);
}
