package org.example.pattern.observer.code0031;

import java.util.concurrent.Executor;

public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
