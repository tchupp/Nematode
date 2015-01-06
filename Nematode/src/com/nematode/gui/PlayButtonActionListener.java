package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonActionListener implements ActionListener {

	private final ToolbarPanelViewControllerInterface viewController;

	public PlayButtonActionListener(final ToolbarPanelViewControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.playButtonPressed();
	}

	public ToolbarPanelViewControllerInterface getViewController() {
		return this.viewController;
	}
}
