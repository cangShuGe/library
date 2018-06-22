package com.cangshuge.dao;

import com.cangshuge.entity.BookAndRecord;
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

    @Results({
            @Result(property = "bookname",column = "bookname"),
            @Result(property = "author",column = "author"),
            @Result(property = "price",column ="price"),
            @Result(property = "buyTime",column = "buyTime"),
            @Result(property = "score",column = "score"),
            @Result(property = "num",column = "num"),
            @Result(property = "bookno",column = "booknum")//需要用别名
    })
    @Select("select bookname,author,price,buyTime,score,num,book.bookno as booknum from record,book where binary account = #{account} and record.bookno = book.bookno")
    List<BookAndRecord> getRecordsByAcc(@Param("account") String account);

    /**
     * 查询所有的购书记录--主要是查看评价
     * @param bookno
     * @return
     */
    @Select("select * from record where bookno=#{bookno}")
    List<Record> getAllByBookno(@Param("bookno") int bookno);

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
