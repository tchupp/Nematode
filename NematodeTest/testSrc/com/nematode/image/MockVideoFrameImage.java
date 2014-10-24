package com.nematode.image;

import java.awt.image.BufferedImage;

import com.nematode.image.VideoFrameImageInterface;
import com.nematode.nullmodel.NullBufferedImage;

public class MockVideoFrameImage implements VideoFrameImageInterface {

	private BufferedImage bufferedImage = new NullBufferedImage();

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

	public void setBufferedImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}
