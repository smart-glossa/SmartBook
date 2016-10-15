package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int operation = Integer.parseInt(request.getParameter("operation"));
        try {
            switch (operation) {
            case UserConstant.REGISTERMODE:
                adduser(request, response);
                break;
            case UserConstant.UPDATEMODE:
                updateuser(request, response);
                break;
            case UserConstant.GETMODE:
                getuser(request, response);
                break;
            case UserConstant.GETALLMODE:
                getAlluser(request, response);
                break;
            case UserConstant.GETADMINMODE:
                getAdmin(request, response);
                break;
            case UserConstant.FORGOTMODE:
                userforget(request, response);
                break;
            case UserConstant.DELETEMODE:
                delete(request, response);
                break;
            case UserConstant.DELETEADMINMODE:
                deleteAdmin(request, response);
                break;
            case UserConstant.LOGINMODE:
                getlogin(request, response);
                break;
            }
        } catch (Exception e) {
            // TODO: handle exception

        }

    }

    private void adduser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        String Name = request.getParameter("Name");
        String dateOfBirth = request.getParameter("dob");
        String userName = request.getParameter("userName");
        String password = request.getParameter("pass");
        String type = request.getParameter("type");
        try {
            UserVO user = UserBL.getObject().addUser(Name, dateOfBirth, userName, password, type);
            result.put("status", 1);
            result.put("Name", user.getName());
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void updateuser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        String Name = request.getParameter("Name");
        String userName = request.getParameter("userName");
        String type = request.getParameter("type");
        try {
            UserBL.getObject().updateUser(Name, userName, type);
            result.put("status", 1);
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void getuser(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {

        JSONObject result = new JSONObject();
        String userName = request.getParameter("userName");
        try {
            UserVO user = UserBL.getObject().getUser(userName);
            if (user.getuserId() != -1l) {
                result.put("Name", user.getName());
                result.put("userName", user.getUserName());
                result.put("type", user.gettype());
            }
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void getAlluser(HttpServletRequest request, HttpServletResponse response)
            throws JSONException, IOException, NumberFormatException, SQLException {
        JSONObject all = new JSONObject();
        JSONArray getall = new JSONArray();

        try {
            List<UserVO> alluser = UserBL.getObject().getusers();
            for (UserVO vo : alluser) {
                if (vo.getuserId() != 1l) {
                    JSONObject get = new JSONObject();
                    get.put("userId", vo.getuserId());
                    get.put("Name", vo.getName());
                    get.put("dob", vo.getDateOfBirth());
                    get.put("userName", vo.getUserName());
                    get.put("type", vo.gettype());
                    getall.put(get);
                }
            }
        } catch (Exception e) {
            all.put("Status", 0);
            all.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(getall);
    }

    private void getAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject all = new JSONObject();
        JSONArray getall = new JSONArray();
        String type = request.getParameter("type");

        try {
            List<UserVO> alluser = UserBL.getObject().getAdmin(type);
            for (UserVO vo : alluser) {
                if (vo.getuserId() != 1l) {
                    JSONObject get = new JSONObject();
                    get.put("userId", vo.getuserId());
                    get.put("Name", vo.getName());
                    get.put("dob", vo.getDateOfBirth());
                    get.put("userName", vo.getUserName());
                    get.put("type", vo.gettype());
                    getall.put(get);
                }
            }
        } catch (Exception e) {
            all.put("Status", 0);
            all.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(getall);
    }

    private void getlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject all = new JSONObject();
        JSONArray getall = new JSONArray();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");

        try {
            List<UserVO> alluser = UserBL.getObject().getlogin(userName, pass);
            JSONObject get = new JSONObject();
            for (UserVO vo : alluser) {
                if (vo.getuserId() != 1l) {

                    get.put("userId", vo.getuserId());
                    get.put("Name", vo.getName());
                    get.put("dob", vo.getDateOfBirth());
                    get.put("userName", vo.getUserName());
                    get.put("type", vo.gettype());
                    getall.put(get);
                } else {
                    get.put("Message", "invalid password/userName");
                    getall.put(get);
                }
            }
        } catch (Exception e) {
            all.put("Status", 0);
            all.put("Message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(getall);
    }

    private void userforget(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        String userName = request.getParameter("userName");
        String password = request.getParameter("pass");
        try {
            UserVO user = UserBL.getObject().forget(userName, password);
            result.put("status", "welcome to Employees");
            result.put("userName", user.getUserName());
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        String userName = request.getParameter("userName");
        try {
            UserBL.getObject().deleteUser(userName);
            result.put("status", "success Deleted");
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject result = new JSONObject();
        String type = request.getParameter("type");
        try {
            UserBL.getObject().deleteAdmin(type);
            result.put("status", "success Deleted");
        } catch (Exception e) {
            result.put("status", 0);
            result.put("message", "Internal Error Occurs");
            e.printStackTrace();
        }
        response.getWriter().print(result);
    }

}
