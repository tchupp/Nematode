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
		final Thread thread = new Thread() {
			@Override
			public void run() {
				BeginScanButtonActionListener.this.viewController.updateImage();
			}
		};

		thread.start();
	}

	public TrackingPanelViewControllerInterface getPanelViewController() {
		return this.viewController;
	}
}
