package lesson3;
import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpLesson {
    public static void main(String[] args) {

        // Классы для работы с регулярными выражениями
       /*
       Регулярные выражения представляют собой последовательность символов. Они позволяют задать шаблон, которому должна соответствовать строка или подстрока.
       Их можно использовать для поиска, редактирования или манипулирования текстом и данными.
       Для написания регулярного выражения используются буквенные и цифровые символы, а также метасимволы
       */

        /*
         * Создание регулярных выражений в Java
         * написать его в виде строки с учётом синтаксиса регулярных выражений;
         * скомпилировать эту строку в регулярное выражение;
         * */

//        класс Pattern
//        Метод Pattern.matches() нужен для быстрой проверки соответствия текста заданному регулярному выражению

        String someStr = "Java Junior Developer";
        System.out.println(Pattern.matches("Java Junior Developer", someStr)); //true

//        Pattern.compile() - для компиляции экземпляра pattern для дальнейшего использования

        someStr = "Java Junior Developer";
        String regex = "Java Developer";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(someStr);

        System.out.println(matcher.matches()); // matches(): возвращает true, если вся строка совпадает с шаблоном

//        find(): возвращает true, если в строке есть подстрока, которая совпадает с шаблоном, и переходит к этой подстроке
        someStr = "Java Junior Developer";
        pattern = Pattern.compile("developer$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find());

        pattern = Pattern.compile("^Java");
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find());

//        group(): возвращает подстроку, которая совпала с шаблоном в результате вызова метода find.
//        Если совпадение отсутствует, то метод генерирует исключение IllegalStateException.

        pattern = Pattern.compile("[gur]");
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

//        int start(): возвращает индекс текущего совпадения
//        int end(): возвращает индекс следующего совпадения после текущего

        // режимы квантификаторов: жадный / ленивый / сверхжадный
//        a.+o
        someStr = "Java Junior Developer";
        pattern = Pattern.compile("a.+o"); // жадный - поиск с конца
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());


        pattern = Pattern.compile("a.+?o"); // ленивый  - самое короткое
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        pattern = Pattern.compile("w.++o"); // сверхжадный  - подставляет в конце строки
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());

        // группировка, опережающие и ретроспективные прверки
        // обязательно содержит цифру, символ ,/? , одну заглавную и остальные маленькие. Длина от 3 и выше
        someStr = "fgvFlav?ueayf.1876";
        pattern = Pattern.compile("(?=.*[0-9])(?=.*[,/?])(?=.*[A-Z])[0-9a-zA-Z!,/].{3,}");
        // опережающая проверка - ?= заглядывает вперед в поисках цифры вначале, либо после сивола(ов)
        matcher = pattern.matcher(someStr);
        System.out.println(matcher.find());

        // ?!= опережающая негативная проверка (опережающая негативная проверка). Проверяет, что после трёх цифр не идёт слово "
        // (?<=TYU)\d{4} (ретроспективная проверка). Проверяет, что перед совпадением находится текст "TYU".
        // (?<!TYU)\d{5} (ретроспективная негативная проверка). Проверяет, что перед совпадением не находится текст "TYU".


        //TODO: составить и проверить следующте регулярные выражения:
        /*Все предложения (начинаются с заглавной буквы, заканчиваются . ? !*/
        String regExp = "[A-Z].+?(.!?)";
//        Найти все слова, начинающиеся на "f"
        regex = "";
//        Найти все слова, начинающиеся на "f", от 5 до 8 символов
        regex = "";
        // Номер телефона в формате +7xxx-xxx-xx-xx:
        regex = "";

    }
}