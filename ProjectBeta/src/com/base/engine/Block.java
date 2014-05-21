package com.base.engine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.Image;

import com.base.blocks.DefaultBlock;
import com.base.blocks.DirtBlock;
import com.base.blocks.StoneBlock;

public class Block {
	
	private Block def, dirt, stone;
	
	private int id;
	private String name;
	private Image texture;

	public Block() {
		
	}
	
	public void InitBlocks() {
		def = new DefaultBlock();
		dirt = new DirtBlock();
		stone = new StoneBlock();
		
		def.SetID(0).SetName("Default");
		dirt.SetID(1).SetName("Dirt");
		stone.SetID(2).SetName("Stone");
		
		Registry.Add(def);
		Registry.Add(dirt);
		Registry.Add(stone);
	}
	
	public void Draw() {
		texture.getTexture().bind();
		
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(1, 0);
			glVertex2f(32, 0);
			glTexCoord2f(1, 1);
			glVertex2f(32, 32);
			glTexCoord2f(0, 1);
			glVertex2f(0, 32);
		glEnd();
	}
	
	public Block SetID(int id) {
		this.id = id;
		return this;
	}
	
	public int GetID() {
		return this.id;
	}
	
	public void SetTexture(Image t) {
		this.texture = t;
	}
	
	public Image GetTexture() {
		return texture;
	}
	
	public Block SetName(String name) {
		this.name = name;
		return this;
	}
	
	public String GetName() {
		return this.name;
	}

}
