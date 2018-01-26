package io.github.chrisfischermta;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class exporter {

	final int BOLDMAX = 5;
	final int BOLDMIN = -5;

	public exporter(BufferedImage image, point p, char[][] finalMaze, boolean bold) throws IOException {
		for (int y = 0; y < finalMaze[0].length; y++) {
			for (int x = 0; x < finalMaze.length; x++) {
				switch (finalMaze[x][y]) {
				case 'U':
					image.setRGB(x, y, -3947581);
					break;
				case '.':
					image.setRGB(x, y, -1);
					break;
				case 'W':
					image.setRGB(x, y, -16777216);
					break;
				default:
					// Leave it to what it was.
					break;
				}
			}
		}
		for (point path : p.pastPoints) {
			image.setRGB(path.x, path.y, -6075996);
			if (bold) {
				for (int i = 0; i < BOLDMAX; i++) {
					if (finalMaze[path.x + i][path.y] != 'W') {
						image.setRGB(path.x + i, path.y, -6075996);
					} else {
						break;
					}

				}
				for (int i = 0; i > BOLDMIN; i--) {
					if (finalMaze[path.x + i][path.y] != 'W') {
						image.setRGB(path.x + i, path.y, -6075996);
					} else {
						break;
					}
				}
				for (int i = 0; i < BOLDMAX; i++) {
					if (finalMaze[path.x][path.y + i] != 'W') {
						image.setRGB(path.x, path.y + i, -6075996);
					} else {
						break;
					}

				}
				for (int i = 0; i > BOLDMIN; i--) {
					if (finalMaze[path.x][path.y + i] != 'W') {
						image.setRGB(path.x, path.y + i, -6075996);
					} else {
						break;
					}
				}
			}
		}
		File output = new File("results.png");
		ImageIO.write(image, "png", output);
	}
}
