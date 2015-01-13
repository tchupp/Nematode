package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class VideoPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;

	public VideoPanel() {
		this.setName("videoPanel");
		this.setLayout(new GridBagLayout());
		this.setBackground(GuiConstants.backgroundColor);

		addImageIcon();
		addBorder();
	}

	private void addImageIcon() {
		final ImageIcon defaultImageIcon = new ImageIcon(new BufferedImage(
				GuiConstants.DISPLAY_WIDTH, GuiConstants.DISPLAY_HEIGHT,
				BufferedImage.TYPE_INT_ARGB));

		this.imageLabel = new JLabel(defaultImageIcon);
		this.imageLabel.setName("imageLabel");
		this.imageLabel.setSize(GuiConstants.DISPLAY_WIDTH, GuiConstants.DISPLAY_HEIGHT);

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(1, 1, 1, 1);

		this.add(this.imageLabel, constraints);
	}

	private void addBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);
		this.setBorder(compoundBorder);
	}

	public JLabel getImageLabel() {
		return this.imageLabel;
	}
}
