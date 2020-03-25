package Exercise4;

// Denne har mulighed for datakorruption så resultat bliver ikke 1000 hver gang.
class NotSynchronized {
    public static void main(String[] args) {
        SumClass sum = new SumClass();
        for (int i = 0; i < 1000; i++) {
            // Anonym indre klasse bruges for at have nem adgang til sum variablen.
            // Den kunne også være lambda udtryk som IntelliJ foreslår men denne er mere overskuelig.
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
