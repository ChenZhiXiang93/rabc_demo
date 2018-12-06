package czx.wt;

import czx.wt.filter.LoginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 20:56
 * @Version: 1.0
 */
@Configuration
public class WebConfiguration {

    private Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LoginFilter");
        //执行顺序，order越小越先执行
        registration.setOrder(1);
        logger.info("filter");
        return registration;
    }
}
