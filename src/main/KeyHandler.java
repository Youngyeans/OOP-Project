package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, pickUpPressed;
    public int counter = 0;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //return integer keyCode (key event)
        int code = e.getKeyCode();
        // W Key
        if(code == KeyEvent.VK_W){
            counter++;
            upPressed = true;
        }
        // S Key
        if(code == KeyEvent.VK_S){
            counter++;
            downPressed = true;
        // A Key
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        // D Key    
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_E){
            counter += 20;
            pickUpPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
             
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_E){
            pickUpPressed = false;
        }
    }
    
}
