package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.view.View;

public class ComputerView extends View {
    Texture texture;
    public int width;
    public int height;
    public static int level = 1;
    public ComputerView(float x, float y, int width, int height){
        super(x,y);
        this.width = width;
        this.height = height;

    }
    @Override
    public void draw(SpriteBatch batch){
        switch (MemoryManager.loadComputerLevel()){
            case 1:
                texture = new Texture(GameResources.COMPUTER_STAGE_1);
                break;
            case 2:
                texture = new Texture(GameResources.COMPUTER_STAGE_2);
                break;
            case 3:
                texture = new Texture(GameResources.COMPUTER_STAGE_3);
                break;
            case 4:
                texture = new Texture(GameResources.COMPUTER_STAGE_4);
                break;
            case 5:
                texture = new Texture(GameResources.COMPUTER_STAGE_5);
                break;
            default:
                texture = new Texture(GameResources.COMPUTER_STAGE_1);
                break;
        }

        batch.draw(texture,x,y,width,height);
    }
    public static void levelUp(){
        level = MemoryManager.loadComputerLevel() + 1;
        MemoryManager.saveComputerLevel(level);
    }
    @Override
    public void dispose(){
        texture.dispose();
    }
}
