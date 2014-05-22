package com.base.engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Camera {
	
	private int x, y;
	private boolean viewportMode;

	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Camera(int x, int y, boolean viewmode) {
		this.x = x;
		this.y = y;
		this.viewportMode = viewmode;
	}
	
	public void GetInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			Move(0, -4);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			Move(0, 4);
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			Move(-4, 0);
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			Move(4, 0);
	}
	
	public void Update() {
		GL11.glViewport(x, y, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
	}
	
	public void Move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public boolean IsInViewportMode() {
		return this.viewportMode;
	}
	
	public void PushViewportMode() {
		this.viewportMode = !this.viewportMode;
	}
}
