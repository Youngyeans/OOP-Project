
package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    File sound[] = new File[30];
    
    
    public Sound(){
        sound[0] = new File("res/sound/bg.wav");
        sound[1] = new File("res/sound/ordered.wav");
        sound[2] = new File("res/sound/hello.wav");
        sound[3] = new File("res/sound/serve.wav");
        sound[4] = new File("res/sound/angry.wav");
        sound[5] = new File("res/sound/exit.wav");
     
    }
    
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}