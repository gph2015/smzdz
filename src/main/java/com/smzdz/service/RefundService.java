package com.smzdz.service;


import com.smzdz.entity.RefundInfo;
import com.smzdz.util.utils.ServiceException;

import java.util.Date;
import java.util.List;

/**
 * User: hujunfei
 * Date: 2015-03-03 18:49
 */
public interface RefundService {
    public static final int REFUND_INIT = 1;
    public static final int REFUND_SUCCESS = 2;
    public static final int REFUND_FAIL = 3;

    /**
     * 查询退款信息
     * @param refundInfo
     * @return 查询结果
     * @throws ServiceException
     */
    public List<RefundInfo> selectList(RefundInfo refundInfo) throws ServiceException;
}
