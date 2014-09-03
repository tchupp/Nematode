package com.nematode.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class NematodeProjectPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public NematodeProjectPanel() {
		setupBorder();
		setupOpenImageButton();
	}

	private void setupOpenImageButton() {
		final JButton openImageButton = new JButton();
		openImageButton.setName("openImageButton");
		openImageButton.setText("Open Image");
		this.add(openImageButton);
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
}
