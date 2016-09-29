package project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProjectServlet extends HttpServlet {
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
            case ProjectConstant.CREATEMODE:
                addproject(request, response);
                break;
            case ProjectConstant.UPDATEMODE:
                updateproject(request, response);
                break;
            case ProjectConstant.GETMODE:
                getprojecct(request, response);
                break;
            case ProjectConstant.GETALLMODE:
                getallProject(request, response);
                break;
            case ProjectConstant.GETONE:
                getOnly(request, response);
                break;
            case ProjectConstant.DELETEONEMODE:
                deleteOne(request, response);
                break;
            case ProjectConstant.DELETESTATUSMODE:
                deletestatus(request, response);
                break;
            default:
                break;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void addproject(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject project = new JSONObject();
        String ptitle = request.getParameter("ptitle");
        String dis = request.getParameter("dis");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        try {
            ProjectVO p = ProjectBL.getobject().createproject(ptitle, dis, date, status);
            project.put("Status", 1);
            project.put("ptitle", p.getptitle());
        } catch (Exception e) {
            project.put("status", 0);
            project.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(project);
    }

    private void updateproject(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject update = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String ptitle = request.getParameter("ptitle");
        String dis = request.getParameter("dis");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        try {
            ProjectBL.getobject().updateproject(projectId, ptitle, dis, date, status);
            update.put("Status", "updated");
        } catch (Exception e) {
            update.put("Status", 0);
            update.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(update);
    }

    private void getprojecct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject get = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));

        try {
            ProjectVO gone = ProjectDB.getobject().getone(projectId);
            get.put("status", 1);
            if (gone.getprojectId() != -1l) {
                get.put("projectId", gone.getprojectId());
                get.put("ptitle", gone.getptitle());
                get.put("dis", gone.getdis());
                get.put("pdate", gone.getdate());
                get.put("status", gone.getstatus());
            }
        } catch (Exception e) {
            get.put("Status", 0);
            get.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(get);
    }

    private void getallProject(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject get = new JSONObject();
        JSONArray plist = new JSONArray();
        try {
            List<ProjectVO> gets = ProjectBL.getobject().getproject();
            for (ProjectVO gs : gets) {
                if (gs.getprojectId() != -1l) {
                    JSONObject value = new JSONObject();
                    value.put("projectId", gs.getprojectId());
                    value.put("ptitle", gs.getptitle());
                    value.put("dis", gs.getdis());
                    value.put("pdate", gs.getdate());
                    value.put("status", gs.getstatus());
                    plist.put(value);
                    value.put("Status", 1);
                }
            }
            get.put("status", 1);
        } catch (Exception e) {
            get.put("Status", 0);
            get.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(plist);
    }

    private void getOnly(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject get = new JSONObject();
        JSONArray plist = new JSONArray();
        try {
            List<ProjectVO> gets = ProjectBL.getobject().getOnlyproject();
            for (ProjectVO gs : gets) {
                if (gs.getprojectId() != -1l) {
                    JSONObject value = new JSONObject();
                    value.put("ptitle", gs.getptitle());
                    plist.put(value);
                    value.put("Status", 1);
                }
            }
            get.put("status", 1);
        } catch (Exception e) {
            get.put("Status", 0);
            get.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(plist);
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        try {
            ProjectBL.getobject().deleteproject(projectId);
            result.put("status", "success deleted");
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void deletestatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String status = request.getParameter("status");

        try {
            ProjectBL.getobject().updatestatus(projectId, status);
            result.put("status", "success updated");
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } 
        response.getWriter().print(result);
    }
}
