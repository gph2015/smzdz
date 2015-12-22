package com.smzdz.service;

import com.smzdz.entity.PayCheckDiff;
import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckDiff;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import javax.xml.ws.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by qibaichao on 2015/3/26.
 */
public interface  PayCheckDiffService {

    public Map<String, String> sumCountAndAmt(Pager pager) throws ServiceException;

    public int selectCount(Pager pager)throws ServiceException;

    public List<PayCheckDiff> selectByPaging(Pager pager)throws ServiceException;

    public PayCheckDiff selectDiffById(Long id) throws ServiceException;

    public void processDiff(Long id, String remark) throws ServiceException;

    public int selectNoProcessCount(String checkDate, String agencyCode, Integer bizCode);

}
