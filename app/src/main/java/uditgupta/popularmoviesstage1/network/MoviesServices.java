package uditgupta.popularmoviesstage1.network;

import android.content.Context;
import android.util.Log;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import uditgupta.popularmoviesstage1.data.PopularMoviesResponse;
import uditgupta.popularmoviesstage1.data.SearchParams;
import uditgupta.popularmoviesstage1.network.interfaces.MoviesApi;

public class MoviesServices {

	//http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=65330944ca3e4e249d239e1c0039b470

	private MoviesApi moviesApi;
	private static MoviesServices moviesServices;
	private static final String POPULAR_MOVIES_API_ENDPOINT = "http://api.themoviedb.org";

	public static MoviesServices getInstance(Context context) {
		if (moviesServices == null) {
			moviesServices = new MoviesServices(context);
		}
		return moviesServices;
	}

	private MoviesServices(final Context context) {
		RequestInterceptor requestInterceptor = new RequestInterceptor() {
			@Override
			public void intercept(RequestFacade request) {
				// ignore
			}
		};

		RestAdapter adapter = new RestAdapter.Builder()
				.setEndpoint(POPULAR_MOVIES_API_ENDPOINT)
				.setRequestInterceptor(requestInterceptor)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setLog(new RestAdapter.Log() {
					@Override
					public void log(String msg) {
						Log.d("request", msg);
					}
				})
				.build();

		moviesApi = adapter.create(MoviesApi.class);
	}


	public void getPopularMovieSortBy(SearchParams.SortBy sortBy, Callback<PopularMoviesResponse> callBack) {
		moviesApi.getPopularMoviesSortBy(sortBy.getSortBy(), "65330944ca3e4e249d239e1c0039b470", callBack);
	}
}
