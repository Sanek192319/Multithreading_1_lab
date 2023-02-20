import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    public static CatchedBallsCounter CatchedBallsCounter;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        JPanel counterPanel = new JPanel();
        JLabel counterLabel = new JLabel("Balls caught: 0");
        CatchedBallsCounter = new CatchedBallsCounter(counterLabel);
        counterPanel.add(counterLabel);
        counterPanel.setBackground(Color.lightGray);
        content.add(counterPanel, BorderLayout.NORTH);
        content.add(this.canvas, BorderLayout.CENTER);
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JButton buttonAddHole = new JButton("Add Hole");
        JButton buttonStart100 = new JButton("Start 100");
        JButton buttonStart1000 = new JButton("Start 1000");
        JButton buttonStart5000 = new JButton("Start 5000");
        JButton buttonStart10000 = new JButton("Start 10000");
        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas);
                canvas.add(b);

                BallThread thread = new BallThread(b,CatchedBallsCounter);
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        buttonAddHole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Hole b = new Hole(canvas);
                canvas.addHole(b);
                canvas.repaint();
            }
        });
buttonStart100.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 100; i++){
            Ball b = new Ball(canvas);
            canvas.add(b);

            BallThread thread = new BallThread(b, CatchedBallsCounter);
            thread.start();
        }
    }
});
        buttonStart1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 1000; i++){
                    Ball b = new Ball(canvas);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, CatchedBallsCounter);
                    thread.start();
                }
            }
        });
        buttonStart5000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 5000; i++){
                    Ball b = new Ball(canvas);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, CatchedBallsCounter);
                    thread.start();
                }
            }
        });
        buttonStart10000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10000; i++){
                    Ball b = new Ball(canvas);
                    canvas.add(b);

                    BallThread thread = new BallThread(b, CatchedBallsCounter);
                    thread.start();
                }
            }
        });
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonAddHole);
        buttonPanel.add(buttonStart100);
        buttonPanel.add(buttonStart1000);
        buttonPanel.add(buttonStart5000);
        buttonPanel.add(buttonStart10000);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}