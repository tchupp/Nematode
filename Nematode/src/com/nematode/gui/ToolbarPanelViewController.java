package com.nematode.gui;

import java.util.ArrayList;

import javax.swing.JButton;

public class ToolbarPanelViewController implements ToolbarPanelViewControllerInterface {

	private final ToolbarPanel toolbarPanel;
	private final ArrayList<ToolbarObserverInterface> observerList;

	public ToolbarPanelViewController() {
		this.toolbarPanel = new ToolbarPanel();
		this.observerList = new ArrayList<ToolbarObserverInterface>();

		addListenerToPlayButton();
	}

	private void addListenerToPlayButton() {
		final PlayButtonActionListener playButtonActionListener = new PlayButtonActionListener(this);

		final JButton playButton = this.toolbarPanel.getPlayButton();
		playButton.addActionListener(playButtonActionListener);
	}

	@Override
	public void addObserver(final ToolbarObserverInterface observer) {
		this.observerList.add(observer);
	}

	@Override
	public void removeObserver(final ToolbarObserverInterface observer) {
		final int observerIndex = this.observerList.indexOf(observer);
		this.observerList.remove(observerIndex);
	}

	@Override
	public void playButtonPressed() {
		for (final ToolbarObserverInterface observer : this.observerList) {
			observer.notifyPlayButtonPressed();
		}
	}

	@Override
	public ExtendableJPanel getToolbarPanel() {
		return this.toolbarPanel;
	}

	public ArrayList<ToolbarObserverInterface> getObserverList() {
		return this.observerList;
	}
}
