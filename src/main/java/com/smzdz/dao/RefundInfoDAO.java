package com.smzdz.dao;

import com.smzdz.entity.RefundInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjf on 15-3-2.
 */
@Repository
public interface RefundInfoDAO {

    public List<RefundInfo> select(RefundInfo refundInfo);
}
