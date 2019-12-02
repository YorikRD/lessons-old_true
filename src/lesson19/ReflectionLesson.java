package lesson19;

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

        

    }
}
