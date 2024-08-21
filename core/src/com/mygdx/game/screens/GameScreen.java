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

    TextView waterMark;

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

    public static int coinsFor10Click;
    private int counter = 0;
    private int priceOfPerClick;
    private int priceOfPerSecond;
    int perSecondLevel;

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

        needScoreView = new TextView(myGdxGame.fontWhiteSmall,550,1410);
        scoreTextView = new TextView(myGdxGame.fontWhiteSmall, 300,1410);
        playerLevelView = new TextView(myGdxGame.fontWhite,290,1440);
        coinsView = new TextView(myGdxGame.fontWhiteSmall,565,1285);
        maxText = new TextView(myGdxGame.fontWhite,580,1210,"MAX!");

        exitButton = new ButtonView(-10,1340,200,210);
        settingsButton = new ButtonView(10, 700, 110,110);
        shopButton = new ButtonView(600, 700, 110,110);

        waterMark = new TextView(myGdxGame.waterMark,0,0,"kyber alliance");

        perSecondView = new TextView(myGdxGame.fontWhite,160,180);
        passiveTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,145,"Passive");
        incomeTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,120,"Income");

        playerText = new TextView(myGdxGame.fontWhiteSmall,480,1490,"Player");
        levelText = new TextView(myGdxGame.fontWhiteSmall,495,1455,"Level");
        perClickText = new TextView(myGdxGame.fontWhite,495,180);
        perTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,145,"Per");
        clickTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,120,"Click");



        priceOfPerSecondText = new TextView(myGdxGame.fontWhiteBtw,130,58);
        priceOfPerClickText = new TextView(myGdxGame.fontWhiteBtw,450,58);


    }
    @Override
    public void show(){
        KLevel = MemoryManager.loadKeyboardLevel();
        MLevel =MemoryManager.loadMonitorLevel();
        CLevel = MemoryManager.loadComputerLevel();

        playerLevel = MemoryManager.loadPlayerLevel();
        goldBanner = MemoryManager.loadGoldBanner();
        score = MemoryManager.loadScore();

        needScore = (playerLevel+1)*110;
        coins = MemoryManager.loadCoins();
        perClick = MemoryManager.loadPerClick();
        perSecond = MemoryManager.loadPerSecond();
        perSecondLevel = perSecond/5;
        priceOfPerSecond = (perSecondLevel+1)*100;
        priceOfPerClick = (perClick+1)*100;

        MSeconds = MemoryManager.loadMSeconds();

        if(playerLevel >= 2 && playerLevel < 10){
            playerLevelView.setPosition(305,1440);
        } else if (playerLevel == 20) {
            playerLevelView.setPosition(290,1440);
        } else if (playerLevel == 11) {
            playerLevelView.setPosition(300,1440);
        } else if (playerLevel == 1) {
            playerLevelView.setPosition(315,1440);
        } else {
            playerLevelView.setPosition(295,1440);
        }
        if(goldBanner){
            myGdxGame.banner = myGdxGame.textureAtlas.createSprite("Gold banner");

            myGdxGame.banner.setPosition(50,1250);
            myGdxGame.banner.setSize(800,400);
        }else {
            myGdxGame.banner = myGdxGame.textureAtlas.createSprite("banner");

            myGdxGame.banner.setPosition(50,1250);
            myGdxGame.banner.setSize(800,400);
        }
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
            MemoryManager.savePerSecond(5);
        }
        if (perClick == 0){
            MemoryManager.savePerClick(1);
        }
        if(MemoryManager.loadMonitorLevel() < 5){
            animateTexture1 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor11");
            animateTexture2 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor12");
            animateTexture3 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor13");
        } else if (MemoryManager.loadMonitorLevel() >= 5 && MemoryManager.loadMonitorLevel() < 10) {
            animateTexture1 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor21");
            animateTexture2 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor22");
            animateTexture3 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor23");
        }else if (MemoryManager.loadMonitorLevel() >= 10 && MemoryManager.loadMonitorLevel() < 15){
            animateTexture1 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor31");
            animateTexture2 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor32");
            animateTexture3 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor33");
        }else if (MemoryManager.loadMonitorLevel() >= 15 && MemoryManager.loadMonitorLevel() < 20){
            animateTexture1 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor41");
            animateTexture2 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor42");
            animateTexture3 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor43");
        }else {
            animateTexture1 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor51");
            animateTexture2 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor52");
            animateTexture3 = MyGdxGame.textureAtlas.createSprite("Main screen/monitor53");
        }

        animateTexture1.setPosition(220, 500);
        animateTexture1.setSize(500, 700);

        animateTexture2.setPosition(220, 500);
        animateTexture2.setSize(500, 700);

        animateTexture3.setPosition(220, 500);
        animateTexture3.setSize(500, 700);

        animateArray = new Sprite[]{
                animateTexture1,
                animateTexture2,
                animateTexture3
        };
        if(KLevel < 5){
            myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("Main screen/keyboard1");
        } else if (KLevel >= 5 && KLevel < 10) {
            myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("Main screen/keyboard2");
        }else if (KLevel >= 10 && KLevel < 15){
            myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("Main screen/keyboard3");
        }else if (KLevel >= 15 && KLevel < 20){
            myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("Main screen/keyboard4");
        }else {
            myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("Main screen/keyboard5");
        }

        if(CLevel < 5){
            myGdxGame.computer = myGdxGame.textureAtlas.createSprite("Main screen/pc1");
        }else if (CLevel >= 5 && CLevel < 10) {
            myGdxGame.computer = myGdxGame.textureAtlas.createSprite("Main screen/pc2");
        }else if (CLevel >= 10 && CLevel < 15){
            myGdxGame.computer = myGdxGame.textureAtlas.createSprite("Main screen/pc3");
        }else if (CLevel >= 15 && CLevel < 20){
            myGdxGame.computer = myGdxGame.textureAtlas.createSprite("Main screen/pc4");
        }else {
            myGdxGame.computer = myGdxGame.textureAtlas.createSprite("Main screen/pc5");
        }
        switch (MLevel){
            case 1: MemoryManager.saveMSeconds(25000); break;
            case 2: MemoryManager.saveMSeconds(24000); break;
            case 3: MemoryManager.saveMSeconds(23000); break;
            case 4: MemoryManager.saveMSeconds(22000); break;
            case 5: MemoryManager.saveMSeconds(21000); break;
            case 6: MemoryManager.saveMSeconds(20000); break;
            case 7: MemoryManager.saveMSeconds(19000); break;
            case 8: MemoryManager.saveMSeconds(18000); break;
            case 9: MemoryManager.saveMSeconds(17000); break;
            case 10: MemoryManager.saveMSeconds(16000); break;
            case 11: MemoryManager.saveMSeconds(15000); break;
            case 12: MemoryManager.saveMSeconds(14000); break;
            case 13: MemoryManager.saveMSeconds(13000); break;
            case 14: MemoryManager.saveMSeconds(12000); break;
            case 15: MemoryManager.saveMSeconds(11000); break;
            case 16: MemoryManager.saveMSeconds(10000); break;
            case 17: MemoryManager.saveMSeconds(9000); break;
            case 18: MemoryManager.saveMSeconds(8000); break;
            case 19: MemoryManager.saveMSeconds(7000); break;
            case 20: MemoryManager.saveMSeconds(6000); break;
        }

        coinsFor10Click = KLevel * 2;

        myGdxGame.computer.setPosition(-70,550);
        myGdxGame.computer.setSize(500,800);

        myGdxGame.keyBoard.setPosition(-65,220);
        myGdxGame.keyBoard.setSize(850,550);

        myGdxGame.coinsBanner.setPosition(420,1220);
        myGdxGame.coinsBanner.setSize(330,150);

        myGdxGame.shop.setPosition(600, 700);
        myGdxGame.shop.setSize(110,110);

        myGdxGame.settings.setPosition(10, 700);
        myGdxGame.settings.setSize(110,110);

        myGdxGame.exit.setPosition(-10,1340);
        myGdxGame.exit.setSize(200,210);

        myGdxGame.price1.setPosition(390,0);
        myGdxGame.price1.setSize(250,150);

        myGdxGame.price2.setPosition(70,0);
        myGdxGame.price2.setSize(250,150);

        myGdxGame.coin1.setPosition(440,173);
        myGdxGame.coin1.setSize(55,50);

        myGdxGame.coin2.setPosition(110,173);
        myGdxGame.coin2.setSize(55,50);

        myGdxGame.coin3.setPosition(535,43);
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

        needScore = (playerLevel+1)*110;
        coins = MemoryManager.loadCoins();
        perClick = MemoryManager.loadPerClick();
        perSecond = MemoryManager.loadPerSecond();
        perSecondLevel = perSecond/5;
        priceOfPerSecond = (perSecondLevel+1)*100;
        priceOfPerClick = (perClick+1)*100;
        MSeconds = MemoryManager.loadMSeconds();

        if(MSeconds==0) MemoryManager.saveMSeconds(5000);

        if(gameSession.shouldGiveMoney() && coins + perSecond <= 99999){
            coins += perSecond;
            MemoryManager.saveCoins(coins);
        } else if (coins + perSecond > 99999) {
            coins = 99999;
            MemoryManager.saveCoins(coins);
        }
        if (score >= needScore){
            playerLevel += 1;
            MemoryManager.savePlayerLevel(playerLevel);
            MemoryManager.saveScore(0);
        }
        handleInput();

        if(score < 100){
            scoreTextView.setPosition(445,1410);
        } else if (score >= 100 && score < 1000) {
            scoreTextView.setPosition(425,1410);
        } else if (score >= 1000) {
            scoreTextView.setPosition(405,1410);
        }


        priceOfPerSecondText.setText(""+ priceOfPerSecond);
        priceOfPerClickText.setText(""+ priceOfPerClick);
        perSecondView.setText(""+ perSecond);
        perClickText.setText(""+ perClick);
        coinsView.setText(""+ coins);
        if (playerLevel == 20){
            needScoreView.setText("max!");
        } else{
            needScoreView.setText(""+ needScore);
        }

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

                if (counter == 9 && coins + coinsFor10Click <= 99999){
                    coins += coinsFor10Click;
                    counter = 0;
                }
                if(coins + perClick <= 99999){
                    coins += perClick;
                } else {
                    coins = 99999;
                }
                if (MemoryManager.loadPlayerLevel() < 20) {
                    score += 1;
                }

                clickForMonitor += 1;
                if(clickForMonitor >= 3){
                    clickForMonitor = 0;
                }
                counter += 1;
                MemoryManager.saveCoins(coins);
                MemoryManager.saveScore(score);

            }
            if(upgradeButtonView.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perClick <= 19 && coins >= priceOfPerClick){
                perClick += 1;
                MemoryManager.savePerClick(perClick);
                coins -= priceOfPerClick;
                MemoryManager.saveCoins(coins);

                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
            }
            if(upgradeButtonView2.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perSecondLevel <= 19 && coins >= priceOfPerSecond ){
                perSecond += 5;
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
        if (perSecond == 100){
            myGdxGame.upgradeButton2 = myGdxGame.textureAtlas.createSprite("msupgrade max");
        } else {
            myGdxGame.upgradeButton2 = myGdxGame.textureAtlas.createSprite("Ms upgrade");
        }
        if (perClick == 20){
            myGdxGame.upgradeButton1 = myGdxGame.textureAtlas.createSprite("msupgrade max");
        }else {
            myGdxGame.upgradeButton1 = myGdxGame.textureAtlas.createSprite("Ms upgrade");
        }
        if(coins > 99999){
            MemoryManager.saveCoins(99999);
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


        animateArray[clickForMonitor].draw(myGdxGame.batch);
        myGdxGame.keyBoard.draw(myGdxGame.batch);
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

        if (perSecond != 100){

            myGdxGame.price2.draw(myGdxGame.batch);
            priceOfPerSecondText.draw(myGdxGame.batch);

            myGdxGame.coin4.draw(myGdxGame.batch);
        }
        if (perClick != 20){


            myGdxGame.price1.draw(myGdxGame.batch);
            priceOfPerClickText.draw(myGdxGame.batch);
            myGdxGame.coin3.draw(myGdxGame.batch);
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


        if(coins == 99999){
            maxText.draw(myGdxGame.batch);
        }
        waterMark.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
        waterMark.dispose();
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
