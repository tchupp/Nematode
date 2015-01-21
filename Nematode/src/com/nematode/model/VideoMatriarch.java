package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

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

	@Override
	public Mat grabCurrentFrame() {
		return this.video.grab();
	}

	@Override
	public void startVideo() {
		this.video.start();
	}

	@Override
	public void stopVideo() {
		this.video.stop();
	}
}
