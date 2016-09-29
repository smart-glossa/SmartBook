package project;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;


public class ProjectBL {
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	 public static ProjectBL getobject()
	 {
		 return new ProjectBL();
	}
	 public ProjectVO createproject(String ptitle,String dis,String date,String status) throws ParseException, ClassNotFoundException, SQLException
	 {
		 Date dat=sdf.parse(date);
		 ProjectVO project=new ProjectVO().setptitle(ptitle).setdes(dis).setdate(date).setstatus(status);
		 ProjectDB.getobject().createproject(project);
		return project;
		 
	 }
	 public ProjectVO updateproject(int projectId,String ptitle,String dis,String date,String status) throws ParseException, ClassNotFoundException, SQLException,NumberFormatException
	 {
		 Date dat=sdf.parse(date);
		 ProjectVO project=new ProjectVO().setprojectId(projectId).setptitle(ptitle).setdes(dis).setdate(date).setstatus(status);
		 ProjectDB.getobject().updateproject(project,ptitle);
		return project;
	 }
	 
	 public ProjectVO getone(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 return ProjectDB.getobject().getone(projectId);
	 }
	 public List<ProjectVO>  getproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
	         return ProjectDB.getobject().getproject();
		 
	 }
	 
	 public List<ProjectVO>  getOnlyproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
	         return ProjectDB.getobject().getOnlyproject();
		 
	 }
	 
	 
	 public void deleteproject(int projectId) throws ClassNotFoundException, SQLException
	 {
		 ProjectDB.getobject().delete(projectId);
	 }
	 public void deletestatus(int projectId) throws ClassNotFoundException, SQLException
	 {
		 ProjectDB.getobject().deletestatus(projectId);
	 }
	 
	 public ProjectVO updatestatus(int projectId,String status) throws ParseException, ClassNotFoundException, SQLException,NumberFormatException
	 {
		// Date dat=sdf.parse(date);
		 ProjectVO project=new ProjectVO().setstatus(status);
		 ProjectDB.getobject().updatestatus(project, projectId, status);
		return project;
	 }
	/* public projectVO geturl(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 return projectDB.getobject().getoneurl(projectId);
	 }*/
	}

