package com.nematode.gui;

public class StatusPanelViewController implements StatusPanelViewControllerInterface {

	private final StatusPanel statusPanel;

	public StatusPanelViewController() {
		this.statusPanel = new StatusPanel();
	}

	@Override
	public ExtendableJPanel getStatusPanel() {
		return this.statusPanel;
	}

}
