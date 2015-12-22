package com.smzdz.manager;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.PayCheckResult;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.model.PayCheckModel;
import com.smzdz.model.PayCheckResultModel;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * 对账查询
 * Created by qibaichao on 2015/3/12.
 */
public interface PayCheckManager {


//    public ResultBean<Map> sumCountAndAmt(Pager pager) ;
//    public ResultListBean<PayCheckModel> selectByPaging(Pager pager);

    public ResultListBean<PayCheckResultModel> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status);

    public ResultBean<Map> sumDiffCountAndAmt(Pager pager);

    public ResultListBean<PayCheckDiffModel> selectDiffByPaging(Pager pager);

    public ResultBean<PayCheckDiffModel> selectDiffById(Long id);

    public ResultBean processDiff(Long id, String remark);

    public void processResultStatus(String checkDate, String agencyCode, Integer bizCode);

}
