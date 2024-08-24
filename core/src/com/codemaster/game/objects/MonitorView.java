package com.codemaster.game.objects;

import com.codemaster.game.managers.MemoryManager;
import com.codemaster.game.view.View;

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

