package com.nematode.image;

import java.awt.image.BufferedImage;

public class NullBufferedImage extends BufferedImage {

	public NullBufferedImage() {
		super(1, 1, BufferedImage.TYPE_INT_ARGB);
	}

}
