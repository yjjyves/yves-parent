package com.yves.service.bill.impl;

import com.yves.dao.bill.VirtualBillDao;
import com.yves.model.bill.VirtualBillDO;
import com.yves.model.bill.criteria.VirtualBillCriteria;
import com.yves.model.common.Pagination;
import com.yves.service.bill.VirtualBillService;
import com.yves.util.common.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date Created in 17:07 2018/5/16
 */
@Service(value = "virtualBillService")
public class VirtualBillServiceImpl implements VirtualBillService {
    @Autowired
    private VirtualBillDao virtualBillDao;

    @Override
    public VirtualBillDO getVirtualBillById(String id) {
        return virtualBillDao.getVirtualBillById(id);
    }

    @Override
    public Pagination<VirtualBillDO> getVirtualBillByPage(Pagination<VirtualBillDO> pagination, VirtualBillCriteria virtualBillCriteria) {
        if(virtualBillCriteria == null){
            return null;
        }
        List<VirtualBillDO> virtualBillDOList = virtualBillDao.listVirtualBillByPage(pagination);
        pagination.setItems(virtualBillDOList);
        return pagination;
    }

    @Override
    public List<VirtualBillDO> getVirtualBillByMap(Map<String, Object> params) {
        if(CommonUtil.isEmpty(params)){
            return null;
        }
        List<VirtualBillDO> virtualBillDOList = virtualBillDao.listVirtualBillByPage(params);
        return virtualBillDOList;
    }
}
