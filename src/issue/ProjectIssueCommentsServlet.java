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
        int mode = Integer.parseInt(request.getParameter("mode"));
        switch (mode) {
        case ProjectIssueCommentsConstants.req_CreateMode:
            createIssueComment(request, response);
            break;
        case ProjectIssueCommentsConstants.req_UpdateMode:
            updateIssueComment(request, response);
            break;
        case ProjectIssueCommentsConstants.req_DeleteMode:
            deleteIssueComment(request, response);
            break;
        case ProjectIssueCommentsConstants.req_GetMode:
            getIssueCommentDetail(request, response);
            break;
        }
    }
    
    private void createIssueComment(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        Long issueId = Long.parseLong(request.getParameter("issueId"));
        Long userId = Long.parseLong(request.getParameter("userId"));
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        
        try {
            ProjectIssueCommentsVO comment = ProjectIssueCommentsBL.getObject().addIssueComment(issueId, userId, content,
                    time);
            result.put("status", 1);
            result.put("commentId", comment.getCommentId());
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
        
    }
    
    private void updateIssueComment(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long commentId = Long.parseLong(request.getParameter("commentId"));
        Long issueId = Long.parseLong(request.getParameter("issueId"));
        Long userId = Long.parseLong(request.getParameter("userId"));
        String content = request.getParameter("content");
        String time = request.getParameter("time");
        
        try {
            ProjectIssueCommentsBL.getObject().updateIssueComment(commentId, issueId,
                    userId, content, time);
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
        } 
        
    }
    
    private void deleteIssueComment(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long commentId = Long.parseLong(request.getParameter("commentId"));
        try {
            ProjectIssueCommentsBL.getObject().deleteIssueComment(commentId);
            result.put("status", 1);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } 
    }
    
    private void getIssueCommentDetail(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long commentId = Long.parseLong(request.getParameter("commentId"));
        try {
            ProjectIssueCommentsVO comment = ProjectIssueCommentsBL.getObject().getIssueComment(commentId);
            result.put("status", 1);
            if (comment.getIssueId() != -1l) {
                result.put("commentId", comment.getCommentId());
                result.put("issueId", comment.getIssueId());
                result.put("userId", comment.getUserId());
                result.put("content", comment.getContent());
                result.put("time", comment.getCommentTime());
            }
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } 
    }
}
