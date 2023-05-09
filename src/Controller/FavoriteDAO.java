package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Model.Favorite;
import Model.User;
import Utils.JpaUitls;

public class FavoriteDAO {


	public boolean insert(Favorite v) {
		EntityManager em = JpaUitls.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();

			em.persist(v);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			System.out.println("Error: " + e.toString());
			return false;
		} finally {
			em.close();
		}

		return true;
	}
	
	
	public void delete(String idVideo, String idUser) {
		EntityManager em = JpaUitls.getEntityManager();
		EntityTransaction trans = em.getTransaction();
	    try {
	        trans.begin();
	        Query query = em.createQuery("DELETE FROM Favorite f WHERE f.idVideo = :idVideo AND f.user.idUser = :idUser");
	        query.setParameter("idVideo", idVideo);
	        query.setParameter("idUser", idUser);
	        int deletedCount = query.executeUpdate();
	        trans.commit();
	        System.out.println(deletedCount + " record(s) deleted.");
	    } catch (Exception ex) {
	        trans.rollback();
	        ex.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
	
	public List<Favorite> findMyFavorite(String idUser){
		EntityManager em = JpaUitls.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		String spql = "SELECT f FROM Favorite f where f.user.idUser =:idUser";
		TypedQuery<Favorite> query = em.createQuery(spql,Favorite.class);
		query.setParameter("idUser", idUser);
		List<Favorite> results = query.getResultList();
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Boolean checkActive(String idVideo, String idUser) {
		EntityManager em = JpaUitls.getEntityManager();
		TypedQuery<Boolean> query = em.createQuery("SELECT f.active FROM Favorite f where f.idVideo =:id and f.user.idUser =:idUser", Boolean.class);
		query.setParameter("id", idVideo);
		query.setParameter("idUser", idUser);
		List<Boolean> results = query.getResultList();
	    if (results.isEmpty()) {
	        return false;
	    }
	    return results.get(0);
	}
}
