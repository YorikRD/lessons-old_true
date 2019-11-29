package lesson17;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // найти студентов с уникальными предметами
    }
}

class Student {
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
