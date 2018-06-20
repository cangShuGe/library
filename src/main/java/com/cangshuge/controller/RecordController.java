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

    @RequestMapping("/getRecordsByAcc")
    JsonResult getRecordsByAcc(String account){
        return recordService.getRecordsByAcc(account);
    }
}
