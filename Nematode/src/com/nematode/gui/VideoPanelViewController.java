package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.image.processing.ImageResizerInterface;

public class VideoPanelViewController implements VideoPanelViewControllerInterface {

	private final VideoPanel videoPanel;
	private final ImageResizerInterface imageResizer;

	public VideoPanelViewController(final ImageResizerInterface imageResizer) {
		this.imageResizer = imageResizer;
		this.videoPanel = new VideoPanel();
	}

	@Override
	public ExtendableJPanel getVideoPanel() {
		return this.videoPanel;
	}

	@Override
	public void showImage(final Mat displayImage) {
		final BufferedImage newImageForLabel = this.imageResizer.resizeImageWithAspect(
				displayImage.getBufferedImage(), GuiConstants.DISPLAY_WIDTH,
				GuiConstants.DISPLAY_HEIGHT);

		final ImageIcon newImageIcon = new ImageIcon(newImageForLabel);
		final JLabel imageLabel = this.videoPanel.getImageLabel();

		imageLabel.setIcon(newImageIcon);
	}

	public ImageResizerInterface getImageResizer() {
		return this.imageResizer;
	}

}
