package optional;

import java.util.Optional;

public class App08_Optional_class_02 {

	public static void main(String[] args) {
		
		final ScreenResolution resolution = new ScreenResolution(750, 1334);
		final DisplayFeaturesWithOptional dfeatures = new DisplayFeaturesWithOptional("4.7", Optional.of(resolution));
		final Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
		final MobileService mService = new MobileService();

		final int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);

		final Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
		final int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + width2);
	}
}