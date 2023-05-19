
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.GamePanel;
import main.KeyHandler;
import Timer.tableACooldown;
import Timer.tableBCooldown;
import Timer.tableCCooldown;
import Timer.tableDCooldown;
import javax.imageio.ImageIO;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public int hasKey = 0;
    int hasMob = 0;
    int tableAPhase, tableBPhase, tableCPhase, tableDPhase;
    boolean tableA, tableB, tableC, tableD, ordered, cancelMoodA, cancelMoodB, cancelMoodC, cancelMoodD;
    int justOnetimeFx = 0;
    public int point = 0;
    // serve = 
    
// eating 
    tableACooldown cooldownA = new tableACooldown(15000);
    tableBCooldown cooldownB = new tableBCooldown(15000); 
    tableCCooldown cooldownC = new tableCCooldown(15000); 
    tableDCooldown cooldownD = new tableDCooldown(15000);


    public Player(GamePanel gp, KeyHandler keyH){
        
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        
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

    //stat and position
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
       // check if customer A is full
            if(tableA == true){
                if(cooldownA.finishedA == true){
                    try {
                        gp.obj[1].image = ImageIO.read(new File("res/objects/fullCustomer.png"));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    tableAPhase = 3;
                    tableA = false;
                    cooldownA.finishedA = false;
                    
                }  
            }
        // check if customer B is full
            if(tableB == true){
                if(cooldownB.finishedB == true){
                    try {
                        gp.obj[2].image = ImageIO.read(new File("res/objects/fullCustomer.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    tableBPhase = 3;
                    tableB = false;
                    cooldownB.finishedB = false;   
                }
            }
        // check if customer C is full
            if(tableC == true){
                if(cooldownC.finishedC == true){
                    
                    try {
                        gp.obj[3].image = ImageIO.read(new File("res/objects/fullCustomer.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    tableC = false;
                    cooldownC.finishedC = false;
                    tableCPhase = 3;
                }  
            }
        // check if customer D is full
            if(tableD == true){
                if(cooldownD.finishedD == true){
                    try {
                        gp.obj[4].image = ImageIO.read(new File("res/objects/fullCustomer.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    tableD = false;
                    cooldownD.finishedD = false;  
                    tableDPhase = 3;
                }    
            }
        
        // move
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
        }
    }
  
////////////////////////////////////////////////////////////////////////////////    
    public void pickUpObject(int i) {
        if(keyH.pickUpPressed == true){
        // ringbell    
            if(i == 5){
                String objectName = gp.obj[i].name; 
  
                switch(objectName){
                    case("Key"): 
                        try {
                            ordered = true;
                            gp.obj[0].image = ImageIO.read(new File("res/objects/shopwnoodle.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    // play sound only 1 time 
                        if(justOnetimeFx == 0){
                            gp.playSoundFX(1);
                            justOnetimeFx = 1;
                        }else if (justOnetimeFx == 1){
                           // do nothing
                        }
                }       
            }
        // clean  
            if(i == 6){
                String objectName = gp.obj[i].name; 
                
                switch(objectName){
                    case("Clean"):
                        hasMob = 1;   
                        gp.ui.showMessage("You got a mop!");
                        gp.ui.x = gp.tileSize/2;
                        gp.ui.y = gp.tileSize * 5;
                }    
            }
            
        // shop
            if(i == 0 && ordered == true){
                String objectName = gp.obj[i].name; 
                
                switch(objectName){
                    case("Shop"):
                        try {
                            gp.obj[0].image = ImageIO.read(new File("res/objects/shop.png"));
           
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        hasKey = 1;                       
                        ordered = false;
                        justOnetimeFx = 0;    
                        gp.ui.showMessage("You got a noddle!");
                        gp.ui.x = gp.tileSize/2;
                        gp.ui.y = gp.tileSize * 5;
                }
            }
        
        // table A
            else if(i == 1 && tableAPhase == 1){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                    if(hasKey > 0 ){
                        try {
                            gp.obj[1].image = ImageIO.read(new File("res/objects/eat.png"));
           
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                            hasKey--;
                            tableAPhase = 2;
                            cooldownA.startCooldown();
                            tableA = true;
                            cancelMoodA = true;  
                            gp.playSoundFX(3);
                            point += 100;
                            gp.ui.showMessage("+ 100");
                            gp.ui.x = 300;
                            gp.ui.y = 240;
                            System.out.println("point: " + point);
                    }              
                } 
            }
        // table B
            else if(i == 2  && tableBPhase == 1){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            try {
                                gp.obj[2].image = ImageIO.read(new File("res/objects/eat.png"));
                            } catch (IOException ex) {
                                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            hasKey-- ;
                            tableBPhase = 2;
                            cooldownB.startCooldown();
                            tableB = true;
                            cancelMoodB = true;  
                            gp.playSoundFX(3);
                            point += 100;
                            gp.ui.showMessage("+ 100");
                            gp.ui.x = 550;
                            gp.ui.y = 240;
                            System.out.println("point: " + point);
                        }
                } 
            }  
        //table c    
            else if(i == 3 && tableCPhase == 1){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            
                            try {
                                gp.obj[3].image = ImageIO.read(new File("res/objects/eat.png"));
                            } catch (IOException ex) {
                                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                            }       
                            
                            hasKey-- ;
                            gp.playSoundFX(3);
                            tableCPhase = 2;
                            cooldownC.startCooldown();
                            tableC = true;
                            cancelMoodC = true;
                            point += 100;
                            gp.ui.showMessage("+ 100");
                            gp.ui.x = 300;
                            gp.ui.y = 430;
                            System.out.println("point: " + point);
                        }
                } 
            }
        // table D
            else if(i == 4 && tableDPhase == 1){
                String objectName = gp.obj[i].name;
            
                switch(objectName){
                    case("Table"):
                        if(hasKey > 0){
                            
                            try {
                                gp.obj[4].image = ImageIO.read(new File("res/objects/eat.png"));
                            } catch (IOException ex) {
                                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            hasKey-- ;
                            gp.playSoundFX(3);
                            tableDPhase = 2;
                            cooldownD.startCooldown();
                            tableD = true;
                            cancelMoodD = true;
                            point += 100;
                            gp.ui.showMessage("+ 100");
                            gp.ui.x = 550;
                            gp.ui.y = 430;
                            System.out.println("point: " + point);
                        }
                } 
            }
            
        // table A after full
            else if (i == 1 && tableAPhase == 3 && hasMob == 1){
                try {
                    gp.obj[1].image = ImageIO.read(new File("res/objects/table1.png"));
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.obj[1].empty = true;
                    tableAPhase = 0;
                    hasMob = 0;
                    gp.player.cancelMoodA = false;
                    point += 500;
                    gp.ui.showMessage("+ 500");
                    System.out.println("point:" + point);
                    gp.ui.x = 300;
                    gp.ui.y = 240;
                    
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        // table B after full    
            else if (i == 2 && tableBPhase == 3 && hasMob == 1){
                try {
                    gp.obj[2].image = ImageIO.read(new File("res/objects/table1.png"));
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.obj[2].empty = true;
                    tableBPhase = 0;
                    hasMob = 0;
                    gp.player.cancelMoodB = false;
                    gp.playSoundFX(2);
                    point += 500;
                    gp.ui.showMessage("+ 500");
                    gp.ui.x = 550;
                    gp.ui.y = 240;
                    System.out.println("point: " + point); 
                    
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        // table C after full    
            else if (i == 3 && tableCPhase == 3 && hasMob == 1){
                try {
                    gp.obj[3].image = ImageIO.read(new File("res/objects/table1.png"));
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.obj[3].empty = true;
                    tableCPhase = 0;
                    hasMob = 0;
                    gp.player.cancelMoodC = false;
                    gp.playSoundFX(2);
                    point += 500;
                    gp.ui.showMessage("+ 500");
                    gp.ui.x = 300;
                    gp.ui.y = 430;
                    System.out.println("point: " + point);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        // table D after full    
            else if (i == 4 && tableDPhase == 3 && hasMob == 1){
                try {
                    gp.obj[4].image = ImageIO.read(new File("res/objects/table1.png"));
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.obj[4].empty = true;
                    tableDPhase = 0;
                    hasMob = 0;
                    gp.player.cancelMoodD = false;
                    gp.playSoundFX(2);
                    point += 500;
                    gp.ui.showMessage("+ 500");
                    gp.ui.x = 550;
                    gp.ui.y = 430;
                    System.out.println("point: " + point);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

  //make walking animation
    public void draw(Graphics2D g2){        
        BufferedImage image = null;
    // no noodles  
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
        // have noodles
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
        g2.drawImage(image, x, y, 69, 69, null);
   
    }
}
