package customTools;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.sun.xml.internal.ws.api.message.Packet.Status;

public class Test_ALL {

	@Test
	public void test() {
//		String qString = "select t from Todolist t where t.status = ?1";
//		TypedQuery<Status> q2 = DBUtil.createQuery(qString, Status.class);
//		q2.setParameter(1,1);
//        
//		Todolist list = new Todolist();
//		Status st = new Status()
//		 System.out.println(st.g);
//		String qString = "update Todolist t set t.status = ?1, t.proirity = ?2, t.duetDate = ?3 where t.id = ?4";
//		TypedQuery<customTools.Todolist> q2 = DBUtil.createQuery(qString, customTools.Todolist.class);
//		q2.setParameter(1,"completed" ).setParameter(2,"01/01/2016").setParameter(3,"high" ).setParameter(4, 5);
//		//q2.setParameter(4,Long.parseLong(request.getParameter("list_id")));
//		DBUtil.updateDB(q2);
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		Todolist DO = new Todolist();
        
		
//		try{
//			
//			DO = em.find(Todolist.class, (long)5);
//			DO.setDuetDate("01/01/2015");
//			DO.setProirity("high");
//			DO.setStatus("completed");
//		}catch(NoResultException e){
//			e.printStackTrace();
//		}
//		
//		DBUtil.update_list(em);
//		 String qString = "delete from Todolist t where t.id = ?1";
//	   	TypedQuery<Todolist> q = DBUtil.createQuery(qString, Todolist.class);
//	   		q.setParameter(1, 5);
//	   		
	//   		DBUtil.delete(qString, Todolist.class,5);
    }
		

}
