package com.cangshuge.dao;

import com.cangshuge.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
                     @Param("jugde") String judge);
}
