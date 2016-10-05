package issue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProjectIssueCommentsBL {
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ProjectCommentsBL getObject() {
        return new ProjectCommentsBL();
    }

    public ProjectCommentsVO addProjectComment(Long issueId, long userId, String content,String time)
            throws ClassNotFoundException, SQLException, ParseException {

    	ProjectCommentsVO comment = new ProjectCommentsVO().setissueId(issueId).setUserId(userId)
                .setCommentContent(content).setCommentTime(time);
        ProjectCommentsDB.getObject().addProjectComment(comment);
        return comment;
    }

    public ProjectCommentsVO updateProjectComment(Long commentId, Long issueId, long userId, String content, String time) 
    		throws ClassNotFoundException, SQLException, ParseException {
        
    	ProjectCommentsVO comment = new ProjectCommentsVO().setissueId(issueId).setUserId(userId).setCommentContent(content)
                .setCommentTime(time).setCommentId(commentId);
        ProjectCommentsDB.getObject().updateProjectComment(comment);
        return comment;
    }

    public void deleteProjectComment(long commentId) throws ClassNotFoundException, SQLException {
        
    	ProjectCommentsDB.getObject().deleteProjectComment(commentId);
    }

    public ProjectCommentsVO getProjectComment(long commentId) throws ClassNotFoundException, SQLException {
        
    	return ProjectCommentsDB.getObject().getProjectComment(commentId);
    }
    public List<ProjectCommentsVO> GetAlls() throws Exception {
        return ProjectCommentsDB.getObject().Getcomment();
    }

}

