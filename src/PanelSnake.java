package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PanelSnake extends JPanel implements ActionListener{
    
    final int Panel_WIDTH = 800;
    final int Panel_HEIGHT = 500;
    Image Snake; 
    Image background;
    Image SNAKEGAME;
    Image easy;
    Image normal;
    Image hard;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x=0;
    int y=0;

    public PanelSnake(){
        this.setPreferredSize(new Dimension(Panel_WIDTH,Panel_HEIGHT));
        this.setBackground(Color.BLACK);
        Snake = new ImageIcon("IMG/Cat08.png").getImage();
        background = new ImageIcon("IMG/nyancat500-background.jpg").getImage();
        SNAKEGAME = new ImageIcon("IMG/SNAKEGAME400.png").getImage();
        easy = new ImageIcon("IMG/Easy200.png").getImage();
        normal = new ImageIcon("IMG/Normal200.png").getImage();
        hard = new ImageIcon("IMG/Hard200.png").getImage();
        timer = new Timer(1, this);
        timer.start();

        //this.setLayout(new BorderLayout()); 


    }

    public void paint(Graphics g){
        super.paint(g); //setBackground
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(background, 0, 0, null);
        g2D.drawImage(Snake, x, y, null);
        g2D.drawImage(SNAKEGAME, 150, 50, null);
        g2D.drawImage(easy, 300, 200, null);
        g2D.drawImage(normal, 300, 250, null);
        g2D.drawImage(hard, 300, 300, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(x>=Panel_WIDTH-Snake.getWidth(null) || x<0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if(y>=Panel_HEIGHT-Snake.getHeight(null) || y<0){
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;
        repaint();
    }
}
