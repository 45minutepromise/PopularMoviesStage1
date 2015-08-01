package uditgupta.popularmoviesstage1.data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Db {

	private static final String LOG_TAG = "DATABASE";

	// Singleton

	private static final Db sDb = new Db();

	private Db() {

	}

	///////////////////////////////////
	// Movies -- only persist in memory for now.

	private SearchParams mSearchParams;

	public static SearchParams getSearchParams() {
		return sDb.mSearchParams;
	}

	public static void setSearchParams(SearchParams params) {
		sDb.mSearchParams = params;
	}

	public static void setSortBy(SearchParams.SortBy sortBy) {
		if (sDb.mSearchParams == null) {
			sDb.mSearchParams = new SearchParams();
		}
		sDb.mSearchParams.setSortBy(sortBy);
	}

	///////////////////////////////////
	// Movies

	private static final String MOVIES_FILE_NAME = "movies_list.dat";
	private PopularMoviesResponse moviesResponse;

	public static PopularMoviesResponse getMoviesResponse() {
		if (sDb.moviesResponse == null) {
			sDb.moviesResponse = new PopularMoviesResponse();
		}
		return sDb.moviesResponse;
	}

	public static void setMoviesResponse(PopularMoviesResponse moviesResponse) {
		sDb.moviesResponse = moviesResponse;
	}

	public static void saveMoviesResponse(Context c) {
		Gson gson = new GsonBuilder().create();
		String movieResponseStrimg = gson.toJson(sDb.moviesResponse);
		saveStringToFileOnDisk(c, MOVIES_FILE_NAME, movieResponseStrimg);
	}

	public static void loadMoviesResponse(Context c) {
		Gson gson = new GsonBuilder().create();
		sDb.moviesResponse = gson.fromJson(loadStringFromFileOnDisk(c, MOVIES_FILE_NAME), PopularMoviesResponse.class);
	}

	public static void clearMoviesResponse(Context context) {
		setMoviesResponse(null);
		saveMoviesResponse(context);
	}

	///////////////////////////////////
	// Helpers

	private static void saveStringToFileOnDisk(final Context c, final String filename, final String data) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (sDb) {
					FileOutputStream fos = null;
					try {
						fos = c.openFileOutput(filename, Context.MODE_PRIVATE);
						fos.write(data.getBytes());
					}
					catch (IOException e) {
						Log.d(LOG_TAG, "Exception saving data to file: " + filename);
					}
					finally {
						try {
							if (fos != null) {
								fos.close();
							}
						}
						catch (IOException e) {
							Log.d(LOG_TAG, "Couldn't output stream for file: " + filename);
						}

					}
				}
			}
		}).start();
	}

	private static String loadStringFromFileOnDisk(final Context c, final String filename) {
		StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(c.getFileStreamPath(filename)));
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				sb.append(s);
			}
			bufferedReader.close();
		}
		catch (IOException e) {
			Log.d(LOG_TAG, "Error reading file: " + filename);
		}
		finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
			catch (IOException e) {
				Log.d(LOG_TAG, "Couldn't close reader for file: " + filename);
			}
		}
		return sb.toString();
	}


}
