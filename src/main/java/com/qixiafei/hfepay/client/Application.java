package com.qixiafei.hfepay.client;

import com.qixiafei.hfepay.client.core.HfepayProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <P>Description: springboot启动类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/1</P>
 * <P>UPDATE DATE: 2017/12/1</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.7.0
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.qixiafei.hfepay.client"}, exclude = {DataSourceAutoConfiguration.class})
// 如果用到定时任务配置则用上这个注解
@EnableScheduling
// 如果用到设计模式，springBean涉及到继承和实现,则配置这个注解,否则程序会报错找不到类型
@EnableCaching(proxyTargetClass = true)
public class Application extends SpringBootServletInitializer {

    static {
        /*
           解决dubbo和lockback集成后不打印日志的问题
         */
        try {
            System.setProperty("dubbo.application.logger", "slf4j");
        } catch (Throwable e) {
            System.out.println("设置dubbo默认日志接口失败" + e.getMessage());
        }
        /*
          解决java.io.IOException: Can not lock the registry cache file问题
         */
        try {
            System.setProperty("dubbo.registry.file", "/home/dubbo/cache/dubbo-registry-loan-gateway.cache");
        } catch (Throwable e) {
            System.out.println("设置dubbo缓存文件存放路径失败" + e.getMessage());
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(getClass());
    }

}
