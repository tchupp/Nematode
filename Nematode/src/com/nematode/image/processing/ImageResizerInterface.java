package com.nematode.image.processing;

import java.awt.image.BufferedImage;

public interface ImageResizerInterface {

	public BufferedImage resizeImage(BufferedImage image, int width, int height);

	public BufferedImage resizeImageWithAspect(BufferedImage image, int width, int height);

}
