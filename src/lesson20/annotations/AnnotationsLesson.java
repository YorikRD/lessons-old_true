package lesson20.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

@ClassInfo
public class AnnotationsLesson {

    private String string;

    public AnnotationsLesson(@ParamsInfo String string) {
        this.string = string;
    }

    @MethodInfo(author = "ifmo", version = 2)
    public void someVoid() {
        System.out.println("someVoid");
    }

    public static void main(String[] args) {

//        AnnotationsLesson lesson = new AnnotationsLesson("Lesson");
//        Method[] methods = lesson.getClass().getDeclaredMethods();
//        for (Method method : methods) {
//            Annotation[] annotations = method.getDeclaredAnnotations();
//            System.out.println(Arrays.toString(annotations));
//
//            method.isAnnotationPresent(MethodInfo.class);
//
//            MethodInfo info = method.getDeclaredAnnotation(MethodInfo.class);
//            if (info != null) {
//                System.out.println(info.author());
//                System.out.println(info.version());
//            }
//        }

        Cat cat = new Cat("qqwe", 2, "black");
        try {
            System.out.println(toString(cat));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

//    static void toString(Cat cat){}


    static public String toString(Object o) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder("");
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.getType() == String.class) {
                if (!f.isAnnotationPresent(Exclude.class)) {
                    if (!f.isAccessible()) f.setAccessible(true);
                    stringBuilder.append("Поле ")
                            .append(f.getName())
                            .append(" имеет значение:")
                            .append(f.get(o))
                            .append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}


class Cat {
    private String name;
    @Exclude
    private int age;
    private String color;
//    private Owner owner;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}

// написать рефлексивный static toString();
// "название some : значение"
// "название data : значение"

// Аннотации:
// для класса Config(prefix="") получает данные из property файла
// для класса Init создает


