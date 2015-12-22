package com.smzdz.dao;

import com.smzdz.entity.Auth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/24 15:24
 */
@Repository
public interface AuthDao {
    public List<Auth> selectList(@Param("userId") Integer userId);

    public List<Integer> selectMenuIds(@Param("userId") Integer userId);

    public int insertList(List<Auth> auths);

    public int deleteUserAuth(@Param("userid") Integer userid);

    public int updateUseAuth(Auth auth);

    public int getCount(@Param("userId") String userId, @Param("menuId") String menuId);

}
