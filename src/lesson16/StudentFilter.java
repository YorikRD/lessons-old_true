package lesson16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {
    // фильтры:
    // 1. по стране (например, студенты из России)
    // 2. старше 30
    // 3. старше 30 и по стране (например, студенты из России)
}

class University{
    private List<Student> studentList;

    public University(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getFilterStudents(Predicate<Student> filter) {
        List<Student> students = new ArrayList<>();

        return students;
    }
}

class Student{
    private String name;
    private int age;
    private String country;

    public Student(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
