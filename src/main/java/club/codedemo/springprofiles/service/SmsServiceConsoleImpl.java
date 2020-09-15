package club.codedemo.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
//@Profile("!pro")
public class SmsServiceConsoleImpl implements SmsService {
    @Override
    public void sentMessage(String phone, String context) {
        // 在控制台中打印发送的手机号及内容
        System.out.println("当前情景为dev");
    }
}