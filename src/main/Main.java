package main;

import javax.swing.JFrame;

public class Main{
    private JFrame window;
    private GamePanel gamePanel;
    public Main(){
        window = new JFrame();
        gamePanel = new GamePanel(this);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("game");
        
        window.add(gamePanel);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
    
    public JFrame getWindow(){
        return window;
    }
    
    public void setGamePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    public GamePanel getGamePanel(){
        return gamePanel;
    }
}
