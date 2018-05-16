package com.yves.service.bill.impl;

import com.yves.dao.bill.VirtualBillDao;
import com.yves.model.bill.VirtualBillDO;
import com.yves.service.bill.VirtualBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
