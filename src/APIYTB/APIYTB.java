package APIYTB;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;


import jakarta.servlet.http.Part;

public class APIYTB {
	private static final String API_KEY = "AIzaSyBIjTtYyFm8d7qTfXMIgSP1qRVlqpAuKp4";
	private static final String API_URL_SEARCH = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=10&q=%s&type=video&key="
			+ API_KEY;
	private static final String API_URL_MUSIC = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=40&regionCode=VN&videoCategoryId=10&key="
			+ API_KEY;
	private static final String API_URL_SPORTS = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=40&regionCode=US&videoCategoryId=17&key="
			+ API_KEY;
	private static final String API_URL_ANIMATION = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=40&regionCode=US&videoCategoryId=1&key="
			+ API_KEY;
	private static final String API_URL_NEWS_POLITICS = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=40&regionCode=US&videoCategoryId=25&key="
			+ API_KEY;
	private static final String API_URL_ENTERTAINMENT = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&chart=mostPopular&maxResults=40&regionCode=US&videoCategoryId=24&key="
			+ API_KEY;

	// read Json From URl
	public static String readJsonFromUrl(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		try {
			Scanner scanner = new Scanner(is);
			scanner.useDelimiter("\\A");
			return scanner.hasNext() ? scanner.next() : "";

		} finally {
			is.close();
		}
	}

	// search video by keyword
	public static List<Model.Videos> SearchVideo(String searchQuery) throws MalformedURLException, IOException {
		List<Model.Videos> list = new ArrayList<>();
		if (searchQuery == null) {
			searchQuery = "example";
		}
		String apiUrl = String.format(API_URL_SEARCH, searchQuery.replace(" ", "+"));
		String json = readJsonFromUrl(apiUrl);
		JSONObject obj = new JSONObject(json);
		JSONArray arr = obj.getJSONArray("items");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject video = arr.getJSONObject(i);
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			JSONObject id = video.getJSONObject("id");
			String videoId = id.getString("videoId");
			String description = snippet.getString("description");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, 0l, thumbnailUrl);

			list.add(listVideo);
		}
		return list;
	}

//	show info video by idVideo
	public static Video getVideoById(String videoId) throws Exception {
		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		final JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		// Set up the YouTube object
		YouTube youtube = new YouTube.Builder(httpTransport, jsonFactory, new HttpRequestInitializer() {
			public void initialize(com.google.api.client.http.HttpRequest request) throws IOException {
			}
		}).setApplicationName("APIYTB").build();
		List<String> videoInfo = new ArrayList<String>();
		List<String> videoIds = new ArrayList<String>();
		videoIds.add(videoId);
		videoInfo.add("snippet");
		videoInfo.add("contentDetails");
		videoInfo.add("statistics");
		// Define the API request for videos.list method
		YouTube.Videos.List videoRequest = youtube.videos().list(videoInfo);

		// Set the API key
		videoRequest.setKey(API_KEY);

		// Set the video ID parameter
		videoRequest.setId(videoIds);

		// Call the API and parse the response
		VideoListResponse response = videoRequest.execute();
		Video video = response.getItems().get(0);

		// Return the video object
		return video;
	}

	public static List<Model.Videos> TopMusic() throws IOException, JSONException {
		List<Model.Videos> videos = new ArrayList<>();

		URL url = new URL(API_URL_MUSIC);
		String response = readJsonFromUrl(url.toString());

		// Chuyển đổi Json thành mảng đối tượng Video
		JSONObject jsonObj = new JSONObject(response);
		JSONArray items = jsonObj.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			JSONObject video = items.getJSONObject(i);

			String videoId = video.getString("id");
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			String description = snippet.getString("description");
			JSONObject statistics = video.getJSONObject("statistics");
			Long viewCount = statistics.getLong("viewCount");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, viewCount, thumbnailUrl);

			videos.add(listVideo);
		}
//		for (Model.Video video : videos) {
//			System.out.println(video.toString());
//
//		}
		return videos;
	}

	public static List<Model.Videos> SPORTS() throws IOException, JSONException {
		List<Model.Videos> videos = new ArrayList<>();

		URL url = new URL(API_URL_SPORTS);
		String response = readJsonFromUrl(url.toString());

		// Chuyển đổi Json thành mảng đối tượng Video
		JSONObject jsonObj = new JSONObject(response);
		JSONArray items = jsonObj.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			JSONObject video = items.getJSONObject(i);

			String videoId = video.getString("id");
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			String description = snippet.getString("description");
			JSONObject statistics = video.getJSONObject("statistics");
			Long viewCount = statistics.getLong("viewCount");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, viewCount, thumbnailUrl);

			videos.add(listVideo);

		}
//		for (Model.Video video : videos) {
//			System.out.println(video.toString());
//
//		}
		return videos;
	}

	public static List<Model.Videos> FILMANDANIMATION() throws IOException, JSONException {
		List<Model.Videos> videos = new ArrayList<>();

		URL url = new URL(API_URL_ANIMATION);
		String response = readJsonFromUrl(url.toString());

		// Chuyển đổi Json thành mảng đối tượng Video
		JSONObject jsonObj = new JSONObject(response);
		JSONArray items = jsonObj.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			JSONObject video = items.getJSONObject(i);

			String videoId = video.getString("id");
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			String description = snippet.getString("description");
			JSONObject statistics = video.getJSONObject("statistics");
			Long viewCount = statistics.getLong("viewCount");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, viewCount, thumbnailUrl);

			videos.add(listVideo);

		}
//		for (Model.Video video : videos) {
//			System.out.println(video.toString());
//
//		}
		return videos;
	}

	public static List<Model.Videos> NEWS_POLITICS() throws IOException, JSONException {
		List<Model.Videos> videos = new ArrayList<>();

		URL url = new URL(API_URL_NEWS_POLITICS);
		String response = readJsonFromUrl(url.toString());

		// Chuyển đổi Json thành mảng đối tượng Video
		JSONObject jsonObj = new JSONObject(response);
		JSONArray items = jsonObj.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			JSONObject video = items.getJSONObject(i);

			String videoId = video.getString("id");
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			String description = snippet.getString("description");
			JSONObject statistics = video.getJSONObject("statistics");
			Long viewCount = statistics.getLong("viewCount");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, viewCount, thumbnailUrl);

			videos.add(listVideo);

		}
//		for (Model.Video video : videos) {
//			System.out.println(video.toString());
//
//		}
		return videos;
	}

	public static List<Model.Videos> ENTERTAINMENT() throws IOException, JSONException {
		List<Model.Videos> videos = new ArrayList<>();

		URL url = new URL(API_URL_ENTERTAINMENT);
		String response = readJsonFromUrl(url.toString());

		// Chuyển đổi Json thành mảng đối tượng Video
		JSONObject jsonObj = new JSONObject(response);
		JSONArray items = jsonObj.getJSONArray("items");

		for (int i = 0; i < items.length(); i++) {
			JSONObject video = items.getJSONObject(i);

			String videoId = video.getString("id");
			JSONObject snippet = video.getJSONObject("snippet");
			String title = snippet.getString("title");
			JSONObject thumbnails = snippet.getJSONObject("thumbnails");
			JSONObject defaultThumbnail = thumbnails.getJSONObject("default");
			String thumbnailUrl = defaultThumbnail.getString("url");
			String description = snippet.getString("description");
			JSONObject statistics = video.getJSONObject("statistics");
			Long viewCount = statistics.getLong("viewCount");

			Model.Videos listVideo = new Model.Videos(videoId, title, description, viewCount, thumbnailUrl);

			videos.add(listVideo);

		}
//		for (Model.Video video : videos) {
//			System.out.println(video.toString());
//
//		}
		return videos;
	}

//	private static void createYouTube() throws GeneralSecurityException, IOException {
//		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//
//		YouTube youtube = new YouTube.Builder(httpTransport, JacksonFactory.getDefaultInstance(), null)
//				.setApplicationName("APIYTB").build();
//	}
//
//	public static String insertVideo(String title, String description, String category, String privacyStatus,
//			InputStream inputStream) throws Exception {
//		createYouTube();
//
//		// Create a new Video object with the required details
//		Video video = new Video();
//		VideoSnippet snippet = new VideoSnippet();
//		snippet.setTitle(title);
//		snippet.setDescription(description);
//		snippet.setCategoryId(category);
//		video.setSnippet(snippet);
//
//		VideoStatus status = new VideoStatus();
//		status.setPrivacyStatus(privacyStatus);
//		video.setStatus(status);
//
//		// Create a new VideoInsert object to insert the video
//		Insert videoInsert = youtube.videos().insert("snippet,status", video,
//				new InputStreamContent("video/*", inputStream));
//
//		// Call the API to insert the video
//		Video insertedVideo = videoInsert.execute();
//
//		return insertedVideo.getId();
//	}

	public static void main(String[] args) {
		try {
			List<Model.Videos> list = ENTERTAINMENT();
			for (Model.Videos video : list) {
				System.out.println(video.toString());
			}
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
