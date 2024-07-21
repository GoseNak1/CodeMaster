package com.mygdx.game.objects;

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

    public Sprite[] animateArray;
    public int width;
    public int height;
    public static int level;

    public static Sprite animateTexture1;
    public static Sprite animateTexture2;
    public static Sprite animateTexture3;

    public MonitorView(float x, float y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(SpriteBatch batch, int click){
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor11");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor12");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor13");
                break;
            case 2:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor21");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor22");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor23");
                break;
            case 3:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor31");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor32");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor33");
                break;
            case 4:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor41");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor42");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor43");
                break;
            case 5:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor51");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor52");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor53");

                break;
            default:
                animateTexture1 = MyGdxGame.textureAtlas.createSprite("monitor/monitor11");
                animateTexture2 = MyGdxGame.textureAtlas.createSprite("monitor/monitor12");
                animateTexture3 = MyGdxGame.textureAtlas.createSprite("monitor/monitor13");
        }
        animateArray = new Sprite[]{
                animateTexture1,
                animateTexture2,
                animateTexture3
        };
        switch (MemoryManager.loadMonitorLevel()){
            case 1: MemoryManager.saveMSeconds(5000); break;
            case 2: MemoryManager.saveMSeconds(4000); break;
            case 3: MemoryManager.saveMSeconds(3000); break;
            case 4: MemoryManager.saveMSeconds(2000); break;
            case 5: MemoryManager.saveMSeconds(1000); break;
        }

        batch.draw(animateArray[click], x, y, width, height);

    }
    public static void levelUp(){
        level = MemoryManager.loadMonitorLevel() + 1;
        MemoryManager.saveMonitorLevel(level);
    }

}

