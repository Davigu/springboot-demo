package com.zhitu.workshop.springbootdemo.web;
import com.zhitu.workshop.springbootdemo.bo.Album;
import com.zhitu.workshop.springbootdemo.bo.Photo;
import com.zhitu.workshop.springbootdemo.bo.User;
import com.zhitu.workshop.springbootdemo.service.PhotoService;
import com.zhitu.workshop.springbootdemo.service.UserService;
import com.zhitu.workshop.springbootdemo.util.LoginUser;
import com.zhitu.workshop.springbootdemo.util.OpenAlbum;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        File saveFile=new File(basepath+File.separator+"static/picture"+File.separator+newFileName+fileStyle);
        Photo p=new Photo();
        p.setPhotoName(fileOnlyName);
        p.setPhotoAddress("/picture/"+newFileName+fileStyle);
        p.setPhotoDescription("哈哈哈 ");
        p.setLove(1L);
        p.setLovenumber(1L);
        p.setSize(fileSize);
        p.setState("0");

        p.setAlbumId(21L);

        p.setUpTime(Calendar.getInstance().getTime());

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        photoService.insertPhoto(p);
        return "ok";


    }



    @RequestMapping(value = "/downloadImage/{photoId}",method = RequestMethod.GET)
    @ResponseBody
    public String downloadImage(@PathVariable Long photoId, Model model, HttpServletRequest request ,HttpServletResponse response )throws Exception {
        Photo photo=photoService.findPhotoByID(photoId);
        String downloadFilePath=this.getClass().getResource("/").getPath()+    photo.getPhotoAddress();
        File src=new File(downloadFilePath);
        if(!src.exists()) {
            // 处理文件不存在的情况
            return null;
        }
        response.setContentType("application/force-download");// 设置强制下载不打开
        String fileStyle="";//文件后缀名
       String address= photo.getPhotoAddress();
        int pos=address.lastIndexOf(".");
        if(pos>-1){
            fileStyle=address.substring(pos);
        }

        response.addHeader("Content-Dispsition","attachment;fileName="+photo.getPhotoName()+fileStyle);
        InputStream input = null;
        OutputStream output = null;
        byte[] buffer = new byte[4096];

        try{
            input=new FileInputStream(src);
            output=response.getOutputStream();
            int i;
            while((i=input.read(buffer))>0){
                output.write(buffer,0,i);
            }
        }finally {
            IOUtils.closeQuietly(input);
        }

        return null;

    }
}
