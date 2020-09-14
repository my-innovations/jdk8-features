package optional;

import java.util.Optional;

import optional.ScreenResolution;

public class DisplayFeatures {

	private final String size; // In inches
	private final Optional<ScreenResolution> resolution;

	public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public Optional<ScreenResolution> getResolution() {
		return resolution;
	}

}