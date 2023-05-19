/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Timer;

import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.plugins.tiff.ExifGPSTagSet;
import main.GamePanel;

/**
 *
 * @author FinalDIE
 */
public class FinishGame {
    private Timer timer;
    private long gameTimerDuration;
    public boolean gameFinished = false;
    long  gamestart , usingTime, remainingTime;
    GamePanel gp;
    int pausecount;

// set Timer
    public FinishGame(long timeDuration, GamePanel gp) {
        this.gp = gp;
        this.gameTimerDuration = timeDuration;
        this.timer = new Timer();
        System.out.println("add timer");
        gamestart = System.currentTimeMillis();
    }

// start cooldown
    public void starttimer() {
        timer.schedule(new GameTimerTask(), gameTimerDuration);
        System.out.println("timer start");
    }

// after cooldown
    private class GameTimerTask extends TimerTask {
        @Override
        public void run() {
            gameFinished = true;
           
        }
    }
    public String getRemainingTime() {
        if(gp.gamestate == gp.playstate && pausecount == 1){
            gamestart = System.currentTimeMillis();
            usingTime = System.currentTimeMillis() - gamestart;
            pausecount = 0;
        }
        //pause
        else if(gp.gamestate == gp.pausestate){
            gameTimerDuration = remainingTime;
            usingTime = 0;
            pausecount = 1;
        }
        else if(gp.gamestate == gp.playstate && pausecount == 0){
            usingTime = System.currentTimeMillis() - gamestart;
        }
        remainingTime = gameTimerDuration - usingTime;
        System.out.println( gameTimerDuration + " - " + usingTime + " = " + remainingTime);

        long minutes = (remainingTime / 1000) / 60;
        long seconds = (remainingTime / 1000) % 60;
        if(gp.gamestate == gp.finishstate){
            minutes = 00;
            seconds = 00;
        }
        return String.format("%02d:%02d", minutes, seconds);
    }
}
