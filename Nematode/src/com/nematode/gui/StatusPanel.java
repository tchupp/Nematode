package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class StatusPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;

	public StatusPanel() {
		this.setName("statusPanel");

		addStatusLabel();
		addBorder();
	}

	private void addStatusLabel() {
		this.statusLabel = new JLabel();
		this.statusLabel.setName("statusLabel");
		this.add(this.statusLabel);
	}

	private void addBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);

		this.setBorder(compoundBorder);
	}

	public JLabel getStatusLabel() {
		return this.statusLabel;
	}
}
