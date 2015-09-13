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

public class DeleteTodoItem {

	@Test
	public void test() {
	  String qString = "delete from Todolist t where t.id = ?1";	
	  DBUtil.delete(qString, Todolist.class,18);
	}


}
