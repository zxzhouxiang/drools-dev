package com.zhouxiang.service;

import com.zhouxiang.model.Message;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * Created by YKDZ075 on 2016/8/29.
 */
@Service
public class RouteService {
    @KSession("ksession_route")
   private KieSession kieSession;
    public void route(){
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        System.out.println(message.getStatus());
        //将实体类插入执行规则
        kieSession.insert(message);
        kieSession.fireAllRules();
        System.out.println(message.getStatus()+"  "+Message.GOODBYE);
    }
}
