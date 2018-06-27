package com.cangshuge.service;

import com.cangshuge.dao.*;
import com.cangshuge.entity.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    AdminDao adminDao;
    @Autowired
    RecordDao recordDao;
    @Autowired
    CartDao cartDao;
    @Autowired
    OnlineBookDao onlineBookDao;
    @Autowired
    BookshelfDao bookshelfDao;

    public JsonResult login(String account,String pwd){
        User user = userDao.login(account);
        if (user == null){
            System.out.println("我在后端欢迎你");
            return new JsonResult("用户名称输入错误",false);
        }else {
            if (!user.getPwd().equals(pwd)){
                return new JsonResult("用户密码输入错误！",false);
            }else {
                return new JsonResult("登录成功！",true);
            }
        }
    }

    @Transactional
    public JsonResult sign(User user){
        User user1 = userDao.login(user.getAccount());
        User user3 = userDao.getByMailbox(user.getMailbox());
        if (user1 != null){
            return new JsonResult("用户名已存在，请重新编辑用户名称进行注册！",false);
        }else if (user3 != null){
            return new JsonResult("该邮箱已经被注册，请使用新的邮箱进行注册！",false);
        }else {
            userDao.sign(user);
            User user2 = userDao.login(user.getAccount());
            if (user2 == null){
                return new JsonResult("用户注册失败！",false);
            }else {
                return new JsonResult("用户注册成功！",true);
            }
        }
    }

    public JsonResult updateUser(User user){
        userDao.updateUser(user);
        return new JsonResult("更新成功！",true);
    }

    public JsonResult updatePwd(String account,String pwd,String newPwd){
        User user = userDao.login(account);//获得用户个人信息
        if (user == null){
            return new JsonResult("不存在该用户账户！",false);
        }else if (!user.getPwd().equals(pwd)){
            return new JsonResult("原密码输入错误！",false);
        }else{
            userDao.updatePwd(account,newPwd);
            return new JsonResult("修改密码成功！",true);
        }
    }

    public JsonResult selectUser(String account){
        User user = userDao.selectUser(account);
        if (user == null){
            return new JsonResult("获取个人信息失败！",false);
        }
        return new JsonResult("获取个人信息成功！",true,user);
    }

    public JsonResult huiyuan(String account){
        userDao.huiyuan(account);
        User user = userDao.selectUser(account);
        if (user == null){
            return new JsonResult("网络连接出错？您还不是普通成员，无法注册会员？",false);
        }else if (user.getMember() != 1){
            return new JsonResult("升级会员失败！",false);
        }
        return new JsonResult("升级会员成功！",true);
    }

    //实体书立即购买方式
    public JsonResult buyBooks(int bookno,int num,long buyTime,String account){
        Book book = bookDao.getBookByNo(bookno);//获得本书的详细信息！
        User user = userDao.login(account);//获得用户的详细信息
        double dis = 1;//折扣
        double sum = 0;//花费的总价格
        if (user.getMember() == 0){//不是会员
            Discord discord = adminDao.showOneDis(bookno,0);
            if (discord != null){
                dis=discord.getDiscord();
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            System.out.println(account);
            System.out.println("------------------");
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
            userDao.updateCredit(account,(int)sum);//增加非会员积分
        }else{//是会员 --- 比所有的活动折扣都要大
            if (user.getCredit()<=1000){
                dis = 0.7;
            }else if (user.getCredit()<=5000){
                dis = 0.65;
            }else{
                dis = 0.6;
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
        }
        return new JsonResult("购买成功！",true,new Double(sum));//将总价格返回
    }
    //实体书购物车中购买方式
    public JsonResult buyBooksCart(String account,int bookno,int num,long buyTime,long addtime){
        Book book = bookDao.getBookByNo(bookno);//获得本书的详细信息！
        User user = userDao.login(account);//获得用户的详细信息
        double dis = 1;//折扣
        double sum = 0;//花费的总价格
        if (user.getMember() == 0){//不是会员
            Discord discord = adminDao.showOneDis(bookno,0);
            if (discord != null){
                dis=discord.getDiscord();
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
            userDao.updateCredit(account,(int)sum);//增加非会员积分
            cartDao.delcart(account,bookno,addtime);//删除购物车商品
        }else{//是会员 --- 比所有的活动折扣都要大
            if (user.getCredit()<=1000){
                dis = 0.7;
            }else if (user.getCredit()<=5000){
                dis = 0.65;
            }else{
                dis = 0.6;
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
            userDao.updateCredit(account,(int)sum);//增加会员积分
            cartDao.delcart(account,bookno,addtime);//删除购物车商品
        }
        return new JsonResult("购买成功！",true,new Double(sum));//将总价格返回
    }

    //推荐实体书方式
    public JsonResult recommendBooks(){
        PageHelper.startPage(1,3);
        List<Recommend> recommends = userDao.recommendBooks();
        return new JsonResult("获取推荐成功",true,recommends);
    }

    //推荐电子书籍
    public JsonResult recommendOnBooks(){
        PageHelper.startPage(1,3);
        List<Recommend> recommends = userDao.recommendOnBooks();
        return new JsonResult("获取推荐成功",true,recommends);
    }

    //用户上传电子书
    /*public JsonResult uploadOnBooks(String account,int bookno){
        Book book = bookDao.getBookByNo(bookno);//获得本书的详细信息！
        User user = userDao.login(account);//获得用户的详细信息
        double dis = 1;//折扣
        double sum = 0;//花费的总价格
        if (user.getMember() == 0){//不是会员
            Discord discord = adminDao.showOneDis(bookno,0);
            if (discord != null){
                dis=discord.getDiscord();
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
            userDao.updateCredit(account,(int)sum);//增加非会员积分
        }else{//是会员 --- 比所有的活动折扣都要大
            if (user.getCredit()<=1000){
                dis = 0.7;
            }else if (user.getCredit()<=5000){
                dis = 0.65;
            }else{
                dis = 0.6;
            }
            sum = book.getPrice()*num*dis;
            Record record = new Record(account,bookno,buyTime,num);
            recordDao.buyBooks(record);//添加购买记录
            bookDao.updateTotal(bookno,num);//减少库存
        }
        return new JsonResult("购买成功！",true,new Double(sum));//将总价格返回
    }*/
    //用户下载电子书
    public JsonResult downloadBooks(String account,int bookno){
        User user = userDao.login(account);//得到用户的详细信息
        OnlineBook onlineBook = onlineBookDao.getOnByNo(bookno);
        Bookshelf bookshelf = new Bookshelf(account,bookno);
        if (user.getMember()==0){//不是会员
            if (user.getCredit() < onlineBook.getPrice()){//积分不够
                return new JsonResult("不好意思，您的积分不够，暂时不能下载！",false);
            }else{
                Bookshelf bookshelf1 = bookshelfDao.isExist(account,bookno);
                if (bookshelf1!=null){
                    return new JsonResult("您已拥有此电子书，不用重新购买！",false);
                }else {
                    bookshelfDao.addshelfbook(bookshelf);
                    userDao.updateCredit(account,0-((int)onlineBook.getPrice()));
                }
            }
        }else {
            Bookshelf bookshelf1 = bookshelfDao.isExist(account,bookno);
            if (bookshelf1!=null){
                return new JsonResult("您已拥有此电子书，不用重新添加！",false);
            }else {
                bookshelfDao.addshelfbook(bookshelf);//会员免费购买
            }
        }
        return new JsonResult("添加电子书成功！",true);
    }
}
