package lesson21;

public class MTFirstLesson {
    public static void main(String[] args) {
        // каждый поток работает со своим стеком вызова,
        // но все потоки используют общую область памяти heap
        // Жизненный цикл потока
        /*1. создание
          2. запуск
          3. выполнение
          4. ожидание или блокировка
          5. завершение */

        FirstThread firstThread = new FirstThread(); // создание потока
        firstThread.start(); // запуск потока

        System.out.println("Основной поток " + Thread.currentThread().getName());
//        SecondThread secondThread = new SecondThread();

        Thread thread1 = new Thread(new SecondThread());
        Thread thread2 = new Thread(new SecondThread());
        Thread thread3 = new Thread(new SecondThread());

        thread1.start();
        System.out.println("thread1 " + thread1.getState());
        thread2.start();
        thread3.start();

        try {
            System.out.println(Thread.currentThread().getName() +
                    " ожидает завершения потоков");
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread someThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from someThread1");
            }
        });

        Thread someThread2 = new Thread(()->{
            System.out.println("someThread2 " + Thread.currentThread().isAlive());
            System.out.println("someThread2 " + Thread.currentThread().getState());
        });
        someThread2.start();

//        Thread daemonThread = new Thread(new DaemonThread());
//        daemonThread.setDaemon(true);
//        daemonThread.start();


        // прерывание потока
        /* Поток останавливается:
        1. выполнил все инструкции
        2. если было выброшено необработанное исключение
        3.остановилась JVM
        4. если поток был daemon потоком и все не daemon потоки
        завершили свою работу
        */


//        Thread: interrupted = false;
        Thread interrupt = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("some actions...");

                try {
                    Thread.sleep(1000); // interrupt.interrupt(); из main
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            System.out.println("After While");
        });
        interrupt.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interrupt.interrupt();

        System.out.println("Завершение основного потока " + Thread.currentThread().getName());

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(()->{
                System.out.println("Some actions");
            }).start();
        }


        /*
        Thread.currentThread() - текущий поток
        setName() - позволяет задать имя для потока
        getName() - возвращает имя потока
        getState() - возвращает состояние потока
        */
    }
}
// первый вариант описания потока - наследование от Thread
class FirstThread extends Thread{
    @Override
    public void run(){
        Thread.currentThread().setName("FirstThread");
        System.out.println(Thread.currentThread().getName());
    }
}
// первый вариант описания потока - расширение Runnable интерфейса
class SecondThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class DaemonThread implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("DaemonThread");
        }
    }
}