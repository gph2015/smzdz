package com.smzdz.service;

import com.smzdz.model.TransQueryModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易服务
 * Created by qibaichao on 2015/3/23.
 */
public interface TransQueryService {

    public int selectCount(Pager pager) throws ServiceException;

    public List<TransQueryModel> selectByPaging(Pager pager) throws ServiceException;

    public TransQueryModel selectPayOrderByPayId(String payId) throws ServiceException;

    public TransQueryModel selectNoSuccessByPayId(String payId) throws ServiceException;

    public TransQueryModel selectSuccessByPayId(String payId) throws ServiceException;

    public BigDecimal selectRefundFee(String payId);

    public List<TransStatisModel> statis(Pager pager) throws ServiceException;

}
