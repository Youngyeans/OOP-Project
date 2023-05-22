package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mac
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Main;

public class LoadingScreen {
    private JLabel Background;
    private JLabel LoadingLabel, LoadingValue;
    private JProgressBar LoadingBar;
    private JFrame fr;
    private JPanel p, p1, p2;
    private ImageIcon icon;
    
    public LoadingScreen() {
        fr = new JFrame();
        p = new JPanel();
        LoadingLabel = new JLabel();
        LoadingValue = new JLabel();
        LoadingBar = new JProgressBar();
        LoadingBar.setStringPainted(true);
        //LoadingBar.setPreferredSize(new Dimension(768, 0));
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        
        p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1));
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,2));
        
        LoadingBar = new JProgressBar();
        
        LoadingValue = new JLabel();
        
        LoadingLabel = new JLabel();
        LoadingLabel.setText("Turning On Modules...");
        
        ImageIcon icon = new ImageIcon("res/MainMenu/Loading.png");
        
        Background = new JLabel(icon);
        
        p.add(LoadingBar);
        p1.add(p2);
        p1.add(p);
        p2.add(LoadingLabel);
        p2.add(LoadingValue);

        fr.add(p1, BorderLayout.SOUTH);
        fr.add(Background, BorderLayout.CENTER);
        fr.setSize(768,576);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        
        LoadingValue.setHorizontalAlignment(SwingConstants.RIGHT);
        startLoading();
    }
   
    public void startLoading(){
        try {
            for(int i=0;i<=100;i+=5) {
                Thread.sleep(10);
                LoadingValue.setText(i + "%  ");
                LoadingBar.setValue(i);
                
                if(i==10) {
                    LoadingLabel.setText("  Turning On Modules...");
                }
                if(i==20) {
                    LoadingLabel.setText("  Loading Modules...");
                }
                if(i==50) {
                    LoadingLabel.setText("  Connecting to Database...");
                }
                if(i==70) {
                    LoadingLabel.setText("  Connection Successful !");
                }
                if(i==80) {
                    LoadingLabel.setText("  Launching Application...");
                }
                if(i==100){
                    Thread.sleep(1000);
                    fr.dispose();
                }
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
//    public static void main(String[] args) {
//        new LoadingScreen();
//    }
    
}

    