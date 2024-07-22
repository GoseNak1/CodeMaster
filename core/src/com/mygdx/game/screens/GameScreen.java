package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSession;
import com.mygdx.game.GameSettings;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.objects.KeyboardView;
import com.mygdx.game.objects.MonitorView;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
import com.mygdx.game.view.TextView;

import java.util.Random;

public class GameScreen extends ScreenAdapter {

    public static Sprite[] animateArray;

    public static Sprite animateTexture1;
    public static Sprite animateTexture2;
    public static Sprite animateTexture3;

    private int MSeconds;

    GameSession gameSession;
    ButtonView exitButton;

    public KeyboardView keyboardView;

    MyGdxGame myGdxGame;

    TextView scoreTextView;

    ButtonView shopButton;
    ButtonView settingsButton;
    public boolean goldBanner;
    public int playerLevel = 1;
    private short clickForMonitor = 0;
    private int score = 0;
    public int coins = 0;
    private int perClick = 1;
    private int perSecond = 10;

    TextView passiveTextView;
    TextView incomeTextView;
    TextView perSecondView;


    TextView clickTextView;
    TextView perTextView;
    TextView perClickText;

    TextView coinsView;
    TextView playerText;
    TextView levelText;
    TextView playerLevelView;
    TextView needScoreView;

    private int coinsFor10Click;
    private int counter = 0;
    private int priceOfPerClick;
    private int priceOfPerSecond;

    TextView priceOfPerClickText;
    TextView priceOfPerSecondText;
    TextView maxText;


    ButtonView upgradeButtonView;
    ButtonView upgradeButtonView2;


    private int needScore;
    private int MLevel;
    public int KLevel;
    private int CLevel;

    public GameScreen(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;
        gameSession = new GameSession();

        keyboardView = new KeyboardView(-65,150,850,550);
        upgradeButtonView = new ButtonView(310,-100,400,600);
        upgradeButtonView2 = new ButtonView(-10,-100,400,600);

        needScoreView = new TextView(myGdxGame.fontWhiteSmall,600,1150);
        scoreTextView = new TextView(myGdxGame.fontWhiteSmall, 465,1150);
        playerLevelView = new TextView(myGdxGame.fontWhite,360,1180);
        coinsView = new TextView(myGdxGame.fontWhiteSmall,595,1035);
        maxText = new TextView(myGdxGame.fontWhite,580,975,"MAX!");

        exitButton = new ButtonView(-10,1080,180,200);
        settingsButton = new ButtonView(10, 700, 110,110);
        shopButton = new ButtonView(600, 700, 110,110);

        perSecondView = new TextView(myGdxGame.fontWhite,160,180);
        passiveTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,145,"Passive");
        incomeTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,120,"Income");

        playerText = new TextView(myGdxGame.fontWhiteSmall,480,1230,"Player");
        levelText = new TextView(myGdxGame.fontWhiteSmall,495,1195,"Level");
        perClickText = new TextView(myGdxGame.fontWhite,495,180);
        perTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,145,"Per");
        clickTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,120,"Click");



        priceOfPerSecondText = new TextView(myGdxGame.fontWhiteSmall,165,58);
        priceOfPerClickText = new TextView(myGdxGame.fontWhiteSmall,500,58);


    }
    @Override
    public void show(){
        if (KLevel == 0){
            MemoryManager.saveKeyboardLevel(1);
        }
        if(MLevel == 0){
            MemoryManager.saveMonitorLevel(1);
        }
        if(CLevel == 0){
            MemoryManager.saveComputerLevel(1);
        }
        if(playerLevel == 0){
            MemoryManager.savePlayerLevel(1);
        }
        if (perSecond == 0){
            MemoryManager.savePerSecond(10);
        }
        if (perClick == 0){
            MemoryManager.savePerClick(1);
        }
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor11");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor12");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor13");
                break;
            case 2:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor21");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor22");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor23");
                break;
            case 3:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor31");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor32");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor33");
                break;
            case 4:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor41");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor42");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor43");
                break;
            case 5:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor51");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor52");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor53");
                break;
            default:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor11");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor12");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor13");
        }
        animateTexture1.setPosition(220, 450);
        animateTexture1.setSize(500, 700);

        animateTexture2.setPosition(220, 450);
        animateTexture2.setSize(500, 700);

        animateTexture3.setPosition(220, 450);
        animateTexture3.setSize(500, 700);

        animateArray = new Sprite[]{
                animateTexture1,
                animateTexture2,
                animateTexture3
        };

        switch (KLevel){
            case 1:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard1");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
            case 2:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard2");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
            case 3:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard3");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
            case 4:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard4");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
            case 5:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard5");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
            default:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard1");
                myGdxGame.keyBoard.setPosition(-65,150);
                myGdxGame.keyBoard.setSize(850,550);

                break;
        }
        switch (CLevel){
            case 1:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc1");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
            case 2:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc2");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
            case 3:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc3");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
            case 4:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc4");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
            case 5:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc5");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
            default:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc1");
                myGdxGame.computer.setPosition(-39,420);
                myGdxGame.computer.setSize(500,800);
                break;
        }


        myGdxGame.banner.setPosition(100,990);
        myGdxGame.banner.setSize(800,400);

        myGdxGame.coinsBanner.setPosition(480,980);
        myGdxGame.coinsBanner.setSize(250,130);

        myGdxGame.shop.setPosition(600, 700);
        myGdxGame.shop.setSize(110,110);

        myGdxGame.settings.setPosition(10, 700);
        myGdxGame.settings.setSize(110,110);

        myGdxGame.exit.setPosition(-10,1080);
        myGdxGame.exit.setSize(180,200);

        myGdxGame.price1.setPosition(390,0);
        myGdxGame.price1.setSize(250,150);

        myGdxGame.price2.setPosition(70,0);
        myGdxGame.price2.setSize(250,150);

        myGdxGame.coin1.setPosition(440,173);
        myGdxGame.coin1.setSize(55,50);

        myGdxGame.coin2.setPosition(110,173);
        myGdxGame.coin2.setSize(55,50);

        myGdxGame.coin3.setPosition(440,48);
        myGdxGame.coin3.setSize(55,50);

        gameSession.startGame();


    }
    @Override
    public void render(float delta) {



        KLevel = MemoryManager.loadKeyboardLevel();
        MLevel =MemoryManager.loadMonitorLevel();
        CLevel = MemoryManager.loadComputerLevel();

        playerLevel = MemoryManager.loadPlayerLevel();
        goldBanner = MemoryManager.loadGoldBanner();
        score = MemoryManager.loadScore();

        needScore = (playerLevel+1)*200;
        coins = MemoryManager.loadCoins();
        perClick = MemoryManager.loadPerClick();
        perSecond = MemoryManager.loadPerSecond();
        priceOfPerSecond = (perSecond-8)*100;
        priceOfPerClick = (perClick+1)*100;
        MSeconds = MemoryManager.loadMSeconds();



        if(MSeconds==0) MemoryManager.saveMSeconds(5000);
        switch (KLevel){
            case 1: coinsFor10Click = 0; break;
            case 2: coinsFor10Click = 20; break;
            case 3: coinsFor10Click = 30; break;
            case 4: coinsFor10Click = 40; break;
            case 5: coinsFor10Click = 50; break;
        }

        if(goldBanner){
            myGdxGame.banner = myGdxGame.textureAtlas.createSprite("banners/Gold banner");

            myGdxGame.banner.setPosition(100,990);
            myGdxGame.banner.setSize(800,400);
        }else {
            myGdxGame.banner = myGdxGame.textureAtlas.createSprite("banners/banner");

            myGdxGame.banner.setPosition(100,990);
            myGdxGame.banner.setSize(800,400);
        }

        switch (MLevel){
            case 1: MemoryManager.saveMSeconds(5000); break;
            case 2: MemoryManager.saveMSeconds(4000); break;
            case 3: MemoryManager.saveMSeconds(3000); break;
            case 4: MemoryManager.saveMSeconds(2000); break;
            case 5: MemoryManager.saveMSeconds(1000); break;
        }
        if(gameSession.shouldGiveMoney() && coins <= 9990){
            coins += perSecond;
            MemoryManager.saveCoins(coins);
        }
        if (score >= needScore){
            playerLevel += 1;
            MemoryManager.savePlayerLevel(playerLevel);
            MemoryManager.saveScore(0);
        }
        handleInput();


        priceOfPerSecondText.setText(""+ priceOfPerSecond);
        priceOfPerClickText.setText(""+ priceOfPerClick);
        perSecondView.setText(""+ perSecond);
        perClickText.setText(""+ perClick);
        coinsView.setText(""+ coins);
        needScoreView.setText(""+ needScore);
        playerLevelView.setText(""+ playerLevel);
        scoreTextView.setText("" + score);

        draw();

    }
    private void handleInput(){
        if (Gdx.input.justTouched()){
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if(keyboardView.isKeyboardHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                Random r = new Random();
                int randomClick = r.nextInt(3);
                if (randomClick == 1) {
                    if(myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.clickSound1.play();
                } else if (randomClick == 2) {
                    if(myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.clickSound2.play();
                } else{
                    if(myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.clickSound3.play();
                }

                if (counter == 10){
                    coins += coinsFor10Click;
                    counter = 0;
                }
                if(coins <= 9990){
                    coins += perClick;
                }
                score += 1;

                clickForMonitor += 1;
                if(clickForMonitor >= 3){
                    clickForMonitor = 0;
                }
                counter += 1;
                MemoryManager.saveCoins(coins);
                MemoryManager.saveScore(score);

            }
            if(upgradeButtonView.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perClick <= 9 && coins >= priceOfPerClick){
                perClick += 1;
                MemoryManager.savePerClick(perClick);
                coins -= priceOfPerClick;
                MemoryManager.saveCoins(coins);

                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
            }
            if(upgradeButtonView2.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perSecond <= 19 && coins >= priceOfPerSecond ){
                perSecond += 1;
                MemoryManager.savePerSecond(perSecond);
                coins -= priceOfPerSecond;
                MemoryManager.saveCoins(coins);
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
            }

            if(exitButton.isHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                Gdx.app.exit();
            }
            if(settingsButton.isHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.settingsScreen);
            }
            if(shopButton.isHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
                myGdxGame.setScreen(myGdxGame.shopScreen);
            }
        }
        if (perSecond == 20){
            myGdxGame.upgradeButton2 = myGdxGame.textureAtlas.createSprite("msupgrade max");
        } else {
            myGdxGame.upgradeButton2 = myGdxGame.textureAtlas.createSprite("Ms upgrade");
        }
        if (perClick == 10){
            myGdxGame.upgradeButton1 = myGdxGame.textureAtlas.createSprite("msupgrade max");
        }else {
            myGdxGame.upgradeButton1 = myGdxGame.textureAtlas.createSprite("Ms upgrade");
        }
        myGdxGame.upgradeButton1.setPosition(310,-100);
        myGdxGame.upgradeButton1.setSize(400,600);

        myGdxGame.upgradeButton2.setPosition(-10,-100);
        myGdxGame.upgradeButton2.setSize(400,600);




    }
    private void draw(){

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        myGdxGame.backGround.draw(myGdxGame.batch);

        myGdxGame.computer.draw(myGdxGame.batch);
        myGdxGame.keyBoard.draw(myGdxGame.batch);

        animateArray[clickForMonitor].draw(myGdxGame.batch);

        myGdxGame.upgradeButton2.draw(myGdxGame.batch);
        myGdxGame.upgradeButton1.draw(myGdxGame.batch);
        perSecondView.draw(myGdxGame.batch);
        passiveTextView.draw(myGdxGame.batch);
        incomeTextView.draw(myGdxGame.batch);
        perClickText.draw(myGdxGame.batch);
        perTextView.draw(myGdxGame.batch);
        clickTextView.draw(myGdxGame.batch);
        myGdxGame.coin1.draw(myGdxGame.batch);
        myGdxGame.coin2.draw(myGdxGame.batch);

        if (perSecond != 20){
            myGdxGame.price2.draw(myGdxGame.batch);
            priceOfPerSecondText.draw(myGdxGame.batch);
            myGdxGame.coin4.draw(myGdxGame.batch);
        }
        if (perClick != 10){
            myGdxGame.price1.draw(myGdxGame.batch);
            myGdxGame.coin3.draw(myGdxGame.batch);
            priceOfPerClickText.draw(myGdxGame.batch);
        }



        myGdxGame.banner.draw(myGdxGame.batch);
        myGdxGame.coinsBanner.draw(myGdxGame.batch);
        coinsView.draw(myGdxGame.batch);
        scoreTextView.draw(myGdxGame.batch);
        playerLevelView.draw(myGdxGame.batch);
        needScoreView.draw(myGdxGame.batch);

        myGdxGame.exit.draw(myGdxGame.batch);
        myGdxGame.settings.draw(myGdxGame.batch);
        myGdxGame.shop.draw(myGdxGame.batch);

        playerText.draw(myGdxGame.batch);
        levelText.draw(myGdxGame.batch);


        if(coins >= 9990){
            maxText.draw(myGdxGame.batch);
        }

        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
        keyboardView.dispose();

        perSecondView.dispose();
        passiveTextView.dispose();
        incomeTextView.dispose();
        perClickText.dispose();
        perTextView.dispose();
        clickTextView.dispose();

        priceOfPerSecondText.dispose();
        priceOfPerClickText.dispose();
        coinsView.dispose();
        scoreTextView.dispose();
        playerLevelView.dispose();
        needScoreView.dispose();

        exitButton.dispose();
        settingsButton.dispose();
        shopButton.dispose();

        playerText.dispose();
        levelText.dispose();
    }

}
