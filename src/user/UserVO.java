package user;


public class UserVO {
	int userId;
    String Name;
    String DateOfBirth;
    String userName;
    String password;
    int imageId;
    String type;
    public int getuserId() {
	       return userId;
	    }
	    public UserVO setuserId(int userId) {
	      this.userId = userId;
	       return this;
	   }
	    public String getName() {
	        return Name;
	    }
	    public UserVO setName(String Name) {
	        this.Name = Name;
	        return this;
	    }
	   
	    public String getDateOfBirth() {
	        return DateOfBirth;
	    }
	    public UserVO setDateOfBirth(String DateOfBirth) {
	        this.DateOfBirth = DateOfBirth;
	        return this;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public UserVO setUserName(String userName) {
	        this.userName = userName;
	        return this;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public UserVO setPassword(String password) {
	        this.password = password;  
	        return this;
	    }
	    public int getimageId() {
	        return imageId;
	    }
	    public UserVO setimageId(int imageId) {
	        this.imageId = imageId;
	        return this;
	    }
	    public String gettype() {
	        return type;
	    }
	    public UserVO settype(String type) {
	        this.type = type;
	        return this;
	    }

}
