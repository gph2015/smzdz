package com.smzdz.dao;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckFeeDiff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/23.
 */
public interface PayCheckFeeDiffDao {

    public Map<String, String> sumCountAndAmt(Pager pager);

    public int selectCount(Pager pager);

    public List<PayCheckFeeDiff> selectByPaging(Pager pager);

    public PayCheckFeeDiff selectDiffById(Long id);

    public void processDiff(@Param("id")Long id, @Param("remark")String remark);

}
