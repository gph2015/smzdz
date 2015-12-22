package com.smzdz.dao;

import com.smzdz.BaseTest;
import com.smzdz.entity.Auth;
import com.smzdz.BaseTest;
import com.smzdz.entity.Auth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * User: hujunfei
 * Date: 2015-03-19 17:17
 */
public class AuthDaoTest extends BaseTest {

    @Autowired
    private AuthDao authDao;

    @Test
    public void testInsert() {
        Auth auth1 = new Auth();
        auth1.setUserId(4);
        auth1.setMenuId(1);

        Auth auth2 = new Auth();
        auth2.setMenuId(2);
        auth2.setUserId(4);

        List<Auth> list = new ArrayList<>();
        list.add(auth1);
        list.add(auth2);
        System.out.println(authDao.insertList(list));
    }
}
