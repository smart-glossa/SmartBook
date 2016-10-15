package issue;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import comments.ProjectCommentsConstants;

public class ProjectIssueCommentsServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);   
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    	
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
	        String userName=request.getParameter("userName");
	        String content = request.getParameter("content");
	        String time = request.getParameter("time");
	        
	        try {
	            ProjectIssueCommentsVO comment = ProjectIssueCommentsBL.getObject().addProjectComment(issueId, userName, content, time);
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
	        String userName = request.getParameter("userName");
	        String content =  request.getParameter("content");
	        String time =     request.getParameter("time");
	        
	        try {
	            ProjectIssueCommentsBL.getObject().updateProjectComment(commentId, issueId, userName, content, time);
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
	        	
	            ProjectIssueCommentsBL.getObject().deleteProjectComment(commentId);
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
	            ProjectIssueCommentsVO comment = ProjectIssueCommentsBL.getObject().getProjectComment(commentId);
	            result.put("Status", 1);
	            
	            if (comment.getCommentId() != -1l) {
	                result.put("commentId", comment.getCommentId());
	                result.put("issueId", comment.getissueId());
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
	    private void GetAll(HttpServletRequest request, HttpServletResponse response) 
	    		throws JSONException, IOException {

	    	 JSONObject all = new JSONObject();
	         JSONArray getall = new JSONArray();

	         try {
	             List<ProjectIssueCommentsVO> allcomment = ProjectIssueCommentsBL.getObject().GetAlls();
	             for (ProjectIssueCommentsVO vo : allcomment) {
	                 if (vo.getCommentId() != 1l) {
	                     JSONObject get = new JSONObject();
	                     get.put("commentId", vo.getCommentId());
	                     get.put("issueId", vo.getissueId());
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
