package com.epam.star.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Logger logger = LoggerFactory.getLogger(ActionFactory.class);
    static Map<String, Action> actions = new HashMap<>();


    static {
//        Reflections reflections = new Reflections(ActionFactory.class.getPackage().getName());
//        Set<Class<? extends Action>> actions = reflections.getSubTypesOf(Action.class);

        actions.put("POST/DeleteFromDataBaseAction", new DeleteFromDataBaseAction());
        actions.put("GET/DeleteFromDataBaseAction", new DeleteFromDataBaseAction());//new ShowPageAction("/WEB-INF/result.jsp"));
//        actions.put("POST/registration", new RegistrationAction());
//        actions.put("GET/registration", new ShowPageAction("registration"));


//        for (Class<? extends Action> actionClass : actions) {
////            Annotation[] annotations = actionClass.getAnnotations();
//            //todo foreach on annotations
////            if (annotation.annotationType().isInstance(Post.class)) {
////            }
//            Action action = null;
//            try {
//                action = actionClass.newInstance();
//            } catch (InstantiationException e) {
//                logger.error(e.toString());
//            } catch (IllegalAccessException e) {
//                logger.error(e.toString());
//            }
//            actionMap.put(actionClass.getSimpleName().toLowerCase(), action); //todo check for null: if you cannot instantiate you should not put it into map!!!
//        }
    }


    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }

    public static void getAllAction() {
        for (String s : actions.keySet()) {
            System.out.println(s);
        }
    }
}
