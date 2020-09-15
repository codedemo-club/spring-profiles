package club.codedemo.springprofiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
//@Profile("!pro")
public class SmsServiceConsoleImpl implements SmsService {
    @Autowired
    Environment environment;

    @Override
    public void sentMessage(String phone, String context) {
        // 在控制台中打印发送的手机号及内容
        System.out.println("当前情景为dev:" + phone + context);
        System.out.println("当前环境environment中的情景值为：" + environment.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME));
        System.out.println("当前环境environment中生效的情景值为：");
        for (String active: environment.getActiveProfiles()) {
            System.out.println(active);
        }
        System.out.println(environment.getProperty("spring.application.name"));
    }
}