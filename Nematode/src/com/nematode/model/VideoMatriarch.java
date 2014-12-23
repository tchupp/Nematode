package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

public class VideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video;
	private final List<VideoObserverInterface> observerList;

	public VideoMatriarch() {
		this.video = new NullVideo();
		this.observerList = new ArrayList<VideoObserverInterface>();
	}

	@Override
	public VideoInterface getVideo() {
		return this.video;
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.video = video;
		notifyObserversVideoHasBeenSet();
	}

	@Override
	public void addObserver(final VideoObserverInterface observer) {
		this.observerList.add(observer);
	}

	@Override
	public void removeObserver(final VideoObserverInterface observer) {
		final int observerIndex = this.observerList.indexOf(observer);
		this.observerList.remove(observerIndex);
	}

	private void notifyObserversVideoHasBeenSet() {
		for (final VideoObserverInterface observer : this.observerList) {
			observer.notifyVideoHasBeenSet(this.video.getThumbnail());
		}
	}

	public List<VideoObserverInterface> getObserverList() {
		return this.observerList;
	}
}
