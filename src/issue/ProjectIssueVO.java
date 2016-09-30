package issue;

public class ProjectIssueVO {

    long issueId;
    long projectId;
    String description;
    long finderId;
    long findTime;
    int status;
    long fixerId;
    long fixTime;
    
    public long getIssueId() {
        return issueId;
    }
    public ProjectIssueVO setIssueId(long issueId) {
        this.issueId = issueId;
        return this;
    }
    public long getProjectId() {
        return projectId;
    }
    public ProjectIssueVO setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }
    public String getDescription() {
        return description;
    }
    public ProjectIssueVO setDescription(String description) {
        this.description = description;
        return this;
    }
    public long getFinderId() {
        return finderId;
    }
    public ProjectIssueVO setFinderId(long finderId) {
        this.finderId = finderId;
        return this;
    }
    public long getFindTime() {
        return findTime;
    }
    public ProjectIssueVO setFindTime(long findTime) {
        this.findTime = findTime;
        return this;
    }
    public int getStatus() {
        return status;
    }
    public ProjectIssueVO setStatus(int status) {
        this.status = status;
        return this;
    }
    public long getFixerId() {
        return fixerId;
    }
    public ProjectIssueVO setFixerId(long fixerId) {
        this.fixerId = fixerId;
        return this;
    }
    public long getFixTime() {
        return fixTime;
    }
    public ProjectIssueVO setFixTime(long fixTime) {
        this.fixTime = fixTime;
        return this;
    }
}
