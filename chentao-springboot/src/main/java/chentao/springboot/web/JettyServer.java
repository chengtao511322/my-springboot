package chentao.springboot.web;

public class JettyServer implements WebServer{
    @Override
    public void start() {
        System.out.println("启动了jetty");
    }
}
