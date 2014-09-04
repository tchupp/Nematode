package com.nematode.nullmodel;

import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;

public class NullNematodeVideoFrame implements NematodeVideoFrameInterface {

	public static NullNematodeVideoFrame NULL = new NullNematodeVideoFrame();

	private NullNematodeVideoFrame() {
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return NullVideoFrameImage.NULL;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
	}

}
