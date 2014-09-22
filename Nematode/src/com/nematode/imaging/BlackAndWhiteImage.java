package com.nematode.imaging;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BlackAndWhiteImage extends BufferedImage {

	public BlackAndWhiteImage(final int width, final int height) {
		super(width, height, BufferedImage.TYPE_BYTE_BINARY);
	}

	public BlackAndWhiteImage(final BufferedImage image) {
		this(image.getWidth(), image.getHeight());

		final Graphics graphics = this.getGraphics();

		graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(),
				null);
		graphics.dispose();
	}
}
