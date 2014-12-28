package com.nematode.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImagePanel extends ExtendableJPanel {

	private static final long serialVersionUID = 1L;
	private final BufferedImage image;

	public ImagePanel(final BufferedImage image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.drawImage(this.image, 0, 0, null);
	}

	public BufferedImage getImage() {
		return this.image;
	}
}
