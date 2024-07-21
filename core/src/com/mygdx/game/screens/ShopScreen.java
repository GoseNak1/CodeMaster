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
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
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
    int KCoins;

    public ShopScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

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

        KInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 325, 625, "Get");
        KInfoTextView2 = new TextView(myGdxGame.fontRed, 395, 625);
        KInfoTextView3 = new TextView(myGdxGame.fontBlackAverage, 445, 625, "coins for");
        KInfoTextView4 = new TextView(myGdxGame.fontBlackAverage, 325, 595, "every 10 clicks");

        CInfoTextView1 = new TextView(myGdxGame.fontBlackAverage, 230, 365, "Upgrade your computer");
        CInfoTextView2 = new TextView(myGdxGame.fontBlackAverage, 230, 340, "to");
        CInfoTextView3 = new TextView(myGdxGame.fontRed, 285, 340, "unlock");
        CInfoTextView4 = new TextView(myGdxGame.fontBlackAverage, 420, 340, "monitor and");
        CInfoTextView5 = new TextView(myGdxGame.fontBlackAverage, 230, 315, "keyboard upgrades");
        CInfoTextView6 = new TextView(myGdxGame.fontBlackSmall, 225, 280, "(Upgrade is");
        CInfoTextView7 = new TextView(myGdxGame.fontBlackSmall, 225, 260, "available");
        CInfoTextView8 = new TextView(myGdxGame.fontBlackSmall, 225, 240, "on Player");
        CInfoTextView9 = new TextView(myGdxGame.fontBlackSmall, 225, 220, "Level 3)");
        CInfoTextView10 = new TextView(myGdxGame.fontBlackSmall, 225, 220, "Level 8)");

        maxTextView1 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 825, "Max level");
        maxTextView2 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 515, "Max level");
        maxTextView3 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 265, "Max level");

        MCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 820);
        KCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 510);
        CCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 260);

        returnButton = new ButtonView(20, 1100, 170, 170);

        upgradeButton1 = new ButtonView(380, 760, 280, 150);
        upgradeButton2 = new ButtonView(380, 450, 280, 150);
        upgradeButton3 = new ButtonView(380, 200, 280, 150);



    }
    @Override
    public void show(){
        myGdxGame.shopUpgradeButton1.setPosition(380, 760);
        myGdxGame.shopUpgradeButton1.setSize(280, 150);

        myGdxGame.shopUpgradeButton2.setPosition(380, 450);
        myGdxGame.shopUpgradeButton2.setSize(280, 150);

        myGdxGame.shopUpgradeButton3.setPosition(380, 200);
        myGdxGame.shopUpgradeButton3.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked1.setPosition(380, 760);
        myGdxGame.shopUpgradeButtonLocked1.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked2.setPosition(380, 450);
        myGdxGame.shopUpgradeButtonLocked2.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked3.setPosition(380, 200);
        myGdxGame.shopUpgradeButtonLocked3.setSize(280, 150);

        myGdxGame.shopImage.setPosition(120, 1055);
        myGdxGame.shopImage.setSize(400, 250);

        myGdxGame.shopBackground.setPosition(-120, -20);
        myGdxGame.shopBackground.setSize(950, 1300);

        myGdxGame.backButton.setPosition(20, 1100);
        myGdxGame.backButton.setSize(170, 170);

        myGdxGame.coinsBanner.setPosition(475, 1100);
        myGdxGame.coinsBanner.setSize(240, 150);

        myGdxGame.coin1.setPosition(570, 800);
        myGdxGame.coin2.setPosition(570, 490);
        myGdxGame.coin3.setPosition(570, 240);
        myGdxGame.coin1.setSize(60,60);
        myGdxGame.coin2.setSize(60,60);
        myGdxGame.coin3.setSize(60,60);
    }

    @Override
    public void render(float delta) {
        switch (MemoryManager.loadKeyboardLevel()){
            case 1:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard1");
                KNeedToPay = 300;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 20;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 2:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard2");
                KNeedToPay = 500;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 30;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 3:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard3");
                KNeedToPay = 1000;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 40;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 4:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard4");
                KNeedToPay = 1500;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 50;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 5:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard5");
                break;
            default:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("keyboard/Shop/keyboard1");
                KNeedToPay = 300;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 20;
                KInfoTextView2.setText(""+ KCoins);
        }
        switch (MemoryManager.loadComputerLevel()){
            case 1:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc1");
                CNeedToPay = 600;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 2:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc2");
                CNeedToPay = 1000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 3:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc3");
                CNeedToPay = 2000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 4:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc4");
                CNeedToPay = 3000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 5:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc5");
                break;
            default:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("PC/Shop/pc1");
                CNeedToPay = 600;
                CCostTextView.setText(""+ CNeedToPay);
                break;
        }
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor1");
                MNeedToPay = 300;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 2:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor2");
                MNeedToPay = 500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 3:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor3");
                MNeedToPay = 1000;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 4:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor4");
                MNeedToPay = 1500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 5:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor5");
                break;
            default:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("monitor/shop/monitor1");
                MNeedToPay = 300;
                MCostTextView.setText(""+ MNeedToPay);
                break;

        }
        myGdxGame.monitorShop.setPosition(40,835);
        myGdxGame.monitorShop.setSize(225, 150);

        myGdxGame.computerShop.setPosition(80, 250);
        myGdxGame.computerShop.setSize(150, 150);

        myGdxGame.keyBoardShop.setPosition(60, 535);
        myGdxGame.keyBoardShop.setSize(275, 150);


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
//        monitorImageView.draw(myGdxGame.batch);

        monitorTextView.draw(myGdxGame.batch);

        myGdxGame.computerShop.draw(myGdxGame.batch);
        myGdxGame.keyBoardShop.draw(myGdxGame.batch);

        nowTextView1.draw(myGdxGame.batch);
        MLevelTextView.draw(myGdxGame.batch);
        MInfoTextView1.draw(myGdxGame.batch);
        MInfoTextView2.draw(myGdxGame.batch);
        MInfoTextView3.draw(myGdxGame.batch);
        if (MemoryManager.loadCoins() >= MNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadMonitorLevel() || MemoryManager.loadMonitorLevel() == 5){
            myGdxGame.shopUpgradeButton1.draw(myGdxGame.batch);
//            upgradeButton1.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked1.draw(myGdxGame.batch);
//            lockedImageView1.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadMonitorLevel() == 5){
            maxTextView1.draw(myGdxGame.batch);
        } else {
            myGdxGame.coin1.draw(myGdxGame.batch);

            MCostTextView.draw(myGdxGame.batch);
        }

        keyboardTextView.draw(myGdxGame.batch);
        nowTextView2.draw(myGdxGame.batch);
        KLevelTextView.draw(myGdxGame.batch);
        if (MemoryManager.loadKeyboardLevel() != 5) {
            KInfoTextView1.draw(myGdxGame.batch);
            KInfoTextView2.draw(myGdxGame.batch);
            KInfoTextView3.draw(myGdxGame.batch);
            KInfoTextView4.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadCoins() >= KNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadKeyboardLevel() || MemoryManager.loadKeyboardLevel() == 5){
            myGdxGame.shopUpgradeButton2.draw(myGdxGame.batch);
//            upgradeButton2.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked2.draw(myGdxGame.batch);
//            lockedImageView2.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadKeyboardLevel() == 5){
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
        if (MemoryManager.loadComputerLevel() == 1) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView9.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadComputerLevel() == 4) {
            CInfoTextView6.draw(myGdxGame.batch);
            CInfoTextView7.draw(myGdxGame.batch);
            CInfoTextView8.draw(myGdxGame.batch);
            CInfoTextView10.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadCoins() < CNeedToPay && MemoryManager.loadComputerLevel() == 1 && MemoryManager.loadPlayerLevel() < 3){
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() < CNeedToPay && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadPlayerLevel() < 8){
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() < CNeedToPay && MemoryManager.loadComputerLevel() > 1 && MemoryManager.loadComputerLevel() < 4){
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadComputerLevel() == 5){
            maxTextView3.draw(myGdxGame.batch);
        } else {
            myGdxGame.coin3.draw(myGdxGame.batch);

            CCostTextView.draw(myGdxGame.batch);
        }

        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
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
