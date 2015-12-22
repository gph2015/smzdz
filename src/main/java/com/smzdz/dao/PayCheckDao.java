package com.smzdz.dao;

import com.smzdz.util.utils.Pager;
import com.smzdz.model.PayCheckModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author qibaichao
 * @ClassName PayCheckDao
 * @Date 2015年03月12日
 * @Description:
 */
@Repository
public interface PayCheckDao {

    public Map<String, String> sumCountAndAmt(Pager pager);

    public int selectCount(Pager pager);

    public List<PayCheckModel> selectByPaging(Pager pager);

}
