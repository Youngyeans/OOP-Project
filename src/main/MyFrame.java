package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    
    GamePanel gp;
    
    private JButton helpButton;
    private JButton startButton;
    private JButton exitButton;
    private JLabel backgroundLabel, wassanaLabel, logoLabel;
    private final int animationTime = 1000; 
    private final int targetX = 0; 

    public MyFrame() {
        setTitle("Wassana Dash!");
        setSize(768, 576);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Background
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundLabel.setIcon(new ImageIcon("res/MainMenu/bgmenu.png"));
        backgroundLabel.setLayout(null);

        // Wassana
        wassanaLabel = new JLabel();
        wassanaLabel.setBounds(800, 0, getWidth(), getHeight());
        wassanaLabel.setIcon(new ImageIcon("res/MainMenu/auntiewassana.png"));
        wassanaLabel.setLayout(null);

        // Logo
        logoLabel = new JLabel();
        logoLabel.setBounds(530, -50, getWidth() / 2, getHeight() / 2);
        logoLabel.setIcon(new ImageIcon("res/MainMenu/logospin2.gif"));
        logoLabel.setLayout(null);

        // Create buttons with custom icons
        startButton = createButton("res/MainMenu/playbutton.png", 50, 40, 200, 150);
        helpButton = createButton("res/MainMenu/helpbutton.png", 50, 110, 200, 150);
        exitButton = createButton("res/MainMenu/exitbutton.png", 50, 180, 200, 150);

        // Center buttons vertically
        int frameHeight = 576;
        int startY = (frameHeight - 380) / 2;
        startButton.setLocation(startButton.getX(), startY);
        helpButton.setLocation(helpButton.getX(), startY + 100);
        exitButton.setLocation(exitButton.getX(), startY + 200);

        // Add components to the frame
        add(helpButton);
        add(startButton);
        add(exitButton);
        add(wassanaLabel);
        add(logoLabel);
        add(backgroundLabel);

        setVisible(true);

        // Animate the wassanaLabel
        animateWassanaLabel();
    }

    private JButton createButton(String imagePath, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        // Set custom icon
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(image));

        // Button click listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event
                if (button == helpButton) {
                    // Handle helpButton click
                } else if (button == startButton) {
                    dispose();
                    new Main();
                } else if (button == exitButton) {
                    // Perform exit action
                    System.exit(0);
                }
            }
        });

        return button;
    }
 
public void animateWassanaLabel() {
    int delay = 10; // FPS

    int targetX = 0; // Specify the target X position for the animation
    int animationTime = 1000; // Specify the animation duration in milliseconds


    Timer wassanatimer = new Timer(delay, new ActionListener() {
        int stepSize = (800 - targetX) / (animationTime / delay);
        int currentX = 800;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            currentX -= stepSize;
            wassanaLabel.setLocation(currentX, wassanaLabel.getY());

            if (currentX <= targetX) {
                ((Timer) e.getSource()).stop(); // Animation complete, stop the timer
            }
        }
    });

    wassanatimer.start();
}

    public static void main(String[] args) {
        new LoadingScreen();
        new MyFrame();
    }
}
