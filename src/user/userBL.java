package user;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONException;




public class userBL {
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    
    public static userBL getObject() {
        return new userBL();
    }
    public userVO addUser(String Name, String dateOfBirth, String userName,
    		              String password,String type) throws ClassNotFoundException, SQLException, ParseException,NumberFormatException
    {
        Date date = sdf.parse(dateOfBirth);
        userVO user = new userVO().setName(Name).setDateOfBirth(dateOfBirth).setUserName(userName).setPassword(password).settype(type);
        userDB.getObject().addUser(user);
        return user;
    }
    public void updateUser(String Name,String userName, String type) throws ClassNotFoundException, SQLException, ParseException,NumberFormatException
	{
     //  Date date = sdf.parse(dateOfBirth);
        userVO user= new userVO().setName(Name).setUserName(userName).settype(type);
        userDB.getObject().updateUser( Name, type, userName);
    }
    public userVO getUser(String userName) throws ClassNotFoundException, SQLException,NumberFormatException {
        return userDB.getObject().getUser(userName);
    }
    public List<userVO> getusers() throws ClassNotFoundException, SQLException,NumberFormatException,ParseException 
	{
        return userDB.getObject().getusers();
}
    public List<userVO> getAdmin(String type) throws ClassNotFoundException, SQLException,NumberFormatException,ParseException 
	{
        return userDB.getObject().getAdmin(type);
    }
    //////////
    public List<userVO> getlogin(String userName,String pass) throws ClassNotFoundException, SQLException,NumberFormatException,ParseException, NullPointerException, JSONException 
   	{
           return userDB.getObject().getlogin(userName, pass);
       }
    //////////
    public userVO forget(String userName,String password) throws ClassNotFoundException, SQLException,ParseException,NumberFormatException
  		{
  			userVO user=new userVO().setUserName(userName).setPassword(password);
  			userDB.getObject().forgetuser(user);
			return user;
  		}
    public void deleteUser(String userName) throws ClassNotFoundException, SQLException,NumberFormatException {
        userDB.getObject().deleteUser(userName);
    }
    public void deleteAdmin(String type) throws ClassNotFoundException, SQLException,NumberFormatException {
        userDB.getObject().deleteAdmin(type);
    }
    public userVO gettotal(String type) throws ClassNotFoundException, SQLException,NumberFormatException,ParseException 
	{
        return userDB.getObject().total(type);
    }
}