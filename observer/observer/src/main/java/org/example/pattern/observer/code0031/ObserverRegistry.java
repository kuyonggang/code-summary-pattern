package org.example.pattern.observer.code0031;

import com.google.common.base.Preconditions;
import org.example.pattern.observer.code0031.annotation.Subscribe;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registery = new ConcurrentHashMap<>();

    public void register(Object observer){
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();

            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registery.get(eventType);
            if(registeredEventActions == null){
                registery.putIfAbsent(eventType,new CopyOnWriteArraySet<ObserverAction>());
                registeredEventActions = registery.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    public List<ObserverAction> getMatchedObserverAction(Object event){
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registery.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            if(eventType.isAssignableFrom(postedEventType)){
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> observerClass = observer.getClass();
        List<Method> methodList = getAnnotatedMethods(observerClass);
        for (Method method : methodList) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if(!observerActions.containsKey(eventType)){
                observerActions.put(eventType,new ArrayList<ObserverAction>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer,method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Subscribe.class)){
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,"Method %s has @Subscribe annotation but has %s parameters."
                        + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}
