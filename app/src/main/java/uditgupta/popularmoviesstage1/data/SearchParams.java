package uditgupta.popularmoviesstage1.data;

public class SearchParams {

	public static enum SortBy {
		POPULARITY_DESC("popularity.desc");

		private String sortBy;

		private SortBy(String sortBy) {
			this.sortBy = sortBy;
		}

		public String getSortBy() {
			return sortBy;
		}
	}

	private SortBy sortBy = SortBy.POPULARITY_DESC;

	public SortBy getSortBy() {
		return sortBy;
	}

	public SearchParams setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
		return this;
	}

	public SearchParams() {
		// ignore
	}
}
