package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUitls {
public static EntityManager getEntityManager() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ASMFinal");
	return factory.createEntityManager();
}
}
