package com.nematode.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SquareContourTracer implements SquareContourTracerInterface {

	public static final int BLACK = Color.BLACK.getRGB();
	public static final int WHITE = Color.WHITE.getRGB();

	@Override
	public ContourLines getContourLines(final BufferedImage image) {
		final int[][] imageMatrix = convertImageToMatrix(image);

		final int[][] matrix = clearBoarder(imageMatrix);

		final ContourPoint startingPoint = getStartingPoint(matrix);
		final ContourPoint currentPoint = startingPoint.clone();

		final ArrayList<ContourPoint> points = new ArrayList<ContourPoint>();
		do {
			if (matrix[currentPoint.getY()][currentPoint.getX()] == BLACK) {
				if (!points.contains(currentPoint)) {
					points.add(currentPoint.clone());
				}
				currentPoint.advanceLeft();
			} else {
				currentPoint.advanceRight();
			}

		} while (!startingPoint.equals(currentPoint) && startingPoint.isValid());

		return new ContourLines(points);
	}

	private int[][] convertImageToMatrix(final BufferedImage image) {
		final int width = image.getWidth();
		final int height = image.getHeight();

		final int[] inputArray = new int[width * height];
		image.getRGB(0, 0, width, height, inputArray, 0, width);

		final int[][] outputMatrix = new int[height][width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				final int arrayIndex = y * width + x;
				outputMatrix[y][x] = inputArray[arrayIndex];
			}
		}

		return outputMatrix;
	}

	private ContourPoint getStartingPoint(final int[][] imageMatrix) {
		for (int y = imageMatrix.length - 1; y >= 0; y--) {

			for (int x = imageMatrix[y].length - 1; x >= 0; x--) {

				if (imageMatrix[y][x] == BLACK) {
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
					imageMatrix[y][x] = WHITE;
				}
			}
		}
		return imageMatrix;
	}
}
