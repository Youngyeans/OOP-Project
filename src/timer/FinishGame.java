/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timer;

import java.util.Timer;
import java.util.TimerTask;
import main.GamePanel;
import main.Main;
import main.ScoreFrame;

/**
 *
 * @author FinalDIE
 */
public class FinishGame {
    private GamePanel gp;
    private Main main;
    //private Timer timer;
    private long gameTimerDuration;
    private boolean gameFinished = false;
    private long  gamestart , usingTime, remainingTime;
    private int pausecount;
    private int onlyOnetimeScoreFrame = 0;

// set Timer
    public FinishGame(long timeDuration, GamePanel gp, Main main) {
        this.gp = gp;
        this.main = main;
        this.gameTimerDuration = timeDuration;
//        this.timer = new Timer();
        //System.out.println("add timer");
        gamestart = System.currentTimeMillis();
    }

//// start cooldown
//    public void starttimer() {
//        this.timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if(!isPaused){
//                    
//                }
//            }
//        }, gameTimerDuration);
//        //System.out.println("timer start");
//    }

//// after cooldown
//    private class GameTimerTask extends TimerTask {
//        @Override
//        public void run() {
//            gameFinished = true;
//        }
//    }
    public String getRemainingTime() {
        //play after pause
        if(gp.getGameState() == gp.getPlayState() && pausecount == 1){
            gamestart = System.currentTimeMillis();
            usingTime = System.currentTimeMillis() - gamestart;  
            pausecount = 0;
            
        }
        //pause
        else if(gp.getGameState() == gp.getPauseState()){
            gameTimerDuration = remainingTime;
            usingTime = 0;
            pausecount = 1;
        }
        //playstate
        else if(gp.getGameState() == gp.getPlayState() && pausecount == 0){
            usingTime = System.currentTimeMillis() - gamestart;
        }
        remainingTime = gameTimerDuration - usingTime;

        
        
        long minutes = (remainingTime / 1000) / 60;
        long seconds = (remainingTime / 1000) % 60;
        
        if(minutes == 0 && seconds == 0){
            gp.setOnlyOnetimeSoundBG(2);
            gp.setGameState(gp.getFinishState());
            try{
                Thread.sleep(1000);
                if(onlyOnetimeScoreFrame == 0){
                    
                    new ScoreFrame(main, gp);
                    onlyOnetimeScoreFrame = 1;
                }
                else if(onlyOnetimeScoreFrame == 1){
                    //do nothing
                }
                 
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return String.format("%02d:%02d", minutes, seconds);
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public int getPausecount() {
        return pausecount;
    }

    public void setPausecount(int pausecount) {
        this.pausecount = pausecount;
    }
    
    //cancel cooldown
    public void cancelCooldown() {
        //timer.cancel();
    }

    public int getOnlyOnetimeScoreFrame() {
        return onlyOnetimeScoreFrame;
    }

    public void setOnlyOnetimeScoreFrame(int onlyOnetimeScoreFrame) {
        this.onlyOnetimeScoreFrame = onlyOnetimeScoreFrame;
    }
    
}
