package org.example.pattern.observer.code0031;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {

    private Executor executor;
    private static final ObserverRegistry observerRegistry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void post(final Object event){
        List<ObserverAction> observerActions = observerRegistry.getMatchedObserverAction(event);
        for (final ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }

    public void register(Object obj){
        observerRegistry.register(obj);
    }
}
