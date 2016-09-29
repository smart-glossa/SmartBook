package user;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;







/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * Default constructor. 
     */
    public userServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int operation=Integer.parseInt(request.getParameter("operation"));
		try {
			switch (operation) {
			case userconstant.req_RegisterMode:
				adduser(request,response);
				break;
			case  userconstant.req_UpdateMode:
				updateuser(request,response);
				break;
			case userconstant.req_getMode:
				getuser(request,response);
				break;
			case userconstant.req_getAllMode:
				getAlluser(request,response);
				break;
			case userconstant.req_getAdminMode:
				getAdmin(request,response);
				break;
			case userconstant.req_getforgetMode:
				userforget(request,response);
				break;
			case userconstant.req_delete:
				delete(request,response);
				break;
			case userconstant.req_deleteAdmin:
				deleteAdmin(request,response);
                break;
			case userconstant.req_getlogin:
				getlogin(request,response);
                break;
			}
			}catch (Exception e) {
				// TODO: handle exception
			
			}
		
	}

	
	private void adduser(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		// TODO Auto-generated method stub
		
		  JSONObject result = new JSONObject();
	        String Name = request.getParameter("Name");
	        String dateOfBirth = request.getParameter("dob");
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("pass");
	        String type = request.getParameter("type");
	        try 
	        {
	           userVO user = userBL.getObject().addUser(Name, dateOfBirth,userName, password,type);
	            result.put("status", 1);
	           // result.put("userId", user.getuserId());
	            result.put("Name",user.getName());
	        } catch (ClassNotFoundException e) {
	            result.put("status", 0);
	            result.put("message", "Internal Error Occurs");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            result.put("status", 0);
	            result.put("message", "SQL Error Occurs");
	            e.printStackTrace();
	        } catch (ParseException e) {
	            result.put("status", 0);
	            result.put("message", "Parse Error Occurs");
	            e.printStackTrace();
	        } 
	       response.getWriter().print(result);
	    }
	
private void updateuser(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
	
	JSONObject result = new JSONObject();
	
     String Name = request.getParameter("Name");
     String userName = request.getParameter("userName"); 
     String type=request.getParameter("type");
     try {
         userBL.getObject().updateUser(Name,userName,type);
         result.put("status", 1);
     } catch (ClassNotFoundException e) {
         result.put("status", 0);
         result.put("message", "Internal Error Occurs");
         e.printStackTrace();
     } catch (SQLException e) {
         result.put("status", 0);
         result.put("message", "SQL Error Occurs");
         e.printStackTrace();
     } catch (ParseException e) {
         result.put("status", 0);
         result.put("message", "Parse Error Occurs");
         e.printStackTrace();
     } catch (JSONException e) {
         result.put("status", 0);
         result.put("message", "Parse Error Occurs");
         e.printStackTrace();
     }
     response.getWriter().print(result);
 }
private void getuser(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
        
    JSONObject result = new JSONObject();
      
        String userName=request.getParameter("userName");
        try {
            userVO user = userBL.getObject().getUser(userName);
            result.put("status", 1);
            if (user.getuserId() != -1l) {
                result.put("userId", user.getuserId());
                result.put("Name", user.getName());
                result.put("userName", user.getUserName());
                result.put("type", user.gettype());
            }
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            result.put("status", 0);
            result.put("message", "NumberFormatException");
            e.printStackTrace();
        } catch (JSONException e) {
            result.put("status", 0);
            result.put("message", "JSONException");
            e.printStackTrace();
        } 
        response.getWriter().print(result);
    }
private void getAlluser(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, NumberFormatException, SQLException {
	JSONObject all=new JSONObject();
	JSONArray getall=new JSONArray();
	
	try
	{
		List<userVO> alluser=userBL.getObject().getusers();
		for(userVO vo:alluser)
         {
			if(vo.getuserId()!=1l)
			{
				JSONObject get=new JSONObject();
				get.put("userId",vo.getuserId());
				get.put("Name", vo.getName());
				get.put("dob", vo.getDateOfBirth());
				get.put("userName",vo.getUserName());
				get.put("type",vo.gettype());
				getall.put(get);
			}
		}
	}catch(ClassNotFoundException e){
		all.put("Status", 0);
		all.put("Message","Internal Error Occurs");
		e.printStackTrace();
	}catch (ParseException e) {
		all.put("Status",0);
		all.put("Message", "parseException Error Occur");
		e.printStackTrace();
}
	response.getWriter().print(getall);
}

private void getAdmin(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, NumberFormatException, SQLException {
	JSONObject all=new JSONObject();
	JSONArray getall=new JSONArray();
	String type=request.getParameter("type");
	
	try
	{
		List<userVO> alluser=userBL.getObject().getAdmin(type);
		for(userVO vo:alluser)
         {
			if(vo.getuserId()!=1l)
			{
				JSONObject get=new JSONObject();
				get.put("userId",vo.getuserId());
				get.put("Name", vo.getName());
				get.put("dob", vo.getDateOfBirth());
				get.put("userName",vo.getUserName());
				get.put("type",vo.gettype());
				getall.put(get);
			}
		}
	}catch(ClassNotFoundException e){
		all.put("Status", 0);
		all.put("Message","Internal Error Occurs");
		e.printStackTrace();
	}catch (ParseException e) {
		all.put("Status",0);
		all.put("Message", "parseException Error Occur");
		e.printStackTrace();
}
	response.getWriter().print(getall);
}

/////////////////////////////
private void getlogin(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, NumberFormatException, SQLException {
	JSONObject all=new JSONObject();
	JSONArray getall=new JSONArray();
	String userName=request.getParameter("userName");
	String pass=request.getParameter("pass");
	
	try
	{
		List<userVO> alluser=userBL.getObject().getlogin(userName, pass);
		JSONObject get=new JSONObject();
		for(userVO vo:alluser)
         {
			if(vo.getuserId()!=1l)
			{
				
				get.put("userId",vo.getuserId());
				get.put("Name", vo.getName());
				get.put("dob", vo.getDateOfBirth());
				get.put("userName",vo.getUserName());
				get.put("type",vo.gettype());
				getall.put(get);
			}else{
				get.put("Message", "invalid password/userName");
				getall.put(get);
			}
		}
	}catch(ClassNotFoundException e){
		all.put("Status", 0);
		all.put("Message","Internal Error Occurs");
		e.printStackTrace();
	}catch (ParseException e) {
		all.put("Status",0);
		all.put("Message", "parseException Error Occur");
		e.printStackTrace();
}
	response.getWriter().print(getall);
}
////////////////////////////////
private void userforget(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
	 
	JSONObject result = new JSONObject();                            
   
    String userName = request.getParameter("userName");
    String password = request.getParameter("pass"); 
    try {
        userVO user=userBL.getObject().forget(userName, password);
        result.put("status","welcome to Employees");
        result.put("userName",user.getUserName());
    } catch (ClassNotFoundException e) {
        result.put("status", 0);
        result.put("message", "Internal Error Occurs");
        e.printStackTrace();
    } catch (SQLException e) {
        result.put("status", 0);
        result.put("message", "SQL Error Occurs");
        e.printStackTrace();
    } catch (ParseException e) {
        result.put("status", 0);
        result.put("message", "Parse Error Occurs");
        e.printStackTrace();
    } catch (JSONException e) {
        result.put("status", 0);
        result.put("message", "JSONException");
        e.printStackTrace();
    }
    response.getWriter().print(result);
}

private void delete(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
	// TODO Auto-generated method stub

	 JSONObject result = new JSONObject();
     String userName =request.getParameter("userName");
     try {
         userBL.getObject().deleteUser(userName);
         result.put("status", "success Deleted");
     } catch (ClassNotFoundException e) {
         result.put("status", 0);
         result.put("message", "Internal Error Occurs");
         e.printStackTrace();
     } catch (SQLException e) {
         result.put("status", 0);
         result.put("message", "SQL Error Occurs");
         e.printStackTrace();
     } catch (NumberFormatException e) {
         result.put("status", 0);
         result.put("message", "NumberFormatException");
         e.printStackTrace();
     } catch (JSONException e) {
         result.put("status", 0);
         result.put("message", "JSONException");
         e.printStackTrace();
     } 
     response.getWriter().print(result);
 }
private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
	// TODO Auto-generated method stub

	 JSONObject result = new JSONObject();
     String type =request.getParameter("type");
     try {
         userBL.getObject().deleteAdmin(type);
         result.put("status", "success Deleted");
     } catch (ClassNotFoundException e) {
         result.put("status", 0);
         result.put("message", "Internal Error Occurs");
         e.printStackTrace();
     } catch (SQLException e) {
         result.put("status", 0);
         result.put("message", "SQL Error Occurs");
         e.printStackTrace();
     } catch (NumberFormatException e) {
         result.put("status", 0);
         result.put("message", "NumberFormatException");
         e.printStackTrace();
     } catch (JSONException e) {
         result.put("status", 0);
         result.put("message", "JSONException");
         e.printStackTrace();
     } 
     response.getWriter().print(result);
 }
	
}


  
	

	





