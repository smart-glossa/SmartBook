package issue;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ProjectIssueServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        doPost(request, response);   
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        int mode = Integer.parseInt(request.getParameter("mode"));
        switch (mode) {
        case ProjectIssueConstants.req_CreateMode:
            createIssue(request, response);
            break;
        case ProjectIssueConstants.req_UpdateMode:
            updateIssue(request, response);
            break;
        case ProjectIssueConstants.req_DeleteMode:
            deleteIssue(request, response);
            break;
        case ProjectIssueConstants.req_GetMode:
            getIssueDetail(request, response);
            break;
        }
    }
    
    private void createIssue(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        Long projectId = Long.parseLong(request.getParameter("projectId"));
        String description = request.getParameter("description");
        Long finderId = Long.parseLong(request.getParameter("finderId"));
        String findTime = request.getParameter("findTime");
        int status = Integer.parseInt(request.getParameter("status"));
        Long fixerId = Long.parseLong(request.getParameter("fixerId"));
        String fixTime = request.getParameter("fixTime");
        
        try {
            ProjectIssueVO issue = ProjectIssueBL.getObject().addProjectIssue(projectId, description,
                    status, finderId, findTime, fixerId, fixTime);
            result.put("status", 1);
            result.put("issueId", issue.getIssueId());
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
    
    private void updateIssue(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        Long issueId = Long.parseLong(request.getParameter("issueId"));
        Long projectId = Long.parseLong(request.getParameter("projectId"));
        String description = request.getParameter("description");
        Long finderId = Long.parseLong(request.getParameter("finderId"));
        String findTime = request.getParameter("findTime");
        int status = Integer.parseInt(request.getParameter("status"));
        Long fixerId = Long.parseLong(request.getParameter("fixerId"));
        String fixTime = request.getParameter("fixTime");
        
        try {
            ProjectIssueBL.getObject().updateProjectIssue(issueId, projectId, description,
                    status, finderId, findTime, fixerId, fixTime);
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
    
    private void deleteIssue(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long issueId = Long.parseLong(request.getParameter("issueId"));
        try {
            ProjectIssueBL.getObject().deleteProjectIssue(issueId);
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
    
    private void getIssueDetail(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject result = new JSONObject();
        long issueId = Long.parseLong(request.getParameter("issueId"));
        try {
            ProjectIssueVO issue = ProjectIssueBL.getObject().getProjectIssue(issueId);
            result.put("status", 1);
            if (issue.getIssueId() != -1l) {
                result.put("issueId", issue.getIssueId());
                result.put("projectId", issue.getProjectId());
                result.put("description", issue.getDescription());
                result.put("status", issue.getStatus());
                result.put("finderId", issue.getFinderId());
                result.put("findTime", issue.getFindTime());
                result.put("fixerTime", issue.getFixerId());
                result.put("fixTime", issue.getFixTime());
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
