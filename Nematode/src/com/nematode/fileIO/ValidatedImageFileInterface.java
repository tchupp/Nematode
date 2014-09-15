package com.nematode.fileIO;

import java.awt.image.BufferedImage;

public interface ValidatedImageFileInterface {

	public boolean isFileValid();

	public BufferedImage getFileImage();

}
