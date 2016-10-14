package Home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int operation=Integer.parseInt(request.getParameter("operation"));
		try {
		switch (operation) {
		
		case Homeconstant.REQ_HOMECOUTOPERATION:	
				CountValue(request,response);
				break;
		       }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	private void CountValue(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		 
		JSONObject result = new JSONObject();
	        try {
	            List<HomeVO> members = HomeBL.getObject().getCountAll();
	            JSONArray rmembers = new JSONArray();
	            for (HomeVO member : members) {
	                if (member.getuserId() != -1l) {
	                	
	                    JSONObject rmember = new JSONObject();
	                    rmember.put("No.Of User",   member.getuserName());
	                    rmember.put("No.Of.Project",member.getprojectId());
	                    rmember.put("No.Of.Issue",  member.getissueId());
	                    rmembers.put(rmember);
	                }
	            }
	           // result.put("status", 1);
	            result.put("members", rmembers);
	        } catch (Exception e) {
	            result.put("status", 0);
	            result.put("message", "Internal Error Occurs");
	            e.printStackTrace();
	        }
	        response.getWriter().print(result);
	    }
		
	}

