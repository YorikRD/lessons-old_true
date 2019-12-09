package lesson12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tasks {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwe", "Тамбов");
        map.put("asd", "Тамбов");
        map.put("zxc", "Тамбов");
        map.put("rty", "Москва");
        map.put("fgh", "Магадан");

        String city = "Тамбов";
        System.out.println(getPeopleByCity(map, city));

        List<String> words = new ArrayList<>();
        words.add("HELLO");
        words.add("HELLO");
        words.add("HELLO");
        words.add("HELLO");
        words.add("HELLO2");
        words.add("HELLO");
        words.add("HELLO2");
        words.add("HELLO3");
        words.add("HELLO4");
//        Map<String, Integer>

    }

    // map хранит login и город проживания
//      Написать метод, который приннимает на вход мапу и город,
//      и формирует список логинов, которые соответствуют
//      переданному городу
    public static List<String> getPeopleByCity(Map<String, String> map, String city){
        List<String> logins = new ArrayList<>();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            if (entry.getValue().equals(city)){
                logins.add(entry.getKey());
            }
        }
        return logins;
    }

    public static Map<String, Integer> getNewAgeMap(Map<String, Integer> map, int from, int to){
        Map<String, Integer> newMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > from && entry.getValue() < to){
                newMap.put(entry.getKey(), entry.getValue());
            }
        }

        return newMap;
    }

    // Дан список строк. Посчитать количество одинаковых слов с списке,
    // Результат в виде Map<String, Integer>
    public static Map<String, Integer> getWordsCount(List<String> words){
        Map<String, Integer> newMap = new HashMap<>();

        for (String word: words){
            if (newMap.containsKey(word)){
                newMap.put(word, newMap.get(word) + 1);
            } else {
                newMap.put(word, 1);
            }
        }

        return newMap;
    }

    // "the"
    // the:
    // 31 568
    // 34 390 - 34 390
    // 31 157

}
