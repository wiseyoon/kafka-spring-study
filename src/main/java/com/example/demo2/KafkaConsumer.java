package com.example.demo2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final String TOPIC_NAME = "topic5";

    ObjectMapper om = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String jsonMessage) {
        try {
            MyMessage message = om.readValue(jsonMessage, MyMessage.class);
            System.out.println(">>>" + message.getName() + "," + message.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
