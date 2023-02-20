public class BallThread extends Thread {
    private Ball b;
    private BallCanvas ballCanvas;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
int i =0;
        while (i<1000) {
            try {
                b.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
i++;
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

