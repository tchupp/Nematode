package com.nematode.fileIO;

import java.awt.image.BufferedImage;

public interface ValidatedImageFileInterface {

	boolean isFileValid();

	BufferedImage getFileImage();

}
