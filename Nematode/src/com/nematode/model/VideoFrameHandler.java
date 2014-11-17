package com.nematode.model;

import java.awt.image.BufferedImage;
import java.util.List;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.image.NullFrameImage;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.image.detection.EdgeDetectionRunnerInterface;
import com.nematode.image.processing.ImageProcessingRunnerInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;

public class VideoFrameHandler implements VideoFrameHandlerInterface {

	private VideoFrameInterface videoFrame;
	private final FrameImageAssemblerInterface frameImageAssembler;
	private final ImageProcessingRunnerInterface imageProcessingRunner;
	private final EdgeDetectionRunnerInterface edgeDetectionRunner;

	public VideoFrameHandler(final VideoFrameInterface videoFrame,
			final FrameImageAssemblerInterface frameImageAssembler,
			final ImageProcessingRunnerInterface imageProcessingRunner,
			final EdgeDetectionRunnerInterface edgeDetectionRunner) {
		this.videoFrame = videoFrame;
		this.frameImageAssembler = frameImageAssembler;
		this.imageProcessingRunner = imageProcessingRunner;
		this.edgeDetectionRunner = edgeDetectionRunner;
	}

	@Override
	public void buildNewFrameImageFromFile(final ValidatedImageFileInterface validatedImageFile) {

		if (validatedImageFile.isFileValid()) {
			final BufferedImage fileImage = validatedImageFile.getFileImage();

			final VideoFrameImageInterface videoFrameImage = this.frameImageAssembler
					.createVideoFrameImage(fileImage);
			this.videoFrame = new VideoFrame(videoFrameImage);
		} else {
			this.videoFrame = new VideoFrame(NullFrameImage.NULL);
		}
	}

	@Override
	public void updateDisplayImageFromScannedObjects() {
	}

	@Override
	public void scanImage() {
		final ProcessedFrameImageInterface processedImageForScanning = this.imageProcessingRunner
				.preprocessImageForScanning(this.videoFrame);
		final List<NematodeWormInterface> objectsInImageList = this.edgeDetectionRunner
				.findAllObjectsInImage(processedImageForScanning);

		this.videoFrame.setObjectsOnImage(objectsInImageList);
	}

	@Override
	public VideoFrameInterface getVideoFrame() {
		return this.videoFrame;
	}

	public FrameImageAssemblerInterface getFrameImageAssembler() {
		return this.frameImageAssembler;
	}

	public ImageProcessingRunnerInterface getImageProcessingRunner() {
		return this.imageProcessingRunner;
	}

	public EdgeDetectionRunnerInterface getEdgeDetectionRunner() {
		return this.edgeDetectionRunner;
	}

}
