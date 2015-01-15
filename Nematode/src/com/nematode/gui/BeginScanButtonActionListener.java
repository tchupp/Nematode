package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginScanButtonActionListener implements ActionListener {

	private final TrackingPanelViewControllerInterface viewController;

	public BeginScanButtonActionListener(final TrackingPanelViewControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
	}

	public TrackingPanelViewControllerInterface getPanelViewController() {
		return this.viewController;
	}
}
