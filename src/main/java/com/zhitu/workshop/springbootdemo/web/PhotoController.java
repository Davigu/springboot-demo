package com.zhitu.workshop.springbootdemo.web;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import com.zhitu.workshop.springbootdemo.util.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class PhotoController {
    @Autowired
    PhotoService photoService;
    @Autowired
    RecycleBinService recycleBinService;

    Long userId;

    //获取年月日，得到map
    public Map<String,List<Photo>> getYYYYMM(List<Photo> photos){
        Map<String,List<Photo>> map=new HashMap<>();
        for(Photo photo:photos){
            Date date=photo.getUpTime();
            Calendar cal = Calendar.getInstance();
            cal.clear();// 清除信息
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH)+1;
            String YYYYMM=year+"年"+month+"月";//获得照片的年和月
            if(map.containsKey(YYYYMM)){
                map.get(YYYYMM).add(photo);
            }else{
                List<Photo> tmpList=new ArrayList<>();
                tmpList.add(photo);
                map.put(YYYYMM,tmpList);
            }
        }
        return map;
    }



    @RequestMapping(value = "/allPhoto")
    public String showMyPhoto(Model model, HttpServletResponse response, HttpServletRequest request)throws Exception{

        if(request.getSession().getAttribute("ID")==null){
            throw new Exception("用户未登录");
        }else{
            userId=LoginUser.getUser(request).getUserId();
        }

        List<Photo> photos=photoService.showAllPhoto(userId,0);

        Map<String,List<Photo>> map=getYYYYMM(photos);
        request.setAttribute("photos",map);
        return "allPhoto";
    }

    @RequestMapping(value = "paging")
    @ResponseBody
    public Map<String,List<Photo>> paging(int startRow)throws Exception{

        List<Photo> photos=photoService.showAllPhoto(userId,startRow);
        Map<String,List<Photo>> map=getYYYYMM(photos);
        return map;
    }

    @RequestMapping(value = "deletePhoto")
    @ResponseBody
    public Object deletePhoto(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Long Id=Long.valueOf(id);
        boolean isSuccess=photoService.deletePhotoById(Id);
        if(isSuccess==true){
            return "true";
        }else {
            return "false";
        }
    }


    @RequestMapping(value = "delIntoRec")
    @ResponseBody
    public Object DelIntoRec(@RequestParam(value = "photoid") Long photoId,HttpServletResponse response,HttpServletRequest request)throws Exception{

        Date dayNow=new Date();
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,30);
        Date date=cal.getTime();

        RecycleBin re=new RecycleBin();
        re.setUserId(LoginUser.getUser(request).getUserId());
        re.setObject("1");
        re.setRecentId(photoId);
        re.setInitialTime(dayNow);
        re.setDeleteTime(date);

        int count1=photoService.DelIntoRec(photoId);
        int count2=recycleBinService.delIntoRec(re);
        if(count1>0&&count2>0){
            return "true";
        }else{
            return "false";
        }
    }
}
