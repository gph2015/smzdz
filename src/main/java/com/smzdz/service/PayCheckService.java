package com.smzdz.service;

import com.smzdz.util.utils.Pager;
import com.smzdz.model.PayCheckModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/12.
 */
public interface PayCheckService {

    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException;

    public int  selectCount(Pager pager) throws ServiceException;

    public List<PayCheckModel> selectByPaging(Pager pager)throws ServiceException;
}
