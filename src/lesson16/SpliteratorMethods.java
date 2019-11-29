package lesson16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorMethods {
    public static void main(String[] args) {
        List<String> stringArrayList = Arrays.asList("a", "b", "c", "d", "f");
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.CONCURRENT));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.SORTED));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.NONNULL));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.DISTINCT));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.ORDERED));
        System.out.println(stringArrayList.spliterator()
                .hasCharacteristics(Spliterator.SUBSIZED));

//        stringArrayList.spliterator().getComparator();

        Spliterator<String> stringSpliterator = stringArrayList.spliterator();
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());

        stringSpliterator.trySplit();
        stringSpliterator.forEachRemaining(System.out::println);

        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());

        Spliterator<String> spliterator1 = stringArrayList.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("==");
        spliterator2.forEachRemaining(System.out::println);
    }
}
