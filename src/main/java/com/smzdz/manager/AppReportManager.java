package com.smzdz.manager;

import com.smzdz.util.utils.Pager;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by qibaichao on 2015/3/30.
 * 业务报表
 */
public interface AppReportManager {


    public ResultBean<AppReportSumModel> selectSum(Pager pager);


    public ResultListBean<AppReportModel> selectByPaging(Pager pager);

    public void reportExport(Pager pager,HttpServletResponse response);


}
