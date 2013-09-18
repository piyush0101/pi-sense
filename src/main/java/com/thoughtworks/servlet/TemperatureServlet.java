package com.thoughtworks.servlet;

import com.thoughtworks.sensors.client.Sensor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TemperatureServlet extends HttpServlet {

    private final Sensor temperatureSensor;

    public TemperatureServlet(Sensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double temperature = temperatureSensor.getReading();
        resp.getWriter().println("Temperature is " + temperature + " F");
    }
}
