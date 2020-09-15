package club.codedemo.springprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class MyWebApplicationInitializer implements ServletContextInitializer {
    @Autowired
    private ConfigurableEnvironment env;


    /**
     * 使用代码来设置当前情景
     * 注意：
     * 该设置并不能够影响项目在启动时读取的项止
     *
     * @param servletContext servlet上下文
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        env.setActiveProfiles("dev");
        servletContext.setInitParameter("spring.profiles.active", "dev");
    }
}
