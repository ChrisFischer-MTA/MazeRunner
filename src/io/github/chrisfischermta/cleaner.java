package io.github.chrisfischermta;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class cleaner {

	boolean hard = false;
	int[][] red;
	int[][] green;
	int[][] blue;
	char[][] finalMaze;

	public cleaner(BufferedImage image, boolean hard) {
		// Init arrays
		this.hard = hard;
		int maxY = image.getHeight();
		int maxX = image.getWidth();
		
		red = new int[maxX][maxY];
		green = new int[maxX][maxY];
		blue = new int[maxX][maxY];
		finalMaze = new char[maxX][maxY];
		System.err.println("Arrays Init " + System.currentTimeMillis());

		// Loop through each pixel.
		for(int y = 0; y < maxY; y++) {
			for(int x = 0; x < maxX; x++) {
				//System.out.printf("%10d ", image.getRGB(x, y));
				Color temp = new Color(image.getRGB(x, y));
				red[x][y] = temp.getRed();
				green[x][y] = temp.getGreen();
				blue[x][y] = temp.getBlue();
			
			}
			//System.out.printf("\n");
		}
		System.err.println("Assignments Done " + System.currentTimeMillis());

		// Find distance between colors.

		for(int y = 0; y < maxY; y++) {
			for(int x = 0; x < maxX; x++) {
				Color temp = new Color(image.getRGB(x, y));
				finalMaze[x][y] = getColor(red[x][y], green[x][y], blue[x][y]);
			}
		}

		// Changes it to the closest color.

	}
	

	char getColor(int r, int g, int b) {
		// Precursor: All RGB values are squared.
		Color[] hardCodedColors = { new Color(20, 20, 20), new Color(255, 255, 255)};
		/*
		 * new Color(237, 28, 36),
		 * new Color(163, 74, 164)
		 */
		
		// Skip the CPU intensive checks and make this specific
		if(r == 237 && g == 28 && b == 36)
			return 'S';
		if(r == 163 && g == 73 && b == 164)
			return 'F';
		if(hard && r == 0 && g == 0 && b == 0) {
			// Return wall.
			return 'W';
		}
		if(hard) {
			return '.';
		}
		
		char[] core = { 'W', '.'};
		int lowestIndex = 0;
		int lowestDistanceYet=1000000000;
		for (int i = 0; i < hardCodedColors.length; i++) {
			// R2 - R1 + G2 - G1 + B2 - B1
			int thisIntDistance = (((hardCodedColors[i].getRed() - r)*(hardCodedColors[i].getRed() - r))
					+ (((hardCodedColors[i].getGreen() - g)*(hardCodedColors[i].getGreen() - g)))
					+ (((hardCodedColors[i].getBlue() - b)*(hardCodedColors[i].getBlue() - b))));
			if (thisIntDistance < lowestDistanceYet) {
				lowestDistanceYet = thisIntDistance;
				lowestIndex = i;
			}
		}
		return core[lowestIndex];

	}
}
