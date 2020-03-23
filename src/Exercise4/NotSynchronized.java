package Exercise4;

class NotSynchronized {
    public static void main(String[] args) {
        SumClass sum = new SumClass();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    sum.AddOneNotSynchronized();
                    System.out.println(sum.getSumNotSynchronized());
                }
            });
            thread.start();
        }
    }
}
