package com.nematode.image;

import java.awt.image.BufferedImage;

public class ProcessedFrameImage implements ProcessedFrameImageInterface {

	private final BufferedImage bufferedImage;

	public ProcessedFrameImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

}
