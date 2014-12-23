package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public interface VideoObserverInterface {

	public void notifyVideoHasBeenSet(Mat thumbnail);

}
