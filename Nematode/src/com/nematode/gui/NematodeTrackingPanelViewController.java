package com.nematode.gui;

public class NematodeTrackingPanelViewController {

	private final NematodeTrackingPanel nematodeTrackingPanel;

	public NematodeTrackingPanelViewController() {
		this.nematodeTrackingPanel = new NematodeTrackingPanel();
	}

	public NematodeTrackingPanel getNematodeTrackingPanel() {
		return this.nematodeTrackingPanel;
	}
}
