package lesson23;

import java.util.*;
import java.util.concurrent.*;

public class ThreadSafeCollections {
    public static void main(String[] args) {
        // потокобезопасные коллекции
        // Vector
        // HashTable
        // Stack

        // однопоточные коллекции и мапы в потокобезопасные коллекции и мапы
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        // потокобезопасные коллекции и мапы из пакета java.util.concurrent.*
        CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<>();
        books.addIfAbsent(new Book("Java", 1800));
        books.addIfAbsent(new Book("Java", 1800));
        System.out.println(books);

        new Thread(new WriteThread(books)).start();
        new Thread(new ReadThread(books)).start();

        CopyOnWriteArraySet<String> strings = new CopyOnWriteArraySet<>();
        strings.add("qwe");
        strings.add("asd");
        strings.add("zxc");
        System.out.println(strings);
        strings.removeIf(s -> s.equals("asd"));
        // ConcurrentSkipListSet

         ConcurrentNavigableMap<String, Integer> navigableMap =
                 new ConcurrentSkipListMap<>();
         navigableMap.put("qwe", 2);
         navigableMap.putIfAbsent("qwe", 2);
         // navigableMap.computeIfPresent();
         // navigableMap.computeIfAbsent();





    }
}

class WriteThread implements Runnable {
    private CopyOnWriteArrayList<Book> books;

    public WriteThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            books.addIfAbsent(Book.getBook());
        }
    }
}

class ReadThread implements Runnable{
    private CopyOnWriteArrayList<Book> books;

    public ReadThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Введите название книги");
            String title = scanner.nextLine();
            for (Book book: books){
                if (title.equals(book.getTitle())){
                    System.out.println(book);
                    books.remove(book);
                }
            }
        }
    }
}

class Book{
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (pageCount != book.pageCount) return false;
        return getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + pageCount;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public static Book getBook(){
        Random random = new Random();
        String[] titles = {"Алфавит", "Философия Java", "Обломов", "Война и мир"};
        return new Book(titles[random.nextInt(titles.length)],
                random.nextInt(2000)); // до 2000 страниц
    }
}
