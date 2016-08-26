import com.zhouxiang.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YKDZ075 on 2016/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SpringTest {
    @Autowired
    private Message message;
    @Test
    public void test1(){
      message.setMessage("hello");
        System.out.println(message.getMessage());
    }
}
