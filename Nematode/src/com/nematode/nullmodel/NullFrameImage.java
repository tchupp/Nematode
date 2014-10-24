package com.nematode.nullmodel;

import java.awt.image.BufferedImage;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;

public class NullFrameImage implements VideoFrameImageInterface,
		DisplayFrameImageInterface, ProcessedFrameImageInterface {

	public static NullFrameImage NULL = new NullFrameImage();

	private NullFrameImage() {
	}

	@Override
	public BufferedImage getImage() {
		return new NullBufferedImage();
	}

}
