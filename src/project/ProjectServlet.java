package project;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




/**
 * Servlet implementation class projectServlet
 */
@WebServlet("/projectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int operation=Integer.parseInt(request.getParameter("operation"));
		try {
			switch (operation) {
			case ProjectConstant.req_CreateMode:
				addproject(request,response);
				break;
			case ProjectConstant.req_UpdateMode:
				updateproject(request,response);
				break;
			case ProjectConstant.req_GetMode:
				getprojecct(request,response);
				break;
			case ProjectConstant.req_getAllProject:
				getallProject(request,response);
				break;
			case ProjectConstant.req_getonlyMode:
				getOnly(request,response);
				break;
			case ProjectConstant.req_DeleteOneMode:
				deleteOne(request,response);
				break;
			case ProjectConstant.req_deletestatusMode:
				deletestatus(request,response);
				break;
			/*case projectconstant.req_geturl:
				geturl(request,response);*/
			default:
				break;
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}

	

	private void addproject(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		// TODO Auto-generated method stub
		
		JSONObject project=new JSONObject();
		String ptitle=request.getParameter("ptitle");
		String dis=request.getParameter("dis");
		String date=request.getParameter("date");
		String status=request.getParameter("status");
		//String url=request.getParameter("url");
		try
		{
			ProjectVO p=ProjectBL.getobject().createproject(ptitle, dis, date, status);
			project.put("Status",1);
			project.put("ptitle",p.getptitle());
			//project.put("projectId",p.getprojectId());
		}catch (ClassNotFoundException e) {
            project.put("status", 0);
            project.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            project.put("status", 0);
            project.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (ParseException e) {
            project.put("status", 0);
            project.put("message", "Parse Error Occurs");
            e.printStackTrace();
        } 
       response.getWriter().print(project);
    }
	
	private void updateproject(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		// TODO Auto-generated method stub

		JSONObject update=new JSONObject();
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		String ptitle=request.getParameter("ptitle");
		String dis=request.getParameter("dis");
		String date=request.getParameter("date");
		String status=request.getParameter("status");
		try
		{
			ProjectVO up=ProjectBL.getobject().updateproject(projectId, ptitle, dis, date, status);
			update.put("Status", "updated");
		}catch(ClassNotFoundException e){
			update.put("Status", 0);
			update.put("Message", "Internal Error Occurs");
			e.printStackTrace();
		}catch (SQLException e) {
			update.put("Status", 0);
			update.put("Message","SQL Error Occurs");
			e.printStackTrace();
		}catch (ParseException e) {
			update.put("Status", 0);
			update.put("Message", "parseException Error Occur");
			e.printStackTrace();
		}catch (NumberFormatException e) {
			update.put("Status", 0);
			update.put("Message", "NumberFormetException");
			e.printStackTrace();
		}catch (Exception e) {
			update.put("Status", 0);
			update.put("Message","Excepion Error Occur");
			e.printStackTrace();
		}
			response.getWriter().print(update);
		}
		
	private void getprojecct(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		// TODO Auto-generated method stub
		JSONObject get=new JSONObject();
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		
		try
		{
			ProjectVO gone=ProjectDB.getobject().getone(projectId);
			get.put("status", 1);
			if(gone.getprojectId()!=-1l)
			{
			get.put("projectId",gone.getprojectId());
			get.put("ptitle", gone.getptitle());
			get.put("dis",gone.getdis());
			get.put("pdate",gone.getdate());
			get.put("status",gone.getstatus());
			//get.put("URl", gone.geturl());
			}
		}catch(ClassNotFoundException e){
			get.put("Status", 0);
			get.put("Message","Internal Error Occurs");
			e.printStackTrace();
		}catch (ParseException e) {
			get.put("Status",0);
			get.put("Message", "parseException Error Occur");
			e.printStackTrace();
		}catch (JSONException e) {
			get.put("Status",0);
			get.put("Message","JsonExcepion Error Occur");
			e.printStackTrace();
		}catch (SQLException e) {
			get.put("Status", 0);
			get.put("Message","SQLExcepion Error Occur");
			e.printStackTrace();
		}catch (NullPointerException e) {
			get.put("Status", 0);
			get.put("Message","NullPointerException Error Occur");
			e.printStackTrace();
			// TODO: handle exception
		}
		response.getWriter().print(get);
	}
	private void getallProject(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		
		
		JSONObject get=new JSONObject();
		JSONArray plist=new JSONArray();
		try
		{
			
			List<ProjectVO> gets=ProjectBL.getobject().getproject();
			//JSONArray plist=new JSONArray();
			for(ProjectVO gs:gets)
			{
			if(gs.getprojectId()!=-1l)
			{
		    JSONObject value=new JSONObject();
			value.put("projectId",gs.getprojectId());
			value.put("ptitle", gs.getptitle());
			value.put("dis",gs.getdis());
			value.put("pdate",gs.getdate());
			value.put("status",gs.getstatus());
			plist.put(value);
			value.put("Status",1);
			}
			}
			get.put("status", 1);
			//get.put("projects", plist);
		}catch(ClassNotFoundException e){
			get.put("Status", 0);
			get.put("Message","Internal Error Occurs");
			e.printStackTrace();
		}catch (ParseException e) {
			get.put("Status",0);
			get.put("Message", "parseException Error Occur");
			e.printStackTrace();
		}catch (JSONException e) {
			get.put("Status",0);
			get.put("Message","JsonExcepion Error Occur");
			e.printStackTrace();
		}catch (SQLException e) {
			get.put("Status", 0);
			get.put("Message","SQLExcepion Error Occur");
			e.printStackTrace();
		}catch (NullPointerException e) {
			get.put("Status", 0);
			get.put("Message","NullPointerException Error Occur");
			e.printStackTrace();
			// TODO: handle exception
		}
		response.getWriter().print(plist);
	}

	private void getOnly(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
	
		JSONObject get=new JSONObject();
		JSONArray plist=new JSONArray();
		try
		{
			
			List<ProjectVO> gets=ProjectBL.getobject().getOnlyproject();
			//JSONArray plist=new JSONArray();
		
			for(ProjectVO gs:gets)
			{
			if(gs.getprojectId()!=-1l)
			{
		    JSONObject value=new JSONObject();
			//value.put("projectId",gs.getprojectId());
			value.put("ptitle", gs.getptitle());
			plist.put(value);
			value.put("Status",1);
			}
			}
			get.put("status", 1);
			//get.put("projects", plist);
		}catch(ClassNotFoundException e){
			get.put("Status", 0);
			get.put("Message","Internal Error Occurs");
			e.printStackTrace();
		}catch (ParseException e) {
			get.put("Status",0);
			get.put("Message", "parseException Error Occur");
			e.printStackTrace();
		}catch (JSONException e) {
			get.put("Status",0);
			get.put("Message","JsonExcepion Error Occur");
			e.printStackTrace();
		}catch (SQLException e) {
			get.put("Status", 0);
			get.put("Message","SQLExcepion Error Occur");
			e.printStackTrace();
		}catch (NullPointerException e) {
			get.put("Status", 0);
			get.put("Message","NullPointerException Error Occur");
			e.printStackTrace();
			// TODO: handle exception
		}
		response.getWriter().print(plist);
	}

	private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		
		

		JSONObject result = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        try {
            ProjectBL.getobject().deleteproject(projectId);
            result.put("status", "success deleted");
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            result.put("status", 0);
            result.put("message", "NumberFormatException");
            e.printStackTrace();
        } catch (JSONException e) {
            result.put("status", 0);
            result.put("message", "JSONException");
            e.printStackTrace();
        } 
        response.getWriter().print(result);
    }
	
	
	private void deletestatus(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONObject result = new JSONObject();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String status=request.getParameter("status");
       
        try {
            ProjectBL.getobject().updatestatus(projectId, status);
            result.put("status", "success updated");
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            result.put("status", 0);
            result.put("message", "NumberFormatException");
            e.printStackTrace();
        } catch (JSONException e) {
            result.put("status", 0);
            result.put("message", "JSONException");
            e.printStackTrace();
        } 
        response.getWriter().print(result);
    }
	
	
	/*private void geturl(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		JSONObject get=new JSONObject();
		int projectId=Integer.parseInt(request.getParameter("projectId"));
		
		try
		{
			projectVO gone=projectDB.getobject().getone(projectId);
			get.put("status", 1);
			if(gone.getprojectId()!=-1l)
			{
			
			get.put("ptitle", gone.getptitle());
			get.put("URl", gone.geturl());
			}
		}catch(ClassNotFoundException e){
			get.put("Status", 0);
			get.put("Message","Internal Error Occurs");
			e.printStackTrace();
		}catch (ParseException e) {
			get.put("Status",0);
			get.put("Message", "parseException Error Occur");
			e.printStackTrace();
		}catch (JSONException e) {
			get.put("Status",0);
			get.put("Message","JsonExcepion Error Occur");
			e.printStackTrace();
		}catch (SQLException e) {
			get.put("Status", 0);
			get.put("Message","SQLExcepion Error Occur");
			e.printStackTrace();
		}catch (NullPointerException e) {
			get.put("Status", 0);
			get.put("Message","NullPointerException Error Occur");
			e.printStackTrace();
			// TODO: handle exception
		}
		response.getWriter().print(get);
	}*/
	}
	


	
		
	

	

