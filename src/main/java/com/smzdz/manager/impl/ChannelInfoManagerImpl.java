package com.smzdz.manager.impl;
/**
 *
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/12 15:30
 */

import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.StringUtil;
import com.smzdz.entity.ChannelInfo;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.service.ChannelInfoService;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultBasicBean;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.util.utils.ServiceException;

import com.smzdz.util.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ChannelInfoManagerImpl implements ChannelInfoManager {

    private static final Logger logger = LoggerFactory.getLogger(ChannelInfoManagerImpl.class);

    @Autowired
    private ChannelInfoService channelInfoService;

    @Override
    public ResultListBean<ChannelInfoModel> queryChannelInfoList(Pager pager) {
        ResultListBean<ChannelInfoModel> channelInfoBean = ResultListBean.build();
        List<ChannelInfo> resultList = null;
        try {
            int totalCount = channelInfoService.selectCount(pager);
            if (totalCount > 0) {
                pager.resetTotalCount(totalCount);
                resultList = channelInfoService.queryChannelInfoList(pager);
            }
            channelInfoBean.success(covertData(resultList), totalCount);
        } catch (ServiceException e) {
            channelInfoBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return channelInfoBean;


    }

    @Override
    public ResultListBean<ChannelInfoModel> queryChannelInfoList() {
        ResultListBean<ChannelInfoModel> channelInfoBean = ResultListBean.build();
        try {
            List<ChannelInfo> channelInfo = channelInfoService.queryChannelInfoList();
            channelInfoBean.success(covertData(channelInfo));
        } catch (ServiceException e) {
            channelInfoBean.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return channelInfoBean;


    }

    private List<ChannelInfoModel> covertData(List<ChannelInfo> channelInfo) {
        if (null == channelInfo || channelInfo.size() == 0) {
            return null;
        }
        List<ChannelInfoModel> list = new ArrayList<ChannelInfoModel>();
        ChannelInfoModel model = null;
        for (ChannelInfo info : channelInfo) {
            model = new ChannelInfoModel(info);
            list.add(model);
        }
        return list;
    }

    @Override
    public ResultBean<ChannelInfoModel> queryChannelInfoDetailById(Integer id) {
        ResultBean<ChannelInfoModel> result = ResultBean.build();
        try {
            ChannelInfo channelInfo = channelInfoService.queryChannelInfoDetailById(id);
            ChannelInfoModel model = new ChannelInfoModel(channelInfo);
            result.setValue(model);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultBasicBean<Boolean> insertChannelInfo(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        if (!StringUtil.isMoney(map.getString("lowLimit"))) {
            result.withError(ResultStatus.ADD_CHANNEL_LOW_ERROR);
            return result;
        }
        if (!StringUtil.isMoney(map.getString("highLimit"))) {
            result.withError(ResultStatus.ADD_CHANNEL_HIGH_ERROR);
            return result;
        }
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setChannelCode(map.getString("channelCode"));            //渠道编码
        channelInfo.setChannelName(map.getString("channelName"));
        channelInfo.setChannelNature(map.getInt("channelNature"));
        channelInfo.setLogo(map.getString("logo"));
        channelInfo.setLowLimit(new BigDecimal(map.getString("lowLimit")));
        channelInfo.setHighLimit(new BigDecimal(map.getString("highLimit")));
        channelInfo.setLimitInfo(map.getString("limitInfo"));
        channelInfo.setChannelType(map.getInt("channelType"));
        channelInfo.setCreateTime(new Date());
        channelInfo.setModifyTime(new Date());
        try {
            int count = channelInfoService.queryChannelByCode(channelInfo.getChannelCode());
            if (count != 0) {
                result.withError(ResultStatus.ADD_CHANNEL_ERROR);
                return result;
            }
            channelInfoService.insertChannelInfo(channelInfo);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<Boolean> updateChannelInfo(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setId(map.getInt("id"));
        channelInfo.setChannelCode(map.getString("channelCode"));            //渠道编码
        channelInfo.setChannelName(map.getString("channelName"));
        channelInfo.setChannelNature(map.getInt("channelNature"));
        channelInfo.setLogo(map.getString("logo"));
        channelInfo.setLowLimit(new BigDecimal(map.getString("lowLimit")));
        channelInfo.setHighLimit(new BigDecimal(map.getString("highLimit")));
        channelInfo.setLimitInfo(map.getString("limitInfo"));
        channelInfo.setChannelType(map.getInt("channelType"));
        channelInfo.setModifyTime(new Date());
        try {
            channelInfoService.updateChannelInfo(channelInfo);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除用户所有信息
     */
    @Override
    public ResultBasicBean<Boolean> deleteChannelInfo(PMap map) {
        ResultBasicBean<Boolean> result = ResultBasicBean.build();
        Integer id = map.getInt("id");
        try {
            channelInfoService.deleteChannelInfo(id);
        } catch (ServiceException e) {
            result.withError(ResultStatus.SYSTEM_ERROR);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map queryChannelInfoForMap() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            map = channelInfoService.queryChannelInfoForMap();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        }
        return map;
    }

}
