package issue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.MySQLConstants;

public class ProjectIssueDB {

    public static ProjectIssueDB getObject() {
        return new ProjectIssueDB();
    }
    
    public void addProjectIssue(ProjectIssueVO issue) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Insert into ProjectIssue(projectId, description, finderId" 
                + "findTime, status, fixerId, fixTime) Values ("
                + issue.getProjectId() + ", '" + issue.getDescription() + "',"
                + issue.getFinderId() + "," + issue.getFindTime() + ","
                + issue.getStatus() + "," + issue.getFixerId() + "," 
                + issue.getFixTime() + ")";
        ResultSet rs =statement.executeQuery(query);
        issue.setIssueId(rs.getLong(0));
    }
    
    public void updateProjectIssue(ProjectIssueVO project) throws ClassNotFoundException, SQLException {
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Update ProjectIssue set projectId ='" 
                + project.getProjectId() + "', description='" + project.getDescription() + "', finderId="
                + project.getFinderId() + ", findTime=" + project.getFindTime() + ",status="
                + project.getStatus() + ", fixerId=" + project.getFixerId() + ",fixTime="
                + project.getFixTime() + " where issueId = " + project.getIssueId();
        statement.execute(query);
    }
    
    public void deleteProjectIssue(long issueId) throws ClassNotFoundException, SQLException{
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Delete from ProjectIssue where issueId =" + issueId;
        statement.execute(query);
    }
    
    public ProjectIssueVO getProjectIssue(long issueId) throws ClassNotFoundException, SQLException {
        ProjectIssueVO issue = new ProjectIssueVO();
        Class.forName(MySQLConstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MySQLConstants.mysqlPath 
                + MySQLConstants.database, 
                MySQLConstants.userName, MySQLConstants.password);
        Statement statement = connection.createStatement();
        String query = "Select * from projectIssue where issueId =" + issueId;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            issue.setIssueId(rs.getLong("issueId"));
            issue.setProjectId(rs.getLong("projectId"));
            issue.setDescription(rs.getString("description"));
            issue.setStatus(rs.getInt("status"));
            issue.setFinderId(rs.getLong("finderId"));
            issue.setFindTime(rs.getLong("findTime"));
            issue.setFixerId(rs.getLong("fixerId"));
            issue.setFixTime(rs.getLong("fixTime"));
        }
        return issue;
    }
    
}
