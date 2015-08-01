package uditgupta.popularmoviesstage1.data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by udigupta on 8/1/15.
 */
public class Movies {

	@Expose
	@SerializedName("adult")
	public boolean adult;

	@Expose
	@SerializedName("backdrop_path")
	public String backdropPath;

	@Expose
	@SerializedName("genre_ids")
	List<Integer> genreIds;

	@Expose
	@SerializedName("id")
	int id;

	@Expose
	@SerializedName("original_language")
	String originalLanguage;

	@Expose
	@SerializedName("original_title")
	String originalTitle;

	@Expose
	@SerializedName("overview")
	String overview;

	@Expose
	@SerializedName("release_date")
	String releaseDate;

	@Expose
	@SerializedName("poster_path")
	String posterPath;

	@Expose
	@SerializedName("popularity")
	Double popularity;

	@Expose
	@SerializedName("title")
	String title;

	@Expose
	@SerializedName("video")
	boolean video;

	@Expose
	@SerializedName("vote_average")
	float voteAverage;

	@Expose
	@SerializedName("vote_count")
	int voteCount;

	public boolean isAdult() {
		return adult;
	}

	public Movies setAdult(boolean adult) {
		this.adult = adult;
		return this;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Movies setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
		return this;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public Movies setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
		return this;
	}

	public int getId() {
		return id;
	}

	public Movies setId(int id) {
		this.id = id;
		return this;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public Movies setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
		return this;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public Movies setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
		return this;
	}

	public String getOverview() {
		return overview;
	}

	public Movies setOverview(String overview) {
		this.overview = overview;
		return this;
	}

	public Double getPopularity() {
		return popularity;
	}

	public Movies setPopularity(Double popularity) {
		this.popularity = popularity;
		return this;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Movies setPosterPath(String posterPath) {
		this.posterPath = posterPath;
		return this;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Movies setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Movies setTitle(String title) {
		this.title = title;
		return this;
	}

	public boolean isVideo() {
		return video;
	}

	public Movies setVideo(boolean video) {
		this.video = video;
		return this;
	}

	public float getVoteAverage() {
		return voteAverage;
	}

	public Movies setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
		return this;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public Movies setVoteCount(int voteCount) {
		this.voteCount = voteCount;
		return this;
	}
}
