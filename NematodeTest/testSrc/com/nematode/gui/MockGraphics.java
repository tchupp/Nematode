package com.nematode.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MockGraphics extends Graphics {

	private int xPosToDraw;
	private int yPosToDraw;
	private Image imageToDraw;
	private ImageObserver imageObserverToUse;
	private boolean drawImageWasCalled;

	@Override
	public void clearRect(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clipRect(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void copyArea(final int x, final int y, final int width, final int height, final int dx,
			final int dy) {
		// TODO Auto-generated method stub
	}

	@Override
	public Graphics create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawArc(final int x, final int y, final int width, final int height,
			final int startAngle, final int arcAngle) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y,
			final ImageObserver imageObserver) {
		this.drawImageWasCalled = true;
		this.imageToDraw = img;
		this.xPosToDraw = x;
		this.yPosToDraw = y;
		this.imageObserverToUse = imageObserver;
		return false;
	}

	public boolean wasDrawImageCalled() {
		return this.drawImageWasCalled;
	}

	public int getXPosToDraw() {
		return this.xPosToDraw;
	}

	public int getYPosToDraw() {
		return this.yPosToDraw;
	}

	public Image getImageToDraw() {
		return this.imageToDraw;
	}

	public ImageObserver getImageObserverToUse() {
		return this.imageObserverToUse;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y, final Color bgcolor,
			final ImageObserver imageObserver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y, final int width,
			final int height, final ImageObserver imageObserver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int x, final int y, final int width,
			final int height, final Color bgcolor, final ImageObserver imageObserver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int dx1, final int dy1, final int dx2,
			final int dy2, final int sx1, final int sy1, final int sx2, final int sy2,
			final ImageObserver imageObserver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drawImage(final Image img, final int dx1, final int dy1, final int dx2,
			final int dy2, final int sx1, final int sy1, final int sx2, final int sy2,
			final Color bgcolor, final ImageObserver imageObserver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawLine(final int x1, final int y1, final int x2, final int y2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawOval(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawPolygon(final int[] xPoints, final int[] yPoints, final int nPoints) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawPolyline(final int[] xPoints, final int[] yPoints, final int nPoints) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawRoundRect(final int x, final int y, final int width, final int height,
			final int arcWidth, final int arcHeight) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawString(final String str, final int x, final int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public void drawString(final AttributedCharacterIterator iterator, final int x, final int y) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillArc(final int x, final int y, final int width, final int height,
			final int startAngle, final int arcAngle) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillOval(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillPolygon(final int[] xPoints, final int[] yPoints, final int nPoints) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillRect(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillRoundRect(final int x, final int y, final int width, final int height,
			final int arcWidth, final int arcHeight) {
		// TODO Auto-generated method stub
	}

	@Override
	public Shape getClip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getClipBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FontMetrics getFontMetrics(final Font f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClip(final Shape clip) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setClip(final int x, final int y, final int width, final int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setColor(final Color c) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setFont(final Font font) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setPaintMode() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setXORMode(final Color c1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void translate(final int x, final int y) {
		// TODO Auto-generated method stub
	}
}
