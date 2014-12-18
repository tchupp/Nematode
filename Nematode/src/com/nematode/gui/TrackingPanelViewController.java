package com.nematode.gui;

import javax.swing.JButton;

public class TrackingPanelViewController implements TrackingPanelViewControllerInterface {

	private final TrackingPanel trackingPanel;

	public TrackingPanelViewController() {
		this.trackingPanel = new TrackingPanel();

		addListenerToBeginScanButton();
	}

	private void addListenerToBeginScanButton() {
		final BeginScanButtonActionListener beginScanButtonActionListener = new BeginScanButtonActionListener(
				this);
		final JButton beginScanButton = this.trackingPanel.getBeginScanButton();
		beginScanButton.addActionListener(beginScanButtonActionListener);
	}

	@Override
	public ExtendableJPanel getTrackingPanel() {
		return this.trackingPanel;
	}

	@Override
	public void updateImage() {
	}

}
