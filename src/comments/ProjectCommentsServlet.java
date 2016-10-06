package comments;

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



@WebServlet("/ProjectCommentsServlet")
public class ProjectCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProjectCommentsServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		 int operation = Integer.parseInt(request.getParameter("operation"));
		 try
		 {
	        switch(operation) {
	        case ProjectCommentsConstants.REQ_CREATEMODE:
	            createProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_UPDATEMODE:
	            updateProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_DELETEMODE:
	            deleteProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_GETMODE:
	            getProjectCommentDetail(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_GETALLMODE:
	        	getAll(request,response);
	        	break;
	        }
		 }catch(Exception e)
		 {
			 
		 }
	    }
	    
		private void createProjectComment(HttpServletRequest request, HttpServletResponse response) 
				throws JSONException, IOException {
	        
			JSONObject result = new JSONObject();
	        Long projectId = Long.parseLong(request.getParameter("projectId"));
	        String userName=request.getParameter("userName");
	        String content = request.getParameter("content");
	        String time = request.getParameter("time");
	        
	        try {
	            ProjectCommentsVO comment = ProjectCommentsBL.getObject().addProjectComment(projectId, userName, content, time);
	            result.put("status", 1);
	            result.put("projectId", comment.getProjectId());
	        } catch (Exception e) {
	            result.put("status", 0);
	            result.put("message", "Internal Error Occurs");
	            e.printStackTrace();
	        }
	        response.getWriter().print(result);
	        
	    }
	    
	    private void updateProjectComment(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {
	        
	    	JSONObject result = new JSONObject();
	        long commentId = Long.parseLong(request.getParameter("commentId"));
	        long projectId = Long.parseLong(request.getParameter("projectId"));
	        String userName = request.getParameter("userName");
	        String content = request.getParameter("content");
	        String time = request.getParameter("time");
	        
	        try {
	            ProjectCommentsBL.getObject().updateProjectComment(commentId, projectId,userName, content, time);
	            result.put("status", 1);
	        } catch (Exception e) {
	            result.put("Status", 0);
	            result.put("Message", "Internal Error Occurs");
	            e.printStackTrace();
	        } 
	        response.getWriter().print(result);
	        
	    }
	    
	    private void deleteProjectComment(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {
	        
	    	JSONObject result = new JSONObject();
	        long commentId = Long.parseLong(request.getParameter("commentId"));
	        try {
	            ProjectCommentsBL.getObject().deleteProjectComment(commentId);
	            result.put("Status", 1);
	        } catch (Exception e) {
	            result.put("Status", 0);
	            result.put("Message", "Internal Error Occurs");
	        } 
	        response.getWriter().print(result);   
	    }
	    
	    private void getProjectCommentDetail(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {
	        
	    	JSONObject result = new JSONObject();
	        long commentId = Long.parseLong(request.getParameter("commentId"));
	        try {
	            ProjectCommentsVO comment = ProjectCommentsBL.getObject().getProjectComment(commentId);
	            result.put("Status", 1);
	            
	            if (comment.getProjectId() != -1l) {
	                result.put("commentId", comment.getCommentId());
	                result.put("projectId", comment.getProjectId());
	                result.put("userName" , comment.getUserName());
	                result.put("content"  , comment.getCommentContent());
	                result.put("time"     , comment.getCommentTime());
	            }
	        }catch (Exception e) {
	            result.put("Status", 0);
	            result.put("Message", "Internal Error Occurs");
	            e.printStackTrace();
	        } 
	        response.getWriter().print(result);

	}
	    private void getAll(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {

	    	 JSONObject all = new JSONObject();
	         JSONArray getall = new JSONArray();

	         try {
	             List<ProjectCommentsVO> allcomment = ProjectCommentsBL.getObject().getAllComments();
	             for (ProjectCommentsVO vo : allcomment) {
	                 if (vo.getCommentId() != 1l) {
	                     JSONObject get = new JSONObject();
	                     get.put("commentId", vo.getCommentId());
	                     get.put("projectId", vo.getProjectId());
	                     get.put("userName", vo.getUserName());
	                     get.put("content",  vo.getCommentContent());
	                     get.put("time", vo.getCommentTime());
	                     getall.put(get);
	                 }
	             }
	         } catch (Exception e) {
	             all.put("Status", 0);
	             all.put("Message", "Internal Error Occurs");
	             e.printStackTrace();
	         }
	         response.getWriter().print(getall);
	     }

		}


