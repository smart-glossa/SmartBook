package Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import common.MySqlConstant;

public class ProjectDB {
    public static ProjectDB getObject() {
        return new ProjectDB();
    }

    public void addProjectMember(ProjectMemberVO project)
            throws ClassNotFoundException, NumberFormatException, ParseException, SQLException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Insert into ProjectMembers(projectId,ptitle, userName) Values ('" + project.getProjectId()
                + "','" + project.getptitle() + "', '" + project.getUserName() + "')";
        statement.execute(query);
    }

    public void updateProjectMember(ProjectMemberVO project) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Update ProjectMembers set ptitle =" + project.getptitle() + " where projectId = "
                + project.getProjectId() + " and userName = " + project.getUserName();
        statement.execute(query);
    }

    public void deleteProjectMember(long projectId, String userName) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query =
                "Delete from ProjectMembers where projectId =" + projectId + " and userName = '" + userName + "'";
        statement.execute(query);
    }

    public List<ProjectMemberVO> getProjectMembers(long projectId, String userName)
            throws ClassNotFoundException, SQLException {
        List<ProjectMemberVO> members = new ArrayList<ProjectMemberVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from projectMembers where projectId =" + projectId + " or userName='" + userName + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectMemberVO project = new ProjectMemberVO();
            project.setProjectId(rs.getInt("projectId"));
            project.setUserName(rs.getString("userName"));
            project.setptitle(rs.getString("ptitle"));
            members.add(project);
        }
        return members;
    }

    public List<ProjectMemberVO> getProjectMembersAll() throws ClassNotFoundException, SQLException {
        List<ProjectMemberVO> members = new ArrayList<ProjectMemberVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from projectMembers";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectMemberVO project = new ProjectMemberVO();
            project.setProjectId(rs.getInt("projectId"));
            project.setUserName(rs.getString("userName"));
            project.setptitle(rs.getString("ptitle"));
            members.add(project);
        }
        return members;
    }

}
