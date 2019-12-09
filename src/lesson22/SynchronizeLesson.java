package lesson22;

import java.util.ArrayList;

public class SynchronizeLesson {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }
        for (IncrementThread thread: threads){
            thread.start();
        }
        for (IncrementThread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("counter = " + counter.counter);
    }
}

class Counter {
    public int counter = 0;

    public void increment(){
        counter++;
    }
}

class IncrementThread extends Thread {
    private Counter counter;
    public IncrementThread(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
