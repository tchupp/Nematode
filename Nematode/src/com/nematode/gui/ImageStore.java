package com.nematode.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore implements ImageStoreInterface {

	private final File playButtonImageFile;
	private final File pauseButtonImageFile;
	private final File stopButtonImageFile;
	private final File mainWindowBackgroundImageFile;

	private final BufferedImage playButtonImage;
	private final BufferedImage pauseButtonImage;
	private final BufferedImage stopButtonImage;
	private final BufferedImage mainWindowBackgroundImage;

	public ImageStore() throws IOException {
		this.playButtonImageFile = new File("resources/gui/buttons/playButtonImage.png");
		this.pauseButtonImageFile = new File("resources/gui/buttons/pauseButtonImage.png");
		this.stopButtonImageFile = new File("resources/gui/backgrounds/darkWood.jpg");
		this.mainWindowBackgroundImageFile = new File("resources/gui/backgrounds/darkWood.jpg");

		this.playButtonImage = ImageIO.read(this.playButtonImageFile);
		this.pauseButtonImage = ImageIO.read(this.pauseButtonImageFile);
		this.stopButtonImage = ImageIO.read(this.stopButtonImageFile);
		this.mainWindowBackgroundImage = ImageIO.read(this.mainWindowBackgroundImageFile);
	}

	@Override
	public BufferedImage getPlayButtonImage() {
		return this.playButtonImage;
	}

	@Override
	public BufferedImage getPauseButtonImage() {
		return this.pauseButtonImage;
	}

	@Override
	public BufferedImage getStopButtonImage() {
		return this.stopButtonImage;
	}

	@Override
	public BufferedImage getMainWindowBackgroundImage() {
		return this.mainWindowBackgroundImage;
	}

	public File getPlayButtonImageFile() {
		return this.playButtonImageFile;
	}

	public File getPauseButtonImageFile() {
		return this.pauseButtonImageFile;
	}

	public File getStopButtonImageFile() {
		return this.stopButtonImageFile;
	}

	public File getMainWindowBackgroundImageFile() {
		return this.mainWindowBackgroundImageFile;
	}
}
