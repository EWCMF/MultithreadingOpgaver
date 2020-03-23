package Exercise4;

public class Synchronized {
    public static void main(String[] args) {
        SumClass sum = new SumClass();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    sum.AddOneSynchronized();
                    System.out.println(sum.getSumSynchronized());
                }
            });
            thread.start();
        }
    }
}
