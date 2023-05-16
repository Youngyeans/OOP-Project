/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Random;


/**
 *
 * @author youngyeans
 */
public class SleepSetter {
    
    public int randomNumber;
    
    
    public void Counter(){
        int min = 150;
        int max = 250;
        Random random = new Random();
        randomNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Random number between " + min + " and " + max + ": " + randomNumber);
    }
}

    
    

