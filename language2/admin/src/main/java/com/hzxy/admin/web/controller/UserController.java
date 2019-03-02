package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.UserService;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   private UserService userService;

   ///获取所有用户的记录
    @GetMapping("/list")
    public Map<String,Object> list() throws ParseException {
        Map<String,Object> resulst=new HashMap<>();
        List<User> users = userService.selectAll();
        resulst.put("data",users);
        return resulst;
    }



    //根据Id获取用户信息
    @GetMapping("/getUserById")
    public User getUserById(Long id){
        return userService.selectById(id);
    }




}
