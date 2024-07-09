package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.objects.ComputerView;
import com.mygdx.game.objects.KeyboardView;
import com.mygdx.game.objects.MonitorView;
import com.mygdx.game.view.BackgroundView;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
import com.mygdx.game.view.TextView;

public class ShopScreen extends ScreenAdapter {
    MyGdxGame myGdxGame;
    BackgroundView backgroundView;
    TextView titleTextView;
    TextView coinsTextView;

    TextView monitorTextView;
    TextView keyboardTextView;
    TextView computerTextView;
    TextView nowTextView1;
    TextView nowTextView2;
    TextView nowTextView3;

    TextView MLevelTextView;
    TextView KLevelTextView;
    TextView CLevelTextView;
    TextView MInfoTextView1;
    TextView MInfoTextView2;
    TextView MInfoTextView3;
    TextView CInfoTextView1;
    TextView CInfoTextView2;
    TextView CInfoTextView3;
    TextView CInfoTextView4;
    TextView CInfoTextView5;
    TextView maxTextView1;
    TextView maxTextView2;
    TextView maxTextView3;
    TextView MCostTextView;
    TextView KCostTextView;
    TextView CCostTextView;

    ImageView boxImageView;
    ImageView shopImageView;
    ImageView coinsImageView;
    ImageView monitorImageView;
    ImageView keyboardImageView;
    ImageView computerImageView;
    ImageView lockedImageView1;
    ImageView lockedImageView2;
    ImageView lockedImageView3;
    ImageView coinImageView1;
    ImageView coinImageView2;
    ImageView coinImageView3;

    ButtonView returnButton;
    ButtonView upgradeButton1;
    ButtonView upgradeButton2;
    ButtonView upgradeButton3;

    int MNeedToPay;
    int KNeedToPay;
    int CNeedToPay;

    public ShopScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        backgroundView = new BackgroundView(GameResources.BACKGROUND_IMG_PATH);

        titleTextView = new TextView(myGdxGame.fontBlackBig, 210, 1150, "Shop");
        coinsTextView = new TextView(myGdxGame.fontWhiteSmall, 580, 1165);
        monitorTextView = new TextView(myGdxGame.fontBlack, 235, 990, "Monitor");
        keyboardTextView = new TextView(myGdxGame.fontBlack, 210, 720, "Keyboard");
        computerTextView = new TextView(myGdxGame.fontBlack, 210, 415, "Computer");

        nowTextView1 = new TextView(myGdxGame.fontBlackSmall, 240, 970, "Now it is LVL");
        nowTextView2 = new TextView(myGdxGame.fontBlackSmall, 240, 700, "Now it is LVL");
        nowTextView3 = new TextView(myGdxGame.fontBlackSmall, 240, 395, "Now it is LVL");

        MLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 970);
        KLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 700);
        CLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 395);

        MInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 265, 935, "Time between passive");
        MInfoTextView2 = new TextView(myGdxGame.fontBlackAverage, 265, 905, "income decreases by");
        MInfoTextView3 = new TextView(myGdxGame.fontRed, 265, 875, "a second");

        CInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 230, 365, "Upgrade your computer");
        CInfoTextView2 = new TextView(myGdxGame.fontBlackAverage, 230, 340, "to");
        CInfoTextView3 = new TextView(myGdxGame.fontRed, 285, 340, "unlock");
        CInfoTextView4 = new TextView(myGdxGame.fontBlackAverage, 420, 340, "monitor and");
        CInfoTextView5 = new TextView(myGdxGame.fontBlackAverage, 230, 315, "keyboard upgrades");

        maxTextView1 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 825, "Max level");
        maxTextView2 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 515, "Max level");
        maxTextView3 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 265, "Max level");

        MCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 820);
        KCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 510);
        CCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 260);

        boxImageView = new ImageView(-120, -20, 950, 1300, GameResources.SHOP_BACKGROUND);
        shopImageView = new ImageView(120, 1055, 400, 250, GameResources.SHOP_IMAGE);
        coinsImageView = new ImageView(475, 1100, 240, 150, GameResources.COINS_PATH);

        coinImageView1 = new ImageView(570, 800, 60, 60, GameResources.COIN_PATH);
        coinImageView2 = new ImageView(570, 490, 60, 60, GameResources.COIN_PATH);
        coinImageView3 = new ImageView(570, 240, 60, 60, GameResources.COIN_PATH);

        lockedImageView1 = new ImageView(380, 760, 280, 150, GameResources.BUTTON_SHOP_LOCKED);
        lockedImageView2 = new ImageView(380, 450, 280, 150, GameResources.BUTTON_SHOP_LOCKED);
        lockedImageView3 = new ImageView(380, 200, 280, 150, GameResources.BUTTON_SHOP_LOCKED);

        returnButton = new ButtonView(20, 1100, 170, 170, GameResources.BUTTON_BACK);

        upgradeButton1 = new ButtonView(380, 760, 280, 150, GameResources.BUTTON_SHOP_UPGRADE);
        upgradeButton2 = new ButtonView(380, 450, 280, 150, GameResources.BUTTON_SHOP_UPGRADE);
        upgradeButton3 = new ButtonView(380, 200, 280, 150, GameResources.BUTTON_SHOP_UPGRADE);



    }

    @Override
    public void render(float delta) {
        coinsTextView.setText(""+ MemoryManager.loadCoins());
        MLevelTextView.setText(""+ MemoryManager.loadMonitorLevel());
        KLevelTextView.setText(""+ MemoryManager.loadKeyboardLevel());
        CLevelTextView.setText(""+ MemoryManager.loadComputerLevel());

        handleInput();

        draw();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (returnButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }

            if (upgradeButton1.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadMonitorLevel() <= 4 && MemoryManager.loadCoins() >= MNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadMonitorLevel()) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - MNeedToPay;
                MemoryManager.saveCoins(odd);
                MonitorView.levelUp();
            }
            if (upgradeButton2.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadKeyboardLevel() <= 4 && MemoryManager.loadCoins() >= KNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadKeyboardLevel()) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - KNeedToPay;
                MemoryManager.saveCoins(odd);
                KeyboardView.levelUp();
            }

            if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 1 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 3) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            } else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() > 1 && MemoryManager.loadComputerLevel() < 4 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            } else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 8) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }
        }
    }
    private void draw(){
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                monitorImageView = new ImageView(40, 835, 250, 150, GameResources.MONITOR_SHOP_1);
                MNeedToPay = 300;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 2:
                monitorImageView = new ImageView(40, 835, 275, 150, GameResources.MONITOR_SHOP_2);
                MNeedToPay = 500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 3:
                monitorImageView = new ImageView(30, 835, 275, 150, GameResources.MONITOR_SHOP_3);
                MNeedToPay = 1000;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 4:
                monitorImageView = new ImageView(40, 835, 275, 150, GameResources.MONITOR_SHOP_4);
                MNeedToPay = 1500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 5:
                monitorImageView = new ImageView(60, 835, 225, 150, GameResources.MONITOR_SHOP_5);
                break;
        }

        switch (MemoryManager.loadKeyboardLevel()){
            case 1:
                keyboardImageView = new ImageView(80, 535, 250, 150, GameResources.KEYBOARD_SHOP_1);
                KNeedToPay = 300;
                KCostTextView.setText(""+ KNeedToPay);
                break;
            case 2:
                keyboardImageView = new ImageView(80, 535, 275, 150, GameResources.KEYBOARD_SHOP_2);
                KNeedToPay = 500;
                KCostTextView.setText(""+ KNeedToPay);
                break;
            case 3:
                keyboardImageView = new ImageView(80, 535, 275, 150, GameResources.KEYBOARD_SHOP_3);
                KNeedToPay = 1000;
                KCostTextView.setText(""+ KNeedToPay);
                break;
            case 4:
                keyboardImageView = new ImageView(80, 535, 275, 150, GameResources.KEYBOARD_SHOP_4);
                KNeedToPay = 1500;
                KCostTextView.setText(""+ KNeedToPay);
                break;
            case 5:
                keyboardImageView = new ImageView(60, 535, 305, 150, GameResources.KEYBOARD_SHOP_5);
                break;
        }

        switch (MemoryManager.loadComputerLevel()){
            case 1:
                computerImageView = new ImageView(80, 250, 150, 150, GameResources.COMPUTER_SHOP_1);
                CNeedToPay = 600;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 2:
                computerImageView = new ImageView(80, 250, 150, 150, GameResources.COMPUTER_SHOP_2);
                CNeedToPay = 1000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 3:
                computerImageView = new ImageView(80, 250, 150, 150, GameResources.COMPUTER_SHOP_3);
                CNeedToPay = 2000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 4:
                computerImageView = new ImageView(80, 250, 150, 150, GameResources.COMPUTER_SHOP_4);
                CNeedToPay = 3000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 5:
                computerImageView = new ImageView(80, 250, 150, 150, GameResources.COMPUTER_SHOP_5);
                break;
        }
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        backgroundView.draw(myGdxGame.batch);
        boxImageView.draw(myGdxGame.batch);

        shopImageView.draw(myGdxGame.batch);
        titleTextView.draw(myGdxGame.batch);

        coinsImageView.draw(myGdxGame.batch);
        coinsTextView.draw(myGdxGame.batch);

        returnButton.draw(myGdxGame.batch);

        monitorImageView.draw(myGdxGame.batch);
        monitorTextView.draw(myGdxGame.batch);
        nowTextView1.draw(myGdxGame.batch);
        MLevelTextView.draw(myGdxGame.batch);
        MInfoTextView1.draw(myGdxGame.batch);
        MInfoTextView2.draw(myGdxGame.batch);
        MInfoTextView3.draw(myGdxGame.batch);
        if (MemoryManager.loadCoins() < MNeedToPay){
            lockedImageView1.draw(myGdxGame.batch);
        } else {
            upgradeButton1.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadMonitorLevel() == 5){
            maxTextView1.draw(myGdxGame.batch);
        } else {
            coinImageView1.draw(myGdxGame.batch);
            MCostTextView.draw(myGdxGame.batch);
        }

        keyboardImageView.draw(myGdxGame.batch);
        keyboardTextView.draw(myGdxGame.batch);
        nowTextView2.draw(myGdxGame.batch);
        KLevelTextView.draw(myGdxGame.batch);
        if (MemoryManager.loadCoins() < KNeedToPay){
            lockedImageView2.draw(myGdxGame.batch);
        } else {
            upgradeButton2.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadKeyboardLevel() == 5){
            maxTextView2.draw(myGdxGame.batch);
        } else {
            coinImageView2.draw(myGdxGame.batch);
            KCostTextView.draw(myGdxGame.batch);
        }

        computerImageView.draw(myGdxGame.batch);
        computerTextView.draw(myGdxGame.batch);
        nowTextView3.draw(myGdxGame.batch);
        CLevelTextView.draw(myGdxGame.batch);
        CInfoTextView1.draw(myGdxGame.batch);
        CInfoTextView2.draw(myGdxGame.batch);
        CInfoTextView3.draw(myGdxGame.batch);
        CInfoTextView4.draw(myGdxGame.batch);
        CInfoTextView5.draw(myGdxGame.batch);
        if (MemoryManager.loadCoins() < CNeedToPay){
            lockedImageView3.draw(myGdxGame.batch);
        } else {
            upgradeButton3.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadComputerLevel() == 5){
            maxTextView3.draw(myGdxGame.batch);
        } else {
            coinImageView3.draw(myGdxGame.batch);
            CCostTextView.draw(myGdxGame.batch);
        }

        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
        backgroundView.dispose();
        boxImageView.dispose();
        shopImageView.dispose();
        coinsImageView.dispose();
        titleTextView.dispose();
        returnButton.dispose();
        monitorImageView.dispose();
        keyboardImageView.dispose();
        computerImageView.dispose();
        upgradeButton1.dispose();
        upgradeButton2.dispose();
        upgradeButton3.dispose();





    }

}
