package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class TrackingPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private JButton scanButton;

	public TrackingPanel() {
		this.setName("trackingPanel");

		setupTrackingButton();
		setupBorder();
	}

	private void setupTrackingButton() {
		this.scanButton = new JButton();
		this.scanButton.setName("scanButton");
		this.scanButton.setText("Scan Image");
		this.add(this.scanButton);
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
