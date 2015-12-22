package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.service.AuthService;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.BaseTest;

import com.smzdz.entity.Auth;
import com.smzdz.entity.User;
import com.smzdz.model.AuthMenuModel;
import com.smzdz.service.AuthService;
import com.smzdz.util.result.ResultListBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * User: hujunfei
 * Date: 2015-03-19 11:44
 */
public class AuthManagerTest extends BaseTest {
    @Autowired
    private AuthManager authManager;
    @Autowired
    private AuthService authService;
    private static final String EMAIL = "test1@sogou-inc.com";


    @Test
    public void test() {
        String reg = "^[0-9]{4,8}(\\|[0-9]{4,8})*$";

        System.out.println("1004".matches(reg));
        System.out.println("1004|2003949|239203".matches(reg));
        System.out.println("10a4".matches(reg));
        System.out.println(authManager.insertAuths("test1@sogou-inc.com", "1|2"));
    }

    @Test
    public void testInsert() {
        try {

            ResultListBean<AuthMenuModel> resultList = authManager.queryAuthMenu(Integer.valueOf(47));

            System.out.println(resultList);

        } catch (Exception e) {
            System.out.println("2");
        }
    }
}
