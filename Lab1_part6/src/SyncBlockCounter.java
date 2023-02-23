public class SyncBlockCounter implements ICounter{
    private int c;
    public SyncBlockCounter(int c)
    {
        this.c = c;
    }
    @Override
    public void Increment() {
        synchronized (this) {
            this.c++;
        }
    }

    @Override
    public void Decrement() {
synchronized (this)
{
    this.c--;
}
    }

    @Override
    public void GetValue() {
        System.out.println(this.c);
    }
}
