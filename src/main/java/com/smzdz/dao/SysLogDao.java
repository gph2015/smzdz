package com.smzdz.dao;

import com.smzdz.entity.SysLog;
import org.springframework.stereotype.Repository;

/**
 * Created by qibaichao on 2015/4/15.
 */
@Repository
public interface SysLogDao {

    public void insertLog(SysLog sysLog);

}
