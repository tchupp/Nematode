package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullVideoFrameImage;

public class VideoFrameBuilder implements VideoFrameBuilderInterface {

	private final NematodeVideoFrameInterface nematodeVideoFrame;

	public VideoFrameBuilder(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
	}

	@Override
	public void buildVideoFrameImage(
			final ValidatedImageFileInterface validatedImageFile) {

		if (validatedImageFile.isFileValid()) {
			final VideoFrameImage videoFrameImage = new VideoFrameImage(
					validatedImageFile.getFileImage());
			this.nematodeVideoFrame.setVideoFrameImage(videoFrameImage);
		} else {
			this.nematodeVideoFrame
			.setVideoFrameImage(NullVideoFrameImage.NULL);
		}
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}
}
