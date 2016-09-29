package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import common.MySqlConstant;

public class ProjectDB {
    
    public static ProjectDB getobject() {
        return new ProjectDB();
    }

    public void createproject(ProjectVO project)
            throws ClassNotFoundException, SQLException, ParseException, NumberFormatException // add function
    {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "insert into project(ptitle,dis,pdate,status)values('" + project.getptitle() + "','"
                + project.getdis() + "','" + project.getdate() + "','" + project.getstatus() + "')";
        statement.executeUpdate(query);
    }

    public void updateproject(ProjectVO project, String ptitle)
            throws ClassNotFoundException, SQLException, NumberFormatException, ParseException // update function
    {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "update project set ptitle='" + project.getptitle() + "',dis='" + project.getdis() + "',pdate='"
                + project.getdate() + "',status='" + project.getstatus() + "' where projectId="
                + project.getprojectId();
        statement.execute(query);

    }

    public ProjectVO getone(int projectId) throws ClassNotFoundException, SQLException, JSONException, ParseException {

        ProjectVO project = new ProjectVO();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "select * from project where projectId= '" + projectId + "' ";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            project.setprojectId(rs.getInt("projectId"));
            project.setptitle(rs.getString("ptitle"));
            project.setdes(rs.getString("dis"));
            project.setdate(rs.getString("pdate"));
            project.setstatus(rs.getString("status"));

        }
        return project;
    }

    public List<ProjectVO> getproject() throws ClassNotFoundException, SQLException, JSONException, ParseException {
        List<ProjectVO> tlist = new ArrayList<>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "select * from project";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectVO getss = new ProjectVO();
            getss.setprojectId(rs.getInt("projectId"));
            getss.setptitle(rs.getString("ptitle"));
            getss.setdes(rs.getString("dis"));
            getss.setdate(rs.getString("pdate"));
            getss.setstatus(rs.getString("status"));
            tlist.add(getss);
        }
        return tlist;

    }

    public List<ProjectVO> getOnlyproject() throws ClassNotFoundException, SQLException, JSONException, ParseException {
        List<ProjectVO> tlist = new ArrayList<>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "select projectId,ptitle from project";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectVO getss = new ProjectVO();
            getss.setprojectId(rs.getInt("projectId"));
            getss.setptitle(rs.getString("ptitle"));

            tlist.add(getss);

        }
        return tlist;

    }

    public void delete(int projectId) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "delete  from project where projectId=" + projectId;
        statement.execute(query);
    }

    public void deletestatus(int projectId) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "delete status from project where=" + projectId;
        statement.execute(query);
    }

    public void updatestatus(ProjectVO project, int projectId, String status)
            throws ClassNotFoundException, SQLException, NumberFormatException, ParseException // update function
    {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query =
                "update project set status='" + project.getstatus() + "' where projectId=" + project.getprojectId();
        statement.execute(query);

    }
}
