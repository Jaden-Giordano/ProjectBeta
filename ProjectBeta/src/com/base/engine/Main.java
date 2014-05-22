package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.SlickException;

import com.base.game.Game;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	
	private static Game game;
	
	public static void main(String[] args) throws SlickException, LWJGLException, IOException {
		InitDisplay();
		InitGL();
		InitGame();
		
		GameLoop();
		
		CleanUp();
	}

	private static void InitDisplay() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT));
		Display.create();
		Display.setVSyncEnabled(true);
		Keyboard.create();
	}

	private static void InitGL() throws LWJGLException {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, -1, 1);
		
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glDisable(GL_DEPTH_TEST);
		
		glClearColor(0, 0, 0, 0);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	private static void InitGame() throws SlickException, IOException {
		Block tmp = new Block();
		tmp.InitBlocks();
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
