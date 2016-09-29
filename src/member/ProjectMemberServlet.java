package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProjectMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int operation = Integer.parseInt(request.getParameter("operation"));
        try {
            switch (operation) {
            case ProjectConstant.ADDOPERATION:
                AddMember(request, response);
                break;
            case ProjectConstant.UPDATEOPERATION:
                updatemember(request, response);
                break;
            case ProjectConstant.GETOPERATION:
                getmember(request, response);
                break;
            case ProjectConstant.GETALLOPERATION:
                getall(request, response);
                break;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void AddMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject owner = new JSONObject();
        long projectId = Long.parseLong(request.getParameter("projectId"));
        String ptitle = request.getParameter("ptitle");
        String userName = request.getParameter("userName");
        try {
            ProjectMemberBL.getObject().addProjectMember(projectId, ptitle, userName);
            owner.put("Status", "Success");
        } catch (Exception e) {
            owner.put("Status", "0");
            owner.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(owner);
    }

    private void updatemember(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject update = new JSONObject();
        long projectId = Long.parseLong(request.getParameter("projectId"));
        String ptitle = request.getParameter("ptitle");
        String userName = request.getParameter("userName");
        try {
            ProjectMemberBL.getObject().updateProjectMember(projectId, userName, ptitle);
            update.put("Status", "Success Updated");
        } catch (Exception e) {
            update.put("Status", 0);
            update.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(update);
    }

    private void getmember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        long projectId = Long.parseLong(request.getParameter("projectId"));
        String userName = request.getParameter("userName");
        try {
            List<ProjectMemberVO> members = ProjectMemberBL.getObject().getProjectMembers(projectId, userName);
            JSONArray rmembers = new JSONArray();
            for (ProjectMemberVO member : members) {
                if (member.getProjectId() != -1l) {
                    JSONObject rmember = new JSONObject();
                    rmember.put("projectId", member.getProjectId());
                    rmember.put("userId", member.getUserName());
                    rmember.put("roleId", member.getProjectRoleId());
                    rmembers.put(rmember);
                }
            }
            result.put("status", 1);
            result.put("members", rmembers);
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void getall(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        try {
            List<ProjectMemberVO> members = ProjectMemberBL.getObject().getProjectMembersAlll();
            JSONArray rmembers = new JSONArray();
            for (ProjectMemberVO member : members) {
                if (member.getProjectId() != -1l) {
                    JSONObject rmember = new JSONObject();
                    rmember.put("projectId", member.getProjectId());
                    rmember.put("userId", member.getUserName());
                    rmember.put("roleId", member.getProjectRoleId());
                    rmembers.put(rmember);
                }
            }
            result.put("status", 1);
            result.put("members", rmembers);
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }
}
