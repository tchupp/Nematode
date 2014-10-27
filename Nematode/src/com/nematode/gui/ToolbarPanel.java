package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class ToolbarPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;

	public ToolbarPanel() {
		this.setName("toolbarPanel");

		addBorder();
	}

	private void addBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);
		this.setBorder(compoundBorder);
	}

}
