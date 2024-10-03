package banking;

public class EmployeeData{
	private String ename;
	private String eid;
	private String epassword;
	
	
	public EmployeeData(String ename,String eid, String epassword) {
		this.ename = ename;
		this.eid = eid;
		this.epassword = epassword;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}



}
