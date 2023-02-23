import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements ICounter{
    private int c;
    ReentrantLock locker = new ReentrantLock();
    public LockCounter(int c)
    {
        this.c = c;
    }
    @Override
    public void Increment() {
        locker.lock();
        try {
            c++;
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void Decrement() {
        locker.lock();
        try {
            c--;
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void GetValue() {
        System.out.println(this.c);
    }
}
