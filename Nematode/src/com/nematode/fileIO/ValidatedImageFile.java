package com.nematode.fileIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nematode.image.NullBufferedImage;

public class ValidatedImageFile implements ValidatedImageFileInterface {

	private final File imageFile;
	private boolean isFileValid;
	private BufferedImage fileImage;

	public ValidatedImageFile(final File imageFile) {
		this.imageFile = imageFile;

		loadImageFromFile();
	}

	private void loadImageFromFile() {
		try {
			this.fileImage = ImageIO.read(this.imageFile);
			this.isFileValid = true;
		} catch (final IOException exception) {
			this.fileImage = new NullBufferedImage();
			this.isFileValid = false;
		}
	}

	@Override
	public BufferedImage getFileImage() {
		return this.fileImage;
	}

	@Override
	public boolean isFileValid() {
		return this.isFileValid;
	}

	public File getImageFile() {
		return this.imageFile;
	}

}
