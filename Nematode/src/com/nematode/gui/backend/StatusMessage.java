package com.nematode.gui.backend;

public enum StatusMessage {
	VIDEO_LOADED("Video correctly loaded."), VIDEO_LOADED_ERROR("Error loading video.");

	private final String message;

	private StatusMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
