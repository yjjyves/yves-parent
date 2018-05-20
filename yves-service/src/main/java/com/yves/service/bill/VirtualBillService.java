package com.yves.service.bill;

import com.yves.model.bill.VirtualBillDO;
import com.yves.model.bill.criteria.VirtualBillCriteria;
import com.yves.model.common.Pagination;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date Created in 17:06 2018/5/16
 */
public interface VirtualBillService {
    VirtualBillDO getVirtualBillById(String id);

    Pagination<VirtualBillDO> getVirtualBillByPage(Pagination<VirtualBillDO> pagination, VirtualBillCriteria virtualBillCriteria);

    List<VirtualBillDO> getVirtualBillByMap(Map<String, Object> params);
}
