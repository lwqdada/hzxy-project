package com.hzxy.admin.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 */
public interface BaseDao<T> {

    //新增
    int insert(T entity);

    //展示所有信息
    List<T> selectAll();

    //更新对应的类信息信息
    int update(T entity);

    //根据ID删除记录
    int deleteById(Long id);

    //根据Id查询记录
   T selectById(Long id);


    /**
     * 查询笔数
     * @return
     */
    int count(T entity);

    //批量删除
    int deleteByTrap(@Param("id") Integer id);




}
