package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.BaseTest;
import com.smzdz.entity.User;
import com.smzdz.model.UserModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserManagerTest extends BaseTest {

    @Autowired
    private UserManager ma;

    //查询全部用户
    @Test
    public void testQueryAll() {
//        ResultListBean<UserModel> result = ma.queryAllUser();
//        System.out.println(result.getStatus().getCode());
//        System.out.println(result.getValue().toString());
//        List<UserModel> list = result.getValue();
//        System.out.println(list.size());
    }

    //根据条件查询
    @Test
    public void queryUserByParams() {
        String name="测试账号";
        String mail=null;
        ResultListBean<UserModel> result = ma.queryUserByParams(name, mail);
        System.out.println(result.getStatus().getCode());
        System.out.println(result.getValue().toString());
        List<UserModel> list = result.getValue();
        System.out.println(list.size());
    }

    //新增用户
    @Test
    public void testInsert() {
        User info = new User();
        info.setName("高朋辉");
        info.setMail("gaopenghui@sogou-inc.com");
        info.setStatus(1);
        info.setAppId(111);
        info.setCreateTime(new Date());
////        Result<Boolean> result = ma.addUser("gph11112", "asdfs1df", 111);
//        System.out.println(result);
    }

}
