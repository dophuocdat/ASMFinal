package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="favorites")
@NamedQueries({
	@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f"),
	@NamedQuery(name="Favorite.findById", query="delete from Favorite f where f.idVideo =:idVideo and f.user =:idUser")
})

public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_video")
	private String idVideo;

	private Boolean active;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="like_date")
	private Date likeDate;

	private String poster;

	private String title;

	private long views;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="favorite")
	private List<Share> shares;

	public Favorite() {
	}
	

	

	public Favorite(String idVideo, Boolean active, String description, Date likeDate, String poster, String title,
			long views, User user) {
		super();
		this.idVideo = idVideo;
		this.active = active;
		this.description = description;
		this.likeDate = likeDate;
		this.poster = poster;
		this.title = title;
		this.views = views;
		this.user = user;
	}




	public String getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getViews() {
		return this.views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setFavorite(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setFavorite(null);

		return share;
	}




	@Override
	public String toString() {
		return "Favorite [idVideo=" + idVideo + ", active=" + active + ", description=" + description + ", likeDate="
				+ likeDate + ", poster=" + poster + ", title=" + title + ", views=" + views + ", user=" + user
				+ ", shares=" + shares + "]";
	}
	

}