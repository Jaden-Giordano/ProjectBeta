package com.base.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FileHelper {
	
	public static Image LoadTexture(String path) {
		try {
			Image tmp = new Image(path);
			return tmp;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int[][] LoadTileData(String pathname, int width) throws IOException {
		
		String[] lines = OpenFile(System.getProperty("user.dir")+pathname);
		
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
		
		int[][] tmp = new int[width][lines.length];
		for (int i = 0; i < parts.length; i++) {
			for (int j = 0; j < parts[i].length; j++) {
				tmp[i][j] = worldData[i][-j+parts[i].length-1];
			}
		}
		
		return tmp;
	}
	
	private static String[] OpenFile(String path) throws IOException {
		BufferedReader textReader = new BufferedReader(new FileReader(path));
		
		String[] textData = new String[GetLines(path)];
		for (int i = 0; i < textData.length; i++) {
			textData[i] = textReader.readLine();
			System.out.println(textData[i]);
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
