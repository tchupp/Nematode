package com.nematode.imaging;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class SquareContourTracer {

	public static final int BLACK = Color.BLACK.getRGB();
	public static final int WHITE = Color.WHITE.getRGB();

	public List<ContourPoint> getContourPoints(final int[][] imageMatrix) {
		final ArrayList<ContourPoint> points = new ArrayList<ContourPoint>();
		final int[][] matrix = clearBoarder(imageMatrix);

		final ContourPoint startingPoint = getStartingPoint(matrix);
		final ContourPoint currentPoint = startingPoint.clone();

		do {
			if (matrix[currentPoint.getY()][currentPoint.getX()] == 1) {
				if (!points.contains(currentPoint)) {
					points.add(currentPoint.clone());
				}
				currentPoint.advanceLeft();
			} else {
				currentPoint.advanceRight();
			}

		} while (!startingPoint.equals(currentPoint) && startingPoint.isValid());

		return points;
	}

	private ContourPoint getStartingPoint(final int[][] imageMatrix) {
		for (int y = imageMatrix.length - 1; y >= 0; y--) {

			for (int x = imageMatrix[y].length - 1; x >= 0; x--) {

				if (imageMatrix[y][x] == 1) {
					return new ContourPoint(x, y);
				}

			}
		}

		return new ContourPoint(-1, -1);
	}

	private int[][] clearBoarder(final int[][] imageMatrix) {
		for (int y = 0; y < imageMatrix.length; y++) {
			for (int x = 0; x < imageMatrix[y].length; x++) {
				if (y == 0 || x == 0 || y == imageMatrix.length - 1
						|| x == imageMatrix[y].length - 1) {
					imageMatrix[y][x] = 0;
				}
			}
		}
		return imageMatrix;
	}
}
