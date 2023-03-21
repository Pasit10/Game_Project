package ScoreBoard;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import game.gameframe;
import src.CatGame;

public class AddnametoScoreBoard extends JFrame implements MouseListener{
    private JLabel gameOver;
    private JButton Butnext;
    private JLabel yourscore;
    private JTextField addName;
    private int score;
    private CatGame catgame;

    private JLabel bgimage;
    private ImageIcon next1;
    private ImageIcon next2;

    private JButton Butplay;
    private ImageIcon Play1;
    private ImageIcon Play2;


    public AddnametoScoreBoard(int score,CatGame ct){
        catgame = ct;
        this.score = score;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddnametoScoreBoradComponents();
        
        setSize(800,500);
        setLocationRelativeTo(null);
        bgimage = new JLabel(new ImageIcon("IMG/nyancat500-background.jpg"));
        bgimage.setBounds(0, 0, 800, 500);
        this.add(bgimage);
        

        //setComponentZOrder(bgimage, 0);
        setLayout(null);
        setVisible(true);
    }

    private void AddnametoScoreBoradComponents(){
        gameOver = new JLabel("Game Over");
        gameOver.setBounds(180, 0,440, 210);
        gameOver.setFont(new Font("Courier New",Font.BOLD,80));
        gameOver.setForeground(Color.darkGray);
        add(gameOver);

        yourscore = new JLabel("Your Score : " + score);
        yourscore.setBounds(330, 140,400, 100);
        yourscore.setFont(new Font("Lucida Console",Font.PLAIN,18));
        yourscore.setForeground(Color.WHITE);
        add(yourscore);

        addName = new JTextField("Your name");
        addName.setBounds(275, 250 ,250, 40);
        addName.setFont(new Font("Lucida Console",Font.PLAIN,18));
        addName.setForeground(Color.GRAY);
        add(addName);


        next1 = new ImageIcon(new ImageIcon("IMG/Next1.png").getImage().getScaledInstance(178, 100, Image.SCALE_DEFAULT));
        next2 = new ImageIcon(new ImageIcon("IMG/Next2.png").getImage().getScaledInstance(178, 100, Image.SCALE_DEFAULT));
        Butnext = new JButton();
        Butnext.setBounds(325, 380, 150,50);
        Butnext.setIcon(next1);
        Butnext.setContentAreaFilled(false); 
        Butnext.setBorderPainted(false);
        add(Butnext);
        Butnext.addMouseListener(this);

        Play1 = new ImageIcon(new ImageIcon("IMG/Playagin1.png").getImage().getScaledInstance(178, 100, Image.SCALE_DEFAULT));
        Play2 = new ImageIcon(new ImageIcon("IMG/Playagin2.png").getImage().getScaledInstance(178, 100, Image.SCALE_DEFAULT));
        Butplay = new JButton();
        Butplay.setContentAreaFilled(false); 
        Butplay.setBorderPainted(false); 
        Butplay.setIcon(Play1);
        Butplay.setBounds(325, 325, 150, 50);
        Butplay.addMouseListener(this);
        this.add(Butplay);
    }

    private void addDatatocsv(){
        try{
            FileWriter csvWriter = new FileWriter("ScoreBoard/score.csv",true);
            csvWriter.append(addName.getText() + "," + score + "\n");

            csvWriter.flush();
            csvWriter.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Butnext){
            addDatatocsv();
            setVisible(false);
            catgame.setVisible(true);
        }else if(e.getSource() == Butplay){
            addDatatocsv();
            new gameframe(catgame);
            setVisible(false);
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
        if(e.getSource() == Butnext){
            Butnext.setIcon(next2);
        }else if(e.getSource() == Butplay){
            Butplay.setIcon(Play2);
        }
	}

	@Override
	public void mouseExited(MouseEvent e) {
        if(e.getSource() == Butnext){
            Butnext.setIcon(next1);
        }else if(e.getSource() == Butplay){
            Butplay.setIcon(Play1);
        }
	}
}

