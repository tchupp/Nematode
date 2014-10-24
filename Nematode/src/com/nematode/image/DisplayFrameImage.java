package com.nematode.image;

import java.awt.image.BufferedImage;

public class DisplayFrameImage implements DisplayFrameImageInterface {

	private final BufferedImage bufferedImage;

	public DisplayFrameImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

}
