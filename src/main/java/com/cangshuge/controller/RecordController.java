package com.cangshuge.controller;

import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.Record;
import com.cangshuge.service.RecordService;
import com.cangshuge.utils.ValidResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RecordController {
    @Autowired
    RecordService recordService;

    /**
     * 购买书籍
     * @param record
     * @param result
     * @return
     */
    @RequestMapping(value = "/buyBooks",method = RequestMethod.POST)
    JsonResult buyBooks(@RequestBody Record record, BindingResult result){
        if (result.hasErrors()){
            return ValidResult.checkResult(result);
        }
        return recordService.buyBooks(record);
    }
    @RequestMapping("/updateJudge")
    JsonResult updateJudge(String account,int bookno,long buyTime,String judge){
        return recordService.updateJudge(account,bookno,buyTime,judge);
    }

    /**
     * 获取全部的购买记录
     * @param account
     * @return
     */
    @RequestMapping("/getRecordsByAcc")
    JsonResult getRecordsByAcc(String account){
        return recordService.getRecordsByAcc(account);
    }

    @RequestMapping("/delRecords")
    JsonResult delRecords(String account,int bookno,long buyTime){
        return recordService.delRecords(account,bookno,buyTime);
    }

    @RequestMapping("/updatescore")
    JsonResult updateScore(String account,int bookno,long buyTime,int score){
        return recordService.updateScore(account,bookno,buyTime,score);
    }
}
