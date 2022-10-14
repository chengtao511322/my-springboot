package chentao.springboot.autoconfig;

import chentao.springboot.annotation.ChentaoConditionOnClass;
import chentao.springboot.web.JettyServer;
import chentao.springboot.web.TomcatServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类,应该判断程序员所指定的依赖来判断放入的baen
 * 程序员配置的扫描路径肯定是扫描不到这里的
 * 所以需要使用JAVA的SPI(Service provider) 服务发现机制来吧该配置类加载到容器
 */
@Configuration
public class WebServerAutoConfig implements AutoConfig{


    @Bean
    @ChentaoConditionOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatServer tomcatServer(){
        return new TomcatServer();
    }

    @Bean
    @ChentaoConditionOnClass("org.eclipse.jetty.server.Server")
    public JettyServer jettyServer(){
        return new JettyServer();
    }
}
