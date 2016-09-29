package Member;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
 * Servlet implementation class projectMemberServlets
 */
@WebServlet("/projectMemberServlets")
public class projectMemberServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectMemberServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		doPost(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     int operation= Integer.parseInt(request.getParameter("operation"));
     try 
     {
     switch (operation) {
	case projectconstants.req_AddOperation:
			AddMember(request,response);
			break;
	case projectconstants.req_UpdateOperation:
		updatemember(request,response);
		break;
	case projectconstants.req_GetOperation:
		getmember(request,response);
		break;
	case projectconstants.req_GetAll:
		getall(request,response);
		break;
     }
		}catch (Exception e) {

			e.printStackTrace();
	}
	}



	
	private void AddMember(HttpServletRequest request, HttpServletResponse response)throws Exception {
		JSONObject owner=new JSONObject();
		long projectId=Long.parseLong(request.getParameter("projectId"));
		String ptitle=request.getParameter("ptitle");
		String userName=request.getParameter("userName");
		//int RoleId=Integer.parseInt(request.getParameter("RoleId"));
		try
		{
			projectMemberVO member=projectMemberBL.getObject().addProjectMember(projectId,ptitle,userName);
			owner.put("Status","Success");
		} catch (NumberFormatException e) {
			owner.put("Status", "0");
			owner.put("Message", "NumberFormatException Error Occur");
			e.printStackTrace();
		} catch (NullPointerException e) {
			owner.put("Status", "0");
			owner.put("Message", "NullPointerException Error Occur");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			owner.put("Status", "0");
			owner.put("Message", "ClassNotFoundException Error Occur");
			e.printStackTrace();
		} catch (JSONException e) {
			owner.put("Status", "0");
			owner.put("Message", "JSONException Error Occur");
			e.printStackTrace();
		} catch (SQLException e) {
			owner.put("Status", "0");
			owner.put("Message", "SQLException Error Occur");
			e.printStackTrace();
		} catch (ParseException e) {
			owner.put("Status", "0");
			owner.put("Message", "ParseException Error Occur");
			e.printStackTrace();
		}
		response.getWriter().print(owner);
	}
	
	private void updatemember(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
         JSONObject update=new JSONObject();
      long projectId=Long.parseLong(request.getParameter("projectId"));
      String ptitle=request.getParameter("ptitle");
      String userName=request.getParameter("userName");
      //int RoleId=Integer.parseInt(request.getParameter("RoleId"));
		try
		{
			projectMemberVO upmember=projectMemberBL.getObject().updateProjectMember(projectId, userName, ptitle);
			update.put("Status", "Success Updated");
		}catch(JSONException e){
			update.put("Status", 0);
			update.put("Message", "JSONException");
			e.printStackTrace();
		}catch(SQLException e) {
			update.put("Status", 0);
			update.put("Message", "JSONException Error Occur");
			e.printStackTrace();
		}catch (ParseException e) {
			update.put("Status", 0);
			update.put("Message", "ParseException Error Occur");
			e.printStackTrace();
			// TODO: handle exception
		}catch (ClassNotFoundException e) {
			update.put("Status", 0);
			update.put("Message", "lassNotFoundException Error Occur");
			e.printStackTrace();
		}catch (NumberFormatException e) {
			update.put("Status", 0);
			update.put("Message", "NumberFormatException Error Occur");
			e.printStackTrace();
		}catch (NullPointerException e) {
			update.put("Status", 0);
			update.put("Message", "NullPointerException Error Occur");
			e.printStackTrace();
		}
		response.getWriter().print(update);
	}
	private void getmember(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		JSONObject result = new JSONObject();
        long projectId = Long.parseLong(request.getParameter("projectId"));
        String userName=request.getParameter("userName");
        try {
            List<projectMemberVO> members = projectMemberBL.getObject().getProjectMembers(projectId,userName);
            JSONArray rmembers = new JSONArray();
            for (projectMemberVO member : members) {
                if (member.getProjectId() != -1l) {
                    JSONObject rmember = new JSONObject();
                    rmember.put("projectId", member.getProjectId());
                    rmember.put("userId", member.getUserName());
                    rmember.put("roleId", member.getProjectRoleId());
                    rmembers.put(rmember);
                }
            }
            result.put("status", 1);
            result.put("members", rmembers);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        }catch (JSONException e) {
        	result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
		}
        response.getWriter().print(result);
    }
	private void getall(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		
		JSONObject result = new JSONObject();


        try {
            List<projectMemberVO> members = projectMemberBL.getObject().getProjectMembersAlll();
            JSONArray rmembers = new JSONArray();
            for (projectMemberVO member : members) {
                if (member.getProjectId() != -1l) {
                    JSONObject rmember = new JSONObject();
                    rmember.put("projectId", member.getProjectId());
                    rmember.put("userId", member.getUserName());
                    rmember.put("roleId", member.getProjectRoleId());
                    rmembers.put(rmember);
                }
            }
            result.put("status", 1);
            result.put("members", rmembers);
        } catch (ClassNotFoundException e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        } catch (SQLException e) {
            result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
        }catch (JSONException e) {
        	result.put("status", 0);
            result.put("message", "SQL Error Occurs");
            e.printStackTrace();
		}
        response.getWriter().print(result);
    }
	}
	

