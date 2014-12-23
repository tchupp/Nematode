package com.nematode.model;

public class VideoFrameIndex implements VideoFrameIndexInterface {

	private final int index;

	public VideoFrameIndex(final int index) {
		this.index = index;
	}

	@Override
	public boolean equals(final Object object) {
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		final VideoFrameIndex other = (VideoFrameIndex) object;
		if (this.index != other.index) {
			return false;
		}
		return true;
	}

	public int getIndex() {
		return this.index;
	}

}
