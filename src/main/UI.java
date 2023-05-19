/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_Key;

/**
 *
 * @author FinalDIE
 */
public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_30, arial_50, arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public int x,y = 0;
    
    public UI(GamePanel gp){
        this.gp = gp;
        arial_50 = new Font("Arial", Font.PLAIN, 100);
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_40 = new Font("Arial", Font.PLAIN, 30);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }
    
    public void showMessage(String text){
        
        message = text;
        messageOn = true;
        
    }
    public void draw(Graphics2D g2){
//        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setFont(arial_30);
        g2.setColor(Color.black);
        g2.drawImage(keyImage, 80, 40, gp.tileSize, gp.tileSize, null);
        g2.drawString("x "+ gp.player.hasKey, 130, 75);
        
        // message
        if(messageOn == true){
            
            g2.setFont(g2.getFont().deriveFont(20F));
            g2.drawString(message, x, y);
            
            messageCounter++;
            
            if(messageCounter > 120 ){
                System.out.println("hi");
                messageCounter = 0;
                messageOn = false;
            }
        }
        
//        g2.setFont(arial_40);
//        g2.setColor(Color.white);
//        g2.drawString("Noodle = "+ gp.player.hasKey, 80, 115);
        
        this.g2 = g2;
        g2.setFont(arial_50);
        g2.setColor(Color.red);
        
        //show time
        g2.setFont(arial_40);
        g2.setColor(Color.black);
        g2.drawString(""+ gp.gameTimer.getRemainingTime(), 80, 115);
        
        //show point
        g2.setFont(arial_40);
        g2.setColor(Color.black);
        g2.drawString(""+ gp.player.point, 80, 200);
        
        //Title State
        if(gp.gamestate == gp.titleState){
            drawTitleScreen();
            
        }
   
        //Play State
        if(gp.gamestate == gp.playstate){
            
        }//Pause State
        if(gp.gamestate == gp.pausestate){
            drawPauseScreen();
        }
        
        if(gp.gamestate == gp.finishstate){
            String text = "time up";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
            
            g2.drawString(text, x, y);
        }
        
        
       
    }
    public void drawTitleScreen(){
        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "Blue boy Adventure";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        
        
    }
    
    
    
    public void drawPauseScreen(){
            String text = "PAUSED";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
            
            g2.drawString(text, x, y);
        }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return  x;
    }
}
