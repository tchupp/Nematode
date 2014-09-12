package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanImageButtonActionListener implements ActionListener {

	private final NematodePanelViewControllerInterface viewController;

	public ScanImageButtonActionListener(
			final NematodePanelViewControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.updateImage();
	}

	public NematodePanelViewControllerInterface getPanelViewController() {
		return this.viewController;
	}

}
