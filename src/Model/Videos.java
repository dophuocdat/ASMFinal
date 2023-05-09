package Model;

import javax.persistence.*;

@Entity
public class Videos {
	
	@Id
	private String idVideo; 
	private String title;
	private String description;
	private long views;
	private String poster;
	
	

	public Videos() {
		
	}


	public Videos(String idVideo, String title, String description, long views, String poster) {
		super();
		this.idVideo = idVideo;
		this.title = title;
		this.description = description;
		this.views = views;
		this.poster = poster;
	}







	public String getIdVideo() {
		return idVideo;
	}







	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}







	public String getTitle() {
		return title;
	}







	public void setTitle(String title) {
		this.title = title;
	}







	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public long getViews() {
		return views;
	}







	public void setViews(long views) {
		this.views = views;
	}







	public String getPoster() {
		return poster;
	}







	public void setPoster(String poster) {
		this.poster = poster;
	}







	@Override
	public String toString() {
		return "Video [idVideo=" + idVideo + ", title=" + title + ", description=" + description + ", views=" + views
				+ ", poster=" + poster + "]";
	}

	
}
