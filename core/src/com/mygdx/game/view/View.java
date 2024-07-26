package com.mygdx.game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public abstract class View implements Disposable {
    public float x;
    public float y;
    public float width;
    public float height;
    public View(float x, float y){
        this.x = x;
        this.y = y;
    }
    public View(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public boolean isHit(float tx,float ty){
        return (tx >= x && tx <= x + width && ty >= y && ty <= y + height);
    }
    public boolean isKeyboardHit(float tx, float ty){
        return (tx >= x && tx <= x + width && ty >= y+190 && ty <= y + height);

    }
    public boolean isUpgradeHit(float tx, float ty){
        return (tx >= x+100 && tx <= x-100 + width && ty >= y+50 && ty <= y-180 + height);
    }
    public void draw(SpriteBatch batch){

    }
    public void draw(SpriteBatch batch, int click){

    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void dispose() {

    }
}
