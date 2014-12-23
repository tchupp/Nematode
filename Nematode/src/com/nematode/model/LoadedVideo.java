package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.FrameGrabber;

public class LoadedVideo implements VideoInterface {

	private final FrameGrabber frameGrabber;

	public LoadedVideo(final FrameGrabber frameGrabber) {
		this.frameGrabber = frameGrabber;
	}

	@Override
	public void start() {
		try {
			this.frameGrabber.start();
		} catch (final FrameGrabber.Exception exception) {
		}
	}

	@Override
	public void stop() {
		try {
			this.frameGrabber.stop();
		} catch (final FrameGrabber.Exception exception) {
		}
	}

	@Override
	public Mat grab() {
		try {
			final IplImage image = this.frameGrabber.grab();
			return new Mat(image);
		} catch (final FrameGrabber.Exception exception) {
			return new Mat();
		}
	}

	@Override
	public Mat getThumbnail() {
		try {
			this.frameGrabber.stop();
			this.frameGrabber.start();
			final IplImage image = this.frameGrabber.grab();
			this.frameGrabber.stop();

			return new Mat(image);
		} catch (final FrameGrabber.Exception exception) {
		}
		return new Mat();
	}

	@Override
	public int getWidth() {
		return this.frameGrabber.getImageWidth();
	}

	@Override
	public int getHeight() {
		return this.frameGrabber.getImageHeight();
	}

	@Override
	public boolean isValid() {
		try {
			this.frameGrabber.start();
			this.frameGrabber.stop();
			return true;
		} catch (final FrameGrabber.Exception exception) {
		}
		return false;
	}

	public FrameGrabber getFrameGrabber() {
		return this.frameGrabber;
	}
}
