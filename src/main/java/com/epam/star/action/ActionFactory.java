package com.epam.star.action;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionFactory {
    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actionMap = new HashMap<>();

    static {
        Reflections reflections = new Reflections(ActionFactory.class.getPackage().getName());
        Set<Class<? extends Action>> actions = reflections.getSubTypesOf(Action.class);
        for (Class<? extends Action> actionClass : actions) {
            Annotation[] annotations = actionClass.getAnnotations();
            //todo foreach on annotations
//            if (annotation.annotationType().isInstance(Post.class)) {
//            }
            Action action = null;
            try {
                action = actionClass.newInstance();
            } catch (InstantiationException e) {
                logger.error(e.toString());
            } catch (IllegalAccessException e) {
                logger.error(e.toString());
            }
            actionMap.put(actionClass.getSimpleName().toLowerCase(), action); //todo check for null: if you cannot instantiate you should not put it into map!!!
        }
    }

    public static Action getAction(String actionName) {
        return actionMap.get(actionName);
    }

    public static void getAllAction() {
        for (String s : actionMap.keySet()) {
            System.out.println(s);
        }
    }
}
