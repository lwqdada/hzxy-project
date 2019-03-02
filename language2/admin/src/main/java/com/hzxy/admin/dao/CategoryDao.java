package com.hzxy.admin.dao;

import com.hzxy.admin.base.BaseDao;
import com.hzxy.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends BaseDao<Category> {


 /*根据父级节点ID查询所有子节点*/
 List<Category> selectByPid(Long pid);

 /*根据父级节点ID查询所有子节点*/
 Category selectByPidSingle(Long pid);

 //删除该类及该类下的子节点
 int deleteAll(Long id);

}
