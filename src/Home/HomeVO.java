package Home;

public class HomeVO {
	
	long userId;
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
