package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.nullmodel.NullBufferedImage;

public class MockDisplayFrameImage implements DisplayFrameImageInterface {

	private BufferedImage bufferedImage = new NullBufferedImage();

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

	public void setBufferedImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

}
