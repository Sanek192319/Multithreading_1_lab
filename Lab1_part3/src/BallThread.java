public class BallThread extends Thread {
    private Ball b;
    private BallCanvas ballCanvas;

    public BallThread(Ball ball){
        b = ball;
    }

    @Override
    public void run() {
        try {
            while (true)
            {
                b.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        }
        catch(InterruptedException ex)
        {

        }
    }
}

