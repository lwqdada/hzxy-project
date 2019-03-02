package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.AreaContentService;
import com.hzxy.domain.entity.AreaContent;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/content")
public class AreaContentController {
    @Autowired
    private AreaContentService areaContentService;

    @ModelAttribute
    public AreaContent getAreaContentbyId(Long id){
        AreaContent areaContent=new AreaContent();
        if(id!=null){
            areaContent= areaContentService.selectById(id);

        }
        else{
            areaContent=new AreaContent();
        }
        return areaContent;

    }



    ///获取所有数据
    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> list() throws ParseException {
        Map<String,Object> resulst=new HashMap<>();
        List<AreaContent>  contents = areaContentService.selectAll();
        resulst.put("data",contents);
        return resulst;
    }





    //跳转到内容分类页面
    @GetMapping("/areaContents")
    private  String contenLists(){
        return "areaContents_list";
    }


    //跳转到新增内容表单
    @GetMapping("/content_form")
    private  String contForm(){
        return "content_form";
    }

    //跳转到更新表单
     @GetMapping("/updateContentForm")
    private  String updateForm(){
        return "update_content_form";
    }

    //根据Id删除用户
    @GetMapping("/deleteByareaId")
    public String deleteById(long id){
        areaContentService.deleteById(id);
        return "redirect:/content/areaContents";

    }

    //新增内容
    @PostMapping("/save")
    public String addContent(AreaContent areaContent,Model model){
        if(areaContent.getId()==null){
            int add = areaContentService.add(areaContent);
            if(add!=0){
                model.addAttribute("msg","新增内容成功！");
            }else
            {
                model.addAttribute("msg","新增内容失败！");
                return "redirect:/content/content_form";

            }
        }else{
            updatebycontentId(areaContent);
        }


        return "redirect:/content/areaContents";
    }

    //更改内容信息
    @PostMapping("/updateAreaContent")
    public void updatebycontentId(AreaContent areaContent){
        areaContentService.update(areaContent);
    }


    //根据id获取内容信息
    @ResponseBody
    @GetMapping("/getContentById")
    private AreaContent  getContentById(long id){
        return areaContentService.selectById(id);
    }

    //批量删除
    @RequestMapping("/deleteContentList")
    @ResponseBody
    public Map<String,Object>  deleteUserList(String ids){
        Map<String,Object> result=new HashMap<>();
        long count = areaContentService.deleteByList(ids);
        if(count>0){
            result.put("msg","成功删除"+count+"记录！");

        }else{
            result.put("msg","删除失败，请稍后再试！");
        }

        return result;
    }




}
