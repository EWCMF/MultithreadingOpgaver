package Exercise4;

// Wrapper class til int da det blev fundet nødvendigt. Den har både normal getter og setter og synkroniseret versioner.
// Synchronized bruger de synkroniseret metoder.
class SumClass {
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
