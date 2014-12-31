package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class NullVideo implements VideoInterface {

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}

	@Override
	public int getWidth() {
		return -1;
	}

	@Override
	public int getHeight() {
		return -1;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Mat getThumbnail() {
		return new Mat();
	}

	@Override
	public Mat grab() {
		return new Mat();
	}

	@Override
	public double getFrameRate() {
		return -1;
	}

	@Override
	public long getDurration() {
		return -1;
	}

	@Override
	public int getFrameLength() {
		return -1;
	}

	@Override
	public int getCurrentFrame() {
		return -1;
	}
}
