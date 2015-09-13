package Unit_test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import customTools.DBUtil;
import customTools.Todolist;
import customTools.User1;

public class select_user_list {

	@Test
	public void test() {
		String qString = "select u from User1 u where u.userId = ?1";
		TypedQuery<User1> q = DBUtil.createQuery(qString, User1.class).setParameter(1, 2);
		User1 user = q.getSingleResult();

		
		qString = "select t from Todolist t where t.user1 = ?1";
		TypedQuery<Todolist> q2 = DBUtil.createQuery(qString, Todolist.class).setParameter(1, user);
		List<Todolist> all_list =  q2.getResultList();
		System.out.println(all_list.size());
	}

}
