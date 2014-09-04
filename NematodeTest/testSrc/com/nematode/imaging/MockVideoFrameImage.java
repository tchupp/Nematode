package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.imaging.VideoFrameImageInterface;

public class MockVideoFrameImage implements VideoFrameImageInterface {

	@Override
	public BufferedImage getBufferedImage() {
		return new BufferedImage(0, 0, BufferedImage.TYPE_INT_ARGB);
	}

}
