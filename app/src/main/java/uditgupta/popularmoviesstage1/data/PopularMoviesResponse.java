package uditgupta.popularmoviesstage1.data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import uditgupta.popularmoviesstage1.interfaces.Jsonable;

/**
 * Created by udigupta on 8/1/15.
 */
public class PopularMoviesResponse implements Jsonable {

	@Expose
	@SerializedName("results")
	private List<Movies> moviesList;

	@Expose
	@SerializedName("page")
	private int page;

	@Expose
	@SerializedName("total_results")
	private int totalResults;

	@Expose
	@SerializedName("total_pages")
	private int totalPage;


	/**
	 *  Getter & Setters
	 */

	public List<Movies> getMoviesList() {
		return moviesList;
	}

	public PopularMoviesResponse setMoviesList(List<Movies> moviesList) {
		this.moviesList = moviesList;
		return this;
	}

	public int getPage() {
		return page;
	}

	public PopularMoviesResponse setPage(int page) {
		this.page = page;
		return this;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public PopularMoviesResponse setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		return this;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public PopularMoviesResponse setTotalResults(int totalResults) {
		this.totalResults = totalResults;
		return this;
	}

	/**
	 * Jsonable
	 */

	@Override
	public String toJsonString() {
		return null;
	}

	@Override
	public void fromJsonString(String jsonString) {

	}
}
