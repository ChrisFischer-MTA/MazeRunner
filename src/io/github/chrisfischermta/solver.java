package io.github.chrisfischermta;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.Current;

public class solver {
	char[][] finalMaze;
	int[] startPos = new int[2];
	Queue<point> masterQueue = new LinkedList<point>();
	point current;
	boolean finish = false;

	public solver(cleaner maze) {
		this.finalMaze = maze.finalMaze;
		for (int i = 0; i < finalMaze[0].length; i++) {
			for (int j = 0; j < finalMaze.length; j++) {
				try {
					if (finalMaze[j][i] == 'S') {
						startPos[0] = j;
						startPos[1] = i;
						i = finalMaze.length;
						break;
					}
				} catch (Exception e) {
					System.err.print("" + i + " " + j);
				}
			}
		}
		System.err.println("Starting Position found! " + startPos[0] + " " + startPos[1]);
		// for(int i = 0; i < finalMaze.length; i++) {
		// for(int j = 0; j < finalMaze[0].length; j++) {
		// }
		// }

		// TODO: Potential Bug; Ensure that this is proper orientation (ex. x is x and y
		// is y)
		masterQueue.add(new point(startPos[0], startPos[1]));
		while (!masterQueue.isEmpty()) {
			if (finish) {
				finalMaze[current.x][current.y] = 'F';
				break;}
			current = masterQueue.poll();
			int x = current.x;
			int y = current.y;
			// System.out.printf("%5d %5d %c \n", current.x, current.y, finalMaze[x][y]);
			// Mark it moved.
			finalMaze[x][y] = 'U';
			// Up
			if (isInBounds(x, y + 1) && isNotWall(x, y + 1)) {
				// Ensure that it isn't finish.
				masterQueue.add(new point(x, y + 1, current.pastPoints));
				finalMaze[x][y + 1] = 'U';
			}
			// Down
			if (isInBounds(x, y - 1) && isNotWall(x, y - 1)) {
				masterQueue.add(new point(x, y - 1, current.pastPoints));
				finalMaze[x][y - 1] = 'U';
			}
			// Left
			if (isInBounds(x - 1, y) && isNotWall(x - 1, y)) {
				masterQueue.add(new point(x - 1, y, current.pastPoints));
				finalMaze[x - 1][y] = 'U';
			}
			// Right
			if (isInBounds(x + 1, y) && isNotWall(x + 1, y)) {
				masterQueue.add(new point(x + 1, y, current.pastPoints));
				finalMaze[x + 1][y] = 'U';
			}

			// System.out.println("Queue Length - "+masterQueue.size());
		}

	}

	boolean isNotWall(int i, int j) {
		if (finalMaze[i][j] == 'W')
			return false;
		if (finalMaze[i][j] == 'U') {
			return false;
		}
		if (finalMaze[i][j] == 'F') {
			// We've found the finish
			System.out.println("Finish found.");
			for (point p : current.pastPoints) {
				System.out.printf("%5d %5d\n", p.x, p.y);
			}
			finish = true;
		}
		return true;
	}

	boolean isInBounds(int i, int j) {
		// Should work.
		return i < finalMaze.length && i > 0 && j < finalMaze[0].length && j > 0;
	}

}
