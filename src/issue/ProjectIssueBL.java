package issue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProjectIssueBL {


	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ProjectIssueBL getObject() {
        return new ProjectIssueBL();
    }

    public ProjectIssueVO addProjectIssue(int projectId, String description, String finderName, String findTime,int status,
            String fixedName, String fixTime) throws ClassNotFoundException, SQLException, ParseException {
        
    	ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
                .setStatus(status).setFinderName(finderName).setFindTime(sdf.parse(findTime).getTime()).setFixedName(fixedName)
                .setFixTime(sdf.parse(fixTime).getTime());
        ProjectIssueDB.getObject().addProjectIssue(project);
        return project;
    }

    public ProjectIssueVO updateProjectIssue(long issueId,int projectId, String description,String finderName,int status,
             String fixedName) throws ClassNotFoundException, SQLException, ParseException {
        
    	ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
                .setStatus(status).setFinderName(finderName).setFixedName(fixedName)
                .setIssueId(issueId);
        ProjectIssueDB.getObject().updateProjectIssue(project);
        return project;
    }

    public void deleteProjectIssue(int IssueId) throws ClassNotFoundException, SQLException {
        ProjectIssueDB.getObject().deleteProjectIssue(IssueId);
    }

    public ProjectIssueVO getProjectIssue(int IssueId) throws ClassNotFoundException, SQLException {
        return ProjectIssueDB.getObject().getProjectIssue(IssueId);
    }
    public List<ProjectIssueVO> GetAlls() throws Exception {
        return ProjectIssueDB.getObject().GetIssue();
    }
}