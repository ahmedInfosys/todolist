

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

@WebServlet("/Addlist")
public class Addlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Addlist() {
        super();
    
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(true);	
    	User1 user = (User1) session.getAttribute("User");
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	if(request.getParameter("description") != null){
			String Description = request.getParameter("description");
			String completed_date;
			if(request.getParameter("status").equalsIgnoreCase("completed")){
				completed_date = sdf.format(now);
			}else{
				completed_date = "Not finished yet";
			}
			String due_date = request.getParameter("datepicker");
			String status = request.getParameter("status");
			String priority = request.getParameter("priority");
			Todolist DO = new Todolist();
			
			DO.setDescription(Description);
			DO.setDateCompleted(completed_date);
			DO.setDuetDate(due_date);
			DO.setStatus(status);
			DO.setProirity(priority);
			DO.setUser1(user);
			
			DBUtil.addToDB(DO);
		}
    	
    	
    	String qString = "select t from Todolist t where t.user1 = ?1";
		TypedQuery<Todolist> q3 = DBUtil.createQuery(qString, Todolist.class).setParameter(1, user);
		List<Todolist> all_list =  q3.getResultList();
		
		session.setAttribute("all_list", all_list);
		
		
		
        
		getServletContext().getRequestDispatcher("/Add.jsp").forward(request,response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   doProcess(request,response);
	}

}
