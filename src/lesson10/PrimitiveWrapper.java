package lesson10;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // Классы обертки хранят значение соответствующего
        // примитива
        // int -> Integer
        // short -> Short
        // byte -> Byte
        // long -> Long
        // char -> Character
        // boolean -> Boolean
        // float -> Float
        // double -> Double

        int a =56;
        Integer integer = a;
        int b = integer;

        Double d = 3.78;
        Boolean boo = false;

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        // методы, преобразования строки в число
        // "78"
        System.out.println(Byte.parseByte("2")); // примитив
        System.out.println(Byte.valueOf("2")); // объект

        System.out.println(Integer.parseInt("56")); // примитив
        System.out.println(Integer.valueOf("56")); // объект

        // NumberFormatException
//        System.out.println(Integer.valueOf("56iduvgriodu"));

        // от -128  до 127
        Integer integer1 = 3;
        Integer integer2 = 3;

        if (integer1 == integer2) System.out.println("40 ==");

        Integer integer3 = 500;
        Integer integer4 = 500;

        if (integer3 == integer4) System.out.println("45 ==");
        integer3.equals(integer2); // true / false

        integer1.doubleValue(); // примитив
        integer1.longValue(); // примитив

        System.out.println(Integer.compare(integer1, integer2)); // -1 / 0 / 1
        System.out.println(Integer.min(integer1, integer2));
        System.out.println(Integer.max(integer1, integer2));

        System.out.println(Integer.sum(integer1, integer2));

        Integer integerSum = Integer.sum(integer1, integer2);

        System.out.println(Integer.hashCode(integer1));
        System.out.println(Integer.hashCode(integer2));

        Integer i = 2;
        d = 2.00;

        System.out.println(i.equals(d));
    }
}
