package Member;


public class projectMemberVO {

	

    long projectId=-1l; 
    String userName;
    String ptitle;
    int projectRoleId;
    
    public long getProjectId() {
        return projectId;
    }
    public projectMemberVO setProjectId(long projectId) {
        this.projectId = projectId;
        return this;
    }
    public String getUserName() {
        return userName;
    }
    public projectMemberVO setUserName(String userName) {
        this.userName = userName;
        return this;
    }
    public String getptitle()
    {
    	return ptitle;
    }
    public projectMemberVO setptitle(String ptitle)
    {
    	this.ptitle=ptitle;
    	return this;
    }
    public int getProjectRoleId() {
        return projectRoleId;
    }
    public projectMemberVO setProjectRoleId(int projectRoleId) {
        this.projectRoleId = projectRoleId;
        return this;
    }
}
