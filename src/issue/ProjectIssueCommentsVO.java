package issue;

public class ProjectIssueCommentsVO {

	long commentId;
    long issueId = -1l;
    long userId;
    String content;
    String time;
    
    public long getCommentId() {
        return commentId;
    }
    public ProjectCommentsVO setCommentId(long commentId) {
        this.commentId = commentId;
        return this;
    }
    public long getissueId() {
        return issueId;
    }
    public ProjectCommentsVO setissueId(long issueId) {
        this.issueId = issueId;
        return this;
    }
    public long getUserId() {
        return userId;
    }
    public ProjectCommentsVO setUserId(long userId) {
        this.userId = userId;
        return this;
    }
    public String getCommentContent() {
        return content;
    }
    public ProjectCommentsVO setCommentContent(String Content) {
        this.content = Content;
        return this;
    }
    public String getCommentTime() {
        return  time;
    }
    public ProjectCommentsVO setCommentTime(String time) {
        this.time = time;
        return this;
    }
}

