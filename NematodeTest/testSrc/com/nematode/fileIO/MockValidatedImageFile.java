package com.nematode.fileIO;

import java.awt.image.BufferedImage;
import java.io.File;

import com.nematode.nullmodel.NullBufferedImage;

public class MockValidatedImageFile implements ValidatedImageFileInterface {

	private final File file;
	private boolean isFileValid;
	private BufferedImage bufferedImage;

	public MockValidatedImageFile() {
		this.file = new File("");
		this.bufferedImage = new NullBufferedImage();
		this.isFileValid = false;
	}

	public File getImageFile() {
		return this.file;
	}

	@Override
	public boolean isFileValid() {
		return this.isFileValid;
	}

	public void setIsFileValid(final boolean isFileValid) {
		this.isFileValid = isFileValid;
	}

	@Override
	public BufferedImage getFileImage() {
		return this.bufferedImage;
	}

	public void setFileImage(final BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

}
