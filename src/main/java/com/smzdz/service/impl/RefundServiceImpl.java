package com.smzdz.service.impl;

import com.smzdz.service.RefundService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.dao.RefundInfoDAO;
import com.smzdz.entity.RefundInfo;
import com.smzdz.service.RefundService;
import com.smzdz.util.result.ResultStatus;
import com.smzdz.util.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: hujunfei
 * Date: 2015-03-03 18:51
 */
@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundInfoDAO refundInfoDAO;

    @Override
    public List<RefundInfo> selectList(RefundInfo refundInfo) throws ServiceException {
        try {
            return refundInfoDAO.select(refundInfo);
        } catch (Exception e) {
            throw new ServiceException(e, ResultStatus.SYSTEM_DB_ERROR);
        }
    }
}
