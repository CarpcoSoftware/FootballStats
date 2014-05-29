package co.com.carpco.footballstats.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import co.com.carpco.footballstats.spring.ServiceLocator;

import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 * Initialize new server that will be responding for all request from mobile devices 
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/17/2014
 */
public class FootballStatsServer {

    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(1512);

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter("com.sun.jersey.config.property.packages", "co.com.carpco.footballstats.web");

        contexts.addHandler(context);

        server.setConnectors(new Connector[] {connector});
        server.setHandler(context);
        context.addServlet(servletHolder, "/*");
        server.setHandler(contexts);

        server.start();
        ServiceLocator.init();
    }

}
