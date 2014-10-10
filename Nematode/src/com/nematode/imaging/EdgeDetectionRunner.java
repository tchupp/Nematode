package com.nematode.imaging;

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
	public List<NematodeWormInterface> findAllObjectsInImage(
			final ProcessedFrameImageInterface processedFrameImage) {

		final List<NematodeWormInterface> listOfObjects = new ArrayList<NematodeWormInterface>();

		ContourLinesInterface contourLines = this.contourTracer
				.getFirstContourLines(processedFrameImage.getImage());

		while (!contourLines.isEmpty()) {
			final NematodeWormInterface builtWorm = this.nematodeWormBuilder
					.buildWorm(contourLines);
			listOfObjects.add(builtWorm);

			final BlackAndWhiteImage imageWithoutNewestWorm = this.imageProcessingHelper
					.removeObjectFromImage(processedFrameImage.getImage(),
							builtWorm);

			contourLines = this.contourTracer
					.getFirstContourLines(imageWithoutNewestWorm);
		}

		return listOfObjects;
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
