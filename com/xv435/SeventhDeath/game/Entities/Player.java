package com.xv435.SeventhDeath.game.Entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.xv435.SeventhDeath.game.Character;
import com.xv435.SeventhDeath.game.Constants;

public class Player extends Character {
	/*
	 * Note that the variables
	 * x and y inherited from entity are not for graphical
	 * rendering. This game scrolls around the player.
	 * These are for abstract location as other entities
	 * and the map needs to render around the player.
	 */
	private int RenderX;
	private int RenderY;
	private Audio attackSound;
	
    public Player() {
    	super(1, 1, "Wooden Sword", "Player");
    	try {
	        attackSound = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("assets/first.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	Constants constant = new Constants();
    	RenderX = constant.width / 2;
    	RenderY = constant.height / 2;
    }
    public void render() {
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glTexCoord2f(0,0);
    	GL11.glVertex2i(RenderX - (texture.getTextureWidth() / 2), RenderY - (texture.getTextureHeight() / 2));
    	GL11.glTexCoord2f(1,0);
    	GL11.glVertex2i(RenderX - (texture.getTextureWidth() / 2), RenderY + (texture.getTextureHeight() / 2));
    	GL11.glTexCoord2f(1,1);
    	GL11.glVertex2i(RenderX + (texture.getTextureWidth() / 2), RenderY + (texture.getTextureHeight() / 2));
    	GL11.glTexCoord2f(0,1);
    	GL11.glEnd();
    }
    public void attack() {
    	attackSound.playAsSoundEffect(1.0F, 1.0F, false);
    }
}
