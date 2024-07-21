package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameResources;
import com.mygdx.game.managers.MemoryManager;
import com.mygdx.game.view.View;

public class ComputerView{
    public static int level = 1;

    public static void levelUp(){
        level = MemoryManager.loadComputerLevel() + 1;
        MemoryManager.saveComputerLevel(level);
    }
}

