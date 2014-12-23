package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideo implements VideoInterface {

	@Override
	public void start() {
		// TODO Auto-generated method stub
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Mat getThumbnail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public Mat grab() {
		// TODO Auto-generated method stub
		return null;
	}

}
