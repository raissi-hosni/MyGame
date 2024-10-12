package package1;

import javax.swing.*;
import java.awt.*;

public class Power extends JPanel {
    private JLabel powerLabel;
    private JProgressBar powerBar;
    private String playerName; 
    private Color barColor; 

    // Constructor for the Power panel
    public Power(String playerName, int level, Color color) {
        this.playerName = playerName;
        this.barColor = color; // Set the color for the progress bar
        
        // Set up the panel layout
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        // Create and configure the label
        powerLabel = new JLabel(playerName);
        powerLabel.setForeground(Color.RED); 
        powerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(powerLabel); 

        // Create a custom progress bar with rounded corners
        powerBar = new JProgressBar(0, 100) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background (empty part)
                g2.setColor(Color.LIGHT_GRAY);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());

                // Foreground (filled part)
                int filledWidth = (int) (getWidth() * ((double) getValue() / getMaximum()));
                g2.setColor(barColor); // Use the specified color for the filled part
                g2.fillRoundRect(0, 0, filledWidth, getHeight(), getHeight(), getHeight());

                // Draw the border for the rounded rectangle
                g2.setColor(Color.BLACK);
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, getHeight(), getHeight());

                // Draw the string (percentage)
                String progressText = getString();
                FontMetrics fontMetrics = g2.getFontMetrics();
                int stringWidth = fontMetrics.stringWidth(progressText);
                int stringHeight = fontMetrics.getAscent();
                g2.setColor(Color.WHITE); // Set the text color
                g2.drawString(progressText, (getWidth() - stringWidth) / 2, (getHeight() + stringHeight) / 2 - 2);
            }
        };

        // Configure progress bar properties
        powerBar.setValue(level); // Set the initial value to the provided level
        powerBar.setPreferredSize(new Dimension(150, 20)); // Set the size of the progress bar
        powerBar.setStringPainted(true); // Show percentage text
        powerBar.setBorderPainted(false); // Remove default border
        this.add(powerBar); // Add progress bar to the panel
    }

    // Method to update the power level
    public void updatePower(int newValue) {
        powerBar.setValue(newValue);
    }
}
