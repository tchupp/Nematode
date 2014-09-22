package com.nematode.imaging;

import java.awt.image.BufferedImage;

public class ScannedFrameImage implements ScannedFrameImageInterface {

	private final BufferedImage bufferedImage;

	public ScannedFrameImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

}
