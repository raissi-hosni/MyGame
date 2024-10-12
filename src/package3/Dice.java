package package3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Dice extends JPanel {
    private JButton diceButton;
    private ImageIcon[] diceFaces;
    private Random random;
    private int nbrSteps =0;
    // Constructor for the DicePanel
    public Dice() {
        // Set up the panel layout
        this.setLayout(new FlowLayout());

        // Initialize random number generator
        random = new Random();

        // Load and resize the dice face images to 60x60
        diceFaces = new ImageIcon[6];
        diceFaces[0] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice1.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        diceFaces[1] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice2.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        diceFaces[2] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice3.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        diceFaces[3] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice4.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        diceFaces[4] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice5.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        diceFaces[5] = new ImageIcon(new ImageIcon("C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/dice6.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        // Create the dice button and set the first dice face as the icon
        diceButton = new JButton(diceFaces[0]);

        // Add an action listener to change the dice face when clicked
        diceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        // Add the dice button to the panel
        this.add(diceButton);
    }
    public int getNbrSteps(){
        return this.nbrSteps;
    }
    // Method to simulate rolling the dice
    private void rollDice() {
    diceButton.setEnabled(false);
    new Thread(() -> {
        int finalValue = 0;  // Variable to hold the final rolled value
        for (int i = 0; i < 30; i++) { 
            int randomValue = random.nextInt(6); 
            diceButton.setIcon(diceFaces[randomValue]); 
            finalValue = randomValue + 1;  // Store the value (1-6) corresponding to the face shown
            try {
                Thread.sleep(20); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.nbrSteps = finalValue;  // Set nbrSteps to the final rolled value
        diceButton.setEnabled(true);
    }).start();
}
}
