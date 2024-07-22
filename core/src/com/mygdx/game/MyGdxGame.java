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

	public AudioManager audioManager;

	
	@Override
	public void create () {


		Color colorS = new Color(0.14F, 0.14F, 0.14F, 0.6F);
		fontWhiteVerySmall = FontBuilder.generate(30,Color.WHITE,GameResources.FONT_PATH);
		fontWhiteSmall = FontBuilder.generate(50, Color.WHITE,GameResources.FONT_PATH);
		fontWhite = FontBuilder.generate(70, Color.WHITE, GameResources.FONT_PATH);
		fontBlack = FontBuilder.generate(70, colorS, GameResources.FONT_PATH);
		fontBlackBig = FontBuilder.generate(100, colorS, GameResources.FONT_PATH);
		fontBlackSmall = FontBuilder.generate(30,colorS,GameResources.FONT_PATH);
		fontBlackAverage = FontBuilder.generate(35, colorS,GameResources.FONT_PATH);
		fontBlackBtw = FontBuilder.generate(55,colorS,GameResources.FONT_PATH);
		fontRed = FontBuilder.generate(35, Color.RED,GameResources.FONT_PATH);

		textureAtlas  = new TextureAtlas("assets.txt");
		backGround = textureAtlas.createSprite("Background");
		coin1 = textureAtlas.createSprite("Coin");
		coin2 = textureAtlas.createSprite("Coin");
		coin3 = textureAtlas.createSprite("Coin");
		coin4 = textureAtlas.createSprite("Coin");

		coin4.setPosition(110,48);
		coin4.setSize(55,50);

		price1 = textureAtlas.createSprite("price");
		price2 = textureAtlas.createSprite("price");

		exit = textureAtlas.createSprite("exitgame");
		settings = textureAtlas.createSprite("settings_button");
		shop = textureAtlas.createSprite("shop_button");

		coinsBanner = textureAtlas.createSprite("banners/coins_image");
		banner = textureAtlas.createSprite("banners/banner");

		backButton = textureAtlas.createSprite("backbutton");
		settingsBackground = textureAtlas.createSprite("Setting_background");
		resetProgress = textureAtlas.createSprite("red_button");

		shopImage = textureAtlas.createSprite("shop_image");
		shopBackground = textureAtlas.createSprite("shop_background");

		shopUpgradeButton1 = textureAtlas.createSprite("upgrade_shop_button");
		shopUpgradeButton2 = textureAtlas.createSprite("upgrade_shop_button");
		shopUpgradeButton3 = textureAtlas.createSprite("upgrade_shop_button");

		shopUpgradeButtonLocked1 = textureAtlas.createSprite("shop_button_locked");
		shopUpgradeButtonLocked2 = textureAtlas.createSprite("shop_button_locked");
		shopUpgradeButtonLocked3 = textureAtlas.createSprite("shop_button_locked");



		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCREEN_WIDTH,SCREEN_HEIGHT);

		audioManager = new AudioManager();

		gameScreen = new GameScreen(this);
		settingsScreen = new SettingsScreen(this);
		shopScreen = new ShopScreen(this);


		setScreen(shopScreen);
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
