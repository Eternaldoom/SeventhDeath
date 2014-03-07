package com.xv435.SeventhDeath.game.Entities;

import org.lwjgl.opengl.GL11;

import com.xv435.SeventhDeath.game.Character;

public class Player extends Character {
    public Player() {
    	super(1, 1, "Player");
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
