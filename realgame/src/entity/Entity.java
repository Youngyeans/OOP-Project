package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import object.TablewithCust;
import object.topTablewithCust;

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
    public boolean hasline;
    
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
                    direction = "";
                    solidArea.height = 0;
                    solidArea.width = 0;
                    gp.obj[1].empty = false;
                    hasTable = true;
                    //table A with Customer
                    gp.obj[1] = new TablewithCust();
                    gp.obj[1].x = 5 * gp.tileSize + 13;
                    gp.obj[1].y = 3 * gp.tileSize + 14;
                    gp.obj[1].empty = false;
                    gp.obj[5] = new topTablewithCust();
                    gp.obj[5].x = 5 * gp.tileSize + 13;
                    gp.obj[5].y = 3 * gp.tileSize + 14;
                }
            }
            
            // no line and table B
            else if(collisionOn == false && gp.obj[2].empty == true && hasTable == false ){
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
                    direction = "";
                    solidArea.height = 0;
                    solidArea.width = 0;
                    gp.obj[2].empty = false;
                    hasTable = true;
                    gp.obj[2] = new TablewithCust();
                    gp.obj[2].x = 11 * gp.tileSize - 14;
                    gp.obj[2].y = 3 * gp.tileSize + 14;
                    gp.obj[2].empty = false;
                    gp.obj[6] = new topTablewithCust();
                    gp.obj[6].x = 11 * gp.tileSize - 14;
                    gp.obj[6].y = 3 * gp.tileSize + 14;

                    
                }
            }
        
        // no line and table C
            else if(collisionOn == false && gp.obj[3].empty == true && hasTable == false){
                if(y != 400 && y != 420){
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
                    System.out.println("have customer at C");
                    direction = "";
                    solidArea.height = 0;
                    solidArea.width = 0;
                    gp.obj[3].empty = false;
                    hasTable = true;
                    gp.obj[3] = new TablewithCust();
                    gp.obj[3].x = 5 * gp.tileSize + 13;
                    gp.obj[3].y = 7 * gp.tileSize + 7;
                    gp.obj[3].empty = false;
                    gp.obj[7] = new topTablewithCust();
                    gp.obj[7].x = 5 * gp.tileSize + 13;
                    gp.obj[7].y = 7 * gp.tileSize + 7;
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
                    direction = "";
                    solidArea.height = 0;
                    solidArea.width = 0;
                    gp.obj[4].empty = false;
                    hasTable = true;
                    gp.obj[4] = new TablewithCust();
                    gp.obj[4].x = 11 * gp.tileSize - 14;
                    gp.obj[4].y = 7 * gp.tileSize + 7;
                    gp.obj[4].empty = false;
                    gp.obj[8] = new topTablewithCust();
                    gp.obj[8].x = 11 * gp.tileSize - 14;
                    gp.obj[8].y = 7 * gp.tileSize + 7;
                }
            }
            
            //no table get line
            else if(collisionOn == false && hasTable == false && gp.line == 0){
                if(y != 400){
                    y += speed;
                    spriteCounter++;
                }
                else{
                    gp.line = 1;
                    speed = 0;
                    hasline = true;
                    spriteNum = 1;
                }
            }
            else if(collisionOn == false && hasTable == false && gp.line == 1){
                if(y != 250){
                    y += speed;
                    spriteCounter++;
                }
                else{
                    gp.line = 2;
                    speed = 0;
                    hasline = true;
                    spriteNum = 1;
                }
            }
            else if(collisionOn == false && hasTable == false && gp.line == 2){
                if(y != 100){
                    y += speed;
                    spriteCounter++;
                }
                else{
                    gp.line = 3;
                    speed = 0;
                    hasline = true;
                    spriteNum = 1;
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
