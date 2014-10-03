package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.nematode.model.NematodeWormBuilderInterface;
import com.nematode.model.NematodeWormInterface;

public class EdgeDetectionRunner implements EdgeDetectionRunnerInterface {

	private final SquareContourTracerInterface contourTracer;
	private final NematodeWormBuilderInterface nematodeWormBuilder;
	private final ImageProcessingHelperInterface imageProcessingHelper;

	public EdgeDetectionRunner(
			final SquareContourTracerInterface contourTracer,
			final NematodeWormBuilderInterface nematodeWormBuilder,
			final ImageProcessingHelperInterface imageProcessingHelper) {
		this.contourTracer = contourTracer;
		this.nematodeWormBuilder = nematodeWormBuilder;
		this.imageProcessingHelper = imageProcessingHelper;
	}

	@Override
	public void findAllObjectsInImage(
			final ProcessedFrameImageInterface processedFrameImage) {

		final List<NematodeWormInterface> listOfObjects = new ArrayList<NematodeWormInterface>();
		final BufferedImage processedImage = processedFrameImage.getImage();

		final ContourLines contourLines = this.contourTracer
				.getFirstContourLines(processedImage);

		while (!contourLines.isEmpty()) {
			listOfObjects.add(this.nematodeWormBuilder.buildWorm(contourLines));

		}
	}

	public SquareContourTracerInterface getContourTracer() {
		return this.contourTracer;
	}

	public NematodeWormBuilderInterface getNematodeWormBuilder() {
		return this.nematodeWormBuilder;
	}

	public ImageProcessingHelperInterface getImageProcessingHelper() {
		return this.imageProcessingHelper;
	}

}
