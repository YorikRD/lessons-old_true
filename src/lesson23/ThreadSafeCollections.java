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
        CopyOnWriteArrayList



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
        return new Book();
    }
}
