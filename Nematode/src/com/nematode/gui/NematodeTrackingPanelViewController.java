package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.model.NematodeVideoFrameInterface;

public class NematodeTrackingPanelViewController implements
NematodePanelViewControllerInterface {

	private final NematodeTrackingPanel nematodeTrackingPanel;
	private final NematodeVideoFrameInterface nematodeVideoFrame;

	public NematodeTrackingPanelViewController(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
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
	public NematodePanel getNematodePanel() {
		return this.nematodeTrackingPanel;
	}

	@Override
	public void updateImage() {
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}
}