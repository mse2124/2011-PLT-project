import java.awt.*;
import javax.swing.*;
public class Turtle extends JPanel{
  private double x;
  private double y;
  private double angle;
  private boolean down;
  public Turtle(){
    this(500,500);
  }
  public Turtle(int w, int h){
    this(w,h,w/2,h/2,0);
  }
  public Turtle(int w, int h, int x, int y, double angle){
    setPreferredSize(new Dimension(w,h));
    this.x = x;
    this.y = y;
    this.angle = angle;
    down = false;
  }
  public void down(){
    down = true;
  }
  public void up(){
    down = false;
  }
  public void forward(double t, Graphics g){
    double nx = x + Math.cos(angle)*t;
    double ny = y + Math.sin(angle)*t;
    if (down)
      g.drawLine((int)x,(int)y,(int)nx,(int)ny);
    x = nx;
    y = ny;
  }
  public void turn(double deg){
    angle += deg*Math.PI/180.0;
  }
}
class Circle extends Turtle {
  public static void main(String[] args){
    JFrame j = new JFrame();
    j.add(new Circle());
    j.pack();
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.setVisible(true);
    j.setResizable(false);
  }
  public Circle(){
    super(500,500);
  }
  public void paintComponent(Graphics g){
    down();
    for (int i = 0; i < 10; i++){
      forward(50,g);
      turn(30);    
    }
  }
}
