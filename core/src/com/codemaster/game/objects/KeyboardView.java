package com.codemaster.game.objects;

import com.codemaster.game.MyGdxGame;
import com.codemaster.game.managers.MemoryManager;
import com.codemaster.game.view.View;

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


