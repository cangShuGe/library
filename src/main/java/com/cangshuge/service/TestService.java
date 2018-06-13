package com.cangshuge.service;

import com.cangshuge.dao.TestDao;
import com.cangshuge.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public String testShow(){
        TestUser testUser = testDao.testUser();
        return testUser.getAccount()+","+
               testUser.getPwd()+","+
               testUser.getMailbox()+","+
               testUser.getMember()+","+
               testUser.getAddress()+","+
               testUser.getCredit()+","+
               testUser.getName()+","+
               testUser.getSex()+","+
               testUser.getBirthday()+"!\n";
    }
}
