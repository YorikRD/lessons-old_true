package lesson11.collection.comparing;

import java.util.ArrayList;
import java.util.Comparator;

public class CarMain {
    public static void main(String[] args) {

        Car opel1 = new Car("black", "opel", 2000);
        Car opel2 = new Car("red", "opel", 2500);
        Car mazda1 = new Car("yellow", "mazda", 3000);
        Car mazda2 = new Car("green", "mazda", 3000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(opel1);
        cars.add(opel2);
        cars.add(mazda1);
        cars.add(mazda2);

        for (Car car: cars) {
            System.out.println(car);
        }
        // brand . price . color
//        Car{color='green', brand='mazda', price=3000}
//        Car{color='yellow', brand='mazda', price=3000}
//        Car{color='black', brand='opel', price=2000}
//        Car{color='red', brand='opel', price=2500}

        Comparator<Car> carComparator = new BrandComparator()
                .thenComparing(new PriceComparator())
                .thenComparing(new ColorComparator());
        cars.sort(carComparator);

        System.out.println("сортировка");
        for (Car car: cars) {
            System.out.println(car);
        }

    }
}

class BrandComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
//        if (o1.getPrice() > o2.getPrice()) return -1;
//        if (o1.getPrice() < o2.getPrice()) return 1;
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}

class ColorComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}

