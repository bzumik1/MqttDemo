package main;


import lombok.Getter;
import lombok.Setter;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

import java.util.UUID;

@Setter @Getter
public class Receiver {
    private String clientId;
    private MqttAsyncClient client;

    public Receiver(String server, String port, String topic) {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);


        clientId = UUID.randomUUID().toString(); // has to uniquely identify client
        try {
            client = new MqttAsyncClient("tcp://" + server + ":" + port, clientId);
            ReceiverCallback receiverCallback = new ReceiverCallback();
            client.setCallback(receiverCallback);

            IMqttToken token = client.connect();
            token.waitForCompletion();

            client.subscribe(topic, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
