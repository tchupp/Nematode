package com.nematode.nullmodel;

import java.awt.image.BufferedImage;

import com.nematode.imaging.VideoFrameImageInterface;

public class NullVideoFrameImage implements VideoFrameImageInterface {

	public static VideoFrameImageInterface NULL = new NullVideoFrameImage();

	private NullVideoFrameImage() {
	}

	@Override
	public BufferedImage getBufferedImage() {
		return new NullBufferedImage();
	}

}
