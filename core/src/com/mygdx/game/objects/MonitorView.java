package com.mygdx.game.objects;

import static com.mygdx.game.screens.GameScreen.animateArray;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.view.View;

import java.util.Iterator;

public class MonitorView extends View {


    public int width;
    public int height;
    public static int level;



    public MonitorView(float x, float y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public static void levelUp(){
        level = MemoryManager.loadMonitorLevel() + 1;
        MemoryManager.saveMonitorLevel(level);
    }

}

