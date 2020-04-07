package com.niek125.userconsumer.handlers;

import com.niek125.userconsumer.events.Event;

public abstract class HandlerMethod<T extends Event> {
    private final Class<T> clazz;

    protected HandlerMethod(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class getHandlingType() {
        return clazz;
    }

    public abstract void handle(Event event);
}
