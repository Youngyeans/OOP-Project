package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class ScoreFrame extends JFrame {
    private GamePanel gp;
    Main main;
    
    private JButton startButton;
    private JButton exitButton;
    private JLabel backgroundLabel;
    private JLabel scoreLabel;

    public ScoreFrame(Main main, GamePanel gp) {
        
        this.gp = gp;
        this.main = main;
        setTitle("Score");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Background
        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundLabel.setIcon(new ImageIcon("res/MainMenu/bgmenu.png"));
        backgroundLabel.setLayout(null);


        // Create buttons with custom icons
        startButton = createButton("res/MainMenu/playbutton.png", 50, 40, 200, 150);
        exitButton = createButton("res/MainMenu/exitbutton.png", 50, 180, 200, 150);

        // Center buttons vertically
        int frameHeight = 576;
        int startY = (frameHeight - 380) / 2;
        startButton.setLocation(startButton.getX(), startY + 25);
        exitButton.setLocation(exitButton.getX(), startY + 125);
        
        // Create score label
        scoreLabel = new JLabel("Score: " + main.getGamePanel().getPlayer().getPoint());
        scoreLabel.setBounds(0, startY - 30, getWidth(), 30);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setOpaque(false);
        
        add(startButton);
        add(exitButton);
        add(scoreLabel);
        add(backgroundLabel);

        setVisible(true);
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
                if (button == startButton) {
                    gp.getGameTimer().setOnlyOnetimeScoreFrame(0);
                    dispose();
                    main.getWindow().dispose();
                    new Main();
                } else if (button == exitButton) {
                    // Perform exit action
                    System.exit(0);
                }
            }
        });

        return button;
    }

}
