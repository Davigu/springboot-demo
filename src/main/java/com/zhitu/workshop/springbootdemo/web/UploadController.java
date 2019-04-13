package com.zhitu.workshop.springbootdemo.web;

import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 文件上传
 */
@Controller

public class UploadController {
    @Autowired
    PhotoService photoService;

    @RequestMapping(value = "/upload")
    public String file() {
        return "upload";
    }

    @RequestMapping(value = "/doUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "upfile") MultipartFile file, Model model, HttpServletRequest request) {



        if (file.isEmpty()) {
            System.out.println("文件为空");
        }

        long fileSize=file.getSize();//文件大小
        String fileName=file.getOriginalFilename();//原始文件名
        String fileStyle="";//文件后缀名
        String fileOnlyName="";//单纯文件名
        int pos=fileName.lastIndexOf(".");
        if(pos>-1){
             fileStyle=fileName.substring(pos);
             fileOnlyName=fileName.substring(0,pos);
        }



        int random=(int)(Math.random()*10000);
        long newFileName=System.currentTimeMillis()+random;

        String basepath= this.getClass().getResource("/").getPath();
        File saveFile=new File(basepath+File.separator+"static"+File.separator+"picture"+File.separator+newFileName+fileStyle);

        Photo p=new Photo();
        p.setPhotoName(fileOnlyName);
        p.setPhotoAddress("/picture/"+newFileName+fileStyle);
        p.setAlbumId(12L);
        p.setPhotoDescription("哈哈哈 ");
        p.setLove(1L);
        p.setLovenumber(1L);
        p.setSize(fileSize);
        p.setState("0");

        p.setUpTime(Calendar.getInstance().getTime());

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        photoService.insertPhoto(p);
        return "ok";


    }

}
