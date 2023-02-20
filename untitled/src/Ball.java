import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.IntToDoubleFunction;

import static java.lang.Math.pow;

class Ball {
    private BallCanvas canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    public void deleteBall()
    {
        this.canvas.removeBall(this);
        this.canvas.repaint();
    }
    public Ball(BallCanvas c) {
        this.canvas = c;

        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public static void f() {
        int a = 0;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));

    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

//    public boolean InHole(ArrayList<Hole> holes) {
//        if(holes.isEmpty())
//        {
//            return false;
//        }
//
//        for (Hole hole : holes)
//        {
////            if (hole.GetX() == this.x && hole.GetY() == this.y)
//            if(pow(this.YSIZE+hole.GetYSIZE(), 2) == pow(this.x - hole.GetX(),2) + pow(this.y-hole.GetY(),2));
//            {
//                return true;
//            }
//        }
//        return false;
//    }
public boolean InHole(){
    for (Hole h : this.canvas.GetHoles()) {
        if (InHole(h)){
            return true;
        }
    }
    return false;
}
    private boolean InHole(Hole hole){
        return x >= hole.GetX() && x <= hole.GetX() + hole.GetXSIZE() && y >= hole.GetY() && y <= hole.GetY() + hole.GetXSIZE();
    }
}