package com.nematode.gui;

public class MockTrackingPanelViewController implements TrackingPanelViewControllerInterface {

	@Override
	public ExtendableJPanel getTrackingPanel() {
		return new ExtendableJPanel();
	}
}
