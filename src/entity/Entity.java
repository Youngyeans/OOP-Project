
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import Timer.CustomerACooldown;
import Timer.CustomerBCooldown;
import Timer.CustomerCCooldown;
import Timer.CustomerDCooldown;
import main.GamePanel;


//store variables that be used in Player , Customer Class
public class Entity {
    GamePanel gp;
    public int x, y;
    public int speed;
    public int moodA, moodB, moodC, moodD;
    
//mood cooldown
    CustomerACooldown custACooldown = new CustomerACooldown(5000);
    CustomerBCooldown custBCooldown = new CustomerBCooldown(5000); 
    CustomerCCooldown custCCooldown = new CustomerCCooldown(5000); 
    CustomerDCooldown custDCooldown = new CustomerDCooldown(5000); 
   
//image
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, walk1, walk2, walk3, walk4;
    public BufferedImage updish1, updish2, downdish1, downdish2, leftdish1, leftdish2, rightdish1, rightdish2;
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
    public int width, height;
    public boolean hasTable;
    String table;
    
//from gamepanel
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    
////////////////////////////////////////////////////////////////////////////////
    public void update(){
    
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);
    
    // choose table to sit on 
        if(table == null){
            if(gp.obj[1].empty == true && hasTable == false){
                table = "A";
            }
            else if(gp.obj[2].empty == true && hasTable == false){
                table = "B";   
            }
            else if(gp.obj[3].empty == true && hasTable == false){
                table = "C";      
            }
            else if(gp.obj[4].empty == true && hasTable == false){
                table = "D";
            }
        }
        
        else{
        // start to walk  
            switch(table){
                case("A"):if(collisionOn == false && gp.obj[1].empty == true && hasTable == false){
                // walk path
                    if(y == 0){
                        gp.playSoundFX(2);                    
                    }
                    if(y != 190 && y != 210){
                        y += speed;
                        spriteCounter++;   
                    }
                    else if(x != 128){
                        if(direction != "to"){
                            direction = "to";
                            y += 20;     
                        }
                        x += speed;
                        spriteCounter++;   
                    }
                    else{
                    // customer A has table
                        direction = "";
                        solidArea.height = 0;
                        solidArea.width = 0;
                        hasTable = true;
                        
                    //table A with Customer
                        try {
                            gp.obj[1].image = ImageIO.read(new File("res/objects/TablewithCust.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    //after has customer   
                        custACooldown.startCooldown();
                        gp.obj[1].empty = false;
                        gp.player.tableAPhase = 1;
                    }
                }
                break;
                
                case("B"):if(collisionOn == false && gp.obj[2].empty == true && hasTable == false ){
                // walk path
                    if(y == 0){
                        gp.playSoundFX(2);
                    }
                    if(y != 110 && y!= 130){
                        y += speed;
                        spriteCounter++;
                    }
                    else if(x != 403){
                        if(direction != "to"){
                            direction = "to";
                            y += 20;
                        }
                        x += speed;
                        spriteCounter++;
                    }
                    else{
                    // customer B has table
                        direction = "";
                        solidArea.height = 0;
                        solidArea.width = 0;
                        hasTable = true;
                        
                    // table B with Customer
                        try {
                            gp.obj[2].image = ImageIO.read(new File("res/objects/TablewithCust.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    // after has customer    
                        custBCooldown.startCooldown();
                        gp.obj[2].empty = false;
                        gp.player.tableBPhase = 1;
                    }
                }
                break;
                
                case("C"):if(collisionOn == false && gp.obj[3].empty == true && hasTable == false){
                // walk path
                    if(y == 0){
                        gp.playSoundFX(2);
                    }
                    if(y != 400 && y != 420){
                        y += speed;
                        spriteCounter++;
                    }
                    else if(x != 123){
                        if(direction != "to"){
                            direction = "to";
                            y += 20;
                        }
                        x += speed;
                        spriteCounter++;
                    }
                    else{
                    // cutomer c has table
                        direction = "";
                        solidArea.height = 0;
                        solidArea.width = 0;
                        hasTable = true;
                        
                    // table c with customer    
                        try {
                            gp.obj[3].image = ImageIO.read(new File("res/objects/TablewithCust.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    // after has customer   
                        custCCooldown.startCooldown();
                        gp.obj[3].empty = false;
                        gp.player.tableCPhase = 1;
                    }
                }
                break;
                
                case("D"): if(collisionOn == false && gp.obj[4].empty == true && hasTable == false){
                // walk path
                    if(y == 0){
                        gp.playSoundFX(2);
                    }
                    if(y != 300 && y != 320){
                        y += speed;
                        spriteCounter++;
                    }
                    else if(x != 403){
                        if(direction != "to"){
                            direction = "to";
                            y += 20;
                        }
                        x += speed;
                        spriteCounter++;
                    }
                    else{
                    // customer d has table
                        direction = "";
                        solidArea.height = 0;
                        solidArea.width = 0;
                        hasTable = true;

                        try {
                            gp.obj[4].image = ImageIO.read(new File("res/objects/TablewithCust.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    // after has customer
                        custDCooldown.startCooldown();
                        gp.obj[4].empty = false;
                        gp.player.tableDPhase = 1;
                    }
                }
                break;
                
            }    
        }
        
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
        
        // table a mood 
            if(gp.player.cancelMoodA == true){ //cancel cooldown when served
                custACooldown.cancelCooldown();
            }
            else{
            // after sit
                if(custACooldown.finishedcustA == true && moodA == 0){
                    try {
                        gp.obj[1].image = ImageIO.read(new File("res/objects/mood2.png"));
                        moodA = 2;
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    custACooldown.finishedcustA = false;
                    custACooldown.startCooldown();
                }
            // into mood 2 (YELLOW)
                if(custACooldown.finishedcustA == true && moodA == 2){
                    try {
                        gp.obj[1].image = ImageIO.read(new File("res/objects/mood3.png"));
                        moodA = 3;
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    custACooldown.finishedcustA = false;
                    custACooldown.startCooldown();
                    gp.playSoundFX(4);            
                }
            // into mood 3 (RED)
                if(custACooldown.finishedcustA == true && moodA == 3){
                    try {
                        gp.obj[1].image = ImageIO.read(new File("res/objects/table1.png"));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                // new customer walk in
                    custACooldown.finishedcustA = false;
                    gp.obj[1].empty = true;
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.player.tableAPhase = 0;
                    gp.playSoundFX(2);
                    gp.player.point -= 50;
                    gp.ui.showMessage("- 50");
                    gp.ui.x = 300;
                    gp.ui.y = 240;
                    System.out.println("point: " + gp.player.point);
                }
            }
            
            //table b mood
            if(gp.player.cancelMoodB == true){ //cancel cooldown when served
                custBCooldown.cancelCooldown();
            }
            else{
            // after sit
                if(custBCooldown.finishedcustB == true && moodB == 0){
                    try {
                        gp.obj[2].image = ImageIO.read(new File("res/objects/mood2.png"));
                        moodB = 2;
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                    custBCooldown.finishedcustB = false;
                    custBCooldown.startCooldown();
                }
            // into mood 2 (YELLOW)
                if(custBCooldown.finishedcustB == true && moodB == 2){
                    try {
                        gp.obj[2].image = ImageIO.read(new File("res/objects/mood3.png"));
                        moodB = 3;
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    custBCooldown.finishedcustB = false;
                    custBCooldown.startCooldown();
                    gp.playSoundFX(4);
                }
            // into mood 3 (RED)
                if(custBCooldown.finishedcustB == true && moodB == 3){
                    try {
                        gp.obj[2].image = ImageIO.read(new File("res/objects/table1.png"));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }                
                // new customer walk in   
                    custBCooldown.finishedcustB = false;
                    gp.obj[2].empty = true;
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.player.tableBPhase = 0;
                    gp.playSoundFX(2);
                    gp.player.point -= 50;
                    gp.ui.showMessage("- 50");
                    gp.ui.x = 550;
                    gp.ui.y = 240;
                    System.out.println("point: " + gp.player.point);
                }
            }
            
        //table C mood
            if(gp.player.cancelMoodC == true){ //cancel cooldown when served
                custCCooldown.cancelCooldown();              
            }
            else{
            // after sit
                if(custCCooldown.finishedcustC == true && moodC == 0){ 
                    try {
                        gp.obj[3].image = ImageIO.read(new File("res/objects/mood2.png"));
                        moodC = 2;
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    custCCooldown.finishedcustC = false;
                    custCCooldown.startCooldown();
                }
            // into mood 2 (YELLOW)
                if(custCCooldown.finishedcustC == true && moodC == 2){
                    try {
                        gp.obj[3].image = ImageIO.read(new File("res/objects/mood3.png"));
                        moodC = 3;
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    gp.playSoundFX(4);
                    custCCooldown.finishedcustC = false;
                    custCCooldown.startCooldown();
                
                }
            // into mood 3 (RED)
                if(custCCooldown.finishedcustC == true && moodC == 3){
                    try {
                        gp.obj[3].image = ImageIO.read(new File("res/objects/table1.png"));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                // new customer walk in
                    custCCooldown.finishedcustC = false;
                    gp.obj[3].empty = true;
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.player.tableCPhase = 0;
                    gp.playSoundFX(2);
                    gp.player.point -= 50;
                    gp.ui.showMessage("- 50");
                    gp.ui.x = 300;
                    gp.ui.y = 430;
                    System.out.println("point: " + gp.player.point);
                }
            }
             
        // table D mood
            if(gp.player.cancelMoodD == true){ //cancel cooldown when served
                custDCooldown.cancelCooldown(); 
            }
            else{
            // after sit
                if(custDCooldown.finishedcustD == true && moodD == 0){
                    try {
                        gp.obj[4].image = ImageIO.read(new File("res/objects/mood2.png"));
                        moodD = 2;                      
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    custDCooldown.finishedcustD = false;
                    custDCooldown.startCooldown();
                }
            // into mood 2 (YELLOW)
                if(custDCooldown.finishedcustD == true && moodD == 2){
                    try {
                        gp.obj[4].image = ImageIO.read(new File("res/objects/mood3.png"));
                        moodD = 3; 
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    gp.playSoundFX(4);
                    custDCooldown.finishedcustD = false;
                    custDCooldown.startCooldown();             
                }
            // into mood 3 (RED)
                if(custDCooldown.finishedcustD == true && moodD == 3){
                    try {
                        gp.obj[4].image = ImageIO.read(new File("res/objects/table1.png"));
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                // new customer walk in   
                    custDCooldown.finishedcustD = false;
                    gp.obj[4].empty = true;
                    int pos = gp.cust.size();
                    gp.cust.add(new Customer(gp));
                    gp.cust.get(pos).x = gp.tileSize * 2 - 8;
                    gp.cust.get(pos).y = 0;
                    gp.cust.get(pos).hasTable = false;
                    gp.player.tableDPhase = 0;
                    gp.playSoundFX(2);
                    gp.player.point -= 50;
                    gp.ui.showMessage("- 50");
                    gp.ui.x = 550;
                    gp.ui.y = 430;
                    System.out.println("point: " + gp.player.point);
                }
            }    
    }
    
////////////////////////////////////////////////////////////////////////////////
    public void draw(Graphics2D g2){
    
    // change image
        BufferedImage image = null;
        switch(direction){
        // walk down
            case "walk":
                if(spriteNum == 1){
                    image = walk1;
                }
                if(spriteNum == 2){
                    image = walk2;
                }
            break;
        // walk right     
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

        }
        g2.drawImage(image, x, y, width, height, null);
    }
}
