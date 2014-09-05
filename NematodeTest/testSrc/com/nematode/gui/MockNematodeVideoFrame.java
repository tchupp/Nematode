package com.nematode.gui;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.MockVideoFrameImage;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeVideoFrameObserverInterface;

public class MockNematodeVideoFrame implements NematodeVideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage = new MockVideoFrameImage();
	private int numberOfObservers = 0;
	private DisplayFrameImageInterface displayFrameImage;

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return this.displayFrameImage;
	}

	@Override
	public void setDisplayFrameImage(
			final DisplayFrameImageInterface displayFrameImage) {
		this.displayFrameImage = displayFrameImage;

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
