package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSession;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.objects.ComputerView;
import com.mygdx.game.objects.KeyboardView;
import com.mygdx.game.objects.MonitorView;
import com.mygdx.game.view.BackgroundView;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.ImageView;
import com.mygdx.game.view.TextView;

import java.util.Random;

public class GameScreen extends ScreenAdapter {
    MonitorView monitorView;
    private int MSeconds;

    GameSession gameSession;
    ButtonView exitButton;
    ImageView banner;
    ImageView coinsBanner;

    ImageView MUpgradeImage;
    ImageView KUpgradeImage;
    ImageView CUpgradeImage;

    ComputerView computerView;
    public KeyboardView keyboardView;
    BackgroundView backgroundView;
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

    ImageView coinView;
    ImageView coinView2;
    ImageView coinView3;
    ImageView coinView4;



    TextView coinsView;
    TextView playerText;
    TextView levelText;
    TextView playerLevelView;
    TextView needScoreView;

    private int coinsFor10Click;
    private int counter = 0;
    private int priceOfPerClick;
    private int priceOfPerSecond;

    ImageView priceBanner;
    ImageView priceBanner2;
    TextView priceOfPerClickText;
    TextView priceOfPerSecondText;


    ButtonView upgradeButtonView;
    ButtonView upgradeButtonView2;


    private int needScore;
    private short a = 0;
    private int MLevel = 1;
    private int KLevel = 1;
    private int CLevel = 1;

    public GameScreen(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;





        gameSession = new GameSession();

        backgroundView = new BackgroundView(GameResources.BACKGROUND_IMG_PATH);

        monitorView = new MonitorView(220, 450, 500, 700);
//        computerView = new ComputerView(-39,420,500,800);
        keyboardView = new KeyboardView(-65,150,850,550);
        upgradeButtonView = new ButtonView(310,-100,400,600);
        upgradeButtonView2 = new ButtonView(-10,-100,400,600);

        needScoreView = new TextView(myGdxGame.fontWhiteSmall,600,1150);
        scoreTextView = new TextView(myGdxGame.fontWhiteSmall, 465,1150);
        playerLevelView = new TextView(myGdxGame.fontWhite,360,1180);
        coinsView = new TextView(myGdxGame.fontWhiteSmall,595,1035);

        banner = new ImageView(100,990,800,400,GameResources.BANNER_PATH);
        coinsBanner = new ImageView(480,980,250,130,GameResources.COINS_PATH);
        MUpgradeImage = new ImageView(480,780,250,130,GameResources.UPGRADE_EFFECT_PATH);
        KUpgradeImage = new ImageView(360,680,250,130,GameResources.UPGRADE_EFFECT_PATH);
        CUpgradeImage = new ImageView(280,780,250,130,GameResources.UPGRADE_EFFECT_PATH);

        exitButton = new ButtonView(-10,1080,180,200,GameResources.EXIT_BUTTON_PATH);
        settingsButton = new ButtonView(10, 700, 110,110, GameResources.BUTTON_SETTINGS);
        shopButton = new ButtonView(600, 700, 110,110, GameResources.BUTTON_SHOP);


        perSecondView = new TextView(myGdxGame.fontWhite,160,180);
        passiveTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,145,"Passive");
        incomeTextView = new TextView(myGdxGame.fontWhiteVerySmall,140,120,"Income");

        playerText = new TextView(myGdxGame.fontWhiteSmall,480,1230,"Player");
        levelText = new TextView(myGdxGame.fontWhiteSmall,495,1195,"Level");
        perClickText = new TextView(myGdxGame.fontWhite,495,180);
        perTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,145,"Per");
        clickTextView = new TextView(myGdxGame.fontWhiteVerySmall,455,120,"Click");

        coinView = new ImageView(440,173,55,50,GameResources.COIN_PATH);
        coinView2 = new ImageView(110,173,55,50,GameResources.COIN_PATH);
        coinView3 = new ImageView(440,48,55,50,GameResources.COIN_PATH);
        coinView4 = new ImageView(110,48,55,50,GameResources.COIN_PATH);

        priceBanner = new ImageView(390,0,250,150,GameResources.PRICE_PATH);
        priceBanner2 = new ImageView(70,0,250,150,GameResources.PRICE_PATH);


        priceOfPerSecondText = new TextView(myGdxGame.fontWhiteSmall,165,58);
        priceOfPerClickText = new TextView(myGdxGame.fontWhiteSmall,500,58);


    }
    @Override
    public void show(){
        gameSession.startGame();
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

    }
    @Override
    public void render(float delta) {
        switch (KLevel){
            case 1:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard1");
                break;
            case 2:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard2");
                break;
            case 3:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard3");
                break;
            case 4:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard4");
                break;
            case 5:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard5");
                break;
            default:
                myGdxGame.keyBoard = myGdxGame.textureAtlas.createSprite("keyboard/Main screen/keyboard1");
                break;
        }
        switch (CLevel){
            case 1:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc1");
                break;
            case 2:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc2");
                break;
            case 3:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc3");
                break;
            case 4:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc4");
                break;
            case 5:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc5");
                break;
            default:
                myGdxGame.computer = myGdxGame.textureAtlas.createSprite("PC/Main screen/pc1");
                break;
        }


        myGdxGame.keyBoard.setPosition(-65,150);
        myGdxGame.keyBoard.setSize(850,550);

        myGdxGame.computer.setPosition(-39,420);
        myGdxGame.computer.setSize(500,800);



        if (clickForMonitor == 0){
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
        }


        if(MSeconds==0) MemoryManager.saveMSeconds(5000);
        switch (KLevel){
            case 1: coinsFor10Click = 0; break;
            case 2: coinsFor10Click = 20; break;
            case 3: coinsFor10Click = 30; break;
            case 4: coinsFor10Click = 40; break;
            case 5: coinsFor10Click = 50; break;
        }

        if(goldBanner){
            GameResources.BANNER_PATH = "textures/banners/Gold banner.png";
        }else {
            GameResources.BANNER_PATH = "textures/banners/banner.png";
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
        switch (MLevel){
            case 1: MemoryManager.saveMSeconds(5000); break;
            case 2: MemoryManager.saveMSeconds(4000); break;
            case 3: MemoryManager.saveMSeconds(3000); break;
            case 4: MemoryManager.saveMSeconds(2000); break;
            case 5: MemoryManager.saveMSeconds(1000); break;
        }
        if(gameSession.shouldGiveMoney()){
            coins += perSecond;
            MemoryManager.saveCoins(coins);
        }
        if (score >= needScore){
            playerLevel += 1;
            MemoryManager.savePlayerLevel(playerLevel);
            MemoryManager.saveScore(0);
        }
        handleInput();

        banner.setImage(GameResources.BANNER_PATH);
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
                if(MemoryManager.loadCoins() <= 9990){
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
            upgradeButtonView2.setImage(GameResources.UPGRADE_BUTTON_FINAL);
        } else {
            upgradeButtonView2.setImage(GameResources.UPGRADE_BUTTON_1);
        }
        if (perClick == 10){
            upgradeButtonView.setImage(GameResources.UPGRADE_BUTTON_FINAL);
        }else {
            upgradeButtonView.setImage(GameResources.UPGRADE_BUTTON_1);
        }




    }
    private void draw(){

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();

        backgroundView.draw(myGdxGame.batch);

        monitorView.draw(myGdxGame.batch,clickForMonitor);
//        computerView.draw(myGdxGame.batch);

        myGdxGame.computer.draw(myGdxGame.batch);
        myGdxGame.keyBoard.draw(myGdxGame.batch);
//        keyboardView.draw(myGdxGame.batch);

        upgradeButtonView2.draw(myGdxGame.batch);
        upgradeButtonView.draw(myGdxGame.batch);
        perSecondView.draw(myGdxGame.batch);
        passiveTextView.draw(myGdxGame.batch);
        incomeTextView.draw(myGdxGame.batch);
        perClickText.draw(myGdxGame.batch);
        perTextView.draw(myGdxGame.batch);
        clickTextView.draw(myGdxGame.batch);
        coinView.draw(myGdxGame.batch);
        coinView2.draw(myGdxGame.batch);

        if (perSecond != 20){
            priceBanner2.draw(myGdxGame.batch);
            priceOfPerSecondText.draw(myGdxGame.batch);
            coinView4.draw(myGdxGame.batch);
        }
        if (perClick != 10){
            priceBanner.draw(myGdxGame.batch);
            coinView3.draw(myGdxGame.batch);
            priceOfPerClickText.draw(myGdxGame.batch);
        }


        banner.draw(myGdxGame.batch);
        coinsBanner.draw(myGdxGame.batch);
        coinsView.draw(myGdxGame.batch);
        scoreTextView.draw(myGdxGame.batch);
        playerLevelView.draw(myGdxGame.batch);
        needScoreView.draw(myGdxGame.batch);

        exitButton.draw(myGdxGame.batch);
        settingsButton.draw(myGdxGame.batch);
        shopButton.draw(myGdxGame.batch);

        playerText.draw(myGdxGame.batch);
        levelText.draw(myGdxGame.batch);




        myGdxGame.batch.end();
    }
    @Override
    public void dispose(){
        backgroundView.dispose();
        monitorView.dispose();
        computerView.dispose();
        keyboardView.dispose();

        upgradeButtonView2.dispose();
        upgradeButtonView.dispose();
        perSecondView.dispose();
        passiveTextView.dispose();
        incomeTextView.dispose();
        perClickText.dispose();
        perTextView.dispose();
        clickTextView.dispose();
        coinView.dispose();
        coinView2.dispose();
        coinView3.dispose();
        coinView4.dispose();

        priceBanner2.dispose();
        priceBanner.dispose();
        priceOfPerSecondText.dispose();
        priceOfPerClickText.dispose();
        banner.dispose();
        coinsBanner.dispose();
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
