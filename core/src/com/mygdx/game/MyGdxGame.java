package com.mygdx.game;

import static com.mygdx.game.GameSettings.POSITION_ITERATIONS;
import static com.mygdx.game.GameSettings.SCREEN_HEIGHT;
import static com.mygdx.game.GameSettings.SCREEN_WIDTH;
import static com.mygdx.game.GameSettings.STEP_TIME;
import static com.mygdx.game.GameSettings.VELOCITY_ITERATIONS;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.AudioManager;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.SettingsScreen;
import com.mygdx.game.screens.ShopScreen;

import java.util.ArrayList;

import javax.swing.Spring;

public class MyGdxGame extends Game {
	public static TextureAtlas textureAtlas;

	public Sprite keyBoard;
	public Sprite computer;

	public Sprite monitorShop;
	public Sprite keyBoardShop;
	public Sprite computerShop;

	public Sprite backGround;

	public Sprite coin1;
	public Sprite coin2;
	public Sprite coin3;
	public Sprite coin4;

	public Sprite upgradeButton1;
	public Sprite upgradeButton2;

	public Sprite price1;
	public Sprite price2;

	public Sprite exit;
	public Sprite settings;
	public Sprite shop;

	public Sprite coinsBanner;
	public Sprite banner;

	public Sprite backButton;
	public Sprite settingsBackground;
	public Sprite resetProgress;

	public Sprite shopImage;
	public Sprite shopBackground;

	public Sprite shopUpgradeButton1;
	public Sprite shopUpgradeButton2;
	public Sprite shopUpgradeButton3;

	public Sprite shopUpgradeButtonLocked1;
	public Sprite shopUpgradeButtonLocked2;
	public Sprite shopUpgradeButtonLocked3;

	public GameScreen gameScreen;
	public SettingsScreen settingsScreen;
	public ShopScreen shopScreen;

	public Vector3 touch;


	public SpriteBatch batch;
	public OrthographicCamera camera;


	public BitmapFont fontWhiteVerySmall;
	public BitmapFont fontWhiteSmall;
	public BitmapFont fontWhite;
	public BitmapFont fontBlackBtw;
	public BitmapFont fontBlack;
	public BitmapFont fontBlackBig;
	public BitmapFont fontBlackSmall;
	public BitmapFont fontBlackAverage;
	public BitmapFont fontRed;
	public BitmapFont waterMark;
	public BitmapFont fontWhiteBtw;

	public AudioManager audioManager;

	
	@Override
	public void create () {


		Color colorS = new Color(0.14F, 0.14F, 0.14F, 0.6F);
		Color colorWM = new Color(0, 255, 0, 0.1F);

		fontWhiteBtw = FontBuilder.generate(38,Color.WHITE,GameResources.FONT_PATH);
		fontWhiteVerySmall = FontBuilder.generate(30,Color.WHITE,GameResources.FONT_PATH);
		fontWhiteSmall = FontBuilder.generate(50, Color.WHITE,GameResources.FONT_PATH);
		fontWhite = FontBuilder.generate(70, Color.WHITE, GameResources.FONT_PATH);
		fontBlack = FontBuilder.generate(70, colorS, GameResources.FONT_PATH);
		fontBlackBig = FontBuilder.generate(100, colorS, GameResources.FONT_PATH);
		fontBlackSmall = FontBuilder.generate(30,colorS,GameResources.FONT_PATH);
		fontBlackAverage = FontBuilder.generate(35, colorS,GameResources.FONT_PATH);
		fontBlackBtw = FontBuilder.generate(55,colorS,GameResources.FONT_PATH);
		fontRed = FontBuilder.generate(35, Color.RED,GameResources.FONT_PATH);
		waterMark = FontBuilder.generate(50,colorWM,GameResources.FONT_WATERMARK_PATH);

		textureAtlas  = new TextureAtlas("assets.txt");
		backGround = textureAtlas.createSprite("Background");
		coin1 = textureAtlas.createSprite("Coin");
		coin2 = textureAtlas.createSprite("Coin");
		coin3 = textureAtlas.createSprite("Coin");
		coin4 = textureAtlas.createSprite("Coin");

		coin4.setPosition(215,43);
		coin4.setSize(55,50);

		price1 = textureAtlas.createSprite("Price");
		price2 = textureAtlas.createSprite("Price");

		exit = textureAtlas.createSprite("exitgame");
		settings = textureAtlas.createSprite("Settingsbutton");
		shop = textureAtlas.createSprite("shopbutton");

		coinsBanner = textureAtlas.createSprite("Show coins");
		banner = textureAtlas.createSprite("banner");

		backButton = textureAtlas.createSprite("backbutton");
		settingsBackground = textureAtlas.createSprite("Setting background");
		resetProgress = textureAtlas.createSprite("red button");

		shopImage = textureAtlas.createSprite("Price");
		shopBackground = textureAtlas.createSprite("Shopbackground");

		shopUpgradeButton1 = textureAtlas.createSprite("shop button");
		shopUpgradeButton2 = textureAtlas.createSprite("shop button");
		shopUpgradeButton3 = textureAtlas.createSprite("shop button");

		shopUpgradeButtonLocked1 = textureAtlas.createSprite("shop buttonLocked");
		shopUpgradeButtonLocked2 = textureAtlas.createSprite("shop buttonLocked");
		shopUpgradeButtonLocked3 = textureAtlas.createSprite("shop buttonLocked");



		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH,SCREEN_HEIGHT);

		audioManager = new AudioManager();

		gameScreen = new GameScreen(this);
		settingsScreen = new SettingsScreen(this);
		shopScreen = new ShopScreen(this);


		setScreen(gameScreen);
	}



	@Override
	public void dispose () {
		fontWhiteVerySmall.dispose();
		fontWhiteSmall.dispose();
		fontWhite.dispose();
		fontBlack.dispose();
		fontBlackBig.dispose();
		fontBlackSmall.dispose();
		fontBlackAverage.dispose();
		fontBlackBtw.dispose();
		fontRed.dispose();
		gameScreen.dispose();
		settingsScreen.dispose();
		shopScreen.dispose();
		batch.dispose();
		textureAtlas.dispose();
	}
}
