package com.nematode.gui;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.MockDisplayFrameImage;
import com.nematode.imaging.MockProcessedFrameImage;
import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.imaging.ProcessedFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class MockNematodeVideoFrame implements NematodeVideoFrameInterface {

	private int numberOfObservers = 0;

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();
	private DisplayFrameImageInterface displayFrameImage = new MockDisplayFrameImage();
	private ProcessedFrameImageInterface processedFrameImage = new MockProcessedFrameImage();

	private boolean setVideoFrameImageWasCalled = false;
	private boolean getVideoFrameImageWasCalled = false;
	private boolean setDisplayFrameImageWasCalled = false;
	private boolean getDisplayFrameImageWasCalled = false;
	private boolean setProcessedFrameImageWasCalled = false;
	private boolean getProcessedFrameImageWasCalled = false;

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		this.getVideoFrameImageWasCalled = true;
		return this.videoFrameImage;
	}

	public boolean wasGetVideoFrameImageCalled() {
		return this.getVideoFrameImageWasCalled;
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
		this.getDisplayFrameImageWasCalled = true;
		return this.displayFrameImage;
	}

	public boolean wasGetDisplayFrameImageCalled() {
		return this.getDisplayFrameImageWasCalled;
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
	public ProcessedFrameImageInterface getProcessedFrameImage() {
		this.getProcessedFrameImageWasCalled = true;
		return this.processedFrameImage;
	}

	public boolean wasGetProcessedFrameImageCalled() {
		return this.getProcessedFrameImageWasCalled;
	}

	@Override
	public void setProcessedFrameImage(
			final ProcessedFrameImageInterface processedFrameImage) {
		this.setProcessedFrameImageWasCalled = true;
		this.processedFrameImage = processedFrameImage;
	}

	public boolean wasSetProcessedFrameImageCalled() {
		return this.setProcessedFrameImageWasCalled;
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
