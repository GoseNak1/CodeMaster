package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.view.ButtonView;
import com.mygdx.game.view.View;

public class KeyboardView extends View {
    Texture texture;
    public static int level =1;

    public KeyboardView(float x, float y, float width, float height){
        super(x, y, width, height);
        if(MemoryManager.loadKeyboardLevel() >= 6){
            MemoryManager.saveKeyboardLevel(1);
            level = 1;
        }


    }
    @Override
    public void draw(SpriteBatch batch){
        switch (MemoryManager.loadKeyboardLevel()){
            case 1:
                texture = new Texture(GameResources.KEYBOARD_STAGE_1);
                break;
            case 2:
                texture = new Texture(GameResources.KEYBOARD_STAGE_2);
                break;
            case 3:
                texture = new Texture(GameResources.KEYBOARD_STAGE_3);
                break;
            case 4:
                texture = new Texture(GameResources.KEYBOARD_STAGE_4);
                break;
            case 5:
                texture = new Texture(GameResources.KEYBOARD_STAGE_5);
                break;
            default:
                texture = new Texture(GameResources.KEYBOARD_STAGE_1);
                break;
        }
        batch.draw(texture,x,y,width,height);
    }
    public static void levelUp(){
        level = MemoryManager.loadKeyboardLevel() + 1;
        MemoryManager.saveKeyboardLevel(level);
    }
    @Override
    public void dispose(){
        texture.dispose();
    }
}


