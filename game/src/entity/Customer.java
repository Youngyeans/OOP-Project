/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author youngyeans
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//to make random move
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;
public class Customer extends Entity{
    public Customer(GamePanel gp){
        //to Entity Class
        super(gp);
        //heart = 3;
        direction = "walk";
        speed = 2;
        width = 110;
        height = 85;
        
        //coll
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = width - 20;
        solidArea.height = height;
        
        getImage();
    }
    
    //getimage
    public void getImage(){
        try{
            walk1 = ImageIO.read(new File("res/customer/down1.png"));
            walk2 = ImageIO.read(new File("res/customer/down2.png"));
            walk3 = ImageIO.read(new File("res/customer/right1.png"));
            walk4 = ImageIO.read(new File("res/customer/right2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
