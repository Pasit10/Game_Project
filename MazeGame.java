import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MazeGame extends JPanel implements KeyListener {
  private static final long serialVersionUID = 1L;
  private static final int WIDTH = 800;
  private static final int HEIGHT = 800;
  private static final int CELL_SIZE = 50;

  private Point player;
  private ArrayList<Point> walls;
  private Point end;

  public MazeGame() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    addKeyListener(this);
    setFocusable(true);
    generateMaze();
  }

  @Override
  public void paintComponent(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(Color.BLACK);
    for (Point wall : walls) {
      g.fillRect(wall.x * CELL_SIZE, wall.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
    g.setColor(Color.RED);
    g.fillRect(end.x * CELL_SIZE, end.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    g.setColor(Color.BLUE);
    g.fillOval(player.x * CELL_SIZE, player.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
  }

  private void generateMaze() {
    player = new Point(0, 0);
    walls = new ArrayList<Point>();
    Random random = new Random();
    for (int i = 0; i < WIDTH / CELL_SIZE; i++) {
      for (int j = 0; j < HEIGHT / CELL_SIZE; j++) {
        if (random.nextFloat() > 0.7) {
          walls.add(new Point(i, j));
        }
      }
    }
    end = new Point(WIDTH / CELL_SIZE - 1, HEIGHT / CELL_SIZE - 1);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
    case KeyEvent.VK_UP:
      if (!walls.contains(new Point(player.x, player.y - 1))) {
        player.y--;
      }
      break;
    case KeyEvent.VK_DOWN:
      if (!walls.contains(new Point(player.x, player.y + 1))) {
        player.y++;
      }
      break;
    case KeyEvent.VK_LEFT:
      if (!walls.contains(new Point(player.x - 1, player.y))){
        player.x--;
      }
      break;
    case KeyEvent.VK_RIGHT:
      if (!walls.contains(new Point(player.x + 1, player.y))) {
        player.x++;
      }
      break;
    }
    if (player.equals(end)) {
      generateMaze();
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void keyTyped(KeyEvent e) {}

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(new MazeGame());
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
