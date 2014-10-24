package com.nematode.image.detection;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.processing.ImageProcessingHelperInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.model.factory.NematodeWormBuilderInterface;

public class EdgeDetectionRunner implements EdgeDetectionRunnerInterface {

	private final SquareContourTracerInterface contourTracer;
	private final NematodeWormBuilderInterface nematodeWormBuilder;
	private final ImageProcessingHelperInterface imageProcessingHelper;

	public EdgeDetectionRunner(final SquareContourTracerInterface contourTracer,
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

		BufferedImage newestImage = processedFrameImage.getImage();
		ContourLinesInterface contourLines = this.contourTracer.getFirstContourLines(newestImage);

		while (!contourLines.isEmpty()) {
			final NematodeWormInterface newWorm = this.nematodeWormBuilder
					.buildWorm(contourLines);
			listOfObjects.add(newWorm);

			newestImage = this.imageProcessingHelper.removeObjectFromImage(newestImage, newWorm);

			contourLines = this.contourTracer.getFirstContourLines(newestImage);
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
