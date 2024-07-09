package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameResources;
import com.mygdx.game.managers.MemoryManager;

import java.util.Random;

public class AudioManager {
    public boolean isSoundOn;
    public boolean isMusicOn;

    public Music backgroundMusic;
    public Sound clickSound;
    public Sound uiSound;



    // для случайного выбора звука клика



    public AudioManager() {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal(GameResources.BACKGROUND_MUSIC_PATH));
        uiSound = Gdx.audio.newSound(Gdx.files.internal(GameResources.UI_SOUND_PATH));


        backgroundMusic.setVolume(0.2f);
        backgroundMusic.setLooping(true);

        updateSoundFlag();
        updateMusicFlag();
    }

    public void updateSoundFlag() {
        isSoundOn = MemoryManager.loadIsSoundOn();
    }

    public void updateMusicFlag() {
        isMusicOn = MemoryManager.loadIsMusicOn();

        if (isMusicOn) {
            backgroundMusic.play();
            backgroundMusic.setVolume(0.05f);
        }

        else backgroundMusic.stop();
    }
}
