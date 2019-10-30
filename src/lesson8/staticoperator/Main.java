package lesson8.staticoperator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Tom", "дворник");
        employee1.setTimeStart(LocalDateTime.of(
                2019, Month.OCTOBER, 25, 6, 0));
        employee1.setTimeEnd(LocalDateTime.of(
                2019, Month.OCTOBER, 25, 14, 0));

        Employee employee2 = new Employee("Mike", "охранник");
        employee2.setTimeStart(LocalDateTime.of(
                2019, Month.OCTOBER, 25, 8, 0));
        employee2.setTimeEnd(LocalDateTime.of(
                2019, Month.OCTOBER, 25, 21, 0));

        employee1.printCurrentDayStatistic();
        employee2.printCurrentDayStatistic();

        System.out.println(Employee.company);

        Employee.changeCompany("RVD");

        employee1.printCompany();
        employee1.company = "employee1 company";

        employee2.printCompany();
    }
}
