package com.nematode.image;

import java.awt.image.BufferedImage;

public class NullFrameImage implements VideoFrameImageInterface, DisplayFrameImageInterface,
		ProcessedFrameImageInterface {

	public static NullFrameImage NULL = new NullFrameImage();

	private NullFrameImage() {
	}

	@Override
	public BufferedImage getImage() {
		return new NullBufferedImage();
	}

}
