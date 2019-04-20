package com.zhitu.workshop.springbootdemo.web;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
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

@RequestMapping(value="/myPhoto")
public String showPhoto()
{
    return "myPhoto";
}
    @RequestMapping(value = "/allPhoto")
    public String showMyPhoto(Model model, HttpServletResponse response, HttpServletRequest request)throws Exception{
        Long userID;
       if(request.getSession().getAttribute("ID")==null){
            throw new Exception("session中用户id为空");
        }else {
           userID = (Long) request.getSession().getAttribute("ID");
       }

        List<Photo> photos=photoService.showAllPhoto(userID);
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
        request.setAttribute("photos",map);
        return "allPhoto";
    }

    @RequestMapping(value = "deletePhoto")
    @ResponseBody
    public Object deletePhoto(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Long ID=Long.valueOf(id);
        boolean isSuccess=photoService.deletePhotoById(ID);
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
        re.setUserId(Long.valueOf("12"));
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
