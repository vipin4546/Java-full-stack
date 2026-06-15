/*class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberThread t = new NumberThread();
        t.start();
    }
}*/
class MessageTask implements Runnable {

    @Override
    public void run() {

        System.out.println(
                "Hello Multithreading"
        );

    }
}

/*public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MessageTask());
        t.start();


        System.out.println(
                Thread.currentThread().getName()
        );

    }
}*/
public class Main {

    public static void main(String[] args) {

        Task1 t1 = new Task1();

        Task2 t2 = new Task2();

        t1.start();

        t2.start();

    }
}

class Task2 extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "Task2 : " + i
            );

        }
    }
}

class Task1 extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "Task1 : " + i
            );

        }
    }
}
