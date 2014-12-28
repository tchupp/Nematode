package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nematode.image.NullBufferedImage;

public class MainWindow extends ExtendableJFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(GuiConstants.VIDEO_FRAME_WIDTH, GuiConstants.VIDEO_FRAME_HEIGHT);

		addContentPane();
	}

	private void addContentPane() {
		BufferedImage backgroundImage = new NullBufferedImage();
		try {
			backgroundImage = ImageIO
					.read(new File(GuiConstants.MAIN_WINDOW_BACKGROUND_IMAGE_PATH));
		} catch (final IOException exception) {
		}

		final Container contentPane = new ImagePanel(backgroundImage);
		contentPane.setLayout(new GridBagLayout());
		this.setContentPane(contentPane);
	}
}
