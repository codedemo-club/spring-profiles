package club.codedemo.springprofiles;

import club.codedemo.springprofiles.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 系统初始化完毕后，将执行onApplicationEvent方法
 */
@Component
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.context.getBean(SmsService.class).sentMessage("13888888888", "hello yunzhi");
    }
}
