package com.zhitu.workshop.springbootdemo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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

        Long userID;
        if(request.getSession().getAttribute("ID")==null){
            throw new Exception("用户未登录");
        }else{
            userID=Long.valueOf(request.getSession().getAttribute("ID").toString());
        }
        List<RecycleBin> recycleBins=recycleBinService.showFiles(userID);

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
            JSONArray arr = (JSONArray)JSONArray.parse(ids);
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
}
