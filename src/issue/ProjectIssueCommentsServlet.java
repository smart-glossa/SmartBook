package issue;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ProjectIssueCommentsServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        doPost(request, response);   
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws JSONException {
    	
    	int operation = Integer.parseInt(request.getParameter("operation"));
		 try
		 {
	        switch(operation) {
	        case ProjectCommentsConstants.REQ_CREATEMODE:
	            CreateProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_UPDATEMODE:
	            UpdateProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_DELETEMODE:
	            DeleteProjectComment(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_GETMODE:
	            GetProjectCommentDetail(request, response);
	            break;
	        case ProjectCommentsConstants.REQ_GETALLMODE:
	        	GetAll(request,response);
	        	break;
	        }
		 }catch(Exception e)
		 {
			 
		 }
	    }
	    
		private void CreateProjectComment(HttpServletRequest request, HttpServletResponse response) 
				throws JSONException, IOException {
	        
			JSONObject result = new JSONObject();
	        Long issueId = Long.parseLong(request.getParameter("issueId"));
	        long userId=Long.parseLong(request.getParameter("userId"));
	        String content = request.getParameter("content");
	        String time = request.getParameter("time");
	        
	        try {
	            ProjectCommentsVO comment = ProjectCommentsBL.getObject().addProjectComment(issueId,
	            		userId, content, time);
	            result.put("status", 1);
	            result.put("projectId", comment.getissueId());
	        } catch (Exception e) {
	            result.put("status", 0);
	            result.put("message", "Internal Error Occurs");
	            e.printStackTrace();
	        }
	        response.getWriter().print(result);
	        
	    }
	    
	    private void UpdateProjectComment(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {
	        
	    	JSONObject result = new JSONObject();
	        long commentId =  Long.parseLong(request.getParameter("commentId"));
	        long issueId =  Long.parseLong(request.getParameter("issueId"));
	        long userId = Long.parseLong(request.getParameter("userId"));
	        String content =  request.getParameter("content");
	        String time =     request.getParameter("time");
	        
	        try {
	            ProjectCommentsBL.getObject().updateProjectComment(commentId, issueId,userId, content, time);
	            result.put("status", 1);
	        } catch (Exception e) {
	            result.put("Status", 0);
	            result.put("Message", "Internal Error Occurs");
	            e.printStackTrace();
	        } 
	        response.getWriter().print(result);
	        
	    }
	    
	    private void DeleteProjectComment(HttpServletRequest request, HttpServletResponse response) 
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
	    
	    private void GetProjectCommentDetail(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {
	        
	    	JSONObject result = new JSONObject();
	        long commentId = Long.parseLong(request.getParameter("commentId"));
	        try {
	            ProjectCommentsVO comment = ProjectCommentsBL.getObject().getProjectComment(commentId);
	            result.put("Status", 1);
	            
	            if (comment.getCommentId() != -1l) {
	                result.put("commentId", comment.getCommentId());
	                result.put("issueId", comment.getissueId());
	                result.put("userId" , comment.getUserId());
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
	    private void GetAll(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {

	    	 JSONObject all = new JSONObject();
	         JSONArray getall = new JSONArray();

	         try {
	             List<ProjectCommentsVO> allcomment = ProjectCommentsBL.getObject().getAllComments();
	             for (ProjectCommentsVO vo : allcomment) {
	                 if (vo.getCommentId() != 1l) {
	                     JSONObject get = new JSONObject();
	                     get.put("commentId", vo.getCommentId());
	                     get.put("issueId", vo.getissueId());
	                     get.put("userId", vo.getUserId());
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


