

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import customTools.User1;


@WebServlet("/My_Profile")
public class My_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public My_Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String  FirstName = null, LastName = null, Email = null, password,  profile_image;
    			
    			
    			String  Password;
    			String  invalid = "", create_an_account = "";

    			String  Page = "";
    	        long ID;
    			
    			SimpleDateFormat  sdf = new SimpleDateFormat("E MM/dd/yyyy hh:mm a");
    			
    			
  			HttpSession session = request.getSession(true);
//    			if(session.getAttribute("User") == null){
//    				User1 user = new User1();
//    				user.setFirstName("Customer");
//    				user.setLastName(",Please sign in to complete shopping");
//    				
//    				DBUtil.addToDB(user);
//    				
//    				session.setAttribute("User", user);
//    			}
    			
    			if(request.getParameter("password") != null){
    				
    				System.out.println("For Sign Up.");
    				FirstName = request.getParameter("fName");
    				LastName = request.getParameter( "lName" );
    				Email=request.getParameter("email");
    				password= request.getParameter("password");
                    
    				
    				String qString = "select u from User1 u where u.email = ?1";
   
    				if(DBUtil.createQuery(qString, User1.class).setParameter(1,Email).getResultList().size() > 0){
    					Page = "/SignUp.jsp";
    					String Already_Exists = "The user " + Email + " is already exists, please <a href=\"/Shopping_cart/SignIn.jsp\"> sign in.</a>" ;
    					request.setAttribute("alreadyin", Already_Exists);
    				}else{
    					
    					Page = "/Profile.jsp";
    					Date now = new Date();

    					User1 user = new User1();
    					
    					user.setFirstName(FirstName);
    					user.setLastName(LastName);
    					user.setEmail(Email);
    					user.setPassword(password);
    					DBUtil.addToDB(user);
    					
    					session = request.getSession();
    		        	session.setAttribute("User", user);
    		        	DBUtil db_util = new DBUtil();
    					session.setAttribute("db_util", db_util);

    				}
    			}else if (request.getParameter("loginpassword") != null){
    				
    				System.out.println("For Sign in.");
    				
    				
    				Email = request.getParameter("email");
    				Password = request.getParameter("loginpassword");
    				
    				User1 single_user = new User1();
    				
    				String qString = "select u from User1 u where u.email = ?1 and u.password = ?2";
    				
    				
    				TypedQuery<User1> q2 = DBUtil.createQuery(qString, User1.class);
    				
    				q2.setParameter(1,Email);
    				q2.setParameter(2,Password);
    				try{
    					single_user = q2.getSingleResult();
    		
    				}catch(Exception e){
    					single_user = null;
    					System.out.println(e);
    				}
    				
    				System.out.println(single_user);
    				
    				if(single_user == null){
    					
    					System.out.println("Invalid");
    					Page = "/SignIn.jsp";
    					
    					invalid = "Invalid Email or/and password";
    					create_an_account = "<a href=\"/ToDoList/SignUp.jsp\">Create an account</a>";
    					request.setAttribute("invalid_user", invalid);
    					request.setAttribute("Sign_up", create_an_account);
    				}
    				else{
    				
    		        	session = request.getSession();
    		        	session.setAttribute("User", single_user);/////change
    		
    		        	Page = "/Profile.jsp";
 
    				}
    				
    				
    			}else {
    				
    				session = request.getSession(true);

    				
		        	User1 user = (User1) session.getAttribute("User");/////change
		        	//session.setAttribute("", arg1);
		        	Page = "/Profile.jsp";

    			}

    	    	
    	  

  
    	    	  getServletContext().getRequestDispatcher(Page).forward(request,response);
    	    	 
    		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
