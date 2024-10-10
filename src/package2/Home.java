package package2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import package1.Player;


public class Home extends JFrame {
    private JTextField player1NameField;
    private JTextField player2NameField;
    private JTextField themeNumberField;
    private JButton startButton;
    private Player player1,player2;
    private int theme = 1;
    public Home() {
        // Set the title and basic settings for the window
        setTitle("Enter Player Info");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Adding 10px horizontal and vertical gaps between components
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); // 20px padding on all sides

        // Player 1 Name
        JLabel player1Label = new JLabel("Player 1 Name:");
        player1Label.setFont(new Font("Arial", Font.BOLD, 20)); // Set font to Arial, bold, size 16
        player1Label.setForeground(Color.BLUE);
        player1NameField = new JTextField();
        player1NameField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(player1Label);
        mainPanel.add(player1NameField);

        // Player 2 Name
        JLabel player2Label = new JLabel("Player 2 Name:");
        player2Label.setFont(new Font("Arial", Font.BOLD, 20)); // Set font to Arial, bold, size 16
        player2Label.setForeground(Color.BLUE);
        player2NameField = new JTextField();
        player2NameField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(player2Label);
        mainPanel.add(player2NameField);

        // Number of Themes
        JLabel themeNumberLabel = new JLabel("Number of Themes:");
        themeNumberLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font to Arial, bold, size 16
        themeNumberLabel.setForeground(Color.BLUE);
        themeNumberField = new JTextField();
        themeNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.add(themeNumberLabel);
        mainPanel.add(themeNumberField);

        // Start Button
        startButton = new JButton("Start Game");
        mainPanel.add(new JLabel()); // Empty label for layout purposes
        mainPanel.add(startButton);

        // Add the main panel to the frame
        add(mainPanel);

        // Add an action listener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1Name = player1NameField.getText();
                String player2Name = player2NameField.getText();
                String themesNumberStr = themeNumberField.getText();
                
                // Validate the input fields
                if (player1Name.isEmpty() || player2Name.isEmpty() || themesNumberStr.isEmpty()) {
                    JOptionPane.showMessageDialog(Home.this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int themesNumber;
                try {
                    themesNumber = Integer.parseInt(themesNumberStr); // Convert the string to an integer
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Home.this, "Please enter a valid number for themes.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                player1 = new Player(player1Name,"C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/player1.jpg");
                player2 = new Player(player2Name,"C:\\Users\\hosny\\Documents\\NetBeansProjects\\myGame\\src\\Touls/player1.jpg");
                theme = themesNumber;
                
                // Close the window
                dispose();
                
                // Open the game board after closing the Home window
                Board game = new Board(player1, player2, theme);
                game.setVisible(true);  // Show the game board
            }
        });
    }
    
}
