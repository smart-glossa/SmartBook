package issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.MySqlConstant;

public class ProjectIssueDB {

	public static ProjectIssueDB getObject() {
		 
        return new ProjectIssueDB();
    }
    
    public void addProjectIssue(ProjectIssueVO issue) throws ClassNotFoundException, SQLException {
    	
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Insert into projectissue(projectId, description,finderId,findTime,status,fixedId, fixTime) Values "
        		+ "('"+ issue.getProjectId() + "',"
        	    + "'" + issue.getDescription() + "',"
        	    + "'"+ issue.getFinderId()+ "',"
        	    + "'" + issue.getFindTime() + "',"
        	    + "'" + issue.getStatus() +"',"
        	    + "'" + issue.getFixedId() + "',"
        	    + "'"+issue.getFixTime() +"')";
        statement.execute(query);
        //issue.setIssueId(rs.getLong(0));
    }
    
    public void updateProjectIssue(ProjectIssueVO project) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Update projectissue set projectId ='"+ project.getProjectId() + "', description='"+ project.getDescription() + "',status='"+ project.getStatus()+"', "
        		+ "finderId='"+ project.getFinderId() +"', fixedId='"+ project.getFixedId() + "'  where issueId = "+ project.getIssueId();
        statement.execute(query);
    }
    
    public void deleteProjectIssue(int issueId) throws ClassNotFoundException, SQLException{
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Delete from projectissue where issueId =" + issueId;
        statement.execute(query);
    }
    
    public ProjectIssueVO getProjectIssue(int issueId) throws ClassNotFoundException, SQLException {
        ProjectIssueVO issue = new ProjectIssueVO();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from projectissue where issueId =" + issueId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            issue.setIssueId(rs.getInt("issueId"));
            issue.setProjectId(rs.getInt("projectId"));
            issue.setDescription(rs.getString("description"));
            issue.setFinderId(rs.getInt("finderId"));
            issue.setFindTime(rs.getLong("findTime"));
            issue.setStatus(rs.getInt("status"));
            issue.setFixedId(rs.getInt("fixedId"));
            issue.setFixTime(rs.getLong("fixTime"));
        }
        return issue;
    }
    public List<ProjectIssueVO> GetIssue()
            throws Exception {
        List<ProjectIssueVO> comment = new ArrayList<ProjectIssueVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select *  from projectissue";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectIssueVO gets = new ProjectIssueVO();
            gets.setIssueId(rs.getLong("issueId"));
            gets.setProjectId(rs.getInt("projectId"));
            gets.setDescription(rs.getString("description"));
            gets.setFinderId(rs.getInt("finderId"));
            gets.setFindTime(rs.getLong("findTime"));
            gets.setStatus(rs.getInt("status"));
            gets.setFixedId(rs.getInt("fixedId"));
            gets.setFixTime(rs.getLong("fixTime"));
            
            comment.add(gets);
        }
        return comment;
    }
}

