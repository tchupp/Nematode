package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.VideoFrameImageInterface;

public class NematodeVideoFrame implements NematodeVideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage;
	private final List<NematodeVideoFrameObserverInterface> videoFrameObservers;

	public NematodeVideoFrame(final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		this.videoFrameObservers = new ArrayList<NematodeVideoFrameObserverInterface>();
	}

	@Override
	public void dispose() {
		this.videoFrameObservers.clear();
	}

	@Override
	public VideoFrameImageInterface getVideoFrameImage() {
		return this.videoFrameImage;
	}

	@Override
	public void setVideoFrameImage(
			final VideoFrameImageInterface videoFrameImage) {
		this.videoFrameImage = videoFrameImage;
		notifyFrameHasBeenSet();
	}

	@Override
	public void addObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {
		this.videoFrameObservers.add(nematodeVideoFrameObserver);
	}

	@Override
	public void removeObserver(
			final NematodeVideoFrameObserverInterface nematodeVideoFrameObserver) {
		this.videoFrameObservers.remove(nematodeVideoFrameObserver);
	}

	@Override
	public List<NematodeVideoFrameObserverInterface> getListOfObservers() {
		return this.videoFrameObservers;
	}

	private void notifyFrameHasBeenSet() {
		for (final NematodeVideoFrameObserverInterface observer : this.videoFrameObservers) {
			observer.notifyFrameHasBeenSet();
		}
	}
}
