package Unit_test;

import static org.junit.Assert.*;

import javax.persistence.TypedQuery;

import org.junit.Test;

import customTools.DBUtil;
import customTools.Todolist;
import customTools.User1;

public class add_todo_item {

	@Test
	public void test() {
		String qString = "select u from User1 u where u.userId = ?1";
		TypedQuery<User1> q = DBUtil.createQuery(qString, User1.class).setParameter(1, 2);
		User1 user = q.getSingleResult();
		
		Todolist DO = new Todolist();
		DO.setDescription("Assn 3");
		DO.setDateCompleted("09/12/2015");
		DO.setDuetDate("09/20/2015");
		DO.setStatus("completed");
		DO.setProirity("Low");
		DO.setUser1(user);
		
		DBUtil.addToDB(DO);
	}

}
