package package1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Map;

public class Player extends JPanel {
    
    private String name;
    private int power = 200;
    private Image body;
    private Map<String, Integer> position;
    private final int width = 20;
    private final int height = 20;
    
    

    public Player(String name, String imagePath) {
        this.name = name;
        position = new HashMap<>();
        position.put("x", 0);
        position.put("y", 0);

        loadImage(imagePath);
        setPreferredSize(new java.awt.Dimension(width, height));
        initBoard(); // Initialize key listener here
    }

    private void loadImage(String imagePath) {
        ImageIcon ii = new ImageIcon(imagePath);
        body = ii.getImage();
        if (body == null) {
            System.out.println("Image not found at: " + imagePath);
        }
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPlayer(g);
    }

    private void drawPlayer(Graphics g) {
        g.drawImage(body, position.get("x"), position.get("y"), this);
    }

    public void move(int dx, int dy) {
        int newX = Math.max(0, Math.min(1300 - width, dx + position.get("x"))); // Prevent moving out of bounds
        int newY = Math.max(0, Math.min(800 - height, dy + position.get("y")));
        position.put("x", newX);
        position.put("y", newY);
        repaint();  // Repaint the component after moving
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                move(-10, 0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                move(10, 0);
            }

            if (key == KeyEvent.VK_UP) {
                move(0, -10);
            }

            if (key == KeyEvent.VK_DOWN) {
                move(0, 10);
            }
        }
    }
}
