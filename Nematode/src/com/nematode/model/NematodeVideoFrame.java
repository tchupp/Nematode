package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import com.nematode.imaging.DisplayFrameImageInterface;
import com.nematode.imaging.VideoFrameImageInterface;
import com.nematode.nullmodel.NullFrameImage;

public class NematodeVideoFrame implements NematodeVideoFrameInterface {

	private VideoFrameImageInterface videoFrameImage;
	private DisplayFrameImageInterface displayFrameImage;
	private List<NematodeWormInterface> objectsOnImage;
	private final List<NematodeVideoFrameObserverInterface> videoFrameObservers;

	public NematodeVideoFrame() {
		this.videoFrameImage = NullFrameImage.NULL;
		this.displayFrameImage = NullFrameImage.NULL;
		this.setObjectsOnImage(new ArrayList<NematodeWormInterface>());
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
	}

	@Override
	public DisplayFrameImageInterface getDisplayFrameImage() {
		return this.displayFrameImage;
	}

	@Override
	public void setDisplayFrameImage(
			final DisplayFrameImageInterface displayFrameImage) {
		this.displayFrameImage = displayFrameImage;
		notifyDisplayFrameHasBeenSet();
	}

	@Override
	public List<NematodeWormInterface> getObjectsOnImage() {
		return this.objectsOnImage;
	}

	@Override
	public void setObjectsOnImage(
			final List<NematodeWormInterface> objectsOnImage) {
		this.objectsOnImage = objectsOnImage;
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

	private void notifyDisplayFrameHasBeenSet() {
		for (final NematodeVideoFrameObserverInterface observer : this.videoFrameObservers) {
			observer.notifyDisplayFrameHasBeenSet();
		}
	}

}
