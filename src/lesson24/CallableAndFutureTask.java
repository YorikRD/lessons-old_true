package lesson24;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureTask {
    public static void main(String[] args)  {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<Unit> unitCallable = new UnitCreator();

//        task1 -> unit1 -> контейнер для unit1 (future1)
//        task2 -> unit2 -> контейнер для unit2 (future2)
//        task3 -> unit3 -> контейнер для unit3 (future3)
//        task4 -> unit4 -> контейнер для unit4 (future4)
//        task5 -> unit5 -> контейнер для unit5 (future5)

//        (future1=unit1).get() -> unit1

        ArrayList<Future<Unit>> list = new ArrayList<>();
        list.add(service.submit(new UnitCreator2()));
        for (int i = 0; i < 10; i++) {
            Future<Unit> future = service.submit(unitCallable);
            list.add(future);
        }
//        for (Future<Unit> future: list){
//            System.out.println("Waiting future...");
//            try {
//                System.out.println("Unit: " + future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//        service.shutdown();

        for (Future<Unit> future: list) {
            System.out.println("Waiting future...");
            try {
                System.out.println("Unit: " +
                        future.get((long)(Math.random()*3000),
                                TimeUnit.MILLISECONDS));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("---TimeoutException---");
            }
        }
        service.shutdown();

        ExecutorService service1 = Executors.newFixedThreadPool(3);
        Callable<Unit> unitCallable1 = new UnitCreator();
        Callable<Unit> unitCallable2 = new UnitCreator();

        FutureTask<Unit> task1 = new FutureTask<>(unitCallable1);
        FutureTask<Unit> task2 = new FutureTask<>(unitCallable2);

        service1.execute(task1);
        service1.execute(task2);
//        isShutdown() - возвращает true, если ExecutorService остановлен
//        isTerminated() - возвращает true, если задачи выполнены
//        при вызове метода shutdown()


        while (!service1.isShutdown()) {
            //  методы future:
//            future.isCancelled();
//            task1.cancel(можно ли прервать задачу в момент выполнения);
            if (task1.isDone() && task2.isDone()) {
                try {
                    System.out.println("TASK 1: " + task1.get());
                    System.out.println("TASK 2: " + task2.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                service1.shutdown();
            }
        }


    }
}

class UnitCreator2 implements Callable<Unit> {

    @Override
    public Unit call() throws Exception {
        Thread.sleep(10000);
        Random random = new Random();
        Unit unit = new Unit();
        unit.setName("UnitCreator2");
        unit.setHealth(random.nextInt(20));
        unit.setAttackScore(random.nextInt(15));
        return unit;
    }
}



class UnitCreator implements Callable<Unit> {

    @Override
    public Unit call() throws Exception {
        Thread.sleep((long)(Math.random()*5000));
        Random random = new Random();
        Unit unit = new Unit();
        unit.setName(Thread.currentThread().getName());
        unit.setHealth(random.nextInt(20));
        unit.setAttackScore(random.nextInt(15));
        return unit;
    }
}


class Unit {
    private String name;
    private int health;
    private int attackScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackScore=" + attackScore +
                '}';
    }
}
