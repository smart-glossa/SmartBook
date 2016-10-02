package issue;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProjectIssueCommentsBL {

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static ProjectIssueCommentsBL getObject() {
        return new ProjectIssueCommentsBL();
    }

    public ProjectIssueCommentsVO addIssueComment(Long projectId, Long userId, String content, String time)
            throws ClassNotFoundException, SQLException, ParseException {
        ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO().setIssueId(projectId).setUserId(userId)
                .setContent(content).setCommentTime(sdf.parse(time).getTime());
        ProjectIssueCommentsDB.getObject().addIssueComment(comment);
        return comment;
    }

    public ProjectIssueCommentsVO updateIssueComment(Long commentId, Long projectId, Long userId, String content,
            String time) throws ClassNotFoundException, SQLException, ParseException {
        ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO().setIssueId(projectId).setUserId(userId)
                .setContent(content).setCommentTime(sdf.parse(time).getTime()).setCommentId(commentId);
        ProjectIssueCommentsDB.getObject().updateIssueComment(comment);
        return comment;
    }

    public void deleteIssueComment(long commentId) throws ClassNotFoundException, SQLException {
        ProjectIssueCommentsDB.getObject().deleteIssueComment(commentId);
    }

    public ProjectIssueCommentsVO getIssueComment(long commentId) throws ClassNotFoundException, SQLException {
        return ProjectIssueCommentsDB.getObject().getIssueComment(commentId);
    }
}
