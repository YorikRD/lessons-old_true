package lesson24;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsLesson {
    public static void main(String[] args) {

        // ExecutorService
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 7; i++) {
            // метод execute запускает задачу на выполнение
            fixedPool.execute(new RunnableTask("fixedPool"));
        }
//        fixedPool.shutdown();// завершает текущие задачи и не принимает новые

        // прерывает выполнение задач, возвращает список с незавершенными задачами
        List<Runnable> runnables = fixedPool.shutdownNow();
        System.out.println(runnables);

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown();



        // отложенное выполнение
        ScheduledExecutorService scheduledService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledService.schedule(new RunnableTask("scheduledService"),
                5, TimeUnit.SECONDS);
        scheduledService.shutdown();

        // выполнение каждые 5 секунд
        ScheduledExecutorService everyFiveSecond =
                Executors.newSingleThreadScheduledExecutor();
        everyFiveSecond.scheduleAtFixedRate(
                new RunnableTask("everyFiveSecond"),
                0,
                5,
                TimeUnit.SECONDS
                );

        ScheduledExecutorService everySecond =
                Executors.newSingleThreadScheduledExecutor();

        everySecond.scheduleWithFixedDelay(
                new RunnableTask("everySecond"),
                0,
                1,
                TimeUnit.SECONDS
        );
    }
}

class RunnableTask implements Runnable {

    private String poolName;

    public RunnableTask(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() +
                " из пула " + poolName);
    }
}
