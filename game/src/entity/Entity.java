package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;

//stories variables that be used in Player , Customer Class
public class Entity {
    GamePanel gp;
    public int x, y;
    public int speed;
    
    //image
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, walk1, walk2, walk3, walk4;
    public String direction;
    
    //make animation : change pic
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    //solid Tiles
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    //solid oject
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    //for customer
//    public int heart;
//    public String state;
    public int width, height;
    public boolean hasTable;
    
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    
    public void setAction(){}
    
    public void update(){
        //setAction();
        
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);
        
        // no line and table A
            if(collisionOn == false && gp.obj[1].empty == true && hasTable == false){
                if(y != 190 && y != 210){
                    y += speed;
                    spriteCounter++;
                }
                else if(x != 120){
                    if(direction != "to"){
                        direction = "to";
                        y += 20;
                    }
                    x += speed;
                    spriteCounter++;
                }
                else{
                    System.out.println("have customer at A");
                    spriteCounter = 0;
                    gp.obj[1].empty = false;
                    hasTable = true;
                }
            }
            
            // no line and table B
            else if(collisionOn == false && gp.obj[3].empty == true && hasTable == false ){
                if(y != 114 && y!= 134){
                    y += speed;
                    spriteCounter++;
                }
                else if(x != 400){
                    if(direction != "to"){
                        direction = "to";
                        y += 20;
                    }
                    x += speed;
                    spriteCounter++;
                }
                else{
                    System.out.println("have customer at B");
                    spriteCounter = 0;
                    gp.obj[3].empty = false;
                    hasTable = true;
                }
            }
        
        // no line and table C
            else if(collisionOn == false && gp.obj[2].empty == true && hasTable == false){
                if(y != 400 && y != 420){
                    y += speed;
                    spriteCounter++;
                }
                else if(x != 150){
                    if(direction != "to"){
                        direction = "to";
                        y += 20;
                    }
                    x += speed;
                    spriteCounter++;
                }
                else{
                    System.out.println("have customer at C");
                    spriteCounter = 0;
                    gp.obj[2].empty = false;
                    hasTable = true;
                }
            }
            
         // no line and table D
            else if(collisionOn == false && gp.obj[4].empty == true && hasTable == false){
                if(y != 300 && y != 320){
                    y += speed;
                    spriteCounter++;
                }
                else if(x != 400){
                    if(direction != "to"){
                        direction = "to";
                        y += 20;
                    }
                    x += speed;
                    spriteCounter++;
                }
                else{
                    System.out.println("have customer at D");
                    spriteCounter = 0;
                    gp.obj[4].empty = false;
                    hasTable = true;
                }
            }
              
//                switch(direction){
//                    case "walk":
//                        
//                        break;
//                    case "down":
//                        y += speed;
//                        break;
//                    case "left":
//                        x -= speed;
//                        break;
//                    case "right":
//                        x += speed;
//                        break;
//                }
            //set time to change
            //spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
    }
    
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        switch(direction){
            case "walk":
                if(spriteNum == 1){
                    image = walk1;
                }
                if(spriteNum == 2){
                    image = walk2;
                }
                break;
            case "to":
                width = 135;
                height = 50;
                solidArea.width = width;
                solidArea.height = height;
                if(spriteNum == 1){
                    image = walk3;
                }
                if(spriteNum == 2){
                    image = walk4;
                }
                break;
//            case "down":
//                if(spriteNum == 1){
//                    image = down1;
//                }
//                if(spriteNum == 2){
//                    image = down2;
//                }
//                break;
//            case "left":
//                if(spriteNum == 1){
//                    image = left1;
//                }
//                if(spriteNum == 2){
//                    image = left2;
//                }
//                break;
//            case "right":
//                if(spriteNum == 1){
//                    image = right1;
//                }
//                if(spriteNum == 2){
//                    image = right2;
//                }
//                break;
        }
        //g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        g2.drawImage(image, x, y, width, height, null);
    }
}
