import java.util.Scanner;

public class FirstLesson {
    //    однострочный комментарий ctrl + /
   /*многострочный  ctrl + shift + /
       комменнтарий*/

    //точка входа в программу
    public static void main(String[] args) { // psvm
//        Объявление переменных
        // типДанных имяПеременной;

//        Ссылочные типы данных
//        Примитивные типы данных

//        byte - 1 байт
//        от -128 до 127
//        Используется при работе с потоками данных,
//            в массивах для экономии памяти

        // Объявление переменной типа byte
        byte byteVar = 23;

        // short - 2 байта
        // от -32768 до 32767
        // Объявление переменной типа short
        short shortVar = 12;
        short shortVar1 = 19;
        // short shortRes = shortVar + shortVar1;
//        ошибка, тк в арифметических операциях вычисления выполняются,
//                как с типом int

        // int - 4 байта
        int intVar = 7;
        int intVar1 = 2;
        // при делении дробная часть отбрасывается
        int intRes = intVar / intVar1;
        // для удобства доступна запись
        int intVar2 = 1_000_000;
        //int zeroDivision = intVar / 0; //ArithmeticException: / by zero

        // long - 8 байт
//        long longVar = 3000000000; будет восприниматься как int,
        // поэтому используем запись вида
        long longVar = 3000000000L;


        // числа с плавающей точкой
//        float - 4 байта
        float floatVar = 3.6f;
        float zeroDivisionFloat = floatVar / 0; // Infinity

        //double - 8 байт
        double doubleVar = 5.7;
        double zeroDivisionDouble = doubleVar / 0; // Infinity

        // char - 2 байта
//        хранит номер символа в таблице Unicode в кодировке UTF-16
//        от 0 до 65536

        // boolean
        // true / false

        boolean closed = true;
        boolean isActive = false;

        // приведение типов
        // 1. автоматическое преобразование
        byte byteVar3 = 3;
        int intVar3 = byteVar3;

        // 2. явное приведение типов
        intVar3 = 45;
        byteVar3 = (byte) intVar3;


        // операторы
        // операторы присваивания
        // = | += | -= | *= | /= | %=
        int a = 7;
        a = a + 4; // a += 4;

        // арифметические операторы
        // + | - | * | / |%
        // 7 % 2; // 1

        // инкремент (увеличивает на 1)
        // i++ ++i
        // декремент (уменьшает на 1)
        // i-- --i

        // операторы сравнения (результат работы либо true, либо false)
        // > | < | >= | <= | != | ==

        // Консольный ввод-вывод
        // Консольный вывод

        System.out.println("Выводимая информация"); // sout

        System.out.printf("Форматированный вывод %s\n", "данных"); // souf
        // %f для вывода чисел с плавающей точкой
        // %d для вывода целых чисел
        // %s для вывода строк

        // консольный ввод
        Scanner in = new Scanner(System.in); // alt + Enter -> Import Class
        System.out.println("Введите число");
        int num = in.nextInt();
        System.out.printf("Вы ввели: %d\n", num);


        //  Логические операторы - применяются к boolean переменным и выражениям
        // && И
        // || ИЛИ
        // ! - НЕ
        // ^ - Исключающее или

        // тернарный оператор
        // Переменная y = (условие) ? выражение1 : выражение2;

        int x = 3;
        int y = 2;

        int res = x > y ? x - y : x + y;

        //конструкции ветвления

       /*if (условие) {
           // код выполняется, если условие true
       } else {
           // код выполняется, если условие false
       }

       if (условие) {
           // код выполняется, если условие true
       } else if (условие2) {
           // код выполняется, если условие - false и условие2 true
       }*/

        System.out.println("Введите число");

        switch (in.nextInt()){
            case 1:
                System.out.println("Вариант 1");
                break;
            case 2:
                System.out.println("Вариант 2");
                break;
            case 3:
            case 4:
                System.out.println("Вариант 3, 4");
                break;
            default:
                System.out.println("Вариант не определен");
                break;

        }

    }

}
