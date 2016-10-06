package Comments;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;



public class ProjectCommentsBL {
	 SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	    public static ProjectCommentsBL getObject() {
	        return new ProjectCommentsBL();
	    }

	    public ProjectCommentsVO addProjectComment(Long projectId, String userName, String content,String time)
	            throws ClassNotFoundException, SQLException, ParseException {

	    	ProjectCommentsVO comment = new ProjectCommentsVO().setProjectId(projectId).setUserName(userName)
	                .setCommentContent(content).setCommentTime(time);
	        ProjectCommentsDB.getObject().addProjectComment(comment);
	        return comment;
	    }

	    public ProjectCommentsVO updateProjectComment(Long commentId, Long projectId, String userName, String content, String time) 
	    		throws ClassNotFoundException, SQLException, ParseException {
	        
	    	ProjectCommentsVO comment = new ProjectCommentsVO().setProjectId(projectId).setUserName(userName).setCommentContent(content)
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
	    public List<ProjectCommentsVO> getAllComments() throws Exception {
	        return ProjectCommentsDB.getObject().getComments();
	    }

	}

