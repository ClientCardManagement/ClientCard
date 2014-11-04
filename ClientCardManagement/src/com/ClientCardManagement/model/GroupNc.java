package com.ClientCardManagement.model;


/**
 * TrnNc entity. @author MyEclipse Persistence Tools
 */

public class GroupNc implements java.io.Serializable {

	// Fields

	private Long id;
	private Long sid;
	private TrnMid trnMid;
	private String comjnam;

	private String postnam;
	private String offposi;
	private String firstnam;
	private String secdnam;
	
	
	public TrnMid getTrnMid() {
		return trnMid;
	}
	public void setTrnMid(TrnMid trnMid) {
		this.trnMid = trnMid;
	}
	public GroupNc() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getComjnam() {
		return comjnam;
	}
	public void setComjnam(String comjnam) {
		this.comjnam = comjnam;
	}
	public String getPostnam() {
		return postnam;
	}
	public void setPostnam(String postnam) {
		this.postnam = postnam;
	}
	public String getOffposi() {
		return offposi;
	}
	public void setOffposi(String offposi) {
		this.offposi = offposi;
	}
	public String getFirstnam() {
		return firstnam;
	}
	public void setFirstnam(String firstnam) {
		this.firstnam = firstnam;
	}
	public String getSecdnam() {
		return secdnam;
	}
	public void setSecdnam(String secdnam) {
		this.secdnam = secdnam;
	}
	
	

}
