public class JoinedBallThread extends BallThread{
    private  BallThread parentThread;
    public JoinedBallThread(Ball ball,  BallThread parent)
    {
        super(ball);
        parentThread = parent;
    }

    @Override
    public void run(){
        try{
            parentThread.join();
            super.run();
        } catch(InterruptedException ignored){
            super.interrupt();
        }

    }
}
