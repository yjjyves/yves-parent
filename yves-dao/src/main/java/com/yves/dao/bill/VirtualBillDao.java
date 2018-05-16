package com.yves.dao.bill;

import com.yves.model.bill.VirtualBillDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
public interface VirtualBillDao {

    VirtualBillDO getVirtualBillById(@Param(value = "id") String id);
}
