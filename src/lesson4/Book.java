package lesson4;

public class Book {
    // свойства, поля, атрибуты
    // название книг
    private String title; // null - значение по-умолчанию для ссылочных типов
    private String author;

    // можно ли брать домой (или только в читальном зале)
    private boolean isForHome;// false - значение по-умолчанию для boolean

    // доступна для выдачи или нет
    private boolean isAvailable;

    // конструкторы
    public Book(){}

    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
        System.out.println("Вызов конструктора");
    }

    public Book(String title) {
        setTitle(title);
    }


    // методы, устанавливающие значения свойств (сеттеры) title и author
    public void setTitle(String title){
        // this - это ссылка на текущий объект
        if (title != null && !"".equals(title)) {
            this.title = title;
        }
    }

    // alt + insert
    public void setAuthor(String author) {
        if (author != null && !"".equals(author)) {
            this.author = author;
        }
    }

    public void setForHome(boolean forHome) {
        isForHome = forHome;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // методы, которые возвращают значения свойств (геттеры)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isForHome() {
        return isForHome;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isForHome=" + isForHome +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
