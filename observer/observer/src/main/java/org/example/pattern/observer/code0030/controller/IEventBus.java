package org.example.pattern.observer.code0030.controller;

public interface IEventBus {

    void post(Object obj);

    void register(Object obj);
}
