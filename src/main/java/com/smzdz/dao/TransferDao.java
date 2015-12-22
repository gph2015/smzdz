package com.smzdz.dao;

import com.smzdz.util.utils.Pager;
import com.smzdz.entity.Transfer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 用户平台事业部---高朋辉
 * @version 1.0
 * @date 2015/6/12 15:53
 */
@Repository
public interface TransferDao {
    public int selectCount(Pager pager);

    public List<Transfer> selectTransferInfo(Pager pager);

    public int selectDetailCount(Pager pager);

    public List<Transfer> selectTransferDetailInfo(@Param("batchNo")String batchNo, @Param("appId")Integer appId);

}
