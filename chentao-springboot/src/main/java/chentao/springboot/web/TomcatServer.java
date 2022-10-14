package chentao.springboot.web;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TomcatServer implements WebServer, ApplicationContextAware {

    private ApplicationContext webApplicaton;

    @Override
    public void start() {
        System.out.println("启动tomcat");

        Tomcat tomcat = new Tomcat();

         Server server = tomcat.getServer();
         Service service = server.findService("Tomcat");

         Connector connector = new Connector();
         connector.setPort(8081);

         Engine engine = new StandardEngine();
         engine.setDefaultHost("localhost");

         Host host = new StandardHost();
         host.setName("localhost");

         String contextPath = "";
         Context context = new StandardContext();
         context.setPath(contextPath);
         context.addLifecycleListener(new Tomcat.FixContextListener());

         host.addChild(context);
         engine.addChild(host);

         service.setContainer(engine);
         service.addConnector(connector);

        tomcat.addServlet(contextPath, "dispatcher", new
                DispatcherServlet((AnnotationConfigWebApplicationContext)webApplicaton));

         context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.webApplicaton = applicationContext;
    }
}
