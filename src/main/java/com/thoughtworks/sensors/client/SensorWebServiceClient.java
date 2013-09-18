package com.thoughtworks.sensors.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SensorWebServiceClient implements SensorClient {

    @Override
    public Double getTemperature() {
        Client client = Client.create();
        WebResource resource = client.resource("http://192.168.0.14:8080/temperature");
        ClientResponse response = resource.accept("application/txt").get(ClientResponse.class);

        String output = response.getEntity(String.class);

        return Double.valueOf(output);
    }

    @Override
    public Double getLight() {
        Client client = Client.create();
        WebResource resource = client.resource("http://192.168.0.14:8080/light");
        ClientResponse response = resource.accept("application/txt").get(ClientResponse.class);

        String output = response.getEntity(String.class);

        return Double.valueOf(output);
    }
}
