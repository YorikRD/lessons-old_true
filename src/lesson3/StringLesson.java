package lesson3;

import java.util.Arrays;
import java.util.StringJoiner;
//import java.util.StringJoiner;

public class StringLesson {
    public static void main(String[] args) {
        /*Строки
        * до 9 версии как массив char[],
        * каждый символ занимает 2 байта
        * Кодировка UTF-16
        * */

        /*
        Начиная с 9 версии - компактные строки
        строки хранятся как массив byte[]
        LATIN-1
        UTF-16
        byte coder;
        byte LATIN1 = 0;
        byte UTF16 = 1;
       * */

        /*Строки в Java неизменны и потокобезопасны*/

        char[] charsArr = {'j', 'a', 'v', 'a'};
        String str = new String(charsArr);
        String str1 = "Java";
        String str2 = new String("Java");
        String str3 = "Java";
        String str4 = str2.intern(); // объект строки создается в пуле
        // строк (если такой строки нет). Если такая строка содержится
        // в пуле строк, то просто возвращает ссылку на нее

        str3.codePoints().forEach(System.out::println);

        // количество символов в строке
        System.out.println("количество символов в строке " + str3.length());

        // сравнение строк
        str = "JAVA";
        str1 = "Java";

        System.out.println(str.equals(str1)); // false
        // сравнение без учета регистра
        System.out.println(str.equalsIgnoreCase(str1)); // true

        int compareRes = str.compareTo(str1);
        System.out.println("compareTo " + compareRes);

        compareRes = str.compareToIgnoreCase(str1);
        System.out.println("compareToIgnoreCase " + compareRes);

        /*
        * 0 - если строки равны
        * положительное целое число - если первая строка следует за второй
        * отрицательное целое число - если первая строка предшествует второй
        * */

        // поиск в строке
        System.out.println(str.startsWith("JA")); // true
        System.out.println(str.endsWith("b")); // false

        // indexOf("символ") - для поиска первого вхождения указанного символа
        // либо подстроки (вернет индекс)
        // lastIndexOf - для поиска последнего вхождения указанного символа
        // либо подстроки (вернет индекс)
        // -1 -если символ или подстрока не найдены

        System.out.println(str.indexOf("V"));
        System.out.println(str.indexOf("v", 2));

        str = "Java Junior Developer";
        str1 = "Java";

        // sout

        System.out.println(str.contains(str1)); // true
        System.out.println(str1.contains(str)); // false

        // Модификация строк (в результате преобразований
        // будет создана новая строка)

        // toLowerCase() - в нижний регистр
        String lowerStr = str.toLowerCase();

        // toUpperCase() - в верхний регистр
        // trim() - убираем пробелы
        // reverse() - переворачивает строку

        str = "Java Junior Developer";
        str1 = "Java";
        String newStr = str.replace("Junior", "");
        System.out.println(newStr);

        newStr = str.replaceAll("v", "V");
        System.out.println(newStr);

        str = "Java Junior Developer";
        // разбивает строку, возврящает массив
        String[] strings = str.split("\\s");
        System.out.println(Arrays.toString(strings));

        //substring(int begin, int end)
        //substring(int begin)
        // - взятие подстроки

        System.out.println(str.substring(3, 6));

        // Конкатенация строк
        String concatString = "Java" + " Junior";
        System.out.println(concatString);

        concatString = concatString.concat("Developer").concat("!");
        System.out.println(concatString);

        str = "String";
        for (int i = 0; i < 7; i++) {
            str += " iteration " + i; // на каждой итерации создается объект
        }
        System.out.println(str);

        // Классы для работы со строками (с возможностью изменения строки)
        // StringBuilder - работает быстрее, чем StringBuffer
        // StringBuffer - работает медленнее, но потокобезопасен
        str = "String";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i = 0; i < 7; i++) {
            stringBuilder.append(" iteration ").append(i);
        }
        str = stringBuilder.toString();

        // объединение строк
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("One");
        joiner.add("Two");
        String joinString = joiner.toString();
        System.out.println(joiner.toString());
        System.out.println(joinString);

        System.out.println(String.join(": ", "One", "Two"));

        // Текстовые блоки
        /*String textBlock = """
                Строка "в кавычках"
                    с переносами
        """;
        System.out.println(textBlock);   */















    }
}
