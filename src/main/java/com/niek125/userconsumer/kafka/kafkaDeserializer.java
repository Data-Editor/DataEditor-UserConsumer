package com.niek125.userconsumer.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niek125.userconsumer.events.Event;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class kafkaDeserializer implements Deserializer<Event> {
    private final String eventFolder = "com.niek125.userconsumer.events.";

    private final ObjectMapper objectMapper;

    public kafkaDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    @SneakyThrows
    public Event deserialize(String s, byte[] bytes) {
        final String data = new String(bytes);
        final String[] dataSplit = data.split("\\.", 2);
        return (Event) objectMapper.readValue(dataSplit[1], Class.forName(eventFolder + dataSplit[0]));
    }
}
