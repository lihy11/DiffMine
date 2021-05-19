package cn.net.cobot.mining.model;

public class ProjectInfo {
	/*
	 * project_id	project_name	project_url	date	last_commit_checked
	 * 保存projectinfo表格信息
	 * */
	private String project_id;
	private String project_name;
	private String project_url;
	private String last_commit_checked;
	private String date;
	
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_url() {
		return project_url;
	}
	public void setProject_url(String project_url) {
		this.project_url = project_url;
	}
	public String getLast_commit_checked() {
		return last_commit_checked;
	}
	public void setLast_commit_checked(String last_commit_checked) {
		this.last_commit_checked = last_commit_checked;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
