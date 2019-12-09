package lesson22;

public class WaitNotifyLesson {
    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();
    }
}

class BookStorage {
    int bookCount = 0;
    public synchronized void putBook() throws InterruptedException {
        // увеличивает счетчик на 1
        System.out.println("putBook - начало выполнения");
        while (bookCount >= 5) {
            notify();
            System.out.println("putBook в состоянии ожидания");
            wait();
        }
        bookCount++;
        System.out.println("putBook - добавил 1 книгу, в хранилище " + bookCount);
        System.out.println("putBook - завершение выполнения");
    }
    public synchronized void getBook() throws InterruptedException {
        // уменьшает счетчик на 1
        System.out.println("getBook - начало выполнения");
        while (bookCount < 1){
            notify();
            System.out.println("getBook в состоянии ожидания");
            wait();
        }
        bookCount--;
        System.out.println("getBook - забрали 1 книгу, осталось " + bookCount);
        System.out.println("getBook - завершение выполнения");
        notify(); // notifyAll()
    }
}

class PutThread implements Runnable{

    BookStorage bookStorage;

    public PutThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread implements Runnable{

    BookStorage bookStorage;

    public GetThread(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

