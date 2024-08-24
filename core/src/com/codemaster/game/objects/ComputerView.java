package com.codemaster.game.objects;

import com.codemaster.game.managers.MemoryManager;

public class ComputerView{
    public static int level = 1;

    public static void levelUp(){
        level = MemoryManager.loadComputerLevel() + 1;
        MemoryManager.saveComputerLevel(level);
    }
}

