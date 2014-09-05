package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import com.nematode.nullmodel.NullBufferedImage;

public class NematodeVideoPanel extends NematodePanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;

	public NematodeVideoPanel() {
		this.setLayout(new GridBagLayout());
		addImageLabel();
		addBorder();
	}

	private void addImageLabel() {
		this.imageLabel = new JLabel(new ImageIcon(new NullBufferedImage()));
		this.imageLabel.setName("imageLabel");
		this.imageLabel.setSize(1200, 900);

		final GridBagConstraints imageLabelConstraints = new GridBagConstraints();
		imageLabelConstraints.gridy = 0;
		imageLabelConstraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.imageLabel, imageLabelConstraints);
	}

	private void addBorder() {
		final Border raisedBevelBorder = BorderFactory
				.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory
				.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory
				.createCompoundBorder(raisedBevelBorder, loweredBevelBorder);
		this.setBorder(compoundBorder);
	}

	public JLabel getImageLabel() {
		return this.imageLabel;
	}
}
