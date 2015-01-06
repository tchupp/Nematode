package com.nematode.gui;

import javax.swing.JButton;

public class ToolbarPanelViewController implements ToolbarPanelViewControllerInterface {

	private final ToolbarPanel toolbarPanel;

	public ToolbarPanelViewController() {
		this.toolbarPanel = new ToolbarPanel();

		addListenerToPlayButton();
	}

	private void addListenerToPlayButton() {
		final PlayButtonActionListener playButtonActionListener = new PlayButtonActionListener(this);

		final JButton playButton = this.toolbarPanel.getPlayButton();
		playButton.addActionListener(playButtonActionListener);
	}

	@Override
	public void playButtonPressed() {
	}

	@Override
	public ExtendableJPanel getToolbarPanel() {
		return this.toolbarPanel;
	}

}
