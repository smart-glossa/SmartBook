package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import common.MySqlconstants;


public class ProjectDB {
	public static ProjectDB getobject()
	 {
		 return new ProjectDB();
	 }
	 public void createproject(ProjectVO project) throws ClassNotFoundException, 
	                                  SQLException,ParseException,NumberFormatException  //add function
	 {
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="insert into project(ptitle,dis,pdate,status)values('"+project.getptitle()+"','"+project.getdis()+"','"+project.getdate()+"','"+project.getstatus()+"')";
		 statement.executeUpdate(query);
	 }
	 public void updateproject(ProjectVO project,String ptitle) throws ClassNotFoundException, 
	                               SQLException,NumberFormatException,ParseException  //update function
	 {
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();                                        
		 String query="update project set ptitle='"+project.getptitle()+"',dis='"+project.getdis()+"',pdate='"+project.getdate()+"',status='"+project.getstatus()+"' where projectId=" +project.getprojectId();
		 statement.execute(query);
		
	 }
	 
	 public ProjectVO getone(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		   
		 ProjectVO project=new ProjectVO();
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="select * from project where projectId= '"+ projectId+"' ";
		 ResultSet rs=statement.executeQuery(query);
		 if(rs.next())
		 {
			 project.setprojectId(rs.getInt("projectId"));
			 project.setptitle(rs.getString("ptitle"));
			 project.setdes(rs.getString("dis"));
			 project.setdate(rs.getString("pdate"));
			 project.setstatus(rs.getString("status"));
			// project.seturl(rs.getString("url"));
			
		 }
		return project;
	 }
	 public List<ProjectVO> getproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 List<ProjectVO> tlist=new ArrayList<>(); // Hi Sathish, tlist
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="select * from project";
		 ResultSet rs=statement.executeQuery(query);
		 while(rs.next())
		 {
			ProjectVO getss=new ProjectVO();
			getss.setprojectId(rs.getInt("projectId"));
			getss.setptitle(rs.getString("ptitle"));
			getss.setdes( rs.getString("dis"));
			getss.setdate(rs.getString("pdate"));
			getss.setstatus(rs.getString("status"));
			tlist.add(getss); // Now try, you will get all the projects :)ok ajith
			// enna resion ajith status :1  var  // Dont use same servlet name in web.xml. If any changes i web.xml, we have to restart the tomcat server for the reflection  k
			// Please debug , dont waste timeon thining, just debug, debug, debug Please 
		 }
		return tlist;
		
	 }
	 
	 
	 public List<ProjectVO> getOnlyproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 List<ProjectVO> tlist=new ArrayList<>(); // Hi Sathish, tlist
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="select projectId,ptitle from project";
		 ResultSet rs=statement.executeQuery(query);
		 while(rs.next())
		 {
			ProjectVO getss=new ProjectVO();
			getss.setprojectId(rs.getInt("projectId"));
			getss.setptitle(rs.getString("ptitle"));

			tlist.add(getss);


		 }
		return tlist;
		
	 }
	 public void delete(int projectId) throws ClassNotFoundException, SQLException
	 {
		 JSONObject del=new JSONObject();
		// projectGS dele=new projectGS();
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="delete  from project where projectId="+projectId;
		 statement.execute(query);
	 }
	 public void deletestatus(int projectId) throws ClassNotFoundException, SQLException
	 {
		 JSONObject del=new JSONObject();
		 Class.forName(MySqlconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
		 Statement statement=connection.createStatement();
		 String query="delete status from project where="+ projectId;
		 statement.execute(query);
	 }
	 public void updatestatus(ProjectVO project,int projectId,String status) throws ClassNotFoundException, 
     SQLException,NumberFormatException,ParseException  //update function
    {
      Class.forName(MySqlconstants.mysqlDriver);
      Connection connection=DriverManager.getConnection(MySqlconstants.mysqlPath + MySqlconstants.database,MySqlconstants.userName,MySqlconstants.password);
      Statement statement=connection.createStatement();                                        
      String query="update project set status='"+project.getstatus()+"' where projectId=" +project.getprojectId();
      statement.execute(query);

}
	/* public projectVO getoneurl(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		   
		 projectVO project=new projectVO();
		 Class.forName(MYSQLconstants.mysqlDriver);
		 Connection connection=DriverManager.getConnection(MYSQLconstants.mysqlPath + MYSQLconstants.database,MYSQLconstants.userName,MYSQLconstants.password);
		 Statement statement=connection.createStatement();
		 String query="select ptitle,url from project where projectId= '"+ projectId+"' ";
		 ResultSet rs=statement.executeQuery(query);
		 if(rs.next())
		 {
			
			 project.setptitle(rs.getString("ptitle"));
			// project.seturl(rs.getString("url"));
			
		 }
		return project;
	 }*/
}
