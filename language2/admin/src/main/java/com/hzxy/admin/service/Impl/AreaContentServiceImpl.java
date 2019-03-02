package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.AreaContentDao;
import com.hzxy.admin.service.AreaContentService;

import com.hzxy.domain.entity.AreaContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaContentServiceImpl implements AreaContentService {

    @Autowired
    private AreaContentDao areaContentDao;


    //查询所有内容
    @Override
    public List<AreaContent> selectAll() {
        return areaContentDao.selectAll();
    }


    /**
     * 根据符合查询条件得出的比数
     * @return
     */
    @Override
    public int count(AreaContent areaContent) {
        return areaContentDao.count(areaContent);
    }


    //根据id删除记录
    @Override
    public int deleteById(Long id) {
        return areaContentDao.deleteById(id);
    }

    @Override
    public long deleteByList(String ids) {
        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
            areaContentDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;
    }


    //新增内容
    @Transactional(readOnly = false)
    @Override
    public int add(AreaContent areaContent) {
        areaContent.setCreated(new Date());
        areaContent.setUpdated(new Date());
        return areaContentDao.insert(areaContent);

    }

     //根据id查找对应的记录信息
    @Override
    public AreaContent selectById(Long id) {
        return areaContentDao.selectById(id);
    }

    @Override
    public int update(AreaContent areaContent) {
        return areaContentDao.update(areaContent);
    }

}
