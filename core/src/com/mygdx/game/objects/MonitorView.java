package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.view.View;

import java.util.Iterator;

public class MonitorView extends View {
    public Texture[] animateArray;
    public int width;
    public int height;
    public static int level;

    public static Texture animateTexture1;
    public static Texture animateTexture2;
    public static Texture animateTexture3;

    public MonitorView(float x, float y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;


    }

    @Override
    public void draw(SpriteBatch batch, int click){
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                animateTexture1 = new Texture(GameResources.MONITOR_STAGE_1_1) ;
                animateTexture2 =  new Texture(GameResources.MONITOR_STAGE_1_2);
                animateTexture3 =  new Texture(GameResources.MONITOR_STAGE_1_3);
                break;
            case 2:
                animateTexture1 =  new Texture(GameResources.MONITOR_STAGE_2_1);
                animateTexture2 =  new Texture(GameResources.MONITOR_STAGE_2_2);
                animateTexture3 =  new Texture(GameResources.MONITOR_STAGE_2_3);
                break;
            case 3:
                animateTexture1 = new Texture( GameResources.MONITOR_STAGE_3_1);
                animateTexture2 =  new Texture(GameResources.MONITOR_STAGE_3_2);
                animateTexture3 = new Texture( GameResources.MONITOR_STAGE_3_3);
                break;
            case 4:
                animateTexture1 =  new Texture(GameResources.MONITOR_STAGE_4_1);
                animateTexture2 =  new Texture(GameResources.MONITOR_STAGE_4_2);
                animateTexture3 = new Texture( GameResources.MONITOR_STAGE_4_3);
                break;
            case 5:
                animateTexture1 =  new Texture(GameResources.MONITOR_STAGE_5_1);
                animateTexture2 =  new Texture(GameResources.MONITOR_STAGE_5_2);
                animateTexture3 =  new Texture(GameResources.MONITOR_STAGE_5_3);
                break;
            default:
                animateTexture1 =  new Texture(GameResources.MONITOR_STAGE_1_1);
                animateTexture2 = new Texture( GameResources.MONITOR_STAGE_1_2);
                animateTexture3 =  new Texture(GameResources.MONITOR_STAGE_1_3);
        }
        animateArray = new Texture[]{
                animateTexture1,
                animateTexture2,
                animateTexture3,
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
    @Override
    public void dispose(){
        animateTexture1.dispose();
        animateTexture2.dispose();
        animateTexture3.dispose();

    }

}

