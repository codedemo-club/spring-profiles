package club.codedemo.springprofiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class SmsServiceImpl implements SmsService {
    @Autowired
    Environment environment;

    @Override
    public void sentMessage(String phone, String context) {
        // 调用短信api发送短信
        System.out.println("当前情景为pro:" + phone + context);
        System.out.println("当前环境environment中的情景值为：" + environment.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME));
        System.out.println("当前环境environment中生效的情景值为：");
        for (String active: environment.getActiveProfiles()) {
            System.out.println(active);
        }
        System.out.println(environment.getProperty("spring.application.name"));
    }
}