
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, pickUpPressed;
    public int counter = 0;
    GamePanel gp;
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //return integer keyCode (key event)
        int code = e.getKeyCode();
        // W Key
        if(code == KeyEvent.VK_UP){
            
            upPressed = true;
        }
        // S Key
        if(code == KeyEvent.VK_DOWN){
            
            downPressed = true;
        // A Key
        }
        if(code == KeyEvent.VK_LEFT){
            counter ++;
            leftPressed = true;
        // D Key    
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            pickUpPressed = true;
            
        }
        if(code == KeyEvent.VK_P){
            if(gp.gamestate == gp.playstate){
                gp.gamestate = gp.pausestate;
            }
            else if(gp.gamestate == gp.pausestate){
                gp.gamestate = gp.playstate;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
             
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            pickUpPressed = false;
        }
    }
    
}
