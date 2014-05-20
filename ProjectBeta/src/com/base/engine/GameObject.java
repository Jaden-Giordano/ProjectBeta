package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

public class GameObject {

	float x, y;
	Block b;
	boolean isBlock;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
		isBlock = false;
	}
	
	public GameObject(float x, float y, Block b) {
		this.x = x;
		this.y = y;
		this.b = b;
		isBlock = true;
	}
	
	public void Draw() {
		glPushMatrix();
			glTranslatef(x, y, 0);
			b.Draw();
		glPopMatrix();
	}

}
