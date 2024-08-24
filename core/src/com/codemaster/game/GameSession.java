package com.codemaster.game;

import com.badlogic.gdx.utils.TimeUtils;
import com.codemaster.game.managers.MemoryManager;

public class GameSession {
    long sessionStartTime;
    long nextGiveMoneyTime;

    public void startGame(){

        sessionStartTime = TimeUtils.millis();
        nextGiveMoneyTime = sessionStartTime + (long) (MemoryManager.loadMSeconds() * getGivePeriodCoolDown());
    }
    public boolean shouldGiveMoney(){

        if (nextGiveMoneyTime <= TimeUtils.millis()){
            nextGiveMoneyTime = TimeUtils.millis() + (long) (MemoryManager.loadMSeconds() * getGivePeriodCoolDown());
            return true;
        }
        return false;
    }
    private float getGivePeriodCoolDown(){
        return (float) Math.exp(-0.001 * (TimeUtils.millis() - sessionStartTime + 1) / 1000);
    }
}
