package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;

public class LoadedVideo implements VideoInterface {

	private final FrameGrabber frameGrabber;
	private Mat thumbnail;

	public LoadedVideo(final FrameGrabber frameGrabber) {
		this.frameGrabber = frameGrabber;

		try {
			this.frameGrabber.start();
			final IplImage image = this.frameGrabber.grab();
			this.thumbnail = new Mat(image, true);
			this.frameGrabber.stop();
		} catch (final Exception exception) {
			this.thumbnail = new Mat();
		}
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
			return new Mat(image, true);
		} catch (final FrameGrabber.Exception exception) {
			return new Mat();
		}
	}

	@Override
	public Mat getThumbnail() {
		return this.thumbnail;
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

	@Override
	public double getFrameRate() {
		try {
			this.frameGrabber.start();
			final double frameRate = this.frameGrabber.getFrameRate();
			this.frameGrabber.stop();

			return frameRate;
		} catch (final Exception exception) {
		}
		return 0;
	}

	@Override
	public long getDurration() {
		return this.frameGrabber.getLengthInTime();
	}

	@Override
	public int getFrameLength() {
		return this.frameGrabber.getLengthInFrames();
	}

	@Override
	public int getCurrentFrame() {
		return this.frameGrabber.getFrameNumber();
	}

	public FrameGrabber getFrameGrabber() {
		return this.frameGrabber;
	}
}
