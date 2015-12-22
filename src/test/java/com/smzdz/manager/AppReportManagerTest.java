package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.util.utils.Pager;
import com.smzdz.BaseTest;
import com.smzdz.model.AppReportModel;
import com.smzdz.model.AppReportSumModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2015/3/30.
 */
public class AppReportManagerTest extends BaseTest {

    @Autowired
    private AppReportManager appReportManager;

    @Test
    public void selectSum() {
        Pager pager = new Pager();
        ResultBean<AppReportSumModel> resultBean = appReportManager.selectSum(pager);
        System.out.println(JsonUtil.beanToJson(resultBean));
    }

    @Test
    public void selectByPaging() {
        Pager pager = new Pager();
        ResultListBean<AppReportModel> resultListBean = appReportManager.selectByPaging(pager);
        System.out.println(JsonUtil.beanToJson(resultListBean));
    }

}
