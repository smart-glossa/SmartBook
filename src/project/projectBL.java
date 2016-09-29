package project;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;


public class projectBL {
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
	 public static projectBL getobject()
	 {
		 return new projectBL();
	}
	 public projectVO createproject(String ptitle,String dis,String date,String status) throws ParseException, ClassNotFoundException, SQLException
	 {
		 Date dat=sdf.parse(date);
		 projectVO project=new projectVO().setptitle(ptitle).setdes(dis).setdate(date).setstatus(status);
		 projectDB.getobject().createproject(project);
		return project;
		 
	 }
	 public projectVO updateproject(int projectId,String ptitle,String dis,String date,String status) throws ParseException, ClassNotFoundException, SQLException,NumberFormatException
	 {
		 Date dat=sdf.parse(date);
		 projectVO project=new projectVO().setprojectId(projectId).setptitle(ptitle).setdes(dis).setdate(date).setstatus(status);
		 projectDB.getobject().updateproject(project,ptitle);
		return project;
	 }
	 
	 public projectVO getone(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 return projectDB.getobject().getone(projectId);
	 }
	 public List<projectVO>  getproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
	         return projectDB.getobject().getproject();
		 
	 }
	 
	 public List<projectVO>  getOnlyproject() throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
	         return projectDB.getobject().getOnlyproject();
		 
	 }
	 
	 
	 public void deleteproject(int projectId) throws ClassNotFoundException, SQLException
	 {
		 projectDB.getobject().delete(projectId);
	 }
	 public void deletestatus(int projectId) throws ClassNotFoundException, SQLException
	 {
		 projectDB.getobject().deletestatus(projectId);
	 }
	 
	 public projectVO updatestatus(int projectId,String status) throws ParseException, ClassNotFoundException, SQLException,NumberFormatException
	 {
		// Date dat=sdf.parse(date);
		 projectVO project=new projectVO().setstatus(status);
		 projectDB.getobject().updatestatus(project, projectId, status);
		return project;
	 }
	/* public projectVO geturl(int projectId) throws ClassNotFoundException, SQLException, JSONException,ParseException
	 {
		 return projectDB.getobject().getoneurl(projectId);
	 }*/
	}

