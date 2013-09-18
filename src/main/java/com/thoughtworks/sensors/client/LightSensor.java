package com.thoughtworks.sensors.client;

public class LightSensor implements Sensor {

    private final SensorClient sensorClient;

    public LightSensor(SensorClient sensorClient) {
        this.sensorClient = sensorClient;
    }

    @Override
    public Double getReading() {
        return sensorClient.getLight();
    }
}
