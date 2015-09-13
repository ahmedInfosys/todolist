package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;







public class DBUtil {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ToDoList");
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
	

	public static <T> void addToDB(Object T){
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try{
			trans.begin();
			em.merge(T);
			trans.commit();
			}
			catch(Exception e){
			trans.rollback();
			}
		finally{
			em.close();
		}
		
	}
	
	public static <T> TypedQuery<T> createQuery(String q, Class<T> className){
		EntityManager em = emf.createEntityManager();
		TypedQuery<T> tQuery = em.createQuery(q,className);
		return tQuery;
	}
	
	
	
	public static <T> void updateDB(TypedQuery<T> tQuery){
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();	
		try{
			trans.begin();
			tQuery.executeUpdate();
			trans.commit();
		} catch(Exception e){
			trans.rollback();
		}finally{
			em.close();
		}
	}	
	
	
	public static <T> void update_list(	EntityManager em ){
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}finally{
			em.clear();
		}
	}
	
//	public static <T> void delete(long id, Class<T> className) {
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		trans.begin(); 
//		try {
//			em.remove(className);
//			trans.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//			trans.rollback();
//		} finally {
//			em.close();
//		} 
//	}
	
	public static <T> void delete (String qString, Class<T> className, long id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try{
			Query q = em.createQuery(qString,  className);
		    q.setParameter(1, id).executeUpdate();
		    trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
	}

}