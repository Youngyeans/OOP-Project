
package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class CustomerCCooldown {
    private Timer timer;
    private long cooldownDuration;
    public boolean finishedcustC = false;

// set timer
    public CustomerCCooldown(long cooldownDuration) {
        this.cooldownDuration = cooldownDuration;
        this.timer = new Timer();
        
    }

// start cooldown
    public void startCooldown() {
        timer.schedule(new CooldownTask(), cooldownDuration);
        
    }
    
//cancel cooldown
    public void cancelCooldown() {
        timer.cancel();
        
    }

// aftercooldown
    private class CooldownTask extends TimerTask {
        @Override
        public void run() {
            finishedcustC = true;

        }
    }
}
