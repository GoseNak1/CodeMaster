package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.objects.ComputerView;
import com.mygdx.game.objects.KeyboardView;
import com.mygdx.game.objects.MonitorView;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.TextView;

public class ShopScreen extends ScreenAdapter {
    MyGdxGame myGdxGame;
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

    TextView KInfoTextView1;
    TextView KInfoTextView2;
    TextView KInfoTextView3;
    TextView KInfoTextView4;

    TextView MInfoTextView1;
    TextView MInfoTextView2;
    TextView MInfoTextView3;

    TextView CInfoTextView1;
    TextView CInfoTextView2;
    TextView CInfoTextView3;
    TextView CInfoTextView4;
    TextView CInfoTextView5;
    TextView CInfoTextView6;
    TextView CInfoTextView7;
    TextView CInfoTextView8;
    TextView CInfoTextView9;
    TextView CInfoTextView10;
    TextView CInfoTextView11;
    TextView CInfoTextView12;


    TextView maxTextView1;
    TextView maxTextView2;
    TextView maxTextView3;
    TextView MCostTextView;
    TextView KCostTextView;
    TextView CCostTextView;

    ButtonView returnButton;
    ButtonView upgradeButton1;
    ButtonView upgradeButton2;
    ButtonView upgradeButton3;

    int MNeedToPay;
    int KNeedToPay;
    int CNeedToPay;

    TextView waterMark;

    public ShopScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        waterMark = new TextView(myGdxGame.waterMark,0,0,"kyber alliance");

        titleTextView = new TextView(myGdxGame.fontBlackBig, 210, 1453, "Shop");
        coinsTextView = new TextView(myGdxGame.fontWhiteBtw, 590, 1468);
        monitorTextView = new TextView(myGdxGame.fontBlack, 235, 1110, "Monitor");
        keyboardTextView = new TextView(myGdxGame.fontBlack, 210, 840, "Keyboard");
        computerTextView = new TextView(myGdxGame.fontBlack, 210, 535, "Computer");

        nowTextView1 = new TextView(myGdxGame.fontBlackSmall, 240, 1090, "Now it is LVL");
        nowTextView2 = new TextView(myGdxGame.fontBlackSmall, 240, 820, "Now it is LVL");
        nowTextView3 = new TextView(myGdxGame.fontBlackSmall, 240, 515, "Now it is LVL");

        MLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 1090);
        KLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 820);
        CLevelTextView = new TextView(myGdxGame.fontBlackSmall, 455, 515);

        MInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 265, 1055, "Time between passive");
        MInfoTextView2 = new TextView(myGdxGame.fontBlackAverage, 265, 1025, "income decreases by");
        MInfoTextView3 = new TextView(myGdxGame.fontRed, 265, 995, "a second");

        KInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 325, 745, "Get");
        KInfoTextView2 = new TextView(myGdxGame.fontRed, 395, 745);
        KInfoTextView3 = new TextView(myGdxGame.fontBlackAverage, 445, 745, "coins for");
        KInfoTextView4 = new TextView(myGdxGame.fontBlackAverage, 325, 715, "every 10 clicks");

        CInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 230, 485, "Upgrade your computer");
        CInfoTextView2 = new TextView(myGdxGame.fontBlackAverage, 230, 460, "to");
        CInfoTextView3 = new TextView(myGdxGame.fontRed, 285, 460, "unlock");
        CInfoTextView4 = new TextView(myGdxGame.fontBlackAverage, 420, 460, "monitor and");
        CInfoTextView5 = new TextView(myGdxGame.fontBlackAverage, 230, 435, "keyboard upgrades");
        CInfoTextView6 = new TextView(myGdxGame.fontBlackSmall, 205, 400, "(Upgrade is");
        CInfoTextView7 = new TextView(myGdxGame.fontBlackSmall, 205, 380, "available");
        CInfoTextView8 = new TextView(myGdxGame.fontBlackSmall, 205, 360, "on Player");
        CInfoTextView9 = new TextView(myGdxGame.fontBlackSmall, 205, 340, "Level 4)");
        CInfoTextView10 = new TextView(myGdxGame.fontBlackSmall, 205, 340, "Level 8)");
        CInfoTextView11 = new TextView(myGdxGame.fontBlackSmall, 205,340, "level 13)");
        CInfoTextView12 = new TextView(myGdxGame.fontBlackSmall, 205,340, "level 19)");


        maxTextView1 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 945, "Max level");
        maxTextView2 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 635, "Max level");
        maxTextView3 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 385, "Max level");

        MCostTextView = new TextView(myGdxGame.fontWhiteBtw, 463, 942);
        KCostTextView = new TextView(myGdxGame.fontWhiteBtw, 463, 632);
        CCostTextView = new TextView(myGdxGame.fontWhiteBtw, 463, 382);

        returnButton = new ButtonView(-20, 1380, 200, 200);

        upgradeButton1 = new ButtonView(360, 880, 310, 150);
        upgradeButton2 = new ButtonView(360, 570, 310, 150);
        upgradeButton3 = new ButtonView(360, 320, 310, 150);



    }
    @Override
    public void show(){
        if(MemoryManager.loadComputerLevel() < 5){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
        } else if (MemoryManager.loadComputerLevel() >= 5 && MemoryManager.loadComputerLevel() < 10) {
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
        }else if (MemoryManager.loadComputerLevel() >= 10 && MemoryManager.loadComputerLevel() < 15){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
        }else if (MemoryManager.loadComputerLevel() >= 15 && MemoryManager.loadComputerLevel() < 20){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
        }else {
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
        }
        if(MemoryManager.loadKeyboardLevel() < 5){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
        } else if (MemoryManager.loadKeyboardLevel() >= 5 && MemoryManager.loadKeyboardLevel() < 10) {
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard2");
        }else if (MemoryManager.loadKeyboardLevel() >= 10 && MemoryManager.loadKeyboardLevel() < 15){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard3");
        }else if (MemoryManager.loadKeyboardLevel() >= 15 && MemoryManager.loadKeyboardLevel() < 20){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard4");
        }else {
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard5");
        }
        if(MemoryManager.loadMonitorLevel() < 5){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
        } else if (MemoryManager.loadMonitorLevel() >= 5 && MemoryManager.loadMonitorLevel() < 10) {
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor2");
        }else if (MemoryManager.loadMonitorLevel() >= 10 && MemoryManager.loadMonitorLevel() < 15){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor3");
        }else if (MemoryManager.loadMonitorLevel() >= 15 && MemoryManager.loadMonitorLevel() < 20){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor4");
        }else {
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor5");
        }
        myGdxGame.monitorShop.setPosition(40,955);
        myGdxGame.monitorShop.setSize(225, 150);

        myGdxGame.computerShop.setPosition(80, 370);
        myGdxGame.computerShop.setSize(150, 150);

        myGdxGame.keyBoardShop.setPosition(60, 655);
        myGdxGame.keyBoardShop.setSize(275, 150);

        myGdxGame.shopUpgradeButton1.setPosition(360, 880);
        myGdxGame.shopUpgradeButton1.setSize(310, 150);

        myGdxGame.shopUpgradeButton2.setPosition(360, 570);
        myGdxGame.shopUpgradeButton2.setSize(310, 150);

        myGdxGame.shopUpgradeButton3.setPosition(360, 320);
        myGdxGame.shopUpgradeButton3.setSize(310, 150);

        myGdxGame.shopUpgradeButtonLocked1.setPosition(360, 880);
        myGdxGame.shopUpgradeButtonLocked1.setSize(310, 150);

        myGdxGame.shopUpgradeButtonLocked2.setPosition(360, 570);
        myGdxGame.shopUpgradeButtonLocked2.setSize(310, 150);

        myGdxGame.shopUpgradeButtonLocked3.setPosition(360, 320);
        myGdxGame.shopUpgradeButtonLocked3.setSize(310, 150);

        myGdxGame.shopImage.setPosition(120, 1358);
        myGdxGame.shopImage.setSize(400, 250);

        myGdxGame.shopBackground.setPosition(-120, 100);
        myGdxGame.shopBackground.setSize(950, 1300);

        myGdxGame.backButton.setPosition(-20, 1380);
        myGdxGame.backButton.setSize(200, 200);

        myGdxGame.coinsBanner.setPosition(450, 1400);
        myGdxGame.coinsBanner.setSize(300, 150);

        myGdxGame.coin1.setPosition(570, 920);
        myGdxGame.coin2.setPosition(570, 610);
        myGdxGame.coin3.setPosition(570, 360);
        myGdxGame.coin1.setSize(60,60);
        myGdxGame.coin2.setSize(60,60);
        myGdxGame.coin3.setSize(60,60);

        KNeedToPay = (700 * (MemoryManager.loadKeyboardLevel() + 1) * (MemoryManager.loadKeyboardLevel() + 1))/10;
        CNeedToPay = (1000 * (MemoryManager.loadComputerLevel() + 1) * (MemoryManager.loadComputerLevel() + 1)) / 10;
        KCostTextView.setText(""+ KNeedToPay);
        CCostTextView.setText(""+ CNeedToPay);
    }

    @Override
    public void render(float delta) {
        switch (MemoryManager.loadKeyboardLevel()){
            case 1: GameScreen.coinsFor10Click = 2; break;
            case 2: GameScreen.coinsFor10Click = 4; break;
            case 3: GameScreen.coinsFor10Click = 6; break;
            case 4: GameScreen.coinsFor10Click = 8; break;
            case 5: GameScreen.coinsFor10Click = 10; break;
            case 6: GameScreen.coinsFor10Click = 12; break;
            case 7: GameScreen.coinsFor10Click = 14; break;
            case 8: GameScreen.coinsFor10Click = 16; break;
            case 9: GameScreen.coinsFor10Click = 18; break;
            case 10: GameScreen.coinsFor10Click = 20; break;
            case 11: GameScreen.coinsFor10Click = 22; break;
            case 12: GameScreen.coinsFor10Click = 24; break;
            case 13: GameScreen.coinsFor10Click = 26; break;
            case 14: GameScreen.coinsFor10Click = 28; break;
            case 15: GameScreen.coinsFor10Click = 30; break;
            case 16: GameScreen.coinsFor10Click = 32; break;
            case 17: GameScreen.coinsFor10Click = 34; break;
            case 18: GameScreen.coinsFor10Click = 36; break;
            case 19: GameScreen.coinsFor10Click = 38; break;
            case 20: GameScreen.coinsFor10Click = 40; break;
        }
        KNeedToPay = (700 * (MemoryManager.loadKeyboardLevel() + 1) * (MemoryManager.loadKeyboardLevel() + 1)) / 10;
        MNeedToPay = (700 * (MemoryManager.loadMonitorLevel() + 1) * (MemoryManager.loadMonitorLevel() + 1)) / 10;
        CNeedToPay = (1000 * (MemoryManager.loadComputerLevel() + 1) * (MemoryManager.loadComputerLevel() + 1)) / 10;

        KCostTextView.setText(""+ KNeedToPay);
        CCostTextView.setText(""+ CNeedToPay);
        MCostTextView.setText(""+ MNeedToPay);

        coinsTextView.setText(""+ MemoryManager.loadCoins());
        MLevelTextView.setText(""+ MemoryManager.loadMonitorLevel());
        KLevelTextView.setText(""+ MemoryManager.loadKeyboardLevel());
        CLevelTextView.setText(""+ MemoryManager.loadComputerLevel());

        handleInput();
        if(MemoryManager.loadComputerLevel() < 5){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
        } else if (MemoryManager.loadComputerLevel() >= 5 && MemoryManager.loadComputerLevel() < 10) {
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
        }else if (MemoryManager.loadComputerLevel() >= 10 && MemoryManager.loadComputerLevel() < 15){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
        }else if (MemoryManager.loadComputerLevel() >= 15 && MemoryManager.loadComputerLevel() < 20){
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
        }else {
            myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
        }
        if(MemoryManager.loadKeyboardLevel() < 5){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
        } else if (MemoryManager.loadKeyboardLevel() >= 5 && MemoryManager.loadKeyboardLevel() < 10) {
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard2");
        }else if (MemoryManager.loadKeyboardLevel() >= 10 && MemoryManager.loadKeyboardLevel() < 15){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard3");
        }else if (MemoryManager.loadKeyboardLevel() >= 15 && MemoryManager.loadKeyboardLevel() < 20){
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard4");
        }else {
            myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard5");
        }
        if(MemoryManager.loadMonitorLevel() < 5){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
        } else if (MemoryManager.loadMonitorLevel() >= 5 && MemoryManager.loadMonitorLevel() < 10) {
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor2");
        }else if (MemoryManager.loadMonitorLevel() >= 10 && MemoryManager.loadMonitorLevel() < 15){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor3");
        }else if (MemoryManager.loadMonitorLevel() >= 15 && MemoryManager.loadMonitorLevel() < 20){
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor4");
        }else {
            myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor5");
        }

        myGdxGame.monitorShop.setPosition(40,955);
        myGdxGame.monitorShop.setSize(225, 150);
        myGdxGame.keyBoardShop.setPosition(60, 655);
        myGdxGame.keyBoardShop.setSize(275, 150);
        KInfoTextView2.setText(""+ GameScreen.coinsFor10Click);
        myGdxGame.computerShop.setPosition(80, 370);
        myGdxGame.computerShop.setSize(150, 150);

        draw();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (returnButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }

            if (upgradeButton1.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadMonitorLevel() <= 19 && MemoryManager.loadCoins() >= MNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadMonitorLevel()) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - MNeedToPay;
                MemoryManager.saveCoins(odd);
                MonitorView.levelUp();
            }

            if (upgradeButton2.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadKeyboardLevel() <= 19 && MemoryManager.loadCoins() >= KNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadKeyboardLevel()) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - KNeedToPay;
                MemoryManager.saveCoins(odd);
                KeyboardView.levelUp();
            }

            if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 4) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            } else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 9 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 8) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            } else if (upgradeButton3.isHit(myGdxGame.touch.x,myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 14 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 13) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            } else if (upgradeButton3.isHit(myGdxGame.touch.x,myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 19  && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 19) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() > 4 && MemoryManager.loadComputerLevel() < 9 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() > 9 && MemoryManager.loadComputerLevel() < 14 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() > 14 && MemoryManager.loadComputerLevel() < 19 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() < 4 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
            }
        }
    }
    private void draw(){

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        myGdxGame.backGround.draw(myGdxGame.batch);
        myGdxGame.shopBackground.draw(myGdxGame.batch);

        myGdxGame.shopImage.draw(myGdxGame.batch);
        titleTextView.draw(myGdxGame.batch);

        myGdxGame.coinsBanner.draw(myGdxGame.batch);
        coinsTextView.draw(myGdxGame.batch);

        myGdxGame.backButton.draw(myGdxGame.batch);

        myGdxGame.monitorShop.draw(myGdxGame.batch);

        monitorTextView.draw(myGdxGame.batch);

        myGdxGame.computerShop.draw(myGdxGame.batch);
        myGdxGame.keyBoardShop.draw(myGdxGame.batch);

        nowTextView1.draw(myGdxGame.batch);
        MLevelTextView.draw(myGdxGame.batch);
        MInfoTextView1.draw(myGdxGame.batch);
        MInfoTextView2.draw(myGdxGame.batch);
        MInfoTextView3.draw(myGdxGame.batch);
        if (MemoryManager.loadCoins() >= MNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadMonitorLevel()){
            myGdxGame.shopUpgradeButton1.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked1.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadMonitorLevel() == 20){
            myGdxGame.shopUpgradeButtonLocked1.draw(myGdxGame.batch);
            maxTextView1.draw(myGdxGame.batch);
        } else {

            myGdxGame.coin1.draw(myGdxGame.batch);
            MCostTextView.draw(myGdxGame.batch);
        }

        keyboardTextView.draw(myGdxGame.batch);
        nowTextView2.draw(myGdxGame.batch);
        KLevelTextView.draw(myGdxGame.batch);


        KInfoTextView1.draw(myGdxGame.batch);
        KInfoTextView2.draw(myGdxGame.batch);
        KInfoTextView3.draw(myGdxGame.batch);
        KInfoTextView4.draw(myGdxGame.batch);

        if (MemoryManager.loadCoins() >= KNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadKeyboardLevel()){
            myGdxGame.shopUpgradeButton2.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked2.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadKeyboardLevel() == 20){
            myGdxGame.shopUpgradeButtonLocked2.draw(myGdxGame.batch);
            maxTextView2.draw(myGdxGame.batch);
        } else {

            myGdxGame.coin2.draw(myGdxGame.batch);
            KCostTextView.draw(myGdxGame.batch);
        }

        computerTextView.draw(myGdxGame.batch);
        nowTextView3.draw(myGdxGame.batch);
        CLevelTextView.draw(myGdxGame.batch);
        CInfoTextView1.draw(myGdxGame.batch);
        CInfoTextView2.draw(myGdxGame.batch);
        CInfoTextView3.draw(myGdxGame.batch);
        CInfoTextView4.draw(myGdxGame.batch);
        CInfoTextView5.draw(myGdxGame.batch);

        if (MemoryManager.loadComputerLevel() == 4) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView9.draw(myGdxGame.batch);
        }else if (MemoryManager.loadComputerLevel() == 9) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView10.draw(myGdxGame.batch);
        } else if (MemoryManager.loadComputerLevel() == 14) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView11.draw(myGdxGame.batch);
        }else if (MemoryManager.loadComputerLevel() == 19) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView12.draw(myGdxGame.batch);
        }


        if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadPlayerLevel() >= 4){
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() < 4) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() > 4 && MemoryManager.loadComputerLevel() < 9) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 9 && MemoryManager.loadPlayerLevel() >= 8) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() > 9 && MemoryManager.loadComputerLevel() < 14) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 14 && MemoryManager.loadPlayerLevel() >= 13) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        }else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() > 14 && MemoryManager.loadComputerLevel() < 19) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        }else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 19 && MemoryManager.loadPlayerLevel() >= 15) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadComputerLevel() == 20){
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
            maxTextView3.draw(myGdxGame.batch);
        } else {
            myGdxGame.coin3.draw(myGdxGame.batch);
            CCostTextView.draw(myGdxGame.batch);
        }
        waterMark.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
        waterMark.dispose();
        myGdxGame.dispose();
        titleTextView.dispose();
        coinsTextView.dispose();

        monitorTextView.dispose();
        keyboardTextView.dispose();
         computerTextView.dispose();
         nowTextView1.dispose();
         nowTextView2.dispose();
         nowTextView3.dispose();

         MLevelTextView.dispose();
         KLevelTextView.dispose();
         CLevelTextView.dispose();

         KInfoTextView1.dispose();
         KInfoTextView2.dispose();
         KInfoTextView3.dispose();
         KInfoTextView4.dispose();

         MInfoTextView1.dispose();
         MInfoTextView2.dispose();
         MInfoTextView3.dispose();

         CInfoTextView1.dispose();
         CInfoTextView2.dispose();
         CInfoTextView3.dispose();
         CInfoTextView4.dispose();
         CInfoTextView5.dispose();
        CInfoTextView6.dispose();
        CInfoTextView7.dispose();
        CInfoTextView8.dispose();
        CInfoTextView9.dispose();
        CInfoTextView10.dispose();

         maxTextView1.dispose();
         maxTextView2.dispose();
         maxTextView3.dispose();
         MCostTextView.dispose();
         KCostTextView.dispose();
         CCostTextView.dispose();

         returnButton.dispose();
         upgradeButton1.dispose();
         upgradeButton2.dispose();
        upgradeButton3.dispose();






    }

}
