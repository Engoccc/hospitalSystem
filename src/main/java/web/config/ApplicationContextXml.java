package web.config;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"web"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class ApplicationContextXml {
        /*
        @Bean
        public BeanNameAutoProxyCreator autoProxyCreator() {
                BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
                autoProxyCreator.setProxyTargetClass(true);		// 设置要创建代理的那些Bean的名字
                autoProxyCreator.setBeanNames("*Service");
                autoProxyCreator.setInterceptorNames("transactionInterceptor");
                return autoProxyCreator;
        }
         */
}