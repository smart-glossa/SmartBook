package issue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.MySQLConstants;

public class ProjectIssueCommentsDB {

    public static ProjectIssueCommentsDB getObject() {
        return new ProjectIssueCommentsDB();
    }
    
    public void addIssueComment(ProjectIssueCommentsVO comment) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath + MySQLConstants.database,
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Insert into IssueComments(IssueId, userId, content,time) Values (" + comment.getIssueId()
                + ", " + comment.getUserId() + ",'" + comment.getContent() + "'," + comment.getCommentTime()
                + ")";
        ResultSet rs = statement.executeQuery(query);
        comment.setCommentId(rs.getLong(0));
    }
    
    public void updateIssueComment(ProjectIssueCommentsVO project) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath + MySQLConstants.database,
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Update IssueComments set IssueId =" + project.getIssueId() + ", userId="
                + project.getUserId() + ", content='" + project.getContent() + "', time="
                + project.getCommentTime() + " where commentId = " + project.getCommentId();
        statement.execute(query);
    }
    
    public void deleteIssueComment(long commentId) throws ClassNotFoundException, SQLException{
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Delete from IssueComments where commentId =" + commentId;
        statement.execute(query);
    }
    
    public ProjectIssueCommentsVO getIssueComment(long commentId) throws ClassNotFoundException, SQLException {
        ProjectIssueCommentsVO comment = new ProjectIssueCommentsVO();
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Select * from IssueComments where commentId =" + commentId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            comment.setCommentId(rs.getLong("commentId"));
            comment.setIssueId(rs.getLong("IssueId"));
            comment.setUserId(rs.getLong("userId"));
            comment.setContent(rs.getString("content"));
            comment.setCommentTime(rs.getLong("time"));
        }
        return comment;
    }
}
