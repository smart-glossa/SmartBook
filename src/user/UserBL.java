package user;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;

public class UserBL {

    public static UserBL getObject() {
        return new UserBL();
    }

    public UserVO addUser(String Name, String dateOfBirth, String userName, String password, String type)
            throws ClassNotFoundException, SQLException, ParseException, NumberFormatException {
        UserVO user = new UserVO().setName(Name).setDateOfBirth(dateOfBirth).setUserName(userName).setPassword(password)
                .settype(type);
        UserDB.getObject().addUser(user);
        return user;
    }

    public void updateUser(String Name, String userName, String type)
            throws ClassNotFoundException, SQLException, ParseException, NumberFormatException {
        UserDB.getObject().updateUser(Name, type, userName);
    }

    public UserVO getUser(String userName) throws ClassNotFoundException, SQLException, NumberFormatException {
        return UserDB.getObject().getUser(userName);
    }

    public List<UserVO> getusers() throws ClassNotFoundException, SQLException, NumberFormatException, ParseException {
        return UserDB.getObject().getusers();
    }

    public List<UserVO> getAdmin(String type)
            throws ClassNotFoundException, SQLException, NumberFormatException, ParseException {
        return UserDB.getObject().getAdmin(type);
    }

    public List<UserVO> getlogin(String userName, String pass) throws ClassNotFoundException, SQLException,
            NumberFormatException, ParseException, NullPointerException, JSONException {
        return UserDB.getObject().getlogin(userName, pass);
    }

    public UserVO forget(String userName, String password)
            throws ClassNotFoundException, SQLException, ParseException, NumberFormatException {
        UserVO user = new UserVO().setUserName(userName).setPassword(password);
        UserDB.getObject().forgetuser(user);
        return user;
    }

    public void deleteUser(String userName) throws ClassNotFoundException, SQLException, NumberFormatException {
        UserDB.getObject().deleteUser(userName);
    }

    public void deleteAdmin(String type) throws ClassNotFoundException, SQLException, NumberFormatException {
        UserDB.getObject().deleteAdmin(type);
    }

    public UserVO gettotal(String type)
            throws ClassNotFoundException, SQLException, NumberFormatException, ParseException {
        return UserDB.getObject().total(type);
    }
}