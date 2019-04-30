package com.zhitu.workshop.springbootdemo.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import com.zhitu.workshop.springbootdemo.util.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
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

        Long userID=LoginUser.getUser(request).getUserId();

        List<RecycleBin> recycleBins=recycleBinService.showFiles(userID);

        Map<RecycleBin,Object> map=new HashMap<>();
        for(RecycleBin re:recycleBins){
            //System.out.println(re.getDeleteTime().getTime() - new Date().getTime());
            int days = (int) ((re.getDeleteTime().getTime() - new Date().getTime()) / (1000*3600*24));
            map.put(re,days);
        }
        if(map!=null){
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
    public Object delPhotoComplete(Long fileId,Long photoId,HttpServletRequest request,HttpServletResponse response)throws Exception{
        if(recycleBinService.DelPhotoComp(fileId,photoId)){
            return true;
        }else{
            return new Exception().getMessage();
        }

    }

    @RequestMapping(value = "delSelected")
    @ResponseBody
    public Object delSelected(String ids, HttpServletRequest request)throws Exception{
        try{
            ids="["+ids+"]";
            JSONArray arr = (JSONArray) JSONArray.parse(ids);
            for(int i=0;i<arr.size();i++){
                JSONObject json=arr.getJSONObject(i);
                Long fileId=Long.valueOf(json.getString("fileId"));
                Long photoId=Long.valueOf(json.getString("recentId"));
                recycleBinService.DelPhotoComp(fileId,photoId);
            }
            return true;
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @RequestMapping(value = "recSelected")
    @ResponseBody
    public Object recSelected(String ids,HttpServletRequest request)throws Exception{
        try{
            ids="["+ids+"]";
            JSONArray arr = (JSONArray) JSONArray.parse(ids);
            for(int i=0;i<arr.size();i++){
                JSONObject json=arr.getJSONObject(i);
                Long fileId=Long.valueOf(json.getString("fileId"));
                Long photoId=Long.valueOf(json.getString("recentId"));
                recycleBinService.RecPhoto(fileId,photoId);
            }
            return true;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
