package Exercise4;

public class SumClass {
    private int sum = 0;

    public int getSumNotSynchronized() {
        return sum;
    }

    public synchronized int getSumSynchronized() {
        return sum;
    }

    public void AddOneNotSynchronized() {
        sum++;
    }

    public synchronized void AddOneSynchronized() {
        sum++;
    }

}
