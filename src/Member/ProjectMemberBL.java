package Member;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ProjectMemberBL {
    public static ProjectMemberBL getObject() {
        return new ProjectMemberBL();
    }

    public ProjectMemberVO addProjectMember(long projectId, String ptitle, String userName) throws Exception {

        ProjectMemberVO project = new ProjectMemberVO().setProjectId(projectId).setUserName(userName).setptitle(ptitle);
        ProjectDB.getObject().addProjectMember(project);
        return project;
    }

    public ProjectMemberVO updateProjectMember(long projectId, String userName, String ptitle)
            throws ClassNotFoundException, SQLException, ParseException {
        ProjectMemberVO project = new ProjectMemberVO().setProjectId(projectId).setUserName(userName).setptitle(ptitle);
        ProjectDB.getObject().updateProjectMember(project);
        return project;
    }

    public void deleteProjectMember(long projectId, String userName) throws ClassNotFoundException, SQLException {
        ProjectDB.getObject().deleteProjectMember(projectId, userName);
    }

    public List<ProjectMemberVO> getProjectMembers(long projectId, String userName)
            throws ClassNotFoundException, SQLException {
        return ProjectDB.getObject().getProjectMembers(projectId, userName);
    }

    public List<ProjectMemberVO> getProjectMembersAlll() throws ClassNotFoundException, SQLException {
        return ProjectDB.getObject().getProjectMembersAll();
    }

}
