package club.codedemo.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class SmsServiceImpl implements SmsService {
    public SmsServiceImpl() {
        System.out.println("smsService");
    }

    @Override
    public void sentMessage(String phone, String context) {
        // 调用短信api发送短信
        System.out.println("当前情景为pro");
    }
}