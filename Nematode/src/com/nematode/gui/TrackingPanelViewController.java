package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.model.VideoFrameHandlerInterface;

public class TrackingPanelViewController implements TrackingPanelViewControllerInterface {

	private final TrackingPanel trackingPanel;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public TrackingPanelViewController(final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
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
		this.videoFrameHandler.scanImage();
		this.videoFrameHandler.updateDisplayImageFromScannedObjects();
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}
