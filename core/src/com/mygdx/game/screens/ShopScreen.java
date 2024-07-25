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

    TextView waterMark;

    public ShopScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;

        waterMark = new TextView(myGdxGame.waterMark,0,0,"kyber alliance");

        titleTextView = new TextView(myGdxGame.fontBlackBig, 210, 1453, "Shop");
        coinsTextView = new TextView(myGdxGame.fontWhiteSmall, 580, 1468);
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
        CInfoTextView6 = new TextView(myGdxGame.fontBlackSmall, 225, 400, "(Upgrade is");
        CInfoTextView7 = new TextView(myGdxGame.fontBlackSmall, 225, 380, "available");
        CInfoTextView8 = new TextView(myGdxGame.fontBlackSmall, 225, 360, "on Player");
        CInfoTextView9 = new TextView(myGdxGame.fontBlackSmall, 225, 340, "Level 3)");
        CInfoTextView10 = new TextView(myGdxGame.fontBlackSmall, 225, 340, "Level 8)");

        maxTextView1 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 945, "Max level");
        maxTextView2 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 635, "Max level");
        maxTextView3 = new TextView(myGdxGame.fontWhiteVerySmall, 470, 385, "Max level");

        MCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 940);
        KCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 630);
        CCostTextView = new TextView(myGdxGame.fontWhiteSmall, 470, 380);

        returnButton = new ButtonView(-20, 1380, 200, 200);

        upgradeButton1 = new ButtonView(380, 880, 280, 150);
        upgradeButton2 = new ButtonView(380, 570, 280, 150);
        upgradeButton3 = new ButtonView(380, 320, 280, 150);



    }
    @Override
    public void show(){
        switch (MemoryManager.loadKeyboardLevel()){
            case 1:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
                KNeedToPay = 300;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 20;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 2:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard2");
                KNeedToPay = 500;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 30;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 3:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard3");
                KNeedToPay = 1000;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 40;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 4:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard4");
                KNeedToPay = 1500;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 50;
                KInfoTextView2.setText(""+ KCoins);
                break;
            case 5:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard5");
                break;
            default:
                myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
                KNeedToPay = 300;
                KCostTextView.setText(""+ KNeedToPay);
                KCoins = 20;
                KInfoTextView2.setText(""+ KCoins);
        }
        switch (MemoryManager.loadComputerLevel()){
            case 1:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                CNeedToPay = 600;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 2:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
                CNeedToPay = 1000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 3:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
                CNeedToPay = 2000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 4:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
                CNeedToPay = 3000;
                CCostTextView.setText(""+ CNeedToPay);
                break;
            case 5:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
                break;
            default:
                myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                CNeedToPay = 600;
                CCostTextView.setText(""+ CNeedToPay);
                break;
        }
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
                MNeedToPay = 300;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 2:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor2");
                MNeedToPay = 500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 3:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor3");
                MNeedToPay = 1000;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 4:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor4");
                MNeedToPay = 1500;
                MCostTextView.setText(""+ MNeedToPay);
                break;
            case 5:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor5");
                break;
            default:
                myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
                MNeedToPay = 300;
                MCostTextView.setText(""+ MNeedToPay);
                break;

        }
        myGdxGame.monitorShop.setPosition(40,955);
        myGdxGame.monitorShop.setSize(225, 150);

        myGdxGame.computerShop.setPosition(80, 370);
        myGdxGame.computerShop.setSize(150, 150);

        myGdxGame.keyBoardShop.setPosition(60, 655);
        myGdxGame.keyBoardShop.setSize(275, 150);

        myGdxGame.shopUpgradeButton1.setPosition(380, 880);
        myGdxGame.shopUpgradeButton1.setSize(280, 150);

        myGdxGame.shopUpgradeButton2.setPosition(380, 570);
        myGdxGame.shopUpgradeButton2.setSize(280, 150);

        myGdxGame.shopUpgradeButton3.setPosition(380, 320);
        myGdxGame.shopUpgradeButton3.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked1.setPosition(380, 880);
        myGdxGame.shopUpgradeButtonLocked1.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked2.setPosition(380, 570);
        myGdxGame.shopUpgradeButtonLocked2.setSize(280, 150);

        myGdxGame.shopUpgradeButtonLocked3.setPosition(380, 320);
        myGdxGame.shopUpgradeButtonLocked3.setSize(280, 150);

        myGdxGame.shopImage.setPosition(120, 1358);
        myGdxGame.shopImage.setSize(400, 250);

        myGdxGame.shopBackground.setPosition(-120, 100);
        myGdxGame.shopBackground.setSize(950, 1300);

        myGdxGame.backButton.setPosition(-20, 1380);
        myGdxGame.backButton.setSize(200, 200);

        myGdxGame.coinsBanner.setPosition(475, 1403);
        myGdxGame.coinsBanner.setSize(240, 150);

        myGdxGame.coin1.setPosition(570, 920);
        myGdxGame.coin2.setPosition(570, 610);
        myGdxGame.coin3.setPosition(570, 360);
        myGdxGame.coin1.setSize(60,60);
        myGdxGame.coin2.setSize(60,60);
        myGdxGame.coin3.setSize(60,60);
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
                switch (MemoryManager.loadMonitorLevel()){
                    case 1:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
                        MNeedToPay = 300;
                        MCostTextView.setText(""+ MNeedToPay);
                        break;
                    case 2:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor2");
                        MNeedToPay = 500;
                        MCostTextView.setText(""+ MNeedToPay);
                        break;
                    case 3:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor3");
                        MNeedToPay = 1000;
                        MCostTextView.setText(""+ MNeedToPay);
                        break;
                    case 4:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor4");
                        MNeedToPay = 1500;
                        MCostTextView.setText(""+ MNeedToPay);
                        break;
                    case 5:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor5");
                        break;
                    default:
                        myGdxGame.monitorShop = myGdxGame.textureAtlas.createSprite("Shop/monitor1");
                        MNeedToPay = 300;
                        MCostTextView.setText(""+ MNeedToPay);
                }


                myGdxGame.monitorShop.setPosition(40,955);
                myGdxGame.monitorShop.setSize(225, 150);
            }
            if (upgradeButton2.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadKeyboardLevel() <= 4 && MemoryManager.loadCoins() >= KNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadKeyboardLevel()) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - KNeedToPay;
                MemoryManager.saveCoins(odd);
                KeyboardView.levelUp();
                switch (MemoryManager.loadKeyboardLevel()){
                    case 1:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
                        KNeedToPay = 300;
                        KCostTextView.setText(""+ KNeedToPay);
                        KCoins = 20;
                        KInfoTextView2.setText(""+ KCoins);
                        break;
                    case 2:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard2");
                        KNeedToPay = 500;
                        KCostTextView.setText(""+ KNeedToPay);
                        KCoins = 30;
                        KInfoTextView2.setText(""+ KCoins);
                        break;
                    case 3:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard3");
                        KNeedToPay = 1000;
                        KCostTextView.setText(""+ KNeedToPay);
                        KCoins = 40;
                        KInfoTextView2.setText(""+ KCoins);
                        break;
                    case 4:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard4");
                        KNeedToPay = 1500;
                        KCostTextView.setText(""+ KNeedToPay);
                        KCoins = 50;
                        KInfoTextView2.setText(""+ KCoins);
                        break;
                    case 5:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard5");
                    default:
                        myGdxGame.keyBoardShop = myGdxGame.textureAtlas.createSprite("Shop/keyboard1");
                        KNeedToPay = 300;
                        KCostTextView.setText(""+ KNeedToPay);
                        KCoins = 20;
                        KInfoTextView2.setText(""+ KCoins);
                }

                myGdxGame.keyBoardShop.setPosition(60, 655);
                myGdxGame.keyBoardShop.setSize(275, 150);
            }

            if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 1 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 3) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
                switch (MemoryManager.loadComputerLevel()){
                    case 1:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 2:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
                        CNeedToPay = 1000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 3:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
                        CNeedToPay = 2000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 4:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
                        CNeedToPay = 3000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 5:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
                        break;
                    default:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                }

                myGdxGame.computerShop.setPosition(80, 370);
                myGdxGame.computerShop.setSize(150, 150);
            } else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() > 1 && MemoryManager.loadComputerLevel() < 4 && MemoryManager.loadCoins() >= CNeedToPay) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
                switch (MemoryManager.loadComputerLevel()){
                    case 1:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 2:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
                        CNeedToPay = 1000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 3:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
                        CNeedToPay = 2000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 4:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
                        CNeedToPay = 3000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 5:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
                        break;
                    default:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                }

                myGdxGame.computerShop.setPosition(80, 370);
                myGdxGame.computerShop.setSize(150, 150);
            } else if (upgradeButton3.isHit(myGdxGame.touch.x, myGdxGame.touch.y) && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadPlayerLevel() >= 8) {
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                int odd = MemoryManager.loadCoins() - CNeedToPay;
                MemoryManager.saveCoins(odd);
                ComputerView.levelUp();
                switch (MemoryManager.loadComputerLevel()){
                    case 1:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 2:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc2");
                        CNeedToPay = 1000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 3:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc3");
                        CNeedToPay = 2000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 4:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc4");
                        CNeedToPay = 3000;
                        CCostTextView.setText(""+ CNeedToPay);
                        break;
                    case 5:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc5");
                        break;
                    default:
                        myGdxGame.computerShop = myGdxGame.textureAtlas.createSprite("Shop/pc1");
                        CNeedToPay = 600;
                        CCostTextView.setText(""+ CNeedToPay);
                }

                myGdxGame.computerShop.setPosition(80, 370);
                myGdxGame.computerShop.setSize(150, 150);
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
        if (MemoryManager.loadCoins() >= MNeedToPay && MemoryManager.loadComputerLevel() > MemoryManager.loadMonitorLevel() || MemoryManager.loadMonitorLevel() == 5){
            myGdxGame.shopUpgradeButton1.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked1.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadMonitorLevel() == 5){
            myGdxGame.shopUpgradeButtonLocked1.draw(myGdxGame.batch);
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
        } else {
            myGdxGame.shopUpgradeButtonLocked2.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadKeyboardLevel() == 5){
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

        if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 1 && MemoryManager.loadPlayerLevel() >= 3){
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() > 1 && MemoryManager.loadComputerLevel() < 4) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() == 4 && MemoryManager.loadPlayerLevel() >= 8) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else if (MemoryManager.loadCoins() >= CNeedToPay && MemoryManager.loadComputerLevel() > 4) {
            myGdxGame.shopUpgradeButton3.draw(myGdxGame.batch);
        } else {
            myGdxGame.shopUpgradeButtonLocked3.draw(myGdxGame.batch);
        }
        if (MemoryManager.loadComputerLevel() == 5){
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
