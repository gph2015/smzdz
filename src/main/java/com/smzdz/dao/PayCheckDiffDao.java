package com.smzdz.dao;

import com.smzdz.entity.PayCheckDiff;
import com.smzdz.util.utils.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/23.
 */
@Repository
public interface PayCheckDiffDao {


    public Map<String, String> sumCountAndAmt(Pager pager);

    public int selectCount(Pager pager);

    public List<PayCheckDiff> selectByPaging(Pager pager);

    public PayCheckDiff selectDiffById(Long id);

    public void processDiff(@Param("id") Long id, @Param("remark") String remark);


    public int selectNoProcessCount(@Param("checkDate") String checkDate, @Param("agencyCode") String agencyCode,
                                    @Param("bizCode") Integer bizCode);

}
