package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AboutUs extends JFrame implements MouseListener{
    final int WIDTH = 800;
    final int HEIGHT = 500;
    JPanel panels;
    Image background;
    JLabel bgimage;
    Image Support;
    Image QR;
    Image Us;

    ImageIcon back;
    JLabel Laback;


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
        Us = new ImageIcon("IMG/Us200.png").getImage();
        //back = new ImageIcon("IMG/Arrow250.png").getImage();
        back = new ImageIcon(new ImageIcon("IMG/Arrow250.png").getImage());

        Laback = new JLabel(back);    
        Laback.setBounds(0, 0, 100, 80);
        panels.add(Laback);
        panels.setComponentZOrder(Laback, 0);
        Laback.addMouseListener(this);

    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        super.paint(g); 
        g2D.drawImage(Support, 470, 50, null);
        g2D.drawImage(QR, 450, 180, null);
        g2D.drawImage(Us, 60, 200, null);
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
        System.out.println("You Released the mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
