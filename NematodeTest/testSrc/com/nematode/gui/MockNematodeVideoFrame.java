package com.nematode.gui;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.MockDisplayFrameImage;
import com.nematode.imaging.MockScannedFrameImage;
import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.imaging.ScannedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class MockNematodeVideoFrame implements NematodeVideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();
	private DisplayFrameImageInterface displayFrameImage = new MockDisplayFrameImage();
	private ScannedFrameImageInterface scannedFrameImage = new MockScannedFrameImage();
	private int numberOfObservers = 0;
	private boolean setVideoFrameImageWasCalled = false;
	private boolean setDisplayFrameImageWasCalled = false;
	private boolean setScannedFrameImageWasCalled = false;

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		this.setVideoFrameImageWasCalled = true;
	}

	public boolean wasSetVideoFrameImageCalled() {
		return this.setVideoFrameImageWasCalled;
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return this.displayFrameImage;
	}

	@Override
	public void setDisplayFrameImage(
			final DisplayFrameImageInterface displayFrameImage) {
		this.displayFrameImage = displayFrameImage;
		this.setDisplayFrameImageWasCalled = true;
	}

	public boolean wasSetDisplayFrameImageCalled() {
		return this.setDisplayFrameImageWasCalled;
	}

	@Override
	public ScannedFrameImageInterface getScannedFrameImage() {
		return this.scannedFrameImage;
	}

	@Override
	public void setScannedFrameImage(
			final ScannedFrameImageInterface scannedFrameImage) {
		this.setScannedFrameImageWasCalled = true;
		this.scannedFrameImage = scannedFrameImage;
	}

	public boolean wasSetScannedFrameImageCalled() {
		return this.setScannedFrameImageWasCalled;
	}

	@Override
	public void addObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {
		this.numberOfObservers++;
	}

	@Override
	public void removeObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {
		if (this.numberOfObservers > 0) {
			this.numberOfObservers--;
		}
	}

	@Override
	public List<NematodeVideoFrameObserverInterface> getListOfObservers() {
		return new ArrayList<NematodeVideoFrameObserverInterface>();
	}

	public int getNumberOfObservers() {
		return this.numberOfObservers;
	}

	@Override
	public void dispose() {
	}

}
