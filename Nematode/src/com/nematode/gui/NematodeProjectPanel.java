package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class NematodeProjectPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton openImageButton;

	public NematodeProjectPanel() {
		setupBorder();
		setupOpenImageButton();
	}

	private void setupOpenImageButton() {
		this.openImageButton = new JButton();
		this.openImageButton.setName("openImageButton");
		this.openImageButton.setText("Open Image");
		this.add(this.openImageButton);
	}

	private void setupBorder() {
		final Border raisedBevelBorder = BorderFactory
				.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory
				.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory
				.createCompoundBorder(raisedBevelBorder, loweredBevelBorder);

		setBorder(compoundBorder);
	}

	public JButton getOpenImageButton() {
		return this.openImageButton;
	}
}
