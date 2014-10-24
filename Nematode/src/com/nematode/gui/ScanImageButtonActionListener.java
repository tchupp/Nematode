package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanImageButtonActionListener implements ActionListener {

	private final TrackingPanelViewControllerInterface viewController;

	public ScanImageButtonActionListener(final TrackingPanelViewControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.updateImage();
	}

	public TrackingPanelViewControllerInterface getPanelViewController() {
		return this.viewController;
	}

}
