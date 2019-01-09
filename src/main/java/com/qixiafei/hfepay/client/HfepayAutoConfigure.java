package com.qixiafei.hfepay.client;

import com.qixiafei.hfepay.client.core.HfepayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * <P>Description: 华付客户端自动配置类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/4 16:50</P>
 * <P>UPDATE AT: 2019/1/4 16:50</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "hfepay", name = {"userCode", "sysCode", "priKey", "pubKey","hfPubKey"})
@EnableConfigurationProperties(value = HfepayProperties.class)
public class HfepayAutoConfigure {

    @Resource
    private HfepayProperties hfepayProperties;

    @Bean
    public HfepayClient hfepayClient() {
        log.info("初始化华付客户端....，使用属性={}", hfepayProperties);

        return new HfepayClient(hfepayProperties);
    }

}
