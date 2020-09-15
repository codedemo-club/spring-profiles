package club.codedemo.springprofiles.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceTest {

    @Autowired
    SmsService smsService;

    @Test
    void sentMessage() {
        this.smsService.sentMessage("13888888888", "message");
    }
}