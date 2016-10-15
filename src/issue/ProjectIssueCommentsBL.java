package issue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProjectIssueCommentsBL {
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ProjectIssueCommentsBL getObject() {
        return new ProjectIssueCommentsBL();
    }

    public ProjectIssueCommentsVO addProjectComment(Long issueId, String userName, String content,String time)
            throws ClassNotFoundException, SQLException, ParseException {

    	ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO().setissueId(issueId).setUserName(userName)
                .setCommentContent(content).setCommentTime(time);
        ProjectIssueCommentsDB.getObject().addProjectComment(comment);
        return comment;
    }

    public ProjectIssueCommentsVO updateProjectComment(Long commentId, Long issueId, String userName, String content, String time) 
    		throws ClassNotFoundException, SQLException, ParseException {
        
    	ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO().setissueId(issueId).setUserName(userName).setCommentContent(content)
                .setCommentTime(time).setCommentId(commentId);
        ProjectIssueCommentsDB.getObject().updateProjectComment(comment);
        return comment;
    }

    public void deleteProjectComment(long commentId) throws ClassNotFoundException, SQLException {
        
    	ProjectIssueCommentsDB.getObject().deleteProjectComment(commentId);
    }

    public ProjectIssueCommentsVO getProjectComment(long commentId) throws ClassNotFoundException, SQLException {
        
    	return ProjectIssueCommentsDB.getObject().getProjectComment(commentId);
    }
    public List<ProjectIssueCommentsVO> GetAlls() throws Exception {
        return ProjectIssueCommentsDB.getObject().Getcomment();
    }

}

