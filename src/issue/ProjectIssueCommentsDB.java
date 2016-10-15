package issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.MySqlConstant;

public class ProjectIssueCommentsDB {


	public static ProjectIssueCommentsDB getObject() {
        return new ProjectIssueCommentsDB();
    }
    
    public void addProjectComment(ProjectIssueCommentsVO comment) 
    		throws ClassNotFoundException, SQLException {
    	 
    	Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Insert into issuecomment(issueId, userName, content,time) Values ('" + comment.getissueId()
                + "', '" + comment.getUserName() + "','" + comment.getCommentContent() + "','" + comment.getCommentTime()+ "')";
        statement.execute(query);
       //comment.setCommentId(rs.getLong(0));
    }
    
    public void updateProjectComment(ProjectIssueCommentsVO project) 
    		throws ClassNotFoundException, SQLException {
    	
    	 Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Update issuecomment set issueId =" + project.getissueId() + ", userName='"
                + project.getUserName() + "', content='" + project.getCommentContent() + "', time='"
                + project.getCommentTime() + "' where commentId = " + project.getCommentId();
        statement.execute(query);
    }
    
    public void deleteProjectComment(long commentId) 
    		throws ClassNotFoundException, SQLException{
    	
    	 Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Delete from issuecomment where commentId =" +commentId+"";
        statement.executeUpdate(query);
    }
    
    public ProjectIssueCommentsVO getProjectComment(long commentId) 
    		throws ClassNotFoundException, SQLException {
       
    	ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from issuecomment where commentId =" + commentId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            comment.setCommentId(rs.getLong("commentId"));
            comment.setissueId(rs.getLong("issueId"));
            comment.setUserName(rs.getString("userName"));
            comment.setCommentContent(rs.getString("content"));
            comment.setCommentTime(rs.getString("time"));
        }
        return comment;
    }
    public List<ProjectIssueCommentsVO> Getcomment()
            throws Exception {
        List<ProjectIssueCommentsVO> comment = new ArrayList<ProjectIssueCommentsVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select *  from issuecomment";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ProjectIssueCommentsVO gets = new ProjectIssueCommentsVO();
            gets.setCommentId(rs.getLong("commentId"));
            gets.setissueId(rs.getLong("issueId"));
            gets.setUserName(rs.getString("userName"));
            gets.setCommentContent(rs.getString("content"));
            gets.setCommentTime(rs.getString("time"));
            comment.add(gets);
        }
        return comment;
    }
}

