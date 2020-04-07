package com.niek125.userconsumer.kafka;

import com.niek125.userconsumer.events.Event;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user", groupId = "user-consumer")
    public void consume(Event event){
        System.out.println(event.getClass().getName());
    }
}
