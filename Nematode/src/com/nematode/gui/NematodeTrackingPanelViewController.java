package com.nematode.gui;

public class NematodeTrackingPanelViewController implements
		NematodePanelViewControllerInterface {

	private final NematodeTrackingPanel nematodeTrackingPanel;

	public NematodeTrackingPanelViewController() {
		this.nematodeTrackingPanel = new NematodeTrackingPanel();
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeTrackingPanel;
	}
}
