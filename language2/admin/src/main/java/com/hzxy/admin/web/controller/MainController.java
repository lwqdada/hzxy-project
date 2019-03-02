package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.UserService;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class MainController {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public User  getUser(Long id){
       User user=null;
        if(id!=null){
         user = userService.selectById(id);//根据id获取用户信息
        }
        else{
           user=new User();
        }
        return  user;

    }
    //跳转到控制面板
    @GetMapping("/main")
    public String  main(){
        return "main";
    }

    //跳转到用户表单
    @GetMapping("/user_form")
    public String  user_form(){
        return "user_form";
    }


    //跳转到用户列表
    @GetMapping("/user_list")
    public String  user_list(){
        return "user_list";
    }


    //根据Id删除用户
    @GetMapping("/deleteById")
    @ResponseBody
    public Map<String,Object> deleteById(long id){
        Map<String,Object> result=new HashMap<>();
        int d=userService.deleteById(id);
        System.out.println(d);
        result.put("data",d);

       return result;

    }


    //批量删除
    @RequestMapping("/deleteUserList")
    @ResponseBody
    public Map<String,Object>  deleteUserList(String ids){
        Map<String,Object> result=new HashMap<>();
        long count = userService.deleteByList(ids);
        if(count>0){
            result.put("msg","成功删除"+count+"记录！");

        }else{
            result.put("msg","删除失败，请稍后再试！");
        }

        return result;
    }


    //新增用户

    @PostMapping("/save")
    public String addUser(User user, Model model){
        if(user.getId()==null){
            if(user.getUsername()!=null&&user.getPassword()!=null&&user.getEmail()!=null&&user.getPhone()!=null){
                userService.add(user);
                model.addAttribute("msg","保存成功！");
            }else{
                model.addAttribute("必填的信息不能为空，请重新填！");
                return "redirect:/user/user_form";
            }
        }else{
            userService.update(user);
        }
        return "redirect:/user/user_list";

    }




}
