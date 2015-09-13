

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import customTools.Todolist;
import customTools.User1;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Edit() {
        super();
    
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(true);	
    	User1 user = (User1) session.getAttribute("User");
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        
    	if(request.getParameter("list_id") != null){
   		    String qString = "select t from Todolist t where t.id = ?1";
//   		TypedQuery<Todolist> q = DBUtil.createQuery(qString, Todolist.class);
//   		q.setParameter(1, Long.parseLong(request.getParameter("list_id")));
//   		Todolist item = q.getSingleResult();
   		
//   		qString = "update Todolist t set t.status = ?1, t.proirity = ?2, t.duetDate = ?3 where t.id = ?4";
//   		TypedQuery<Todolist> q2 = DBUtil.createQuery(qString, Todolist.class);
//   		q2.setParameter(1,request.getParameter("status") );
//   		q2.setParameter(2,request.getParameter("datepicker") );
//   		q2.setParameter(3,request.getParameter("priority") );
//   		q2.setParameter(4,Long.parseLong(request.getParameter("list_id")));
//
//   		DBUtil.updateDB(q2);
   		 
   		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
   			Todolist DO = new Todolist();
   			
   			try{
//   				System.out.println(request.getParameter("datepicker"));
//   				System.out.println(request.getParameter("priority"));
//   				System.out.println(request.getParameter("status"));
   				DO = em.find(Todolist.class, Long.parseLong(request.getParameter("list_id")));
   				DO.setDuetDate(request.getParameter("datepicker"));
   				DO.setProirity(request.getParameter("priority"));
   				DO.setStatus(request.getParameter("status"));
   				if(DO.getStatus().equalsIgnoreCase("completed")){
   					DO.setDateCompleted(sdf.format(now));
   				}else{
   					DO.setDateCompleted("Not finished yet");
   				}
   			}catch(NoResultException e){
   				e.printStackTrace();
   			}
   			DBUtil.update_list(em);	
   		}
    	
    	String qString = "select t from Todolist t where t.user1 = ?1";
		TypedQuery<Todolist> q3 = DBUtil.createQuery(qString, Todolist.class).setParameter(1, user);
		List<Todolist> all_list =  q3.getResultList();
		
		session.setAttribute("all_list", all_list);
		
    	
    		
    	getServletContext().getRequestDispatcher("/Edit.jsp").forward(request,response);
    		
    	}
    	
    	
    	

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   doProcess(request,response);
	}

}
