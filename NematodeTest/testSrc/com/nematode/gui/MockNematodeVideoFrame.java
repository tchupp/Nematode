package com.nematode.gui;

import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;

public class MockNematodeVideoFrame implements NematodeVideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;

	}

}
