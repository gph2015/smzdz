package com.smzdz.dao;

import com.smzdz.BaseTest;
import com.smzdz.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: hujunfei
 * Date: 2015-03-19 14:40
 */
public class MenuDaoTest extends BaseTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void testSelect() {
         System.out.println(menuDao.selectAll());
    }
}
