package com.base.helpers;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class FileHelper {
	
	public static TrueTypeFont GetFont(String path, float size) {
		try {
			InputStream input = ResourceLoader.getResourceAsStream(path);
			
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, input);
			awtFont = awtFont.deriveFont(size);
			TrueTypeFont f =  new TrueTypeFont(awtFont, false);
			return f;
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Image LoadTexture(String path) {
		try {
			Image tmp = new Image(path);
			return tmp;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int[][] LoadTileData(String path, int width) throws IOException {
		
		String[] lines = OpenFile(System.getProperty("user.dir")+path+".MAP");
		
		String[][] parts = new String[lines.length][width];
		for (int j = 0; j < lines.length; j++) {
			parts[j] = lines[j].split("\\s");
		}
			
		int[][] worldData = new int[width][lines.length];
		for (int j = 0; j < parts.length; j++) {
			for (int i = 0; i < parts[j].length; i++) {
				worldData[i][j] = Integer.parseInt(parts[j][i]);
			}
		}
		
		return worldData;
	}
	
	private static String[] OpenFile(String path) throws IOException {
		BufferedReader textReader = new BufferedReader(new FileReader(path));
		
		String[] textData = new String[GetLines(path)];
		for (int i = 0; i < textData.length; i++) {
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		return textData;
	}
	
	@SuppressWarnings("unused")
	private static int GetLines(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			i++;
		}
		
		br.close();
		return i;
	}
	
}
