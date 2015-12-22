package com.smzdz.manager;

import com.smzdz.model.TransQueryModel;
import com.smzdz.util.utils.Pager;
import com.smzdz.model.TransQueryModel;
import com.smzdz.model.TransStatisModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;

/**
 * 交易查询
 * Created by qibaichao on 2015/3/23.
 */
public interface TransManager {

    public ResultListBean<TransQueryModel> selectByPaging(Pager pager);

    public ResultBean<TransQueryModel> selectByPayId(String payId);

    public ResultListBean<TransStatisModel> statis(Pager pager);

}
