package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class ProjectPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;

	private JButton openImageButton;
	private JButton openVideoButton;

	public ProjectPanel() {
		this.setName("projectPanel");
		this.setLayout(new GridBagLayout());
		this.setBackground(GuiConstants.backgroundColor);
		this.setOpaque(false);

		setupBorder();
		setupOpenImageButton();
		setupOpenVideoButton();
	}

	private void setupOpenImageButton() {
		this.openImageButton = new JButton();
		this.openImageButton.setName("openImageButton");
		this.openImageButton.setText("Open Image");

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.openImageButton, constraints);
	}

	private void setupOpenVideoButton() {
		this.openVideoButton = new JButton();
		this.openVideoButton.setName("openVideoButton");
		this.openVideoButton.setText("Open Video");

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.openVideoButton, constraints);
	}

	private void setupBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);

		setBorder(compoundBorder);
	}

	public JButton getOpenImageButton() {
		return this.openImageButton;
	}

	public JButton getOpenVideoButton() {
		return this.openVideoButton;
	}
}
