package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.XiangYinService;
import com.hzxy.domain.entity.XiangYin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xiangyin")
public class XiangYinController {

    @Autowired
    private XiangYinService xiangYinService;


    @ModelAttribute
    public XiangYin getXiangYin(Long id){
        XiangYin xiangYin=null;
        if(id!=null){
            xiangYin = xiangYinService.selectById(id);//根据id获取用户信息
        }
        else{
            xiangYin=new XiangYin();
        }
        return  xiangYin;

    }

    /*跳转到乡音列表*/
    @RequestMapping("/xiangyinList")
    public String xiangyinList(){
        return "xiangyin_list";
    }


    /*查询所有记录*/
    @GetMapping("/selectAll")
    public List<XiangYin> selectAll(){
        return xiangYinService.selectAll();
    }

    /*新增记录*/
   @PostMapping("/add")
    public int  add(XiangYin xiangYin){
       return xiangYinService.add(xiangYin);
    }


    @ResponseBody
    //根据id查找记录
    @GetMapping("/selectById")
    public XiangYin selectById(Long id){
        return xiangYinService.selectById(id);
    }


    //根据id删除记录
    @GetMapping("/deleteById")
    public int deleteByid(Long id){
        return xiangYinService.deleteById(id);
    }

    //根据id更新
    @PostMapping("/update")
    public String update(XiangYin xiangYin){
        xiangYinService.update(xiangYin);
        return "redirect:/xiangyin/xiangyinList";
    }

    /*跳转到乡音更新表单*/
    @GetMapping("/xiangyin_form")
    public String updateXiangyinForm(){
        return "xiangyin_form";
    }



    /*列表*/

    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> resulst=new HashMap<>();
        List<XiangYin>  xiangYins = xiangYinService.selectAll();
        resulst.put("data",xiangYins);
        return resulst;
    }


    //批量删除
    @RequestMapping("/deleteXiangyinList")
    @ResponseBody
    public Map<String,Object>  deleteUserList(String ids){
        Map<String,Object> result=new HashMap<>();
        long count = xiangYinService.deleteByList(ids);
        if(count>0){
            result.put("msg","成功删除"+count+"记录！");

        }else{
            result.put("msg","删除失败，请稍后再试！");
        }

        return result;
    }






}
