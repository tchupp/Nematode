package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import com.nematode.nullmodel.NullBufferedImage;

public class VideoPanel extends ExtendableJPanel {

	public static final int ICON_WIDTH = 1500;
	public static final int ICON_HEIGHT = 900;

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;

	public VideoPanel() {
		this.setLayout(new GridBagLayout());
		addImagePanelAndImageIcon();
		addControlPanel();

		addBorder();
	}

	private void addImagePanelAndImageIcon() {
		final JPanel imagePanel = new JPanel();
		imagePanel.setName("imagePanel");
		imagePanel.setLayout(new GridBagLayout());

		final GridBagConstraints imagePanelConstraints = new GridBagConstraints();
		imagePanelConstraints.gridy = 0;
		imagePanelConstraints.weighty = 1;
		imagePanelConstraints.anchor = GridBagConstraints.NORTH;
		imagePanelConstraints.insets = new Insets(5, 5, 5, 5);

		this.add(imagePanel, imagePanelConstraints);

		this.imageLabel = new JLabel(new ImageIcon(new NullBufferedImage()));
		this.imageLabel.setName("imageLabel");
		this.imageLabel.setSize(ICON_WIDTH, ICON_HEIGHT);

		final GridBagConstraints imageLabelConstraints = new GridBagConstraints();
		imageLabelConstraints.gridy = 0;
		imageLabelConstraints.insets = new Insets(5, 5, 5, 5);

		imagePanel.add(this.imageLabel, imageLabelConstraints);
	}

	private void addControlPanel() {
		final JPanel controlPanel = new JPanel();
		controlPanel.setName("controlPanel");

		final GridBagConstraints controlPanelConstraints = new GridBagConstraints();
		controlPanelConstraints.gridy = 1;
		controlPanelConstraints.anchor = GridBagConstraints.SOUTH;
		controlPanelConstraints.insets = new Insets(5, 5, 5, 5);

		this.add(controlPanel, controlPanelConstraints);
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
