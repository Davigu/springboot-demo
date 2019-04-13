package com.zhitu.workshop.springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import java.io.*;


/**
 * 文件上传
 */
@Controller
public class UploadController {

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
        File saveFile=new File("F:\\1.png");
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
