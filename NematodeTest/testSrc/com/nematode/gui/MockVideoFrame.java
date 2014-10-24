package com.nematode.gui;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.MockDisplayFrameImage;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameObserverInterface;

public class MockVideoFrame implements VideoFrameInterface {

	private int numberOfObservers = 0;

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();
	private DisplayFrameImageInterface displayFrameImage = new MockDisplayFrameImage();
	private List<NematodeWormInterface> objectsOnImage = new ArrayList<NematodeWormInterface>();

	private boolean setVideoFrameImageWasCalled = false;
	private boolean getVideoFrameImageWasCalled = false;
	private boolean setDisplayFrameImageWasCalled = false;
	private boolean getDisplayFrameImageWasCalled = false;
	private boolean setObjectsOnImageWasCalled = false;

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		this.getVideoFrameImageWasCalled = true;
		return this.videoFrameImage;
	}

	public boolean wasGetVideoFrameImageCalled() {
		return this.getVideoFrameImageWasCalled;
	}

	@Override
	public void setVideoFrameImage(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		this.setVideoFrameImageWasCalled = true;
	}

	public boolean wasSetVideoFrameImageCalled() {
		return this.setVideoFrameImageWasCalled;
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		this.getDisplayFrameImageWasCalled = true;
		return this.displayFrameImage;
	}

	public boolean wasGetDisplayFrameImageCalled() {
		return this.getDisplayFrameImageWasCalled;
	}

	@Override
	public void setDisplayFrameImage(final DisplayFrameImageInterface displayFrameImage) {
		this.displayFrameImage = displayFrameImage;
		this.setDisplayFrameImageWasCalled = true;
	}

	public boolean wasSetDisplayFrameImageCalled() {
		return this.setDisplayFrameImageWasCalled;
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

	@Override
	public void addObserver(final VideoFrameObserverInterface videoFrameObserver) {
		this.numberOfObservers++;
	}

	@Override
	public void removeObserver(final VideoFrameObserverInterface videoFrameObserver) {
		if (this.numberOfObservers > 0) {
			this.numberOfObservers--;
		}
	}

	@Override
	public List<VideoFrameObserverInterface> getListOfObservers() {
		return new ArrayList<VideoFrameObserverInterface>();
	}

	public int getNumberOfObservers() {
		return this.numberOfObservers;
	}

	@Override
	public void dispose() {
	}
}
