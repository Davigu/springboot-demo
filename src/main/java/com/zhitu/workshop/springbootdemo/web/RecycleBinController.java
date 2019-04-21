package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RecycleBinController {
    @Autowired
    RecycleBinService recycleBinService;

    @RequestMapping(value = "/myRecycleBin")
    public String myRecyclebin(HttpServletRequest request, HttpServletResponse response)
    throws Exception{

        List<RecycleBin> recycleBins=recycleBinService.showFiles(Long.valueOf("12"));

        Map<RecycleBin,Object> map=new HashMap<>();
        for(RecycleBin re:recycleBins){
            //System.out.println(re.getDeleteTime().getTime() - new Date().getTime());
            int days = (int) ((re.getDeleteTime().getTime() - new Date().getTime()) / (1000*3600*24));
            map.put(re,days);

        }

        if(recycleBins!=null){
            request.setAttribute("map",map);
        }else {
            throw new Exception("列表为空");
        }
        return "myRecycleBin";
    }

    @RequestMapping(value = "recoverPhoto")
    @ResponseBody
    public Object recoverPhoto(RecycleBin recycleBin, ModelMap model, HttpServletRequest request, HttpServletResponse response)throws Exception{
        try{
            if(recycleBinService.RecPhoto(recycleBin.getFileId(),recycleBin.getRecentId())){
                return "true";
            }else{
                return "false";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping(value = "delPhotoComplete")
    @ResponseBody
    public Object delPhotoComplete(Long fileID,Long photoID,HttpServletRequest request,HttpServletResponse response)throws Exception{
        if(recycleBinService.DelPhotoComp(fileID,photoID)){
            return true;
        }else{
            return false;
        }

    }
}
