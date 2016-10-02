package Comments;

public class ProjectCommentsVO {
	long commentId;
    long projectId = -1l;
    String userName;
    String content;
    String time;
    
    public long getCommentId() {
        return commentId;
    }
    public ProjectCommentsVO setCommentId(long commentId) {
        this.commentId = commentId;
        return this;
    }
    public long getProjectId() {
        return projectId;
    }
    public ProjectCommentsVO setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }
    public String getUserName() {
        return userName;
    }
    public ProjectCommentsVO setUserName(String userName) {
        this.userName = userName;
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

