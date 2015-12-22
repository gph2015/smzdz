package com.smzdz.dao;

import com.smzdz.model.TransQueryModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.TransStatisModel;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @User: qibaichao
 * @Date: 2015/03/03
 * @Description: 交易查询Dao
 */
@Repository
public interface TransQueryDao {

    public List<TransStatisModel> selectCount(Pager pager);

    public List<TransQueryModel> selectByPaging(Pager pager);

    public TransQueryModel selectPayOrderByPayId(String payId);

    public TransQueryModel selectNoSuccessByPayId(String payId);

    public TransQueryModel selectSuccessByPayId(String payId);

    public  BigDecimal selectRefundFee(String payId);

}
