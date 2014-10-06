package com.nematode.imaging;

public class ContourPoint implements ContourPointInterface {

	public static final int DIR_NORTH = 0;
	public static final int DIR_EAST = 1;
	public static final int DIR_SOUTH = 2;
	public static final int DIR_WEST = 3;
	private int x;
	private int y;
	private int direction;
	private final boolean isValid;

	public ContourPoint() {
		this(0, 0, 0);
	}

	public ContourPoint(final int x, final int y) {
		this(x, y, DIR_NORTH);
	}

	public ContourPoint(final int x, final int y, final int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.isValid = (x > 0) && (y > 0);
	}

	public ContourPoint(final ContourPoint referencePoint) {
		this(referencePoint.x, referencePoint.y, referencePoint.direction);
	}

	private void turnRight() {
		this.direction = (this.direction + 1) % 4;
	}

	private void turnLeft() {
		if (this.direction == 0) {
			this.direction = 3;
		} else {
			this.direction--;
		}
	}

	private void goForward() {
		if (this.direction == DIR_NORTH) {
			this.y = this.y - 1;
		}
		if (this.direction == DIR_EAST) {
			this.x = this.x + 1;
		}
		if (this.direction == DIR_SOUTH) {
			this.y = this.y + 1;
		}
		if (this.direction == DIR_WEST) {
			this.x = this.x - 1;
		}
	}

	public void advanceRight() {
		turnRight();
		goForward();
	}

	public void advanceLeft() {
		turnLeft();
		goForward();
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public int getDirection() {
		return this.direction;
	}

	public boolean isValid() {
		return this.isValid;
	}

	@Override
	public ContourPoint clone() {
		return new ContourPoint(this.x, this.y, this.direction);
	}

	@Override
	public boolean equals(final Object object) {

		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		final ContourPoint other = (ContourPoint) object;
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
