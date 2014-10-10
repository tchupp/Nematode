package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.List;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.nullmodel.NullFrameImage;

public class VideoFrameHandler implements VideoFrameHandlerInterface {

	private final NematodeVideoFrameInterface nematodeVideoFrame;
	private final FrameImageAssemblerInterface frameImageAssembler;
	private final ImageProcessingRunnerInterface imageProcessingRunner;
	private final EdgeDetectionRunnerInterface edgeDetectionRunner;

	public VideoFrameHandler(final NematodeVideoFrameInterface nematodeVideoFrame,
			final FrameImageAssemblerInterface frameImageAssembler,
			final ImageProcessingRunnerInterface imageProcessingRunner,
			final EdgeDetectionRunnerInterface edgeDetectionRunner) {
		this.nematodeVideoFrame = nematodeVideoFrame;
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
	public void updateDisplayImageFromScannedObjects() {
		final BlackAndWhiteImage imageWithDrawnObjects = this.imageProcessingRunner
				.createImageWithIdentifiedObjects(this.nematodeVideoFrame);

		final DisplayFrameImageInterface displayFrameImage = this.frameImageAssembler
				.createDisplayFrameImage(imageWithDrawnObjects);

		this.nematodeVideoFrame.setDisplayFrameImage(displayFrameImage);
	}

	@Override
	public void scanImage() {
		final ProcessedFrameImageInterface processedImageForScanning = this.imageProcessingRunner
				.preprocessImageForScanning(this.nematodeVideoFrame);
		final List<NematodeWormInterface> objectsInImageList = this.edgeDetectionRunner
				.findAllObjectsInImage(processedImageForScanning);

		this.nematodeVideoFrame.setObjectsOnImage(objectsInImageList);
	}

	@Override
	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
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