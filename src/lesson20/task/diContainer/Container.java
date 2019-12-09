package lesson20.task.diContainer;

import lesson20.task.Server;
import lesson20.task.ServerSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Container {
    private Set<Class> classes;
    private Properties properties = new Properties();
    private HashMap<Class, Object> objects = new HashMap<>();


    public Container(Set<Class> classes) {
        this.classes = classes;
    }

    public void init() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        loadProperties();
        createObjects();
        intProps();
        runVoids();
    }

    private void runVoids() throws InvocationTargetException, IllegalAccessException {
        for (Map.Entry<Class, Object> entry: objects.entrySet()){
            // Method[] methods = entry.getValue().getClass().getDeclaredMethods();
            Method[] methods = entry.getKey().getDeclaredMethods();
            for (Method method: methods){
                if (method.isAnnotationPresent(RunMethod.class)){
                    method.setAccessible(true);
                    method.invoke(entry.getValue());
                }
            }
        }
    }

    private void intProps() throws IllegalAccessException {
        for (Map.Entry<Class, Object> entry: objects.entrySet()){
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field: fields){
                if (field.isAnnotationPresent(InitProp.class)){
                    Object o = objects.get(field.getType());
                    field.setAccessible(true);
                    field.set(entry.getValue(), o);
                }
            }
        }
    }

    private void createObjects() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Class cls: classes){
            if (cls.isAnnotationPresent(ConfigClass.class) 
                    || cls.isAnnotationPresent(InitClass.class)){
                Object o = createObject(cls);
                if (cls.isAnnotationPresent(ConfigClass.class)){
                    Field[] fields = cls.getDeclaredFields();
                    for (Field field: fields){
                        ConfigClass configClass =
                                (ConfigClass) cls.getDeclaredAnnotation(ConfigClass.class);
                        String prefix = configClass.prefix();
                        field.setAccessible(true);
                        field.set(o, properties.getProperty(prefix+"."+field.getName()));
                    }
                }
                objects.put(cls, o);
            }
            System.out.println(objects);
        }
    }



    private Object createObject(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = cls.getDeclaredConstructor();
        return constructor.newInstance();
    }

    private void loadProperties(){
        try (InputStream input =
                     Container.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
