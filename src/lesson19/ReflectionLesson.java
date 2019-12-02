package lesson19;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) {
//        Reflection API класс Class
        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(TextMessage.class);

        TextMessage textMessage =
                new TextMessage("Срочно", "Провести совещание");
        System.out.println(textMessage.getClass());

        Class cls = textMessage.getClass(); // ссылка на класс TextMessage

        System.out.println(cls.getName()); // возвращает имя класса
        // возвращает интрейфейсы, которые имплементирует класс
        System.out.println(Arrays.toString(cls.getInterfaces()));
        // возвращает родительский класс
        System.out.println(cls.getSuperclass());
        System.out.println(cls.getSuperclass().getSuperclass());
        System.out.println(cls.getSuperclass().getSuperclass().getSuperclass());

        // доступ к компонентам класса
        Class<TextMessage> textMessageClass = TextMessage.class;

        // доступ к полям класса
        // возвращает все публичные поля класса (включая родительские)
        Field[] fields = textMessageClass.getFields();
        System.out.println(Arrays.toString(fields));

        // возвращает все поля класса (включая private и protected)
        Field[] declaredFields = textMessageClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        // возвращает все публичные методы класса (включая родительские)
        Method[] methods = textMessageClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // возвращает все методы класса (включая private и protected)
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor[] declaredConstructors =
                textMessageClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // доступ к конкретному полю / методу

        Field field = textMessageClass.getDeclaredField("text");

    }
}
