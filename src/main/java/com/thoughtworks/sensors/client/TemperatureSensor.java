package com.thoughtworks.sensors.client;

public class TemperatureSensor implements Sensor {

    private final SensorClient sensorClient;

    public TemperatureSensor(SensorClient sensorClient) {
        this.sensorClient = sensorClient;
    }

    @Override
    public Double getReading() {
        return sensorClient.getTemperature();
    }
}
