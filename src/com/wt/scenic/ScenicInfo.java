package com.wt.scenic;

import java.io.Serializable;

public class ScenicInfo implements Serializable{
	private String scenicid;
	private String scenicname;
	public ScenicInfo(String scenicid, String scenicname, String sceniccontents) {
		super();
		this.scenicid = scenicid;
		this.scenicname = scenicname;
		this.sceniccontents = sceniccontents;
	}
	public ScenicInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String sceniccontents;
	public String getScenicid() {
		return scenicid;
	}
	public void setScenicid(String scenicid) {
		this.scenicid = scenicid;
	}
	public String getScenicname() {
		return scenicname;
	}
	public void setScenicname(String scenicname) {
		this.scenicname = scenicname;
	}
	public String getSceniccontents() {
		return sceniccontents;
	}
	public void setSceniccontents(String sceniccontents) {
		this.sceniccontents = sceniccontents;
	}
}
