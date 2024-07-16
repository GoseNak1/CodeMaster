package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameSettings;

public class BackgroundView extends View {
    Texture texture;

    int texture1Y;
    int texture2Y;

    public BackgroundView(String pathToTexture){
        super(0,0);
        texture1Y = 0;
        texture2Y = GameSettings.SCREEN_HEIGHT;
        texture = new Texture(pathToTexture);
    }
    @Override
    public void draw(SpriteBatch batch){
        batch.draw(texture,0, texture1Y, GameSettings.SCREEN_WIDTH,GameSettings.SCREEN_HEIGHT);
        batch.draw(texture,0, texture2Y, GameSettings.SCREEN_WIDTH,GameSettings.SCREEN_HEIGHT);
    }
    @Override
    public void dispose(){
        texture.dispose();
    }
}
