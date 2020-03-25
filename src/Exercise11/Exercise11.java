package Exercise11;

// Et eksempel på deadlock. To tråde skal lægge to tal sammen i modsat rækkefølge og derfor ender de i deadlock da der er lås på.
// Kører man programmet vil den derfor aldrig afslutte.
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

                    // Alt efter her når tråd 1 aldrig hen til.
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

                    // Alt efter her når tråd 2 aldrig hen til.
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
