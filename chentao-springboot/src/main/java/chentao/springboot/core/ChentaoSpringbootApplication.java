package chentao.springboot.core;

import chentao.springboot.autoconfig.AutoConfig;
import chentao.springboot.web.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;
import java.util.ServiceLoader;

public class ChentaoSpringbootApplication {


    /**
     * springboot主启动类
     * @param clazz
     */
    public static void run(Class clazz){

        //1.创建web容器
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();

        //2.注册配置类
        webApplicationContext.register(clazz);



        //3.刷新容器
        webApplicationContext.refresh();

        //4.启动tomcat或者jetty
        WebServer webServer = getWebServer(webApplicationContext);

        webServer.start();

    }

    //从容器中获得webServer
    public static WebServer getWebServer(ApplicationContext context) {
        Map<String, WebServer> serverMap = context.getBeansOfType(WebServer.class);

        if(serverMap.size()== 0){
            throw new RuntimeException("没有引入Web容器");
        }

        if(serverMap.size() > 1){
            throw new RuntimeException("引入了多个web容器");
        }

        return serverMap.values().stream().findFirst().get();

    }
}
