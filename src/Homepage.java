package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Homepage extends JPanel implements ActionListener, MouseListener{
    
    final int Panel_WIDTH = 800;
    final int Panel_HEIGHT = 500;
    Image CAT1; 
    Image CAT2; 
    Image background;
    Image CATGAME;
    ImageIcon Play1;
    ImageIcon Play2;
    ImageIcon Aboutus1;
    ImageIcon Aboutus2;
    Timer timer;
    int xVelocity1 = 1;
    int yVelocity1 = 1;
    int xVelocity2 = 2;
    int yVelocity2 = 1;
    int x1=(int)(Math.random()*100);
    int y1=(int)(Math.random()*100);
    int x2=(int)(Math.random()*100)+300;
    int y2=(int)(Math.random()*100)+300;
    // JLabel play;
    JButton Butplay;
    JButton Butaboutus;
    JLabel bgimage;

    public Homepage(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(Panel_WIDTH,Panel_HEIGHT));
        this.setBackground(Color.BLACK);

        CAT1 = new ImageIcon("IMG/Cat4.png").getImage().getScaledInstance(106, 70, Image.SCALE_DEFAULT);
        CAT2 = new ImageIcon("IMG/Cat5.png").getImage().getScaledInstance(106, 70, Image.SCALE_DEFAULT);
        //background = new ImageIcon("IMG/nyancat500-background.jpg").getImage();
        CATGAME = new ImageIcon("IMG/CatgameName200.png").getImage();
        Play1 = new ImageIcon(new ImageIcon("IMG/Play6200.png").getImage());
        Play2 = new ImageIcon(new ImageIcon("IMG/Play7.png").getImage().getScaledInstance(267, 200, Image.SCALE_DEFAULT));
        Aboutus1 = new ImageIcon(new ImageIcon("IMG/aboutus1.png").getImage().getScaledInstance(355, 200, Image.SCALE_DEFAULT));
        Aboutus2 = new ImageIcon(new ImageIcon("IMG/aboutus2.png").getImage().getScaledInstance(355, 200, Image.SCALE_DEFAULT));
        timer = new Timer(1, this);
        timer.start();

        //this.setLayout(new BorderLayout()); 
            
        Butplay = new JButton("");
        //Butplay.setSize(200, 100);
        Butplay.setContentAreaFilled(false); //not show layout behind the button
        Butplay.setBorderPainted(false); //ปิดขอบ
        Butplay.setIcon(Play1);
        Butplay.setBounds(275, 245, 260, 120);
        Butplay.addMouseListener(this);
        this.add(Butplay);

        Butaboutus = new JButton("");
        //Butaboutus.setSize(200, 100);
        Butaboutus.setContentAreaFilled(false); //not show layout behind the button
        Butaboutus.setBorderPainted(false); //ปิดขอบ
        Butaboutus.setIcon(Aboutus1);
        Butaboutus.setBounds(235, 320, 350, 120);
        Butaboutus.addMouseListener(this);
        this.add(Butaboutus);

        bgimage = new JLabel(new ImageIcon("IMG/nyancat500-background.jpg"));
        bgimage.setBounds(0, 0, 800, 500);
        this.add(bgimage);

       

    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        super.paint(g); //setBackground
        //g2D.drawImage(background, 0, 0, null);
        g2D.drawImage(CATGAME, 80, 50, null);
        g2D.drawImage(CAT1, x1, y1, null);
        g2D.drawImage(CAT2, x2, y2, null);
       
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(x1>=Panel_WIDTH-CAT1.getWidth(null) || x1<0){
            xVelocity1 = xVelocity1 * -1;
        }
        x1 = x1 + xVelocity1;

        if(y1>=Panel_HEIGHT-CAT1.getHeight(null) || y1<0){
            yVelocity1 = yVelocity1 * -1;
        }
        y1 = y1 + yVelocity1;
        ////////////////////////////////////////////////////////////////
        if(x2>=Panel_WIDTH-CAT2.getWidth(null) || x2<0){
            xVelocity2 = xVelocity2 * -1;
        }
        x2 = x2 + xVelocity2;

        if(y2>=Panel_HEIGHT-CAT2.getHeight(null) || y2<0){
            yVelocity2 = yVelocity2 * -1;
        }
        y2 = y2 + yVelocity2;
        repaint();
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You Clicked the mouse");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You Pressed the mouse");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == Butaboutus){
            new AboutUs();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("You Entered the mouse");
        if(e.getSource() == Butplay){
            Butplay.setIcon(Play2);
        }else if (e.getSource() == Butaboutus){
            Butaboutus.setIcon(Aboutus2);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("You Exited the mouse");
        if(e.getSource() == Butplay){
            Butplay.setIcon(Play1);
        }else if (e.getSource() == Butaboutus){
            Butaboutus.setIcon(Aboutus1);
        }
    }

}
