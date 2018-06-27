package com.cangshuge.service;

import com.cangshuge.dao.RecordDao;
import com.cangshuge.entity.BookAndRecord;
import com.cangshuge.entity.JsonResult;
import com.cangshuge.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    RecordDao recordDao;
///????????实现的不完善
    public JsonResult buyBooks(Record record){
        recordDao.buyBooks(record);
        return new JsonResult("购买成功！",true);
    }

    public JsonResult updateJudge(String account,int bookno,long buyTime,String judge,int score){
        recordDao.updateJudge(account,bookno,buyTime,judge,score);
        return new JsonResult("评论成功！",true);
    }

    public JsonResult getRecordsByAcc(String account){
        List<BookAndRecord> records = recordDao.getRecordsByAcc(account);
        if (records == null){
            return new JsonResult("网络连接失败!",false);
        }else if(records.size() == 0){
            return new JsonResult("您还没有买书记录",false);
        }else {
            return new JsonResult("获取买书记录成功！",true,records);
        }
    }

    public JsonResult  delRecords(String account,int bookno,long buyTime){
        recordDao.delRecords(account,bookno,buyTime);
        Record record = recordDao.isExist(account,bookno,buyTime);
        if (record != null){
            return new JsonResult("删除购买记录失败！",false);
        }else {
            return new JsonResult("删除购买记录成功！",true);
        }
    }

    public JsonResult updateScore(String account,int bookno,long buyTime,int score){
        recordDao.updateScore(account,bookno,buyTime,score);
        Record record = recordDao.isExist(account,bookno,buyTime);
        if (record == null){
            return new JsonResult("网络连接失败！",false);
        }else if (record.getScore() != score){
            return new JsonResult("评分失败！",false);
        }else{
            return new JsonResult("评分成功！",true);
        }
    }

    public JsonResult getAllByBookno(int bookno){
        List<Record> records = recordDao.getAllByBookno(bookno);
        if (records == null){
            return new JsonResult("网络连接失败！",false);
        }else if (records.size() == 0){
            return new JsonResult("当前书籍没有购买记录！",false);
        }else {
            return new JsonResult("该书籍购买记录查询成功！",true,records);
        }
    }
}
