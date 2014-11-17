package com.nematode.fileIO;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class VideoFileFilter extends FileFilter {

	@Override
	public boolean accept(final File file) {
		if (file.isDirectory()) {
			return true;
		}

		final String fileExtention = getFileExtention(file);

		if (fileExtention.equals("avi") || fileExtention.equals("mp4")) {
			return true;
		}

		return false;
	}

	@Override
	public String getDescription() {
		return "AVI and MP4 video files";
	}

	private String getFileExtention(final File file) {
		String extention = "unacceptable";
		final String fileName = file.getName();
		final int lastIndexOf = fileName.lastIndexOf(".");

		if (lastIndexOf > 0 && lastIndexOf < fileName.length() - 1) {
			extention = fileName.substring(lastIndexOf + 1).toLowerCase();
		}

		return extention;
	}
}
