package com.thoughtworks.servlet;

import com.thoughtworks.sensors.client.Sensor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LightServlet extends HttpServlet {

    private final Sensor lightServlet;

    public LightServlet(Sensor lightServlet) {
        this.lightServlet = lightServlet;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double lightIntensity = lightServlet.getReading();
        resp.getWriter().println("Light is " + lightIntensity);
    }
}
