package com.base.engine;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.SlickException;

public class Main {
	
	private static Game game;
	
	public static void main(String[] args) throws SlickException, LWJGLException, IOException {
		InitDisplay();
		InitGL();
		InitGame();
		
		GameLoop();
		
		CleanUp();
	}

	private static void InitDisplay() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.create();
		Keyboard.create();
	}

	private static void InitGL() throws LWJGLException {
		glEnable(GL_TEXTURE_2D);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_TEXTURE_2D);
		
		glClearColor(0, 0, 0, 0);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	private static void InitGame() throws SlickException, IOException {
		game = new Game();
	}

	private static void GameLoop() throws SlickException {
		while (!Display.isCloseRequested()) {
			GetInput();
			Update();
			Draw();
		}
	}

	private static void GetInput() {
		game.GetInput();
	}

	private static void Update() {
		game.Update();
	}

	private static void Draw() throws SlickException {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		game.Draw();
		
		Display.update();
		Display.sync(60);
	}

	private static void CleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}

}
