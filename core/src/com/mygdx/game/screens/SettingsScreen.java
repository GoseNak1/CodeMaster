package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;

import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.view.BackgroundView;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
import com.mygdx.game.view.TextView;

public class SettingsScreen extends ScreenAdapter {
    MyGdxGame myGdxGame;

    BackgroundView backgroundView;
    TextView titleTextView;
    ImageView boxImageView;
    ButtonView returnButton;
    ButtonView resetButton;
    TextView musicSettingView;
    TextView soundSettingView;
    TextView clearSettingView1;
    TextView clearSettingView2;
    TextView languageView;
    TextView goldbanner;
    private boolean isOld;

    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;




        backgroundView = new BackgroundView(GameResources.BACKGROUND_IMG_PATH);
        titleTextView = new TextView(myGdxGame.fontBlackBig, 160, 900, "Settings");
        boxImageView = new ImageView(-180, -180,1100,1600, GameResources.SETTINGS_BACKGROUND);
        clearSettingView1 = new TextView(myGdxGame.fontWhite, 270, 400, "reset");
        clearSettingView2 = new TextView(myGdxGame.fontWhite, 210, 350, "progress");

        musicSettingView = new TextView(
                myGdxGame.fontBlack,
                120, 717,
                "music: " + translateStateToText(MemoryManager.loadIsMusicOn())
        );

        soundSettingView = new TextView(
                myGdxGame.fontBlack,
                120, 658,
                "sound: " + translateStateToText(MemoryManager.loadIsSoundOn())
        );

        languageView = new TextView(
                myGdxGame.fontBlack,
                120, 599,
                "language: eng"
        );

        returnButton = new ButtonView(
                20, 1100, 170, 170,
                GameResources.BUTTON_BACK);

        resetButton = new ButtonView(
                120, 240, 467, 280,
                GameResources.BUTTON_RED);

        goldbanner = new TextView(
                myGdxGame.fontBlackBtw,
                120, 555,
                "gold banner: " + translateStateToText(MemoryManager.loadGoldBanner()));
    }

    @Override
    public void render(float delta) {

        isOld = MemoryManager.loadIsOld();
        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        backgroundView.draw(myGdxGame.batch);
        boxImageView.draw(myGdxGame.batch);
        titleTextView.draw(myGdxGame.batch);
        returnButton.draw(myGdxGame.batch);
        resetButton.draw(myGdxGame.batch);
        musicSettingView.draw(myGdxGame.batch);
        soundSettingView.draw(myGdxGame.batch);
        languageView.draw(myGdxGame.batch);
        clearSettingView1.draw(myGdxGame.batch);
        clearSettingView2.draw(myGdxGame.batch);
        if(MemoryManager.loadPlayerLevel() >= 10 || isOld){
            goldbanner.draw(myGdxGame.batch);
            MemoryManager.saveIsOld(true);
            isOld = MemoryManager.loadIsOld();
        }

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
                MemoryManager.savePerSecond(10);

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
                goldbanner.setText("gold banner "+ translateStateToText(MemoryManager.loadGoldBanner()));
                if(MemoryManager.loadGoldBanner()){
                    GameResources.BANNER_PATH = "textures/banners/Gold banner.png";
                }else {
                    GameResources.BANNER_PATH = "textures/banners/banner.png";
                }

            }
        }
    }

    private String translateStateToText(boolean state) {
        return state ? "ON" : "OFF";
    }

    @Override
    public void dispose() {
        backgroundView.dispose();
        boxImageView.dispose();
        titleTextView.dispose();
        returnButton.dispose();
        resetButton.dispose();
        musicSettingView.dispose();
        soundSettingView.dispose();
        languageView.dispose();
        clearSettingView1.dispose();
        clearSettingView2.dispose();
    }
}

