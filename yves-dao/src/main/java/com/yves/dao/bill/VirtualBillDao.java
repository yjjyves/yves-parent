package com.yves.dao.bill;

import com.yves.model.bill.VirtualBillDO;
import com.yves.model.bill.criteria.VirtualBillCriteria;
import com.yves.model.common.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public interface VirtualBillDao {

    VirtualBillDO getVirtualBillById(@Param(value = "id") String id);

    List<VirtualBillDO> listVirtualBillByPage(VirtualBillCriteria virtualBillCriteria, Pagination<VirtualBillDO> pagination);

    List<VirtualBillDO> listVirtualBillByPage(Pagination<VirtualBillDO> pagination);


    List<VirtualBillDO> listVirtualBillByPage(Map<String, Object> params);


}
