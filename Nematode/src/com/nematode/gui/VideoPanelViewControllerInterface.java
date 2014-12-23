package com.nematode.gui;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.gui.backend.VideoFrameDisplayInfoInterface;
import com.nematode.model.VideoFrameSequenceInterface;

public interface VideoPanelViewControllerInterface {

	public ExtendableJPanel getVideoPanel();

	public void updateDisplay(VideoFrameDisplayInfoInterface displayInfo,
			VideoFrameSequenceInterface videoSequence);

	public void showImage(Mat displayImage);
}
