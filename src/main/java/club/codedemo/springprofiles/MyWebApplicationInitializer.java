package club.codedemo.springprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class MyWebApplicationInitializer implements ServletContextInitializer {

    @Autowired
    private ConfigurableEnvironment env;

    /**
     * 使用代码来设置:
     * 1. 设置激活的active值
     * 2. 设置环境变量中的spring.profiles.active值
     * 上述两点并不同，具体请参考：SmsServiceConsoleImpl->sendMessage中的日志
     *
     * 注意：
     * 由于Spring在项目启动时便获取了spring.profiles.active值
     * 而此方法在执行时Spring项目已经获取了spring.profiles.active的值
     * 所以此时对spring.profiles.active的变更并不会影响Spring对当前情景的获取
     * 当然也不会影响@Profile注解的依据active的值来决定装载的Bean
     *
     * @param servletContext servlet上下文
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("当前情景为");
        for (String active: env.getActiveProfiles()) {
            System.out.println(active);
        }
        env.setActiveProfiles("dev-env");

        System.out.println("当前情景为");
        for (String active: env.getActiveProfiles()) {
            System.out.println(active);
        }
        servletContext.setInitParameter(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev-setInitParameter");
    }
}
