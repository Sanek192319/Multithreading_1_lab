public class Main {
    public static void main(String[] args) throws InterruptedException {
        NotSyncCounter counter = new NotSyncCounter(0);
        //SyncCounter counter = new SyncCounter(0);
        //SyncBlockCounter counter = new SyncBlockCounter(0);
        //LockCounter counter = new LockCounter(0);
        Thread thread1 = new Thread(()-> {
            for(int i =0; i < 100000;i++)
            {
                counter.Increment();
            }
        });
        Thread thread2 = new Thread(()-> {
            for(int i =0; i < 100000;i++)
            {
                counter.Decrement();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
counter.GetValue();
    }
}