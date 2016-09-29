package user;


public class userVO {
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
	    public userVO setuserId(int userId) {
	      this.userId = userId;
	       return this;
	   }
	    public String getName() {
	        return Name;
	    }
	    public userVO setName(String Name) {
	        this.Name = Name;
	        return this;
	    }
	   
	    public String getDateOfBirth() {
	        return DateOfBirth;
	    }
	    public userVO setDateOfBirth(String DateOfBirth) {
	        this.DateOfBirth = DateOfBirth;
	        return this;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public userVO setUserName(String userName) {
	        this.userName = userName;
	        return this;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public userVO setPassword(String password) {
	        this.password = password;  
	        return this;
	    }
	    public int getimageId() {
	        return imageId;
	    }
	    public userVO setimageId(int imageId) {
	        this.imageId = imageId;
	        return this;
	    }
	    public String gettype() {
	        return type;
	    }
	    public userVO settype(String type) {
	        this.type = type;
	        return this;
	    }

}
