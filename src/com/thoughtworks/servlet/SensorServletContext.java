package com.thoughtworks.servlet;

import com.thoughtworks.sensors.client.LightSensor;
import com.thoughtworks.sensors.client.SensorWebServiceClient;
import com.thoughtworks.sensors.client.TemperatureSensor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class SensorServletContext {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new TemperatureServlet(new TemperatureSensor(new SensorWebServiceClient()))), "/temperature");
        context.addServlet(new ServletHolder(new LightServlet(new LightSensor(new SensorWebServiceClient()))), "/light");

        server.start();

        server.join();
    }
}
