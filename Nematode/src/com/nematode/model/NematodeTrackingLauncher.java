package com.nematode.model;

import com.nematode.gui.NematodeMainWindow;
import com.nematode.gui.NematodeVideoContainerPanel;

public class NematodeTrackingLauncher {

	public static void main(String[] args) {
		new NematodeMainWindow(new NematodeVideoContainerPanel());
	}
}