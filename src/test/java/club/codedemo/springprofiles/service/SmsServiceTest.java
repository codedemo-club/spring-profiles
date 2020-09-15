package club.codedemo.springprofiles.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * SpringProfilesApplication中的main方法对单元测试并不生效
 * 预在单元测试中指定某个情景，则需要使用@ActiveProfiles注解
 *
 * 注意：若测试使用JVM或设置环境变量的方法来设置项目情景的方法
 * 则应该注释掉@ActiveProfiles("dev")注解以避免干扰
 */
@SpringBootTest
@ActiveProfiles("dev")
class SmsServiceTest {

    @Autowired
    ApplicationContext context;

    /**
     * 在默认未设置情景的情况下，Spring Boot的情景为 default
     * 由于SmsService的两个实现，一个是在dev下生效，另一个是在pro下生效
     * 所以此时是无法获取实现了SmsService的bean的
     * 在执行以下单元测试时，将得到一个找不到Bean的异常
     *
     * 一、可以通过添加JVM选项来设置项目的情景：
     * 比如:
     * 1. -Dspring.profiles.active=dev
     * 2. -Dspring.profiles.active=pro
     * 此时，再运行此测试，单元测试通过并且会根据情景获取到对应的SmsService Bean
     *
     * 二、可以通过设置当前用户的环境变量来设置当前项目的情景
     * 1. 如果是使用的shell，则执行：export spring_profiles_active=dev
     * 2. 如果是IDEA，则打开此单元测试的配置 -> Environment Variables: spring_profiles_active=dev
     */
    @Test
    void sentMessage() {
        SmsService smsService = this.context.getBean(SmsService.class);
        smsService.sentMessage("13888888888", "message");
    }
}