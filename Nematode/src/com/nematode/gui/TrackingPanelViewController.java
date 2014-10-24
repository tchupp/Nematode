package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.model.VideoFrameHandlerInterface;

public class TrackingPanelViewController implements TrackingPanelViewControllerInterface {

	private final TrackingPanel trackingPanel;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public TrackingPanelViewController(final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		this.trackingPanel = new TrackingPanel();

		addListenerToScanButton();
	}

	private void addListenerToScanButton() {
		final ScanImageButtonActionListener scanImageButtonActionListener = new ScanImageButtonActionListener(
				this);
		final JButton scanButton = this.trackingPanel.getScanButton();
		scanButton.addActionListener(scanImageButtonActionListener);
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
