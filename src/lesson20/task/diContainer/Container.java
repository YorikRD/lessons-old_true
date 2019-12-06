package lesson20.task.diContainer;

import lesson20.task.Server;
import lesson20.task.ServerSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Container {
    private Set<Class> classes;
    private Properties properties = new Properties();
    private HashMap<Class, Object> objects = new HashMap<>();


    public Container(Set<Class> classes) {
        this.classes = classes;
    }

    public void init() {
        createObjects();
//        intProps();
//        runVoids();
    }

    private void createObjects() {
        for (Class cls: classes){
            if (cls.isAnnotationPresent(ConfigClass.class) 
                    || cls.isAnnotationPresent(InitClass.class)){
                Object o = createObject(cls);
            }
        }
    }

    private Object createObject(Class cls) {
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
