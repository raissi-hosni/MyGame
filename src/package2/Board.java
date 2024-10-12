package package2;


import package1.Player;
import package3.Dice;
import package1.Power;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

public class Board extends JFrame {
    private Player player1, player2;
    private Dice dice;
    private Power power1,power2;
    private Image backgroundImage;
    private  String bg ;
    private  ArrayList models ;
     private Color barColor; 
     
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
        //=========add powers======================
        this.power1 = new Power(player1.getFullName(),player1.getPower(),Color.BLUE);
        power1.setBounds(10, 10, 300, 30);
        this.add(power1);
        
        this.power2 = new Power(player2.getFullName(),player2.getPower(),Color.RED);
        power2.setBounds(10, 50, 300, 30);
        this.add(power2);
        
        
        this.dice = new Dice();
        dice.setBounds(620, 670, 70, 80);  // Example position (adjust as needed)
        this.add(dice);

    }

     @Override
    public void paint(Graphics g) {
        super.paint(g);
         Graphics2D g2d = (Graphics2D) g;

        
        float opacity = 0.7f;  // Adjust this value to change the opacity (e.g., 0.5f for 50% opacity)

        // Set the composite for transparency
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

        // Draw the background image with the specified opacity
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Reset the composite to fully opaque for subsequent drawings
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        
       //player1.paint(g); 
       //player2.paint(g); 
      
    }
    
}
