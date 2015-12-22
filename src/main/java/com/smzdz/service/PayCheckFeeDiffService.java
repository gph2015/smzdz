package com.smzdz.service;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckFeeDiff;
import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/26.
 */
public interface PayCheckFeeDiffService {

    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException;

    public int selectCount(Pager pager) throws ServiceException;

    public List<PayCheckFeeDiff> selectByPaging(Pager pager) throws ServiceException;

    public PayCheckFeeDiff selectDiffById(Long id) throws ServiceException;

    public void processDiff(Long id, String remark) throws ServiceException;
}
