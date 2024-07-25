package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.View;

public class KeyboardView extends View {
    MyGdxGame myGdxGame;
    public static int level = 1;

    public KeyboardView(float x, float y, float width, float height){
        super(x, y, width, height);
        myGdxGame = new MyGdxGame();

    }
    public static void levelUp(){
        level = MemoryManager.loadKeyboardLevel() + 1;
        MemoryManager.saveKeyboardLevel(level);
    }
}


