package com.nematode.gui;

import com.nematode.gui.backend.VideoFrameDisplayInformationInterface;
import com.nematode.model.VideoFrameSequenceInterface;

public interface VideoPanelViewControllerInterface {

	public ExtendableJPanel getVideoPanel();

	public void updateVideoDisplay();

	public void updateDisplay(VideoFrameDisplayInformationInterface displayInfo,
			VideoFrameSequenceInterface videoSequence);
}
