package issue;

public class projectIssueVO {

	long issueId ;
	int projectId;
	String discription;
	int userId;
	long findtime;
	long fixedtime;
	
	public long getIssueId()
	{
		return issueId;
	}
	public projectIssueVO setIssueId(long issueId)
	{
		this.issueId=issueId;
		return this;
	}
	public int getprojectId()
	{
		return projectId;
	}
	public projectIssueVO setdiscription( String dis)
	{
		this.discription=dis;
		return this;
	}
	public int getuserId()
	{
		return userId;
	}
	public projectIssueVO setuserId(int userId)
	{
		this.userId=userId;
		return this;
	}
	public long getfindtime()
	{
		return findtime;
	}
	public projectIssueVO setfindtime(long findtime)
	{
		this.findtime=findtime;
		return this;
	}
	public long getfixedtime()
	{
		return fixedtime;
	}
	public projectIssueVO setfixedtime(long fixedtime)
	{
		
		
		this.fixedtime=fixedtime;
		return this;
	}
}
