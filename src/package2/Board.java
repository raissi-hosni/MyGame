package package2;

import package1.Player;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
/*
bgs paths
 Touls/bg1.jpg
*/
public class Board extends JFrame {
    private Player player1, player2;
    private Image backgroundImage;
    private  String bg ;
    private  ArrayList models ;
    
    public Board(Player player1, Player player2,int bg_Num) {
        
        if(bg_Num == 1)
        {
            bg = "C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/bg1.jpg";
        }
        else{
            bg = "C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/bg2.jpg";
        }
        this.player1 = player1;
        this.player2 = player2;

        setTitle("Go To Hell");
        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setLayout(null);

        // Set size and initial positions of each player
        player1.setBounds(100, 100, 50, 50);  
        add(player1);
        player2.setBounds(200, 100, 50, 50);  
        add(player2);

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File(bg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     @Override
    public void paint(Graphics g) {
        super.paint(g);
         Graphics2D g2d = (Graphics2D) g;

        
        float opacity = 0.5f;  // Adjust this value to change the opacity (e.g., 0.5f for 50% opacity)

        // Set the composite for transparency
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

        // Draw the background image with the specified opacity
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Reset the composite to fully opaque for subsequent drawings
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        
       player1.paint(g); 
       player2.paint(g); 
    }
    
}
