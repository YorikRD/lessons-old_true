package lesson8;

import lesson8.object.Car;
import lesson8.object.Owner;

public class Main {
    public static void main(String[] args)
            throws CloneNotSupportedException {
        // родительский класс для всех классов
        Object obj = new Object();
        // toString() возвращает строку, описывающую объект
        // hashCode() - возвращает хешкод объекта
        // equals() - проверяет на соответствие
        // clone() - для создании копии объекта

        // getClass() wait() и тд

        Owner owner1 = new Owner("Tom", "+79999999999");
        Owner owner2 = new Owner("Mike", "+78888888888");
        Owner owner3 = new Owner("Tom", "+79999999999");

        Car opel = new Car("Opel", "yellow", owner1);
        System.out.println(opel); //System.out.println(opel.toString())

        // hashCode() + equals()
        Car mazda = new Car("Mazda", "red", owner2);
        Car opel2 = new Car("Opel", "yellow", owner3);

        System.out.println(opel.hashCode());
        System.out.println(opel2.hashCode());
        System.out.println(mazda.hashCode());

        System.out.println(opel.equals(opel2));

        // clone()
        Car newCar = (Car) opel.clone();

        opel.getOwner().setName("New Name");
        System.out.println(newCar);
        System.out.println(opel);

    }
}
