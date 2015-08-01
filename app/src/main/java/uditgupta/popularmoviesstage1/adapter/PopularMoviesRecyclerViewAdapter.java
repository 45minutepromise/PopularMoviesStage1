package uditgupta.popularmoviesstage1.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import uditgupta.popularmoviesstage1.R;
import uditgupta.popularmoviesstage1.data.MovieMedia;
import uditgupta.popularmoviesstage1.data.Movies;
import uditgupta.popularmoviesstage1.data.PopularMoviesResponse;
import uditgupta.popularmoviesstage1.picasso.PicassoHelper;
import uditgupta.popularmoviesstage1.picasso.PicassoTarget;


public class PopularMoviesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private static final String ROW_PICASSO_TAG = "movie_poster";
	private List<Movies> activities = new ArrayList<>();

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_popular_movie, parent, false);
		return new ViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			Movies activity = activities.get(position);
			((ViewHolder) holder).bind(activity);
	}

	@Override
	public void onViewRecycled(RecyclerView.ViewHolder holder) {
		super.onViewRecycled(holder);
	}


	@Override
	public int getItemCount() {
		return activities.size();
	}

	public void setMovies(List<Movies> movies) {
		this.activities = movies;
		notifyDataSetChanged();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		@InjectView(R.id.movie_poster)
		ImageView moviePoster;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.inject(this, itemView);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			PopularMoviesResponse activity = (PopularMoviesResponse) v.getTag();
		}

		public void bind(Movies activity) {
			itemView.setTag(activity);

			List<String> imageURLs = MovieMedia
				.getMovieImageURLBasedOnWidth(activity.getImageUrls(), (getDisplaySize(itemView.getContext()).x)/2);
			new PicassoHelper.Builder(itemView.getContext())
				.setPlaceholder(R.drawable.abc_ic_clear_mtrl_alpha)
				.setError(R.drawable.abc_btn_check_material)
				.setTag(ROW_PICASSO_TAG)
				.setTarget(target)
				.build()
				.load(imageURLs);

		}

		private PicassoTarget target = new PicassoTarget() {
			@Override
			public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
				super.onBitmapLoaded(bitmap, from);
				moviePoster.setImageBitmap(bitmap);
			}

			@Override
			public void onBitmapFailed(Drawable errorDrawable) {
				super.onBitmapFailed(errorDrawable);
				moviePoster.setImageDrawable(errorDrawable);
			}

			@Override
			public void onPrepareLoad(Drawable placeHolderDrawable) {
				super.onPrepareLoad(placeHolderDrawable);
				moviePoster.setImageDrawable(placeHolderDrawable);
			}
		};

	}

	/**
	 * Similar to AndroidUtils.getScreenSize(), but takes the notification and nav bar in to account to
	 * provide a consistent experience across different orientations, API levels, and hardware.
	 * @param context
	 * @return
	 */
	public static Point getDisplaySize(Context context) {
		Point size = new Point();

		WindowManager w = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display d = w.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		d.getMetrics(metrics);

		// since SDK_INT = 1;
		size.x = metrics.widthPixels;
		size.y = metrics.heightPixels;

		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
			try {
				size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(d);
				size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(d);
			}
			catch (Exception ignored) {

			}
		}

		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 17) {
			try {
				Point realSize = new Point();
				Display.class.getMethod("getRealSize", Point.class).invoke(d, realSize);
				size.x = realSize.x;
				size.y = realSize.y;
			}
			catch (Exception ignored) {

			}
		}

		return size;
	}

}
