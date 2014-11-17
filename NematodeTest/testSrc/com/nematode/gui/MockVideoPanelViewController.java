package com.nematode.gui;

import com.nematode.gui.backend.VideoFrameDisplayInfoInterface;
import com.nematode.model.VideoFrameSequenceInterface;

public class MockVideoPanelViewController implements VideoPanelViewControllerInterface {

	@Override
	public ExtendableJPanel getVideoPanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void updateDisplay(final VideoFrameDisplayInfoInterface displayInfo,
			final VideoFrameSequenceInterface videoSequence) {
	}

}
