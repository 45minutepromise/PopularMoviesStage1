package uditgupta.popularmoviesstage1.application;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;

import uditgupta.popularmoviesstage1.picasso.PicassoHelper;

/**
 * Created by udigupta on 8/2/15.
 */
public class PopularMoviesApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		PicassoHelper.init(this, new OkHttpClient());
	}
}
