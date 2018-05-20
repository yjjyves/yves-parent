import com.yves.model.bill.VirtualBillDO;
import com.yves.model.bill.criteria.VirtualBillCriteria;
import com.yves.model.common.Pagination;
import com.yves.service.bill.VirtualBillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date Created in 17:12 2018/5/15
 */
public class VirtualBillServiceTest extends BaseTests{

    @Autowired
    private VirtualBillService virtualBillService;

    @Test
    public void test_getVirtualBillById(){
        VirtualBillDO virtualBillDO = virtualBillService.getVirtualBillById("fa33eb15-30bb-4f6d-8737-c6428cfcc0ee");
        System.out.println("______________" + virtualBillDO.toString());
    }


    @Test
    public void test_getVirtualBillByPage(){
        Pagination<VirtualBillDO> pagination = new Pagination();
        pagination.setCurrentPage(1);
        pagination.setPageSize(11);
        VirtualBillCriteria virtualBillCriteria = new VirtualBillCriteria();
        virtualBillCriteria.setAgentNumber("13246730744");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", pagination);
        List<VirtualBillDO> users = virtualBillService.getVirtualBillByMap(params);
        System.out.println("______________" + pagination.getCount() + "pageSize" + pagination.getPageSize() + ":::::" + pagination.getItems() );
    }
}
