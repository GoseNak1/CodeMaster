package com.codemaster.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.codemaster.game.MyGdxGame;
import com.codemaster.game.managers.MemoryManager;
import com.codemaster.game.view.ButtonView;
import com.codemaster.game.view.TextView;

public class MakeSureResetScreen extends ScreenAdapter {
    MyGdxGame myGdxGame;

    TextView waterMark;
    TextView question1;
    TextView question2;
    TextView question3;
    TextView accept;
    TextView decline;

    ButtonView acceptButton;
    ButtonView declineButton;

    public MakeSureResetScreen (MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        waterMark = new TextView(myGdxGame.waterMark,0,0,"kyber alliance");
        question1 = new TextView(myGdxGame.fontBlack,145,1050,"Do you want");
        question2 = new TextView(myGdxGame.fontBlack,200,1000,"to reset");
        question3 = new TextView(myGdxGame.fontBlack,190,950,"progress?");
        accept = new TextView(myGdxGame.fontBlackBtw,240,770,"Yes, I do");
        decline = new TextView(myGdxGame.fontBlackBtw,220,665,"No, I don't");

        acceptButton = new ButtonView(130, 700, 460, 180);
        declineButton = new ButtonView(130, 600, 460, 170);
    }

    @Override
    public void show(){
        myGdxGame.settingsBackground.setPosition(-180, -50);
        myGdxGame.settingsBackground.setSize(1100,1600);

        myGdxGame.acceptReset.setPosition(130, 700);
        myGdxGame.acceptReset.setSize(460,180);

        myGdxGame.declineReset.setPosition(130, 600);
        myGdxGame.declineReset.setSize(460,170);
    }

    @Override
    public void render(float delta) {
        handleInput();

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        myGdxGame.backGround.draw(myGdxGame.batch);
        myGdxGame.settingsBackground.draw(myGdxGame.batch);
        myGdxGame.acceptReset.draw(myGdxGame.batch);
        myGdxGame.declineReset.draw(myGdxGame.batch);
        question1.draw(myGdxGame.batch);
        question2.draw(myGdxGame.batch);
        question3.draw(myGdxGame.batch);
        accept.draw(myGdxGame.batch);
        decline.draw(myGdxGame.batch);
        waterMark.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (acceptButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                if(MemoryManager.loadPlayerLevel() >= 20){
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
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }

            if (declineButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.settingsScreen);
            }
        }
    }

    @Override
    public void dispose() {
        waterMark.dispose();
        question1.dispose();
        question2.dispose();
        question3.dispose();
        accept.dispose();
        decline.dispose();
    }
}
