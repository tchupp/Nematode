package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullFrameImage;

public class VideoFrameHandler implements VideoFrameHandlerInterface {

	private final NematodeVideoFrameInterface nematodeVideoFrame;
	private final FrameImageAssemblerInterface frameImageAssembler;
	private final ImageProcessingRunnerInterface imageProcessingRunner;

	public VideoFrameHandler(
			final NematodeVideoFrameInterface nematodeVideoFrame,
			final FrameImageAssemblerInterface frameImageAssembler,
			final ImageProcessingRunnerInterface imageProcessingRunner) {
		this.nematodeVideoFrame = nematodeVideoFrame;
		this.frameImageAssembler = frameImageAssembler;
		this.imageProcessingRunner = imageProcessingRunner;
	}

	@Override
	public void buildNewFrameImageFromFile(
			final ValidatedImageFileInterface validatedImageFile) {

		if (validatedImageFile.isFileValid()) {
			final BufferedImage fileImage = validatedImageFile.getFileImage();

			final VideoFrameImageInterface videoFrameImage = this.frameImageAssembler
					.createVideoFrameImage(fileImage);
			this.nematodeVideoFrame.setVideoFrameImage(videoFrameImage);

			final DisplayFrameImageInterface displayFrameImage = this.frameImageAssembler
					.createDisplayFrameImage(fileImage);
			this.nematodeVideoFrame.setDisplayFrameImage(displayFrameImage);

		} else {
			this.nematodeVideoFrame.setVideoFrameImage(NullFrameImage.NULL);
			this.nematodeVideoFrame.setDisplayFrameImage(NullFrameImage.NULL);
		}
	}

	@Override
	public void scanImage() {
		this.imageProcessingRunner.scanVideoFrame();
	}

	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public FrameImageAssemblerInterface getFrameImageAssembler() {
		return this.frameImageAssembler;
	}

	public ImageProcessingRunnerInterface getImageProcessingRunner() {
		return this.imageProcessingRunner;
	}

}
