import com.yves.model.bill.VirtualBillDO;
import com.yves.service.bill.VirtualBillService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
