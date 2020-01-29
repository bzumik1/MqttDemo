package main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Setter @Getter @AllArgsConstructor @ToString
public class MqttTriggerJSON implements Serializable {
    private Integer Id;
    private Long timestamp;
}


