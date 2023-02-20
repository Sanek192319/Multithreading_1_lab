import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.blue;
import static java.awt.Color.red;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStop = new JButton("Stop");
        JButton buttonStart100 = new JButton("Start 100 blue");
        JButton buttonStart1000 = new JButton("Start 1000 blue");
        JButton buttonStart5000 = new JButton("Start 5000 blue");

        buttonStart100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas, blue);
                canvas.add(b);
                BallThread ballThread = new BallThread(b);
                ballThread.start();
                BallThread prev = ballThread;
                for (int i = 1; i < 10; i++) {
                    b = new Ball(canvas, i % 2 == 0 ? blue : red);
                    canvas.add(b);
                    ballThread = new JoinedBallThread(b, prev);
                    ballThread.start();
                    prev = ballThread;
                }

            }
        });
        buttonPanel.add(buttonStart100);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}