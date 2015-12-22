package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.model.PayCheckDiffModel;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.JsonUtil;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qibaichao on 2015/3/12.
 */
public class PayCheckManagerTest extends BaseTest {

    @Autowired
    private PayCheckManager payCheckManager;

    @Test
    public void selectPaging() {

        Pager pager = new Pager();
        pager.getF().put("checkDate", "20140612");
        pager.getF().put("agencyCode", "TENPAY");
        pager.getF().put("bizCode", "1");
        pager.getF().put("status", "3");
        pager.setPageNo(1);
        ResultListBean<PayCheckDiffModel> resultListBean = payCheckManager.selectDiffByPaging(pager);
        System.out.println(JsonUtil.beanToJson(resultListBean));
        System.out.println(JsonUtil.beanToJson(pager));
    }

    @Test
    public void selectDiffById() {
        Long id = 72L;
        ResultBean<PayCheckDiffModel> resultBean = payCheckManager.selectDiffById(id);
        System.out.println(JsonUtil.beanToJson(resultBean));
    }

    @Test
    public void processDiff() {
        Long id = 72L;
        String remark = "hhhh";
        ResultBean resultBean = payCheckManager.processDiff(id, remark);
        System.out.println(JsonUtil.beanToJson(resultBean));
    }

}
