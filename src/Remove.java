

import java.io.IOException;
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

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Remove() {
        super();
    }

     protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession(true);	
     	User1 user = (User1) session.getAttribute("User");
     	Date now = new Date();
         
     	
     	if(request.getParameter("list_id") != null){
	   	  String qString = "delete from Todolist t where t.id = ?1";		
		  DBUtil.delete(qString, Todolist.class,Long.parseLong(request.getParameter("list_id")));	
   		}
     	String qString = "select t from Todolist t where t.user1 = ?1";
 		TypedQuery<Todolist> q3 = DBUtil.createQuery(qString, Todolist.class).setParameter(1, user);
 		List<Todolist> all_list =  q3.getResultList();
 		
 		session.setAttribute("all_list", all_list);
 		
 		getServletContext().getRequestDispatcher("/Remove.jsp").forward(request,response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request,response);
	}

}
