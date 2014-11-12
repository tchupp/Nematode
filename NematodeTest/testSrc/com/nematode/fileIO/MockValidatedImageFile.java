package com.nematode.fileIO;

import java.awt.image.BufferedImage;
import java.io.File;

import com.nematode.image.NullBufferedImage;

public class MockValidatedImageFile implements ValidatedImageFileInterface {

	private final File file;
	private boolean isFileValid;
	private BufferedImage bufferedImage;
	private boolean isFileValidWasCalled = false;

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
		this.isFileValidWasCalled = true;
		return this.isFileValid;
	}

	public boolean wasIsFileValidCalled() {
		return this.isFileValidWasCalled;
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
