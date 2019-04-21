package com.zhitu.workshop.springbootdemo;

import com.zhitu.workshop.springbootdemo.bo.RecycleBin;
import com.zhitu.workshop.springbootdemo.service.RecycleBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class handleJob {
    @Autowired
    RecycleBinService recycleBinService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void handleOrderStatus()throws Exception{
        Date Now=new Date();
        List<RecycleBin> list=recycleBinService.getAllFile(Now);
        for(RecycleBin re:list){
            recycleBinService.DelPhotoComp(re.getFileId(),re.getRecentId());
        }
    }
}
