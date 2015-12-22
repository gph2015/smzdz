package com.smzdz.dao;

import com.smzdz.entity.MenuItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: hujunfei
 * Date: 2015-03-19 09:30
 */
@Repository
public interface MenuDao {
    public MenuItem select(@Param("id") Integer id);
    public List<MenuItem> selectList(List<Integer> ids);
    public List<MenuItem> selectAll();
    public int insert(MenuItem menuItem);
    public List<MenuItem> selectByParent(@Param("parent") Integer parent);
    public List<Integer> selectAllMenuId();
    public List<MenuItem> selectTwoMenu();
    public int deleteMenu(@Param("id") Integer id);

}
