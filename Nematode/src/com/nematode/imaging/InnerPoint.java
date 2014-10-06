package com.nematode.imaging;

public class InnerPoint implements InnerPointInterface {

	private final int y;
	private final int x;

	public InnerPoint(final int x, final int y) {
		this.x = x;
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
	public boolean isValid() {
		return this.x >= 0 && this.y >= 0;
	}

	@Override
	public InnerPoint clone() {
		return new InnerPoint(this.x, this.y);
	}

	@Override
	public boolean equals(final Object object) {
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		final InnerPoint other = (InnerPoint) object;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true;

	}

	@Override
	public String toString() {
		return getClass().getName() + " [" + this.x + ", " + this.y + "]";
	}
}
