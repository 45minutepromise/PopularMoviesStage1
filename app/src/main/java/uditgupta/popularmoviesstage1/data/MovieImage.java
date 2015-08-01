package uditgupta.popularmoviesstage1.data;

public class MovieImage {

	public String imageURL;
	public ImageSize imageSize;

	public MovieImage(String imageURL, ImageSize imageSize) {
		this.imageURL = imageURL;
		this.imageSize = imageSize;
	}

	public enum ImageSize {
		w92(92),
		w(154),
		w185(185),
		w342(342),
		w500(500),
		w780(780);

		public int width;

		ImageSize(int width) {
			this.width = width;
		}
	}
}
