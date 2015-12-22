package com.smzdz.dao;

import com.smzdz.entity.PayCheckFeeResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qibaichao on 2015/3/23.
 */
@Repository
public interface PayCheckFeeResultDao {


    public List<PayCheckFeeResult> selectByDateAndAgency(@Param("checkDate") String checkDate,
                                                      @Param("agencyCode") String agencyCode,
                                                      @Param("bizCode") Integer bizCode,
                                                      @Param("status") Integer status);
}
