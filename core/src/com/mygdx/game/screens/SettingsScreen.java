package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;

import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
import com.mygdx.game.view.TextView;

public class SettingsScreen extends ScreenAdapter {
    MyGdxGame myGdxGame;
    TextView titleTextView;
    ButtonView returnButton;
    ButtonView resetButton;
    TextView musicSettingView;
    TextView soundSettingView;
    TextView clearSettingView1;
    TextView clearSettingView2;
    TextView goldbanner;
    TextView waterMark;
    private boolean isOld;

    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        titleTextView = new TextView(myGdxGame.fontBlackBig, 160, 1050, "Settings");
        clearSettingView1 = new TextView(myGdxGame.fontWhite, 270, 550, "reset");
        clearSettingView2 = new TextView(myGdxGame.fontWhite, 210, 500, "progress");
        waterMark = new TextView(myGdxGame.waterMark,0,0,"kyber alliance");

        musicSettingView = new TextView(
                myGdxGame.fontBlack,
                120, 867,
                "music: " + translateStateToText(MemoryManager.loadIsMusicOn())
        );

        soundSettingView = new TextView(
                myGdxGame.fontBlack,
                120, 808,
                "sound: " + translateStateToText(MemoryManager.loadIsSoundOn())
        );


        returnButton = new ButtonView(-10, 1350, 200, 220);

        resetButton = new ButtonView(120, 390, 467, 280);

        goldbanner = new TextView(
                myGdxGame.fontBlackBtw,
                120, 745,
                "gold banner: " + translateStateToText(MemoryManager.loadGoldBanner()));
    }
    @Override
    public void show(){
        myGdxGame.resetProgress.setPosition(120, 390);
        myGdxGame.resetProgress.setSize(467, 280);

        myGdxGame.backButton.setPosition(-10, 1350);
        myGdxGame.backButton.setSize(200, 220);

        myGdxGame.settingsBackground.setPosition(-180, -50);
        myGdxGame.settingsBackground.setSize(1100,1600);
    }

    @Override
    public void render(float delta) {

        isOld = MemoryManager.loadIsOld();
        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        myGdxGame.backGround.draw(myGdxGame.batch);
        myGdxGame.settingsBackground.draw(myGdxGame.batch);
        titleTextView.draw(myGdxGame.batch);
        myGdxGame.backButton.draw(myGdxGame.batch);
        myGdxGame.resetProgress.draw(myGdxGame.batch);
        musicSettingView.draw(myGdxGame.batch);
        soundSettingView.draw(myGdxGame.batch);

        clearSettingView1.draw(myGdxGame.batch);
        clearSettingView2.draw(myGdxGame.batch);
        if(MemoryManager.loadPlayerLevel() >= 10 || isOld){
            goldbanner.draw(myGdxGame.batch);
            MemoryManager.saveIsOld(true);
            isOld = MemoryManager.loadIsOld();
        }
        waterMark.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (returnButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }
            if (resetButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {

                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                if(MemoryManager.loadPlayerLevel() >= 10){
                    MemoryManager.saveIsOld(true);
                }
                MemoryManager.saveScore(0);
                MemoryManager.savePlayerLevel(1);
                MemoryManager.saveCoins(0);
                MemoryManager.savePerClick(1);
                MemoryManager.saveMonitorLevel(1);
                MemoryManager.saveKeyboardLevel(1);
                MemoryManager.saveComputerLevel(1);
                MemoryManager.savePerSecond(5);

            }
            if (musicSettingView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                MemoryManager.saveMusicSettings(!MemoryManager.loadIsMusicOn());
                musicSettingView.setText("music: " + translateStateToText(MemoryManager.loadIsMusicOn()));
                myGdxGame.audioManager.updateMusicFlag();
            }
            if (soundSettingView.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                MemoryManager.saveSoundSettings(!MemoryManager.loadIsSoundOn());
                soundSettingView.setText("sound: " + translateStateToText(MemoryManager.loadIsSoundOn()));
                myGdxGame.audioManager.updateSoundFlag();
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
            }
            if (goldbanner.isHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                MemoryManager.saveGoldBanner(!MemoryManager.loadGoldBanner());
                goldbanner.setText("gold banner: "+ translateStateToText(MemoryManager.loadGoldBanner()));
            }
        }
    }

    private String translateStateToText(boolean state) {
        return state ? "ON" : "OFF";
    }

    @Override
    public void dispose() {
        waterMark.dispose();
        titleTextView.dispose();
        returnButton.dispose();
        resetButton.dispose();
        musicSettingView.dispose();
        soundSettingView.dispose();

        clearSettingView1.dispose();
        clearSettingView2.dispose();
    }
}


