
package entity;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

//to make random move
import javax.imageio.ImageIO;
import main.GamePanel;

public class Customer extends Entity{
    public Customer(GamePanel gp){
        
    //to Entity Class
        super(gp);
    
    //stat 
        direction = "walk";
        speed = 5;
        width = 110;
        height = 85;
        
    //collision
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
