package optional;

import optional.ScreenResolution;

public class DisplayFeaturesWithoutOptional {

	private final String size; // In inches
	private final ScreenResolution resolution;

	public DisplayFeaturesWithoutOptional(String size, ScreenResolution resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public ScreenResolution getResolution() {
		return resolution;
	}

}