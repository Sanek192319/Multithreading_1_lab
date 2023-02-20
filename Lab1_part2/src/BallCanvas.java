import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    private volatile ArrayList<Ball> balls = new ArrayList<>();
    private volatile ArrayList<Hole> holes = new ArrayList<>();

    public void add(Ball b){
        this.balls.add(b);
    }
    public void addHole(Hole b){

        this.holes.add(b);
    }
    public synchronized void  removeBall(Ball b)
    {
        this.balls.remove(b);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<balls.size();i++){
            Ball b = balls.get(i);
            b.draw(g2);
        }
        for(int i=0; i<holes.size();i++){
            Hole b = holes.get(i);
            b.draw(g2);
        }
    }
    public ArrayList<Hole> GetHoles()
    {
        return holes;
    }

}