package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the shares database table.
 * 
 */
@Entity
@Table(name="shares")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_share")
	private double idShare;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="share_date")
	private Date shareDate;

	//bi-directional many-to-one association to Favorite
	@ManyToOne
	@JoinColumn(name="id_video")
	private Favorite favorite;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Share() {
	}

	public double getIdShare() {
		return this.idShare;
	}

	public void setIdShare(double idShare) {
		this.idShare = idShare;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return this.shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public Favorite getFavorite() {
		return this.favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}