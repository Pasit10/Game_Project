package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.*;

public class AboutUs extends JFrame{
    final int WIDTH = 800;
    final int HEIGHT = 500;
    JPanel panels;
    Image background;
    JLabel bgimage;
    Image Support;
    Image QR;

    public AboutUs(){
        panels = new JPanel();
        detailPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.add(panels);   
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);




    }

    void detailPanel(){
        panels.setLayout(null);
        panels.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panels.setBackground(Color.BLACK);
        bgimage = new JLabel(new ImageIcon("IMG/nyancat500-background.jpg"));
        bgimage.setBounds(0, 0, 800, 500);
        panels.add(bgimage);
        //Support = new ImageIcon("IMG/support.png").getImage().getScaledInstance(355, 200, Image.SCALE_DEFAULT);
        Support = new ImageIcon("IMG/support150.png").getImage();
        QR = new ImageIcon("IMG/Donate300.png").getImage();

    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        super.paint(g); 
        g2D.drawImage(Support, 270, 50, null);
        g2D.drawImage(QR, 250, 180, null);
    }

    public static void main(String[] args) {
        new AboutUs();
    }


}
