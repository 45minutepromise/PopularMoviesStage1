package uditgupta.popularmoviesstage1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.widget.ImageView;

import uditgupta.popularmoviesstage1.picasso.PicassoHelper;
import uditgupta.popularmoviesstage1.picasso.PicassoTarget;


public class MovieMedia implements IMedia {

	List<String> imageURLs;

	public MovieMedia(List<String> imageURLs) {
		this.imageURLs = imageURLs;
	}

	@Override
	public void loadImage(ImageView imageView, PicassoTarget target, int defaultResId) {
		new PicassoHelper.Builder(imageView).setPlaceholder(defaultResId).setTarget(target).build().load(imageURLs);
	}

	@Override
	public void preloadImage(Context context) {
		new PicassoHelper.Builder(context).build().load(imageURLs);
	}

	/**
	 * Returns list of image URLs based on the screen size.
	 * List contains the best match at 0th index followed by higher resolution and then lower resolution image URLs
	 * @param MovieImages List of images in ascending order of size
	 * @param width of the device
	 * @return sorted imageURLs
	 */

	List<String> imageUrls;
	public static List<String> getMovieImageURLBasedOnWidth(List<MovieImage> movieImages, int width) {
		List<String> imageURLs = new ArrayList<>();
		if (movieImages.size() > 1) {
			movieImages = sortMovieImagesBasedOnWidth(movieImages, width);
		}

		for (MovieImage image : movieImages) {
			StringBuilder imageURLBuilder = new StringBuilder();
			imageURLBuilder.append("http://image.tmdb.org/t/p/");
			imageURLBuilder.append(image.imageSize.toString());
			imageURLBuilder.append("/");
			imageURLBuilder.append(image.imageURL);
			imageURLs.add(imageURLBuilder.toString());
		}
		return imageURLs;
	}

	private static List<MovieImage> sortMovieImagesBasedOnWidth(List<MovieImage> MovieImages, int width) {
		List<MovieImage> sortedImages = new ArrayList<>();
		int index = 0;
		for (MovieImage image : MovieImages) {
			index++;
			if (image.imageSize.width >= width) {
				break;
			}
		}

		if (index != 0) {
			sortedImages.add(MovieImages.get(index - 1));
			// Add higher res images if available
			sortedImages.addAll(MovieImages.subList(index, MovieImages.size()));

			// Add lower res images in reverse
			List<MovieImage> lowerResImages = MovieImages.subList(0, index - 1);
			Collections.reverse(lowerResImages);
			sortedImages.addAll(lowerResImages);
		}
		else {
			Collections.reverse(MovieImages);
			return MovieImages;
		}
		return sortedImages;
	}


}
