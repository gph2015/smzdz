package com.smzdz.manager;

import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.PayCheckFeeDiffModel;
import com.smzdz.model.PayCheckFeeResultModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;

import java.util.Map;

/**
 * 手续费对账查询
 * Created by qibaichao on 2015/3/23.
 */
public interface PayCheckFeeManager {

    public ResultListBean<PayCheckFeeResultModel> selectByDateAndAgency(String checkDate, String agencyCode, Integer bizCode, Integer status);

    public ResultBean<Map> sumDiffCountAndAmt(Pager pager);

    public ResultListBean<PayCheckFeeDiffModel> selectDiffByPaging(Pager pager);

    public ResultBean<PayCheckFeeDiffModel> selectDiffById(Long id);

    public ResultBean processDiff(Long id, String remark);
}
