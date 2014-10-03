package com.nematode.nullmodel;

import java.awt.image.BufferedImage;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.ProcessedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;

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
