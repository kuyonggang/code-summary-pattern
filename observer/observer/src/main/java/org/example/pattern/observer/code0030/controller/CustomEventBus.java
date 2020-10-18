package org.example.pattern.observer.code0030.controller;


import org.example.pattern.observer.code0031.AsyncEventBus;
import org.example.pattern.observer.code0031.EventBus;

import java.util.concurrent.Executors;

public class CustomEventBus implements IEventBus {

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    private EventBus eventBus;

    public CustomEventBus() {
        // 同步阻塞模式
//      eventBus = new EventBus();
        // 异步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public CustomEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void register(Object obj){
        eventBus.register(obj);
    }

    public void post(Object obj){
        eventBus.post(obj);
    }
}
