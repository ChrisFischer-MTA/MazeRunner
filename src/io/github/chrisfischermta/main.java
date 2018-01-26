package io.github.chrisfischermta;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class main {
	public static void main(String[] arg) throws Exception {
		// Get input
		boolean hardmode = false;
		boolean bold = false;
		BufferedImage image = ImageIO.read(new File("input.png"));
		for(String s:arg) {
			if(s.contains("hardmode")) {
				System.err.println("Hardmode enabled.");
				hardmode = true;
			}
			if(s.contains("bold")) {
				System.err.println("Bold lines will be made. Some walls will be disbanded.");
				bold = true;
			}
			if(s.contains("chrisfischer-mta.github.io"));
		}
		cleaner newCleaner = new cleaner(image, hardmode);
		solver newSolver = new solver(newCleaner);
		exporter newExporter = new exporter(image, newSolver.current, newSolver.finalMaze, bold);
	}
}
