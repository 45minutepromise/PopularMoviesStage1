package uditgupta.popularmoviesstage1.data;

import android.content.Context;
import android.widget.ImageView;

import uditgupta.popularmoviesstage1.picasso.PicassoTarget;

public interface IMedia {
	public void loadImage(ImageView imageView, PicassoTarget target, int defaultResId);
	public void preloadImage(Context context);
}
