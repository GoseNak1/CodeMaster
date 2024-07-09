package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Json;

import java.util.ArrayList;

public class MemoryManager {
    private static final Preferences preferences = Gdx.app.getPreferences("User saves");
    public static void saveSoundSettings(boolean isOn) {
        preferences.putBoolean("isSoundOn", isOn);
        preferences.flush();
    }

    public static boolean loadIsSoundOn() {
        return preferences.getBoolean("isSoundOn", true);
    }


    public static void saveMusicSettings(boolean isOn) {
        preferences.putBoolean("isMusicOn", isOn);
        preferences.flush();
    }

    public static boolean loadIsMusicOn() {
        return preferences.getBoolean("isMusicOn", true);
    }


    public static void saveScore(int score){

        preferences.putInteger("score", score);
        preferences.flush();
    }
    public static int loadScore(){
        return preferences.getInteger("score");
    }


    public static void savePlayerLevel(int level){
        preferences.putInteger("level",level);
        preferences.flush();
    }
    public static int loadPlayerLevel(){
        return preferences.getInteger("level");
    }



    public static void saveCoins(int coins){
        preferences.putInteger("coins", coins);
        preferences.flush();
    }
    public static int loadCoins(){
        return preferences.getInteger("coins");
    }


    public static void savePerClick(int perClick){
        preferences.putInteger("perClick",perClick);
        preferences.flush();
    }
    public static int loadPerClick(){
        return preferences.getInteger("perClick");
    }

    public static void saveMonitorLevel(int level){
        preferences.putInteger("MLevel",level);
        preferences.flush();
    }
    public static int loadMonitorLevel(){
        return preferences.getInteger("MLevel");
    }
    public static void saveKeyboardLevel(int level){
        preferences.putInteger("KLevel",level);
        preferences.flush();
    }
    public static int loadKeyboardLevel(){
        return preferences.getInteger("KLevel");
    }

    public static void saveComputerLevel(int level){
        preferences.putInteger("CLevel",level);
        preferences.flush();
    }
    public static int loadComputerLevel(){
        return preferences.getInteger("CLevel");
    }

    public static void saveMSeconds(int mSeconds){
        preferences.putInteger("MSeconds", mSeconds);
        preferences.flush();
    }
    public static int loadMSeconds(){
        return preferences.getInteger("MSeconds");
    }
    public static void savePerSecond(int perSecond){
        preferences.putInteger("PerSecond", perSecond);
        preferences.flush();
    }
    public static int loadPerSecond(){
        return preferences.getInteger("PerSecond");
    }

    public static void saveGoldBanner(boolean is){
        preferences.putBoolean("GoldBanner", is);
        preferences.flush();
    }
    public static boolean loadGoldBanner(){
        return preferences.getBoolean("GoldBanner", false);
    }
    public static void saveIsOld(boolean isOld){
        preferences.putBoolean("Old", isOld);
        preferences.flush();
    }
    public static boolean loadIsOld(){
        return preferences.getBoolean("Old", false);
    }
}
