package com.smzdz.web.controller;

import com.alibaba.druid.util.StringUtils;
import com.smzdz.util.Constant;
import com.smzdz.util.result.Result;
import com.smzdz.util.result.ResultListBean;
import com.smzdz.util.utils.PMap;
import com.smzdz.util.utils.Pager;
import com.smzdz.enums.OperationLogType;
import com.smzdz.manager.ChannelInfoManager;
import com.smzdz.model.ChannelInfoModel;
import com.smzdz.service.ImgService;
import com.smzdz.util.result.ResultBean;
import com.smzdz.util.utils.CommonConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/3/25 11:52
 */
@Controller
@RequestMapping("/channelInfo")
public class ChannelInfoController extends BaseController {

    @Autowired
    private ChannelInfoManager channelInfoManager;
    @Autowired
    private ImgService imgService;

    @RequestMapping("/query")
    public ModelAndView getChannelInfoList(Pager pager) {
        ModelAndView view = new ModelAndView("/configure/channelInfo/channelInfoList");
        if (StringUtils.isEmpty(pager.getF().get("channelType"))) {
            pager.getF().put("channelType", "0");
        }
        ResultListBean<ChannelInfoModel>
                resultList =
                channelInfoManager.queryChannelInfoList(pager);
        if (!Result.isSuccess(resultList)) {
            return setErrorPage(resultList.getStatus().getMessage(), resultList
                    .getStatus().getCode());
        }
        List<ChannelInfoModel> channelInfoList = resultList.getValue();
        view.addObject("channelTypeMap", Constant.CHANNELTYPEMAP);
        view.addObject("pager", pager);
        view.addObject("channelInfoList", channelInfoList);
        return view;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView("/configure/channelInfo/addChannelInfo");
        modelAndView.addObject("channelNatureMap", Constant.CHANNELNATUREMAP);
        modelAndView.addObject("channelTypeMap", Constant.CHANNELTYPEMAP);
        return modelAndView;
    }

    @RequestMapping("/addChannelInfo")
    public ModelAndView addChannelInfo(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam(value = "logo",
                                               required = false) CommonsMultipartFile logo) {
        PMap map = new PMap();
        map.put("channelCode", request.getParameter("channelCode"));         //渠道编码
        map.put("channelName", request.getParameter("channelName"));
        map.put("channelNature", request.getParameter("channelNature"));
        map.put("lowLimit", request.getParameter("lowLimit"));
        map.put("highLimit", request.getParameter("highLimit"));
        map.put("limitInfo", request.getParameter("limitInfo"));
        map.put("channelType", request.getParameter("channelType"));
        String path = request.getSession().getServletContext().getRealPath("./static/i/bank");
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        try {
            FileCopyUtils.copy(logo.getBytes(), new File(path + "/" + logo.getOriginalFilename()));
        } catch (IOException e) {
            return setErrorPage("Add Logo Error", 999);
        }
        File f = new File(path + "/" + logo.getOriginalFilename());
        boolean isOk = imgService.uploadImg(logo.getOriginalFilename(), f, CommonConstant.APPID);
        if (!isOk) {
            return setErrorPage("Add Logo Error", 999);
        }
        String logoAllName = logo.getOriginalFilename();
        map.put("logo", "http://img03.sogoucdn.com/app/a/200538/" + logoAllName);
        Result result = channelInfoManager.insertChannelInfo(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.INSERT, "addChannelInfo", map);
        return toSuccess();
    }

    @RequestMapping("/showChannelInfo")
    public ModelAndView showChannelInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String flag = request.getParameter("flag");
        if ("detail".equals(flag)) {
            modelAndView.setViewName("/configure/channelInfo/channelInfoDetail");
        } else if ("update".equals(flag)) {
            modelAndView.setViewName("/configure/channelInfo/updateChannelInfo");
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        ResultBean<ChannelInfoModel> result = channelInfoManager.queryChannelInfoDetailById(id);
        ChannelInfoModel channelInfo = result.getValue();
        modelAndView.addObject("channelNatureMap", Constant.CHANNELNATUREMAP);
        modelAndView.addObject("channelTypeMap", Constant.CHANNELTYPEMAP);
        modelAndView.addObject("channelInfo", channelInfo);
        return modelAndView;
    }

    @RequestMapping("/updateChannelInfo")
    public ModelAndView updateMerchant(HttpServletRequest request, @RequestParam(value = "updatelogo",
            required = false) CommonsMultipartFile updatelogo) {
        PMap map = new PMap();
        if (updatelogo.getSize() == 0) {
            map.put("logo", request.getParameter("logo"));
        } else {
            String path = request.getSession().getServletContext().getRealPath("./static/i/bank");
            File file = new File(path);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            try {
                FileCopyUtils.copy(updatelogo.getBytes(), new File(path + "/" + updatelogo.getOriginalFilename()));
            } catch (IOException e) {
                return setErrorPage("Upload Logo Error", 999);
            }
            File f = new File(path + "/" + updatelogo.getOriginalFilename());
            boolean isOk = imgService.uploadImg(updatelogo.getOriginalFilename(), f, CommonConstant.APPID);
            if (!isOk) {
                return setErrorPage("Upload Logo Error", 999);
            }
            String logoAllName = updatelogo.getOriginalFilename();
            map.put("logo", "http://img03.sogoucdn.com/app/a/200538/" + logoAllName);
        }
        map.put("id", request.getParameter("id"));
        map.put("channelCode", request.getParameter("channelCode"));         //渠道编码
        map.put("channelName", request.getParameter("channelName"));
        map.put("channelNature", request.getParameter("channelNature"));
        map.put("lowLimit", request.getParameter("lowLimit"));
        map.put("highLimit", request.getParameter("highLimit"));
        map.put("limitInfo", request.getParameter("limitInfo"));
        map.put("channelType", request.getParameter("channelType"));
        Result<Boolean> result = channelInfoManager.updateChannelInfo(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        toLog(OperationLogType.UPDATE, "updateMerchant", map);
        return toSuccess();
    }

    @RequestMapping("/deleteChannelInfo")
    public ModelAndView deleteMerchant(HttpServletRequest request, HttpServletResponse response) {
        PMap map = new PMap();
        map.put("id", request.getParameter("id"));
        Result<Boolean> result = channelInfoManager.deleteChannelInfo(map);
        if (!Result.isSuccess(result)) {
            return setErrorPage(result.getStatus().getMessage(), result
                    .getStatus().getCode());
        }
        Pager pager = new Pager();
        if (StringUtils.isEmpty(pager.getF().get("channelType"))) {
            pager.getF().put("channelType", "0");
        }
        toLog(OperationLogType.DELETE, "deleteMerchant", map);
        return toSuccess();
    }
}
