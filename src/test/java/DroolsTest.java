import com.zhouxiang.model.Message;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.TimedRuleExectionOption;
import org.kie.api.runtime.conf.TimedRuleExecutionFilter;

/**
 * Created by YKDZ075 on 2016/8/26.
 */
public class DroolsTest {
    @Test
    public  void test1(){
        try {
            //从工厂中获得KieServices实例
            KieServices kieServices = KieServices.Factory.get();
            //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
            KieContainer kieContainer = kieServices.getKieClasspathContainer();
            //建立KieSession到规则文件的通信管道
            KieSession kSession = kieContainer.newKieSession("ksession-rules");
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            System.out.println(message.getStatus());
            //将实体类插入执行规则
            kSession.insert(message);
            kSession.fireAllRules();
            System.out.println(message.getStatus()+"  "+Message.GOODBYE);
        }catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
}
