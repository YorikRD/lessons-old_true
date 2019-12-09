package lesson22;

public class Robot {
    // 10 - самый высокий
    // 1 - самый низкий
    // setPriority(int);
    // getPriority();
//    final static int MIN_PRIORITY = 1;
//    final static int NORM_PRIORITY = 5;
//    final static int MAX_PRIORITY = 10;

    // два потока должны по очереди выводить свое имя в консоль


    // топ 100 слов параллельно.
    // Количество потоков = Runtime.getRuntime().availableProcessors()
    // Каждый поток собирает результат в свой map, затем добавляет в общий map.
    // Поток, который создавал другие потоки должен ожидать их завершения и
    // выводить результат в консоль

    // the - 234
    // the - 56



    volatile boolean currentLeg = true;

    class Leg implements Runnable{

        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg = leg;
        }

        public void step(){
            System.out.println(name);
        }

        @Override
        public void run() {
            while (true) {
                if (leg == currentLeg){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    step();
                    currentLeg = !leg;
                    System.out.println(Thread.currentThread().getPriority());
                    Thread.yield();
                }
            }
        }
    }

    Leg left = new Leg("Left", false);
    Leg right = new Leg("Right", true);

    public void startRun(){
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().startRun();
    }
}
