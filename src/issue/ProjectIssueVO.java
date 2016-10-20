package issue;

public class ProjectIssueVO {

	long issueId;
    int projectId;
    String description;
    String finderName;
    long findTime;
    String status;
    String fixedName;
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
    public String getFinderName() {
        return finderName;
    }
    public ProjectIssueVO setFinderName(String finderName) {
        this.finderName = finderName;
        return this;
    }
    public String getStatus()
    {
    	return status;
    }
    public ProjectIssueVO setStatus(String status)
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
    public String getFixedName() {
        return fixedName;
    }
    public ProjectIssueVO setFixedName(String fixedName) {
        this.fixedName = fixedName;
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
