package com.smzdz.dao;

import com.smzdz.entity.PayCheckResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author qibaichao
 * @ClassName PayCheckResultDao
 * @Date 2015年03月12日
 * @Description:
 */
@Repository
public interface PayCheckResultDao {

    public List<PayCheckResult> selectByDateAndAgency(@Param("checkDate") String checkDate,
                                                      @Param("agencyCode") String agencyCode,
                                                      @Param("bizCode") Integer bizCode,
                                                      @Param("status") Integer status);

    public void updateResultStatus(@Param("checkDate") String checkDate,
                                   @Param("agencyCode") String agencyCode,
                                   @Param("bizCode") Integer bizCode);
}
