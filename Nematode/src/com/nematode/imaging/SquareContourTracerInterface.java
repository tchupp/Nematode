package com.nematode.imaging;

import java.awt.image.BufferedImage;

public interface SquareContourTracerInterface {

	public ContourPoints getContourPoints(BufferedImage image);

}