package com.nematode.model;

public class VideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video;

	public VideoMatriarch() {
		this.video = new NullVideo();
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.video = video;
	}

	public VideoInterface getVideo() {
		return this.video;
	}
}
