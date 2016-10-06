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

	    public ProjectIssueVO addProjectIssue(int projectId, String description, int finderId, String findTime,int status,
	            int fixedId, String fixTime) throws ClassNotFoundException, SQLException, ParseException {
	        
	    	ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
	                .setStatus(status).setFinderId(finderId).setFindTime(sdf.parse(findTime).getTime()).setFixedId(fixedId)
	                .setFixTime(sdf.parse(fixTime).getTime());
	        ProjectIssueDB.getObject().addProjectIssue(project);
	        return project;
	    }

	    public ProjectIssueVO updateProjectIssue(long IssueId,int projectId, String description,int finderId,int status,
	             int fixedId) throws ClassNotFoundException, SQLException, ParseException {
	        
	    	ProjectIssueVO project = new ProjectIssueVO().setProjectId(projectId).setDescription(description)
	                .setStatus(status).setFinderId(finderId).setFixedId(fixedId)
	                .setIssueId(IssueId);
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