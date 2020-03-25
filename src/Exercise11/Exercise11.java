package Exercise11;

public class Exercise11 {
    public static void main(String[] args) {
        Integer firstNumber = 5;
        Integer secondNumber = 10;
        System.out.println("Adderer variablerne, firstNumber og secondNumber, i forskellig rækkefølge.");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                synchronized (firstNumber) {
                    sum += firstNumber;

                    System.out.println("firstNumber er låst af tråd 1.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Tråd 1 vil have låsen til secondNumber.");
                    synchronized (secondNumber) {
                        sum += secondNumber;
                        System.out.println("secondNumber er låst af tråd 1.");
                    }

                    System.out.println("Summen er: " + sum);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                synchronized (secondNumber) {
                    sum += secondNumber;

                    System.out.println("secondNumber er låst af tråd 2.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Tråd 2 vil have låsen til firstNumber.");
                    synchronized (firstNumber) {
                        sum += firstNumber;

                        System.out.println("firstNumber er låst af tråd 2.");
                    }

                    System.out.println("Summen er: " + sum);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
