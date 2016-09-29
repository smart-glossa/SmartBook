package Member;

public class ProjectMemberVO {

    long projectId = -1l;
    String userName;
    String ptitle;
    int projectRoleId;

    public long getProjectId() {
        return projectId;
    }

    public ProjectMemberVO setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ProjectMemberVO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getptitle() {
        return ptitle;
    }

    public ProjectMemberVO setptitle(String ptitle) {
        this.ptitle = ptitle;
        return this;
    }

    public int getProjectRoleId() {
        return projectRoleId;
    }

    public ProjectMemberVO setProjectRoleId(int projectRoleId) {
        this.projectRoleId = projectRoleId;
        return this;
    }
}
