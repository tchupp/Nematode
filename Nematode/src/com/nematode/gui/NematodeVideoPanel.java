package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class NematodeVideoPanel extends NematodePanel {

	private static final long serialVersionUID = 1L;

	public NematodeVideoPanel() {
		setupBorder();
	}

	private void setupBorder() {
		final Border raisedBevelBorder = BorderFactory
				.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory
				.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory
				.createCompoundBorder(raisedBevelBorder, loweredBevelBorder);

		this.setBorder(compoundBorder);
	}
}
