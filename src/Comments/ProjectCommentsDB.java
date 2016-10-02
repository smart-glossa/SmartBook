package Comments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.MySqlConstant;



public class ProjectCommentsDB {
	  public static ProjectCommentsDB getObject() {
	        return new ProjectCommentsDB();
	    }
	    
	    public void addProjectComment(ProjectCommentsVO comment) 
	    		throws ClassNotFoundException, SQLException {
	    	 
	    	Statement statement = MySqlConstant.getInstance().getCreatedStatement();
	        String query = "Insert into issuecomment(projectId, userName, content,time) Values ('" + comment.getProjectId()
	                + "', '" + comment.getUserName() + "','" + comment.getCommentContent() + "','" + comment.getCommentTime()+ "')";
	        statement.execute(query);
	       //comment.setCommentId(rs.getLong(0));
	    }
	    
	    public void updateProjectComment(ProjectCommentsVO project) 
	    		throws ClassNotFoundException, SQLException {
	    	
	    	 Statement statement = MySqlConstant.getInstance().getCreatedStatement();
	        String query = "Update issuecomment set projectId =" + project.getProjectId() + ", userName='"
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
	    
	    public ProjectCommentsVO getProjectComment(long commentId) 
	    		throws ClassNotFoundException, SQLException {
	       
	    	ProjectCommentsVO comment = new ProjectCommentsVO();
	        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
	        String query = "Select * from issuecomment where commentId =" + commentId;
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	            comment.setCommentId(rs.getLong("commentId"));
	            comment.setProjectId(rs.getLong("projectId"));
	            comment.setUserName(rs.getString("userName"));
	            comment.setCommentContent(rs.getString("content"));
	            comment.setCommentTime(rs.getString("time"));
	        }
	        return comment;
	    }
	    public List<ProjectCommentsVO> Getcomment()
	            throws Exception {
	        List<ProjectCommentsVO> comment = new ArrayList<>();
	        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
	        String query = "Select *  from issuecomment";
	        ResultSet rs = statement.executeQuery(query);
	        while (rs.next()) {
	            ProjectCommentsVO gets = new ProjectCommentsVO();
	            gets.setCommentId(rs.getLong("commentId"));
	            gets.setProjectId(rs.getLong("projectId"));
	            gets.setUserName(rs.getString("userName"));
	            gets.setCommentContent(rs.getString("content"));
	            gets.setCommentTime(rs.getString("time"));
	            comment.add(gets);
	        }
	        return comment;
	    }
	}

