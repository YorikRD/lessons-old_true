package lesson4;

public class Main {
    public static void main(String[] args) {
        Book java = new Book();
        System.out.println(java);
        Book cleanCode = new Book();

        // доступ к свойству объекта (имя_объекта.свойство)
        //java.title = "Филосифия Java";
        //cleanCode.title = "Чистый код";

        //java.author = "Брюс Эккель";
        //cleanCode.author = "Роберт Мартин";

        // вызов метода
        java.setTitle("Филосифия Java");
        cleanCode.setTitle("Чистый код");

        System.out.println(java.getTitle());
        System.out.println(cleanCode.getTitle());

        java.setAuthor("Брюс Эккель");
        cleanCode.setAuthor("Роберт Мартин");


//        java - можно брать на дом
        java.setForHome(true);

        java.setAvailable(true);
        cleanCode.setAvailable(true);

        Book forBeginners = new Book("Руководство для начинающих",
                "Герберт Шилдт");

        System.out.println(java);
        System.out.println(cleanCode);
        System.out.println(forBeginners);

        Library library = new Library();
        library.addBook(java);
        library.addBook(cleanCode, forBeginners);

    }
}
