package issue;

public class ProjectIssueVO {

	long issueId;
    int projectId;
    String description;
    int finderId;
    long findTime;
    int status;
    int fixedId;
    long fixTime;
    
    public long getIssueId() {
        return issueId;
    }
    public ProjectIssueVO setIssueId(long issueId) {
        this.issueId = issueId;
        return this;
    }
    public int getProjectId() {
        return projectId;
    }
    public ProjectIssueVO setProjectId(int projectId) {
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
    public int getFinderId() {
        return finderId;
    }
    public ProjectIssueVO setFinderId(int finderId) {
        this.finderId = finderId;
        return this;
    }
    public int getStatus()
    {
    	return status;
    }
    public ProjectIssueVO setStatus(int status)
    {
    	this.status=status;
    	return this;
    }
    public long getFindTime() {
        return findTime;
    }
    public ProjectIssueVO setFindTime(long findTime) {
        this.findTime = findTime;
        return this;
    }
    public int getFixedId() {
        return fixedId;
    }
    public ProjectIssueVO setFixedId(int fixedId) {
        this.fixedId = fixedId;
        return this;
    }
    public long getFixTime() {
        return fixTime;
    }
    public ProjectIssueVO setFixTime(long  fixTime) {
        this.fixTime =  fixTime;
        return this;
    }

}
