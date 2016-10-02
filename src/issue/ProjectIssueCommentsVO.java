package issue;

public class ProjectIssueCommentsVO {

    long commentId;
    long issueId;
    long userId;
    String content;
    long commentTime;
    
    public long getCommentId() {
        return commentId;
    }
    public ProjectIssueCommentsVO setCommentId(long commentId) {
        this.commentId = commentId;
        return this;
    }
    public long getIssueId() {
        return issueId;
    }
    public ProjectIssueCommentsVO setIssueId(long issueId) {
        this.issueId = issueId;
        return this;
    }
    public long getUserId() {
        return userId;
    }
    public ProjectIssueCommentsVO setUserId(long userId) {
        this.userId = userId;
        return this;
    }
    public String getContent() {
        return content;
    }
    public ProjectIssueCommentsVO setContent(String content) {
        this.content = content;
        return this;
    }
    public long getCommentTime() {
        return commentTime;
    }
    public ProjectIssueCommentsVO setCommentTime(long commentTime) {
        this.commentTime = commentTime;
        return this;
    }
}
