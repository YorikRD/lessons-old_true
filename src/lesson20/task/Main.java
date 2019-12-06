package lesson20.task;

import lesson20.task.diContainer.Container;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        classes.add(ServerSettings.class);
        classes.add(Server.class);
        Container container = new Container(classes);
        try {
            container.init();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
