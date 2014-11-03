package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class BeginScanButtonActionListener implements ActionListener {

	private final TrackingPanelViewControllerInterface viewController;

	public BeginScanButtonActionListener(final TrackingPanelViewControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BeginScanButtonActionListener.this.viewController.updateImage();
			}
		});
	}

	public TrackingPanelViewControllerInterface getPanelViewController() {
		return this.viewController;
	}
}
