public class SyncCounter implements ICounter{
    private int c;
    public SyncCounter(int c)
    {
        this.c = c;
    }
    @Override
    public synchronized void Increment() {
        c++;
    }

    @Override
    public synchronized void Decrement() {
        c--;
    }

    @Override
    public void GetValue() {
        System.out.println(this.c);
    }
}
