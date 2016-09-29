package project;


public class projectVO {

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
	public projectVO setprojectId(int projectId)
	{
		this.projectId=projectId;
		return this;
	}
	public String getptitle()
	{
		return ptitle;
	}
	public projectVO setptitle(String ptitle)
	{
		this.ptitle=ptitle;
		return this;
	}
	public String getdis()
	{
		return dis;
	}
	public projectVO setdes(String dis)
	{
		this.dis=dis;
		return this;
	}
	public String getdate()
	{
		return date;
	}
	public projectVO setdate(String date)
	{
		this.date=date;
		return this;
	}
	public String getstatus()
	{
		return status;
	}
	public projectVO setstatus(String status)
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

