package Unit_test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import customTools.DBUtil;
import customTools.User1;

public class Create_account {

	@Test
	public void test() {
		User1 user = new User1();
        user.setEmail("ahmed@damah.com");
        user.setFirstName("Ahmed");
        user.setLastName("Hameed");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy hh:mm a");
        user.setJoinDate(sdf.format(now));
        user.setPassword("123456");

        String qString = "select u from User1 u where u.email = ?1";
        if(DBUtil.createQuery(qString, User1.class).setParameter(1,user.getEmail()).getResultList().size() > 0){
			System.out.println("User with email " + user.getEmail() + " is already exists in our database.");
		}else{
			
	        DBUtil.addToDB(user);

		}
        	
        	
	}

}
