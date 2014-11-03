package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class TrackingPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private JButton scanButton;

	public TrackingPanel() {
		this.setName("trackingPanel");
		this.setLayout(new GridBagLayout());

		setupTrackingButton();
		setupBorder();
	}

	private void setupTrackingButton() {
		this.scanButton = new JButton();
		this.scanButton.setName("beginScanButton");
		this.scanButton.setText("Begin Scan");

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.scanButton, constraints);
	}

	private void setupBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);

		this.setBorder(compoundBorder);
	}

	public JButton getScanButton() {
		return this.scanButton;
	}
}
