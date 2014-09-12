package com.nematode.nullmodel;

import java.awt.image.BufferedImage;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.ScannedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;

public class NullFrameImage implements VideoFrameImageInterface,
		DisplayFrameImageInterface, ScannedFrameImageInterface {

	public static NullFrameImage NULL = new NullFrameImage();

	private NullFrameImage() {
	}

	@Override
	public BufferedImage getImage() {
		return new NullBufferedImage();
	}

}
