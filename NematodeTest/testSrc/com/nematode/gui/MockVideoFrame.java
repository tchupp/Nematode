package com.nematode.gui;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.model.VideoFrameInterface;

public class MockVideoFrame implements VideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();
	private List<NematodeWormInterface> objectsOnImage = new ArrayList<NematodeWormInterface>();

	private boolean getVideoFrameImageWasCalled = false;
	private boolean setObjectsOnImageWasCalled = false;

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		this.getVideoFrameImageWasCalled = true;
		return this.videoFrameImage;
	}

	public boolean wasGetVideoFrameImageCalled() {
		return this.getVideoFrameImageWasCalled;
	}

	public void setVideoFrameImage(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return this.objectsOnImage;
	}

	@Override
	public void setObjectsOnImage(final List<NematodeWormInterface> objectsOnImage) {
		this.objectsOnImage = objectsOnImage;
		this.setObjectsOnImageWasCalled = true;
	}

	public boolean wasSetObjectsOnImageCalled() {
		return this.setObjectsOnImageWasCalled;
	}
}
