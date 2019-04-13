package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.service.AlbumService;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
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
    AlbumService albumService;


    @RequestMapping(value = "myPhoto")
    public String showMyPhoto(Model model, HttpServletResponse response, HttpServletRequest request)throws Exception{
        Long userID;
//        if(request.getSession().getAttribute("userID")==null){
//            throw new Exception("session中用户id为空");
//        }else{
//            userID=(Long)request.getSession().getAttribute("userID");
//        }

        List<Photo> photos=photoService.showAllPhoto(Long.valueOf("12"));
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
        return "myPhoto";
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
}
