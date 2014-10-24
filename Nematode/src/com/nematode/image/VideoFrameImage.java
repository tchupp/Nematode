package com.nematode.image;

import java.awt.image.BufferedImage;

public class VideoFrameImage implements VideoFrameImageInterface {

	private final BufferedImage bufferedImage;

	public VideoFrameImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public BufferedImage getImage() {
		return this.bufferedImage;
	}

}
