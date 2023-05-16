package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import main.SleepSetter;
import object.Shop;
import object.ShopnoNoodle;
import object.TablewithDish;
import object.topTablewithDish;
import org.w3c.dom.css.Counter;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    SleepSetter sl;
    
    int hasKey = 0;
    
 
    
    public Player(GamePanel gp, KeyHandler keyH, SleepSetter sl){
        
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        this.sl = sl;
        
        //solid (x, y, width, height)
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 50;
        solidArea.height = 35;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        x = 13 * gp.tileSize + 10;
        y = 2 * gp.tileSize + 20;
        speed = 4;
        direction = "down";
    }
    
    //getimage
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(new File("res/player/boy_up_1.png"));
            up2 = ImageIO.read(new File("res/player/boy_up_2.png"));
            down1 = ImageIO.read(new File("res/player/boy_down_1.png"));
            down2 = ImageIO.read(new File("res/player/boy_down_2.png"));
            left1 = ImageIO.read(new File("res/player/boy_left_1.png"));
            left2 = ImageIO.read(new File("res/player/boy_left_2.png"));
            right1 = ImageIO.read(new File("res/player/boy_right_1.png"));
            right2 = ImageIO.read(new File("res/player/boy_right_2.png"));
            updish1 = ImageIO.read(new File("res/player/updish1.png"));
            updish2 = ImageIO.read(new File("res/player/updish2.png"));
            downdish1 = ImageIO.read(new File("res/player/downdish1.png"));
            downdish2 = ImageIO.read(new File("res/player/downdish2.png"));
            leftdish1 = ImageIO.read(new File("res/player/leftdish1.png"));
            leftdish2 = ImageIO.read(new File("res/player/leftdish2.png"));
            rightdish1 = ImageIO.read(new File("res/player/rightdish1.png"));
            rightdish2 = ImageIO.read(new File("res/player/rightdish2.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //change posiition
    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true || keyH.pickUpPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){
                direction = "down";
            }
            else if(keyH.leftPressed == true){
                direction = "left";
            }
            else if(keyH.rightPressed == true){
                direction = "right";
            }
            
            //check tiles collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //check obj collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
           
            //check customer collision
            int custIndex = gp.cChecker.checkEntity(this, gp.cust);
            
            
            //no collision = can move
            if(collisionOn == false && keyH.pickUpPressed == false){
                switch(direction){
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }
            //set time to change
            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            sl.Counter();
            
        }
    }
    
    public void pickUpObject(int i) {
   

        if(keyH.pickUpPressed == true){
            if(i == 0 || i == 35){
                String objectName = gp.obj[i].name; 
                
                switch(objectName){
                    case("Shop"):
                      
                        gp.obj[19] = new ShopnoNoodle();
                        gp.obj[19].x = 7 * gp.tileSize + 23;
                        gp.obj[19].y = 0;

                        hasKey += 1;
                        gp.obj[i] = null;
                        System.out.println("key : "+ hasKey);
                        
                        
                }       
            }
            
            else if(i == 31){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){

                            gp.obj[6] = new TablewithDish();
                            gp.obj[6].x = 5 * gp.tileSize + 13;
                            gp.obj[6].y = 3 * gp.tileSize + 14;
                            
                            gp.obj[11] = new topTablewithDish();
                            gp.obj[11].x = 5 * gp.tileSize + 13;
                            gp.obj[11].y = 3 * gp.tileSize + 14;
                            
                            gp.obj[i - 10].width = 0;
                            gp.obj[i - 10].height = 0;
                            
                            gp.obj[i].width = 0;
                            gp.obj[i].height = 0;
                            
                            hasKey--;
                            
                            System.out.println("key : "+ hasKey);
                    
                        }       
                        
                } 
            }
            
            else if(i == 32){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            gp.obj[7] = new TablewithDish();
                            gp.obj[7].x = 11 * gp.tileSize - 14;
                            gp.obj[7].y = 3 * gp.tileSize + 14;
                            
                            gp.obj[12] = new topTablewithDish();
                            gp.obj[12].x = 11 * gp.tileSize - 14;
                            gp.obj[12].y = 3 * gp.tileSize + 14;
                            
                            gp.obj[i - 10].width = 0;
                            gp.obj[i - 10].height = 0;
                            
                            gp.obj[i].width = 0;
                            gp.obj[i].height = 0;
                            hasKey-- ;
                            System.out.println("key : "+ hasKey);
                           
                        }
                } 
            }  
            else if(i == 33){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            gp.obj[8] = new TablewithDish();
                            gp.obj[8].x = 5 * gp.tileSize + 13;
                            gp.obj[8].y = 7 * gp.tileSize + 7;
                            
                            gp.obj[13] = new topTablewithDish();
                            gp.obj[13].x = 5 * gp.tileSize + 13;
                            gp.obj[13].y = 7 * gp.tileSize + 7;
                            
                            gp.obj[i - 10].width = 0;
                            gp.obj[i - 10].height = 0;
                            
                            gp.obj[i].width = 0;
                            gp.obj[i].height = 0;
                            hasKey-- ;
                            System.out.println("key : "+ hasKey);
                             
                        }
                } 
            }
            
            else if(i == 34){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            gp.obj[9] = new TablewithDish();
                            gp.obj[9].x = 11 * gp.tileSize - 14;
                            gp.obj[9].y = 7 * gp.tileSize + 7;
                            
                            gp.obj[14] = new topTablewithDish();
                            gp.obj[14].x = 11 * gp.tileSize - 14;
                            gp.obj[14].y = 7 * gp.tileSize + 7;
                            
                            gp.obj[i - 10].width = 0;
                            gp.obj[i - 10].height = 0;
                            
                            gp.obj[i].width = 0;
                            gp.obj[i].height = 0;
                            hasKey-- ;
                            System.out.println("key : "+ hasKey);
           
                        }
                } 
            }
        }
    }
    
    //make walking animetion
  public void draw(Graphics2D g2){        
        BufferedImage image = null;
        if(hasKey == 0){
            switch(direction){
                case "up":
                    if(spriteNum == 1){
                        image = up1;
                    }
                    if(spriteNum == 2){
                        image = up2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2){
                        image = right2;
                    }
                    break;
            }
        }
        else if(hasKey >= 1){
            switch(direction){
                case "up":
                    if(spriteNum == 1){
                        image = updish1;
                    }
                    if(spriteNum == 2){
                        image = updish2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1){
                        image = downdish1;
                    }
                    if(spriteNum == 2){
                        image = downdish2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1){
                        image = leftdish1;
                    }
                    if(spriteNum == 2){
                        image = leftdish2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1){
                        image = rightdish1;
                    }
                    if(spriteNum == 2){
                        image = rightdish2;
                    }
                    break;
            }
            
        }
        //g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        g2.drawImage(image, x, y, 69, 69, null);
                    
        
        if(keyH.counter > sl.randomNumber){
                        gp.obj[35] = new Shop();
                        gp.obj[35].x = 7 * gp.tileSize + 23;
                        gp.obj[35].y = 0;
                        
                        keyH.counter = 0;
                        }
        
    }
}
