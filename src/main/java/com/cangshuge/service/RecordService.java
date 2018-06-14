package com.cangshuge.service;

import com.cangshuge.dao.RecordDao;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    RecordDao recordDao;
///????????实现的不完善
    public JsonResult buyBooks(Record record){
        recordDao.buyBooks(record);
        return new JsonResult("购买成功！",true);
    }

    public JsonResult updateJudge(String account,int bookno,long buyTime,String judge){
        recordDao.updateJudge(account,bookno,buyTime,judge);
        return new JsonResult("评论成功！",true);
    }
}
