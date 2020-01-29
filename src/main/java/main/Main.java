package main;

import static main.Settings.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello world...");

        Receiver receiver = new Receiver(SERVER,PORT,TOPIC); // will connect when it is created;
        Sender sender = new Sender(SERVER,PORT,TOPIC);
        MqttTriggerJSON mqttTriggerJSON = new MqttTriggerJSON(2,564465L);





        for(int i=0; i<10;i++){
            sender.getClient().publish(TOPIC, SeDe.toByteArray(mqttTriggerJSON),0,false);
        }





        System.out.println("Konec");
    }

}
