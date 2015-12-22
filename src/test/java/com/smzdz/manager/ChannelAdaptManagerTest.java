package com.smzdz.manager;

import com.smzdz.BaseTest;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.smzdz.BaseTest;
import com.smzdz.model.PayChannelAdaptModel;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;

public class ChannelAdaptManagerTest extends BaseTest {
    @Autowired
    ChannelAdaptManager channelAdaptManager;
    
    @Test
    public void getList(){
        PMap map = new PMap();
        map.put("appId",1999);
        ResultListBean<PayChannelAdaptModel> result = channelAdaptManager.getChannelAdaptList(null);
        System.out.println(result.getValue().size());
        System.out.println(result.getValue());
    }
    
    @Test
    public void selectCountTest(){
        Pager pager = new Pager();
        System.out.println(channelAdaptManager.getChannelAdaptList(pager));
    }
}
