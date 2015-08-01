package uditgupta.popularmoviesstage1.network.interfaces;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import uditgupta.popularmoviesstage1.data.PopularMoviesResponse;
import uditgupta.popularmoviesstage1.data.SearchParams;

public interface MoviesApi {

	/*
	 * Legislators
	 */

	//http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=65330944ca3e4e249d239e1c0039b470

	@GET("/3/discover/movie")
	public void getPopularMoviesSortBy(@Query("sort_by") String sortBy, @Query("api_key") String apiKey,
		Callback<PopularMoviesResponse> callback);

}
