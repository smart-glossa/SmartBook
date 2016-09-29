package Member;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;



public class projectMemberBL {
	public static projectMemberBL getObject() {
        return new projectMemberBL();                               //int projectRoleId      
    }
    public projectMemberVO addProjectMember(long projectId,String ptitle, String userName) throws Exception{
    	
        projectMemberVO project = new projectMemberVO().setProjectId(projectId).setUserName(userName).setptitle(ptitle);
        projectDB.getObject().addProjectMember(project);                  
		return project;
    }
    
    public projectMemberVO updateProjectMember(long projectId, String userName,String ptitle) throws ClassNotFoundException, SQLException, ParseException {
        projectMemberVO project = new projectMemberVO().setProjectId(projectId)
                .setUserName(userName).setptitle(ptitle);
        projectDB.getObject().updateProjectMember(project);
		return project;
    }                                                               //.setProjectRoleId(projectRoleId)
    
    public void deleteProjectMember(long projectId, String userName) throws ClassNotFoundException, SQLException {
        projectDB.getObject().deleteProjectMember(projectId, userName);
    }
    
    public List<projectMemberVO> getProjectMembers(long projectId,String userName) throws ClassNotFoundException, SQLException {
        return projectDB.getObject().getProjectMembers(projectId, userName);
    }
    public List<projectMemberVO> getProjectMembersAlll() throws ClassNotFoundException, SQLException {
        return projectDB.getObject().getProjectMembersAll();
    }
    
}
