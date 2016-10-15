package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import common.MySqlConstant;

public class UserDB {
    public static UserDB getObject() {
        return new UserDB();
    }

    public void addUser(UserVO user) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Insert into user(Name, dob,userName, pass, type) Values ('" + user.getName() + "','"
                + user.getDateOfBirth() + "','" + user.getUserName() + "','" + user.getPassword() + "','"
                + user.gettype() + "')";
        statement.executeUpdate(query);
        user.getName();
    }

    public void updateUser(String Name, String type, String userName) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Update user set  Name='" + Name + "',type='" + type + "' where userName = '" + userName + "' ";
        statement.execute(query);
    }

    public UserVO getUser(String userName) throws ClassNotFoundException, SQLException {

        UserVO user = new UserVO();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from user where userName ='" + userName + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            user.setName(rs.getString("Name"));
            user.setUserName(rs.getString("userName"));
            user.settype(rs.getString("type"));
        }
        return user;
    }

    public List<UserVO> getusers()
            throws ClassNotFoundException, SQLException, NullPointerException, NumberFormatException, ParseException {
        List<UserVO> user = new ArrayList<UserVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select Name,userName,type from user";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            UserVO gets = new UserVO();
            //gets.setuserId(rs.getInt("userId"));
            gets.setName(rs.getString("Name"));
            gets.setUserName(rs.getString("userName"));
            gets.settype(rs.getString("type"));
            user.add(gets);
        }
        return user;
    }

    public List<UserVO> getAdmin(String type)
            throws ClassNotFoundException, SQLException, NullPointerException, NumberFormatException, ParseException {
        List<UserVO> user = new ArrayList<UserVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select * from user where type='" + type + "'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {

            UserVO gets = new UserVO();
           // gets.setuserId(rs.getInt("userId"));
            gets.setName(rs.getString("Name"));
            gets.setUserName(rs.getString("userName"));
            gets.settype(rs.getString("type"));
            user.add(gets);
        }
        return user;
    }

    public List<UserVO> getlogin(String userName, String pass) throws ClassNotFoundException, SQLException,
            NullPointerException, NumberFormatException, ParseException, JSONException {
        List<UserVO> user = new ArrayList<UserVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Select userName,type from user where userName='" + userName + "' AND pass='" + pass + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {

            UserVO gets = new UserVO();
            gets.setUserName(rs.getString("userName"));
            gets.settype(rs.getString("type"));
            if (userName != null && pass != null) {
                user.add(gets);
            } else {
                JSONObject n = new JSONObject();
                n.put("Message", "invalid userName/password");
                user.add(gets);
            }
        }
        return user;
    }

    public void forgetuser(UserVO user) throws SQLException, ClassNotFoundException // forget password
    {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query =
                "update user set pass='" + user.getPassword() + "' where userName= '" + user.getUserName() + "' ";
        statement.execute(query);
    }

    public void deleteUser(String userName) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Delete from user where userName =' " + userName + "'";
        statement.execute(query);
    }

    public void deleteAdmin(String type) throws ClassNotFoundException, SQLException {
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "Delete from user where type =' " + type + "'";
        statement.execute(query);
    }

    public UserVO total(String type) throws ClassNotFoundException, SQLException {

        UserVO log = new UserVO();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "SELECT userId FROM user WHERE userId LIKE '%0'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            log.setuserId(rs.getInt("userId"));

        }
        return log;

    }
}
