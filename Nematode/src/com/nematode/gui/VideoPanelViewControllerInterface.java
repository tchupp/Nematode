package com.nematode.gui;

import org.bytedeco.javacpp.opencv_core.Mat;

public interface VideoPanelViewControllerInterface {

	public ExtendableJPanel getVideoPanel();

	public void showImage(Mat displayImage);
}
