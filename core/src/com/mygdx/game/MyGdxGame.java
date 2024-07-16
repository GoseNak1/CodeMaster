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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.managers.AudioManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.SettingsScreen;
import com.mygdx.game.screens.ShopScreen;

public class MyGdxGame extends Game {
	public GameScreen gameScreen;
	public SettingsScreen settingsScreen;
	public ShopScreen shopScreen;

	float accumulator = 0;

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
	}
}
