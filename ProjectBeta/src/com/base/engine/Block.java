package com.base.engine;

import org.newdawn.slick.Image;

import com.base.blocks.DefaultBlock;
import com.base.blocks.DirtBlock;

public class Block {
	
	private Block def, dirt;
	
	private int id;
	private Image texture;

	public Block() {
		
	}
	
	public void InitBlocks() {
		def = new DefaultBlock();
		dirt = new DirtBlock();
		
		def.SetID(0);
		dirt.SetID(1);
		
		Registry.Add(def);
		Registry.Add(dirt);
	}
	
	public void Draw() {
		texture.draw();
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

}
