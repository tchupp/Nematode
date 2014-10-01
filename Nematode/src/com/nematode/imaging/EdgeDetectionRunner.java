package com.nematode.imaging;

import com.nematode.model.NematodeWormBuilderInterface;

public class EdgeDetectionRunner {

	private final SquareContourTracerInterface contourTracer;
	private final NematodeWormBuilderInterface nematodeWormBuilder;

	public EdgeDetectionRunner(
			final SquareContourTracerInterface contourTracer,
			final NematodeWormBuilderInterface nematodeWormBuilder) {
		this.contourTracer = contourTracer;
		this.nematodeWormBuilder = nematodeWormBuilder;
	}

	public void findAllObjectInImage() {

	}

	public SquareContourTracerInterface getContourTracer() {
		return this.contourTracer;
	}

	public NematodeWormBuilderInterface getNematodeWormBuilder() {
		return this.nematodeWormBuilder;
	}

}
