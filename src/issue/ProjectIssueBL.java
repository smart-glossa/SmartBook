package issue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProjectIssueBL {

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ProjectIssueBL getObject() {
        return new ProjectIssueBL();
    }

    public ProjectIssueVO addProjectIssue(Long projectId, String description, int status, Long finderId, String findTime,
            Long fixerId, String fixTime) throws ClassNotFoundException, SQLException, ParseException {
        ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
                .setStatus(status).setFinderId(finderId).setFindTime(sdf.parse(findTime).getTime()).setFixerId(fixerId)
                .setFixTime(sdf.parse(fixTime).getTime());
        ProjectIssueDB.getObject().addProjectIssue(project);
        return project;
    }

    public ProjectIssueVO updateProjectIssue(Long IssueId, Long projectId, String description, int status, Long finderId,
            String findTime, Long fixerId, String fixTime) throws ClassNotFoundException, SQLException, ParseException {
        ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
                .setStatus(status).setFinderId(finderId).setFindTime(sdf.parse(findTime).getTime()).setFixerId(fixerId)
                .setFixTime(sdf.parse(fixTime).getTime()).setIssueId(IssueId);
        ProjectIssueDB.getObject().updateProjectIssue(project);
        return project;
    }

    public void deleteProjectIssue(long IssueId) throws ClassNotFoundException, SQLException {
        ProjectIssueDB.getObject().deleteProjectIssue(IssueId);
    }

    public ProjectIssueVO getProjectIssue(long IssueId) throws ClassNotFoundException, SQLException {
        return ProjectIssueDB.getObject().getProjectIssue(IssueId);
    }
}
