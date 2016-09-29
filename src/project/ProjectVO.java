package project;


public class ProjectVO {

	int projectId;
	String ptitle;
	String dis;
	String date;
	String status;
	//String url;
	/*getter and setter*/
	public int getprojectId()
	{
		return projectId;
		
	}
	public ProjectVO setprojectId(int projectId)
	{
		this.projectId=projectId;
		return this;
	}
	public String getptitle()
	{
		return ptitle;
	}
	public ProjectVO setptitle(String ptitle)
	{
		this.ptitle=ptitle;
		return this;
	}
	public String getdis()
	{
		return dis;
	}
	public ProjectVO setdes(String dis)
	{
		this.dis=dis;
		return this;
	}
	public String getdate()
	{
		return date;
	}
	public ProjectVO setdate(String date)
	{
		this.date=date;
		return this;
	}
	public String getstatus()
	{
		return status;
	}
	public ProjectVO setstatus(String status)
	{
		this.status=status;
		return this;
	}
	/*public String geturl()
	/{
		return url;
	}
	public projectVO seturl(String url)
	{
		this.url=url;
		return this;
	}*/

}

