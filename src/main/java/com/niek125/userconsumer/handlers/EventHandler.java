package com.niek125.userconsumer.handlers;

import com.niek125.userconsumer.events.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EventHandler {
    private final List<HandlerMethod> handlerMethods;
    private final UnrecognizedEventHandlerMethod unrecognizedEventHandlerMethod;

    public void processMessage(Event event){
        final HandlerMethod method = handlerMethods.stream()
                .filter(x -> x.getHandlingType() == event.getClass())
                .findFirst()
                .orElse(unrecognizedEventHandlerMethod);
        method.handle(event);
    }
}
