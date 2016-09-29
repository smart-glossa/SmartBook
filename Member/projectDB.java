package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import comman.MYSQLconstants;


public class projectDB {
	public static projectDB getObject() {
        return new projectDB();
    }
    
    public void addProjectMember(projectMemberVO project) throws ClassNotFoundException,NumberFormatException,ParseException,SQLException, 
                                          SQLException {
        Class.forName(MYSQLconstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MYSQLconstants.mysqlPath + MYSQLconstants.database,MYSQLconstants.userName, MYSQLconstants.password);
        Statement statement = connection.createStatement();
        String query = "Insert into ProjectMembers(projectId,ptitle, userName) Values ('"+ project.getProjectId() + "','"+project.getptitle()+"', '" + project.getUserName() + "')";
        statement.execute(query);
    }
    
    public void updateProjectMember(projectMemberVO project) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQLconstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MYSQLconstants.mysqlPath 
                + MYSQLconstants.database, 
                MYSQLconstants.userName, MYSQLconstants.password);
        Statement statement = connection.createStatement();
        String query = "Update ProjectMembers set ptitle =" 
                + project.getptitle() + " where projectId = " + project.getProjectId()
                + " and userName = " + project.getUserName();
        statement.execute(query);
    }

    public void deleteProjectMember(long projectId, String userName) throws ClassNotFoundException, SQLException{
        Class.forName(MYSQLconstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MYSQLconstants.mysqlPath 
                + MYSQLconstants.database, 
                MYSQLconstants.userName, MYSQLconstants.password);
        Statement statement = connection.createStatement();
        String query = "Delete from ProjectMembers where projectId =" + projectId + " and userName = '" + userName+"'";
        statement.execute(query);
    }
    
    public List<projectMemberVO> getProjectMembers(long projectId,String userName) throws ClassNotFoundException, SQLException {
        List<projectMemberVO> members = new ArrayList<projectMemberVO>();
        Class.forName(MYSQLconstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MYSQLconstants.mysqlPath 
                + MYSQLconstants.database, 
                MYSQLconstants.userName, MYSQLconstants.password);
        Statement statement = connection.createStatement();
        String query = "Select * from projectMembers where projectId =" +projectId+" or userName='"+userName+"'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            projectMemberVO project = new projectMemberVO();
            project.setProjectId(rs.getInt("projectId"));
            project.setUserName(rs.getString("userName"));
            project.setptitle(rs.getString("ptitle"));
         //   project.setProjectRoleId(rs.getInt("projectRoleId"));
            members.add(project);
        }
        return members;
    }
    public List<projectMemberVO> getProjectMembersAll() throws ClassNotFoundException, SQLException {
        List<projectMemberVO> members = new ArrayList<projectMemberVO>();
        Class.forName(MYSQLconstants.mysqlDriver);
        Connection connection = DriverManager.getConnection(MYSQLconstants.mysqlPath 
                + MYSQLconstants.database, 
                MYSQLconstants.userName, MYSQLconstants.password);
        Statement statement = connection.createStatement();
        String query = "Select * from projectMembers";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            projectMemberVO project = new projectMemberVO();
            project.setProjectId(rs.getInt("projectId"));
            project.setUserName(rs.getString("userName"));
            project.setptitle(rs.getString("ptitle"));
         //   project.setProjectRoleId(rs.getInt("projectRoleId"));
            members.add(project);
        }
        return members;
    }
   
}

