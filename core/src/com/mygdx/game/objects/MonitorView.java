package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.view.View;

public class MonitorView extends View {
    Texture[] animateArray;
    public int width;
    public int height;
    public static int level;

    public MonitorView(float x, float y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;

        level = MemoryManager.loadMonitorLevel();
    }

    @Override
    public void draw(SpriteBatch batch, int click){
        switch (MemoryManager.loadMonitorLevel()){
            case 1: MemoryManager.saveMSeconds(5000); break;
            case 2: MemoryManager.saveMSeconds(4000); break;
            case 3: MemoryManager.saveMSeconds(3000); break;
            case 4: MemoryManager.saveMSeconds(2000); break;
            case 5: MemoryManager.saveMSeconds(1000); break;
        }
        switch (MemoryManager.loadMonitorLevel()){
            case 1:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_1_1),
                        new Texture(GameResources.MONITOR_STAGE_1_2),
                        new Texture(GameResources.MONITOR_STAGE_1_3),
                };

                break;
            case 2:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_2_1),
                        new Texture(GameResources.MONITOR_STAGE_2_2),
                        new Texture(GameResources.MONITOR_STAGE_2_3),
                };
                break;
            case 3:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_3_1),
                        new Texture(GameResources.MONITOR_STAGE_3_2),
                        new Texture(GameResources.MONITOR_STAGE_3_3),
                };
                break;
            case 4:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_4_1),
                        new Texture(GameResources.MONITOR_STAGE_4_2),
                        new Texture(GameResources.MONITOR_STAGE_4_3),
                };
                break;
            case 5:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_5_1),
                        new Texture(GameResources.MONITOR_STAGE_5_2),
                        new Texture(GameResources.MONITOR_STAGE_5_3),
                };
                break;
            default:
                animateArray = new Texture[]{
                        new Texture(GameResources.MONITOR_STAGE_1_1),
                        new Texture(GameResources.MONITOR_STAGE_1_2),
                        new Texture(GameResources.MONITOR_STAGE_1_3),
                };
                break;
        }
        batch.draw(animateArray[click], x, y, width, height);
    }
    public static void levelUp(){
        level = MemoryManager.loadMonitorLevel() + 1;
        MemoryManager.saveMonitorLevel(level);

    }

}

