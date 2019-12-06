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
//        runVoids();
    }

    private void intProps() {
        for (Map.Entry<Class, Object> entry: objects.entrySet()){

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
