
package main;

import entity.Customer;
import object.OBJ_Clean;
import object.OBJ_Key;
import object.Table;
import object.ShopnoNoodle;

// set pos for object
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        //shop
        gp.obj[0] = new ShopnoNoodle();
        gp.obj[0].x = 7 * gp.tileSize + 23;
        gp.obj[0].y = 0;
        
        //table A
        gp.obj[1] = new Table();
        gp.obj[1].x = 5 * gp.tileSize + 13;
        gp.obj[1].y = 3 * gp.tileSize + 14;
        gp.obj[1].empty = true;

        //table B
        gp.obj[2] = new Table();
        gp.obj[2].x = 11 * gp.tileSize - 14;
        gp.obj[2].y = 3 * gp.tileSize + 14;
        gp.obj[2].empty = true;
        
        //table C
        gp.obj[3] = new Table();
        gp.obj[3].x = 5 * gp.tileSize + 13;
        gp.obj[3].y = 7 * gp.tileSize + 7;
        gp.obj[3].empty = true;
        
        //tabel D
        gp.obj[4] = new Table();
        gp.obj[4].x = 11 * gp.tileSize - 14;
        gp.obj[4].y = 7 * gp.tileSize + 7;
        gp.obj[4].empty = true;
        
        //noodle
        gp.obj[5] = new OBJ_Key();
        gp.obj[5].x = 14 * gp.tileSize;
        gp.obj[5].y = 1 * gp.tileSize + 20;
      
        //clean
        gp.obj[6] = new OBJ_Clean();
        gp.obj[6].x = 12 * gp.tileSize;
        gp.obj[6].y = 1 * gp.tileSize + 17;
    }

// customer
    public void setCustomer(){
        
        gp.cust.add(0,new Customer(gp));
        gp.cust.add(1,new Customer(gp));
        gp.cust.add(2,new Customer(gp));
        gp.cust.add(3,new Customer(gp));

        gp.cust.get(0).x = gp.tileSize * 2 - 8;
        gp.cust.get(0).y = 0;
        gp.cust.get(0).hasTable = false;
        
        gp.cust.get(1).x = gp.tileSize * 2 - 8;
        gp.cust.get(1).y = 0;
        gp.cust.get(1).hasTable = false;
        
        gp.cust.get(2).x = gp.tileSize * 2 - 8;
        gp.cust.get(2).y = 0;
        gp.cust.get(2).hasTable = false;
        
        gp.cust.get(3).x = gp.tileSize * 2 - 8;
        gp.cust.get(3).y = 0;
        gp.cust.get(3).hasTable = false;
    }
    
}
