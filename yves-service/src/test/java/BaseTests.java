import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ra on 2015/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:application-dao.xml",
        "classpath:application-service.xml"

})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class BaseTests {
}
