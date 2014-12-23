package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public interface VideoInterface {

	public void start();

	public int getWidth();

	public int getHeight();

	public boolean isValid();

	public Mat getThumbnail();

	public void stop();

	public Mat grab();

}
