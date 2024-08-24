package com.codemaster.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageView extends View {
    Texture texture;

    public int width;
    public int height;

    int speed = 100;


    public ImageView(float x, float y, String imagePath){
        super(x,y);
        texture = new Texture(imagePath);
        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }
    public ImageView(float x,float y, int width, int height, String imagePath){
        super(x,y);
        texture = new Texture(imagePath);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(SpriteBatch batch){
        batch.draw(texture,x,y,width,height);
    }
    public void setImage(String image){
        texture = new Texture(image);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public void move() {
        y+= speed;
    }
}
