package com.nematode.imaging;

public class MockContourPoint implements ContourPointInterface {

	private int y;
	private int x;

	public MockContourPoint() {
		this(0, 0);
	}

	public MockContourPoint(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public boolean equals(final Object object) {
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		final MockContourPoint other = (MockContourPoint) object;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}

		return true;
	}

}
