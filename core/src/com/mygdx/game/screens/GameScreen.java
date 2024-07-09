package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
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
    GameSession gameSession;
    ButtonView exitButton;
    ImageView banner;
    ImageView coinsBanner;

    ImageView MUpgradeImage;
    ImageView KUpgradeImage;
    ImageView CUpgradeImage;

    ComputerView computerView;
    MonitorView monitorView;
    public KeyboardView keyboardView;
    BackgroundView backgroundView;
    MyGdxGame myGdxGame;

    TextView scoreTextView;

    ButtonView shopButton;
    ButtonView settingsButton;
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

    private int priceOfPerClick;
    private int priceOfPerSecond;

    ImageView priceBanner;
    ImageView priceBanner2;
    TextView priceOfPerClickText;
    TextView priceOfPerSecondText;


    ButtonView upgradeButtonView;
    ButtonView upgradeButtonView2;


    private int needScore;

    private int MLevel = 1;
    private int KLevel = 1;
    private int CLevel = 1;

    public GameScreen(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;
        gameSession = new GameSession();

        backgroundView = new BackgroundView(GameResources.BACKGROUND_IMG_PATH);

        computerView = new ComputerView(-40,420,500,800);
        keyboardView = new KeyboardView(-65,150,850,550);
        monitorView = new MonitorView(220, 450, 500, 700 );
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
        score = MemoryManager.loadScore();
        priceOfPerSecond = (MemoryManager.loadPerSecond()-8)*100;
        priceOfPerClick = (MemoryManager.loadPerClick()+1)*100;
        needScore = (MemoryManager.loadPlayerLevel()+1)*200;
        coins = MemoryManager.loadCoins();
        perClick = MemoryManager.loadPerClick();
        perSecond = MemoryManager.loadPerSecond();



    }
    @Override
    public void render(float delta) {
        if(MemoryManager.loadGoldBanner()){
            GameResources.BANNER_PATH = "textures/banners/Gold banner.png";
        }else {
            GameResources.BANNER_PATH = "textures/banners/banner.png";
        }
        if (MemoryManager.loadPerSecond() == 0){
            MemoryManager.savePerSecond(10);
            perSecond = MemoryManager.loadPerSecond();
            priceOfPerSecond = (MemoryManager.loadPerSecond()-8)*100;
        }
        if (MemoryManager.loadPerClick() == 0){
            MemoryManager.savePerClick(1);
            perClick = MemoryManager.loadPerClick();
            priceOfPerClick = (MemoryManager.loadPerClick()+1)*100;
        }
        switch (MemoryManager.loadMonitorLevel()){
            case 1: MemoryManager.saveMSeconds(5000); break;
            case 2: MemoryManager.saveMSeconds(4000); break;
            case 3: MemoryManager.saveMSeconds(3000); break;
            case 4: MemoryManager.saveMSeconds(2000); break;
            case 5: MemoryManager.saveMSeconds(1000); break;
        }
        if(gameSession.shouldGiveMoney()){
            coins = MemoryManager.loadCoins() + perSecond;
            MemoryManager.saveCoins(coins);
        }
        if (score >= needScore){
            playerLevel = MemoryManager.loadPlayerLevel() + 1;
            MemoryManager.savePlayerLevel(playerLevel);
            needScore = (MemoryManager.loadPlayerLevel()+1)*200;
            MemoryManager.saveScore(0);
        }
        randomizerSound();
        handleInput();

        banner.setImage(GameResources.BANNER_PATH);
        priceOfPerSecondText.setText(""+ priceOfPerSecond);
        priceOfPerClickText.setText(""+ priceOfPerClick);
        perSecondView.setText(""+ MemoryManager.loadPerSecond());
        perClickText.setText(""+ MemoryManager.loadPerClick());
        coinsView.setText(""+ MemoryManager.loadCoins());
        needScoreView.setText(""+ needScore);
        playerLevelView.setText(""+ MemoryManager.loadPlayerLevel());
        scoreTextView.setText("" + MemoryManager.loadScore());

        myGdxGame.stepWorld();
        draw();

    }
    private void handleInput(){
        if (Gdx.input.justTouched()){
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if(keyboardView.isKeyboardHit(myGdxGame.touch.x,myGdxGame.touch.y)){
                if(myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.clickSound.play();
                if(MemoryManager.loadCoins() <= 9990){
                    coins = MemoryManager.loadCoins() + perClick;
                    MemoryManager.saveCoins(coins);
                }
                score = MemoryManager.loadScore() + 1;
                MemoryManager.saveScore(score);
                clickForMonitor += 1;
                if(clickForMonitor >= 3){
                    clickForMonitor = 0;
                }
            }
            if(upgradeButtonView.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perClick <= 9 && MemoryManager.loadCoins() >= priceOfPerClick){
                perClick = MemoryManager.loadPerClick() + 1;
                MemoryManager.savePerClick(perClick);
                coins = MemoryManager.loadCoins() - priceOfPerClick;
                MemoryManager.saveCoins(coins);
                priceOfPerClick = (MemoryManager.loadPerClick()+1)*100;
                if (myGdxGame.audioManager.isSoundOn) myGdxGame.audioManager.uiSound.play();
            }
            if(upgradeButtonView2.isUpgradeHit(myGdxGame.touch.x,myGdxGame.touch.y) && perSecond <= 19 && MemoryManager.loadCoins() >= priceOfPerSecond ){
                perSecond = MemoryManager.loadPerSecond() + 1;
                MemoryManager.savePerSecond(perSecond);
                coins = MemoryManager.loadCoins() - priceOfPerSecond;
                MemoryManager.saveCoins(coins);
                priceOfPerSecond = (MemoryManager.loadPerSecond()-8)*100;
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
    private void randomizerSound(){
        Random r = new Random();
        int randomClick = r.nextInt(3);
        if (randomClick == 1) {
            myGdxGame.audioManager.clickSound = Gdx.audio.newSound(Gdx.files.internal(GameResources.CLICK_1));
        } else if (randomClick == 2) {
            myGdxGame.audioManager.clickSound = Gdx.audio.newSound(Gdx.files.internal(GameResources.CLICK_2));
        } else{
            myGdxGame.audioManager.clickSound = Gdx.audio.newSound(Gdx.files.internal(GameResources.CLICK_3));
        }
    }
    private void upgradeEffect(){
        if (MLevel != MemoryManager.loadMonitorLevel()){
            MUpgradeImage.move();
            MUpgradeImage.draw(myGdxGame.batch);
            MLevel += 1;
        }
    }
    private void draw(){

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();
        backgroundView.draw(myGdxGame.batch);

        computerView.draw(myGdxGame.batch);
        monitorView.draw(myGdxGame.batch, clickForMonitor);
        keyboardView.draw(myGdxGame.batch);

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
        computerView.dispose();
        keyboardView.dispose();
        monitorView.dispose();

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
