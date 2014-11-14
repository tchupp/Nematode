package com.nematode.fileIO;

public class MockVideoFrameAssembler implements VideoFrameAssemblerInterface {

	private ValidatedImageFileInterface imageFileToAdd;
	private int indexToAdd;
	private boolean addNewVideoFrameWasCalled;

	@Override
	public void addNewVideoFrame(final ValidatedImageFileInterface imageFile, final int index) {
		this.imageFileToAdd = imageFile;
		this.indexToAdd = index;
		this.addNewVideoFrameWasCalled = true;
	}

	public boolean wasAddNewVideoFrameCalled() {
		return this.addNewVideoFrameWasCalled;
	}

	public ValidatedImageFileInterface getImageFileToAdd() {
		return this.imageFileToAdd;
	}

	public int getIndexToAdd() {
		return this.indexToAdd;
	}
}
