package com.cangshuge.dao;

import com.cangshuge.entity.Record;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RecordDao {
    @Insert("insert into record(account,bookno,buyTime,num,score,judge) values(" +
            "#{record.account},#{record.bookno},#{record.buyTime}," +
            "#{record.num},#{record.score},#{record.judge})")
    void buyBooks(@Param("record") Record record);

    @Update("update record set judge=#{judge} where account = #{account} and " +
            "bookno = #{bookno} and buyTime = #{buyTime}")
    void updateJudge(@Param("account") String account,
                     @Param("bookno") int bookno,
                     @Param("buyTime") long buyTime,
                     @Param("judge") String judge);

    @Select("select * from record where binary account = #{account}")
    List<Record> getRecordsByAcc(@Param("account") String account);

    @Select("select * from record where binary account = #{account} and bookno=#{bookno} and buyTime=#{buyTime}")
    Record isExist(@Param("account") String account,
                   @Param("bookno") int bookno,
                   @Param("buyTime") long buyTime);
    @Delete("delete from record where binary account=#{account} and " +
            "bookno=#{bookno} and buyTime=#{buyTime}")
    void delRecords(@Param("account") String account,
                    @Param("bookno") int bookno,
                    @Param("buyTime") long buyTime);

    @Update("update record set score = #{score} where binary account=#{account} and " +
            "bookno=#{bookno} and buyTime=#{buyTime}")
    void updateScore(@Param("account") String account,
                     @Param("bookno") int bookno,
                     @Param("buyTime") long buyTime,
                     @Param("score") int score);
}
