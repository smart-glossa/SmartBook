package issue;

public class ProjectIssueVO {

    long issueId;
    int projectId;
    String description;
    int userId;
    long findtime;
    long fixedtime;

    public long getIssueId() {
        return issueId;
    }

    public ProjectIssueVO setIssueId(long issueId) {
        this.issueId = issueId;
        return this;
    }

    public int getprojectId() {
        return projectId;
    }

    public ProjectIssueVO setdescription(String dis) {
        this.description = dis;
        return this;
    }

    public int getuserId() {
        return userId;
    }

    public ProjectIssueVO setuserId(int userId) {
        this.userId = userId;
        return this;
    }

    public long getfindtime() {
        return findtime;
    }

    public ProjectIssueVO setfindtime(long findtime) {
        this.findtime = findtime;
        return this;
    }

    public long getfixedtime() {
        return fixedtime;
    }

    public ProjectIssueVO setfixedtime(long fixedtime) {

        this.fixedtime = fixedtime;
        return this;
    }
}
