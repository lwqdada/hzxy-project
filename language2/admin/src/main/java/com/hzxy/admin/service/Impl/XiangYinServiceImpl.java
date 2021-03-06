package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.XiangYinDao;
import com.hzxy.admin.service.XiangYinService;
import com.hzxy.domain.entity.XiangYin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiangYinServiceImpl implements XiangYinService {
    @Autowired
    private XiangYinDao xiangYinDao;


    @Override
    public int add(XiangYin entity) {
           if(entity.getId()==null){
             entity.setCreated(new Date());
             entity.setUpdated(new Date());
           }
        return xiangYinDao.insert(entity);
    }

    @Override
    public List<XiangYin> selectAll() {
        return xiangYinDao.selectAll();
    }


    @Override
    public int count(XiangYin entity) {
        return xiangYinDao.count(entity);
    }

    @Override
    public XiangYin selectById(Long id) {
        return xiangYinDao.selectById(id);
    }

    @Override
    public int update(XiangYin entity) {
        if(entity.getId()!=null){
            entity.setUpdated(new Date());
        }
        return xiangYinDao.update(entity);
    }

    @Override
    public int deleteById(Long id) {
        return xiangYinDao.deleteById(id);
    }

    @Override
    public long deleteByList(String ids) {
        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
            xiangYinDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;
    }
}
