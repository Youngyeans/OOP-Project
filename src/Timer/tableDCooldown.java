
package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class tableDCooldown {
    private Timer timer;
    private long cooldownDuration;
    public boolean finishedD = false;

// set Timer
    public tableDCooldown(long cooldownDuration) {
        this.cooldownDuration = cooldownDuration;
        this.timer = new Timer();
    }

// start cooldown
    public void startCooldown() {
        timer.schedule(new CooldownTask(), cooldownDuration);
    }

// after cooldown
    private class CooldownTask extends TimerTask {
        @Override
        public void run() {
            finishedD = true;
           
        }
    }
}
