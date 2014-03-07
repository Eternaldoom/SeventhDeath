package com.xv435.SeventhDeath.game;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Entity {
	public int x;
	public int y;
	public Texture texture;
	public Entity(String textureName) {
	    try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("assets/" + textureName));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	texture.bind();
	}
	public void render() {

    	
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glTexCoord2f(0,0);
    	GL11.glVertex2i(x,y);
    	GL11.glTexCoord2f(1,0);
    	GL11.glVertex2i(x+texture.getTextureWidth(),y);
    	GL11.glTexCoord2f(1,1);
    	GL11.glVertex2i(x+texture.getTextureWidth(),y+texture.getTextureHeight());
    	GL11.glTexCoord2f(0,1);
    	GL11.glVertex2i(x,y+texture.getTextureHeight());
    	GL11.glEnd();


	}
}
