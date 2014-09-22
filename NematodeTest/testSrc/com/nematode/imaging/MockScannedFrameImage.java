package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.nullmodel.NullBufferedImage;

public class MockScannedFrameImage implements ScannedFrameImageInterface {

	private BufferedImage bufferedImage = new NullBufferedImage();

	@Override
	public BufferedImage getImage() {
		return this.bufferedImage;
	}

	public void setBufferedImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

}
