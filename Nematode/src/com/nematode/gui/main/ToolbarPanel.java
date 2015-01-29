package com.nematode.gui.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import com.nematode.bucket.StrategyBucket;
import com.nematode.gui.ExtendableJPanel;
import com.nematode.gui.GuiConstants;
import com.nematode.gui.ImageStoreInterface;

public class ToolbarPanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private JButton playButton;
	private JButton pauseButton;
	private JButton stopButton;

	public ToolbarPanel() {
		this.setName("toolbarPanel");
		this.setLayout(new GridBagLayout());
		this.setBackground(GuiConstants.BACKGROUND_COLOR);

		addPlayButton();
		addPauseButton();
		addStopButton();

		addBorder();
	}

	private void addPlayButton() {
		this.playButton = new JButton();
		this.playButton.setName("playButton");
		this.playButton.setPreferredSize(new Dimension(20, 20));

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		final ImageIcon imageIcon = new ImageIcon(imageStore.getPlayButtonImage());
		this.playButton.setIcon(imageIcon);

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.playButton, constraints);
	}

	private void addPauseButton() {
		this.pauseButton = new JButton();
		this.pauseButton.setName("pauseButton");
		this.pauseButton.setPreferredSize(new Dimension(20, 20));

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		final ImageIcon imageIcon = new ImageIcon(imageStore.getPauseButtonImage());
		this.pauseButton.setIcon(imageIcon);

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0.0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.pauseButton, constraints);
	}

	private void addStopButton() {
		this.stopButton = new JButton();
		this.stopButton.setName("stopButton");
		this.stopButton.setPreferredSize(new Dimension(20, 20));

		final ImageStoreInterface imageStore = StrategyBucket.getImageStore();
		final ImageIcon imageIcon = new ImageIcon(imageStore.getStopButtonImage());
		this.stopButton.setIcon(imageIcon);

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.weightx = 1.0;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		this.add(this.stopButton, constraints);
	}

	private void addBorder() {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);
		this.setBorder(compoundBorder);
	}

	public JButton getPlayButton() {
		return this.playButton;
	}

	public JButton getPauseButton() {
		return this.pauseButton;
	}

	public JButton getStopButton() {
		return this.stopButton;
	}
}
