package org.example.pattern.observer.code0030.controller;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

public class GoogleEventBus implements IEventBus{

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    private EventBus  eventBus;

    public GoogleEventBus() {
        // 同步阻塞模式
//      eventBus = new EventBus();
        // 异步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public GoogleEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void register(Object obj){
        eventBus.register(obj);
    }

    public void post(Object obj){
        eventBus.post(obj);
    }
}
