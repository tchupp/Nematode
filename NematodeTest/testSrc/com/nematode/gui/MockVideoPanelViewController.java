package com.nematode.gui;

import com.nematode.gui.backend.VideoFrameDisplayInfoInterface;
import com.nematode.model.VideoFrameSequenceInterface;

public class MockVideoPanelViewController implements VideoPanelViewControllerInterface {

	private boolean updateVideoDisplayWasCalled = false;

	@Override
	public ExtendableJPanel getVideoPanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void updateVideoDisplay() {
		this.updateVideoDisplayWasCalled = true;
	}

	public boolean wasUpdateVideoDisplayCalled() {
		return this.updateVideoDisplayWasCalled;
	}

	@Override
	public void updateDisplay(final VideoFrameDisplayInfoInterface displayInfo,
			final VideoFrameSequenceInterface videoSequence) {
	}

}
