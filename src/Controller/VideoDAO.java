package Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.json.JSONArray;
import org.json.JSONObject;

import APIYTB.APIYTB;
import Model.Videos;
import Utils.JpaUitls;

public class VideoDAO {

	public boolean insert(Videos v) {
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
}
