package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Model.User;
import Utils.JpaUitls;

public class UserDAO {

	public static User login(String idUser, String pass) {
		EntityManager em = JpaUitls.getEntityManager();
		User ent = em.find(User.class, idUser);
		if (ent != null && ent.getPassword().equals(pass.trim())) {
			return ent;
		} else {
			return null;

		}

	}
	public Boolean insertUser(User u) {
		EntityManager em = JpaUitls.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			
			
			em.persist(u);
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
	public Boolean findById(String idUser) {
		EntityManager em = JpaUitls.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		User user = em.find(User.class, idUser);
		//System.out.println(user.toString());
		if(user == null){
			return false;
		}
		return true;
		
	}


}
