package issue;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProjectIssueServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int operation = Integer.parseInt(request.getParameter("operation"));

        try {
            switch (operation) {
            case ProjectIssueConstants.REQ_CREATEISSUEOPERATION:
                CreateIssue(request, response);
                break;
            case ProjectIssueConstants.REQ_UPDATEISSUEOPERATION:
                UpdateIssue(request, response);
                break;
            case ProjectIssueConstants.DELETEISSUEORERATION:
                DeleteIssue(request, response);
                break;
            case ProjectIssueConstants.REQ_GETISSUEOPERATION:
                GetIssueDetail(request, response);
                break;
            case ProjectIssueConstants.GETALLISSUEOPERATION:
                GetAllIssue(request, response);
                break;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void CreateIssue(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, SQLException, ParseException, IOException {

        JSONObject result = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String description = request.getParameter("description");
        String finderName = request.getParameter("finderName");
        String findTime = request.getParameter("findTime");
        String status = request.getParameter("status");
        String fixedName = request.getParameter("fixedName");
        String fixTime = request.getParameter("fixTime");

        try {
            ProjectIssueBL.getObject().addProjectIssue(projectId, description, finderName,
                    findTime, status, fixedName, fixTime);
            result.put("status", 1);
            // result.put("issueId", issue.getIssueId());
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void UpdateIssue(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, SQLException, ParseException, IOException {

        JSONObject result = new JSONObject();
        long issueId = Long.parseLong(request.getParameter("issueId"));
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String finderName = request.getParameter("finderName");
        String fixedName = request.getParameter("fixedName");

        try {
            ProjectIssueBL.getObject().updateProjectIssue(issueId, projectId, description, finderName, status,
                    fixedName);
            result.put("status", 1);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void DeleteIssue(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, SQLException, IOException {

        JSONObject result = new JSONObject();
        int issueId = Integer.parseInt(request.getParameter("issueId"));
        try {
            ProjectIssueBL.getObject().deleteProjectIssue(issueId);
            result.put("status", 1);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void GetIssueDetail(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, SQLException, IOException {

        JSONObject result = new JSONObject();
        int issueId = Integer.parseInt(request.getParameter("issueId"));
        try {
            ProjectIssueVO issue = ProjectIssueBL.getObject().getProjectIssue(issueId);
            result.put("status", 1);
            if (issue.getIssueId() != -1l) {
                result.put("issueId", issue.getIssueId());
                result.put("projectId", issue.getProjectId());
                result.put("description", issue.getDescription());
                result.put("finderName", issue.getFinderName());
                result.put("findTime", issue.getFindTime());
                result.put("fixedName", issue.getFixedName());
                result.put("fixTime", issue.getFixTime());
            }
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);

    }

    private void GetAllIssue(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, IOException {
        // TODO Auto-generated method stub
        JSONObject all = new JSONObject();
        JSONArray getall = new JSONArray();

        try {
            List<ProjectIssueVO> allcomment = ProjectIssueBL.getObject().GetAlls();
            for (ProjectIssueVO vo : allcomment) {
                if (vo.getIssueId() != 1l) {
                    JSONObject get = new JSONObject();
                    get.put("issueId", vo.getIssueId());
                    get.put("projectId", vo.getProjectId());
                    get.put("description", vo.getDescription());
                    get.put("finderName", vo.getFinderName());
                    get.put("findTime", vo.getFindTime());
                    get.put("status", vo.getStatus());
                    get.put("fixedName", vo.getFixedName());
                    get.put("fixTime", vo.getFixTime());
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
