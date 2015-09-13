package Unit_test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.junit.Test;

import customTools.DBUtil;
import customTools.Todolist;
import customTools.User1;

public class Edit_todoList {

	@Test
	public void test() {
		String qString = "select u from User1 u where u.userId = ?1";
		TypedQuery<User1> q = DBUtil.createQuery(qString, User1.class).setParameter(1, 2);
		User1 user = q.getSingleResult();
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy hh:mm a");
		
		qString = "select t from Todolist t where t.id = ?1";

		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
			Todolist DO = new Todolist();
			
			try{
				DO = em.find(Todolist.class,18L);
				DO.setDuetDate("11/01/2015");
				DO.setProirity("Very high");
				DO.setStatus("On hold");
				if(DO.getStatus().equalsIgnoreCase("completed")){
					Date now = new Date();
					DO.setDateCompleted(sdf.format(now));
				}else{
					
					DO.setDateCompleted("Not finished yet");
				}
			}catch(NoResultException e){
				e.printStackTrace();
			}
			DBUtil.update_list(em);	
	}

}
