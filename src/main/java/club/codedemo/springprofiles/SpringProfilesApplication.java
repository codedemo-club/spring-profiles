package club.codedemo.springprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.AbstractEnvironment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class SpringProfilesApplication {
    /**
     * 在执行SpringApplication.run方法以前，我们是有机会通过变更spring.profiles.active的值来达到变更项目情景的目的
     * 本例中展示了两种方法
     * 可以任选其一
     * <p>
     * 注意：单元测试时并不会运行此main方法，所以此方法中对情景的设置并不会在单元测试中生效
     * <p>
     * 本例中展示的方法直接修改了Spring项目的情景值，并且间接的变更了Environment中的情景值
     * <h2>不同点</h2>
     * <ol>
     *     <li>方法一将<b>覆盖</b>原情景模式</li>
     *     <li>方法二将在原情景模式下进行<b>追加</b></li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        // 方法一：在run方法执行前，设置spring.profiles.active
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");

        // 方法二：将原SpringApplication.run(SpringProfilesApplication.class, args)拆分
        // 在执行run方法前执行setAdditionalProfiles方法，来达到变更项目情景的目的
        SpringApplication application = new SpringApplication(SpringProfilesApplication.class);
//        application.setAdditionalProfiles("pro");
        application.run(args);
    }
}
