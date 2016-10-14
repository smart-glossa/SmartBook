package Home;

public class HomeVO {
	
	long userId;
	long userName;
	long projectId; 
	long issueId;
	
	public long getuserId()
	{
		return userId;
	}
	public HomeVO setuserId(long userId){
		this.userId=userId;
		return this;
	}
	public long getuserName()
	{
		return userName;
	}
	public HomeVO setuserName(long userName){
		this.userName=userName;
		return this;
	}
	public long getprojectId()
	{
		return projectId;
	}
	public HomeVO setprojectId(long projectId)
	{
		this.projectId=projectId;
		return this;
	}
	public long getissueId(){
		return issueId;
	}
	public HomeVO setissueId(long issueId)
	{
		this.issueId=issueId;
		return this;
	}

}
