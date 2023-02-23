public class NotSyncCounter implements ICounter{
    private int c;
    public NotSyncCounter(int c)
    {
        this.c = c;
    }

    public void Increment() {
        c++;
    }

    public void Decrement() {
        c--;
    }

    @Override
    public void GetValue() {
        System.out.println(this.c);
    }


}
