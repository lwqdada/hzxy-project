package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.UserDao;
import com.hzxy.admin.service.UserService;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    //新增用户
    @Transactional
    @Override
    public int add(User user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        return userDao.insert(user);
    }

    /**
     * 用户列表
     */
    @Override
    public List<User> selectAll() {
        //pageHeler帮我们生成分页语句
        List<User> users=userDao.selectAll();
        return users;

    }



    /**
     * 根据符合查询条件得出的比数
     * @return
     */
    @Override
    public int count(User user) {
        return userDao.count(user);
    }


    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> selectByName(String username) {
        return userDao.selectByName(username);
    }

    @Override
    @Transactional(readOnly = false)
    public int  update(User user) {
         user.setUpdated(new Date());
        return userDao.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public long deleteByList(String ids) {
        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
            userDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;
    }



    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
