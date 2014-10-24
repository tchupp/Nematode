package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.model.VideoFrameHandlerInterface;

public class NematodeTrackingPanelViewController implements
		NematodePanelViewControllerInterface {

	private final NematodeTrackingPanel nematodeTrackingPanel;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public NematodeTrackingPanelViewController(
			final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		this.nematodeTrackingPanel = new NematodeTrackingPanel();

		addListenerToScanButton();
	}

	private void addListenerToScanButton() {
		final ScanImageButtonActionListener scanImageButtonActionListener = new ScanImageButtonActionListener(
				this);
		final JButton scanButton = this.nematodeTrackingPanel.getScanButton();
		scanButton.addActionListener(scanImageButtonActionListener);
	}

	@Override
	public ExtendableJPanel getNematodePanel() {
		return this.nematodeTrackingPanel;
	}

	@Override
	public void updateImage() {
		this.videoFrameHandler.scanImage();
		this.videoFrameHandler.updateDisplayImageFromScannedObjects();
	}

	@Override
	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}