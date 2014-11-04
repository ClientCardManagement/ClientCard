package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * TrnAccess entity. @author MyEclipse Persistence Tools
 */

public class TrnAccess implements java.io.Serializable {

	// Fields

	private Long id;
	private MstUser mstUser;
	private TrnMid trnMid;
	private Timestamp compltime;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors

	/** default constructor */
	public TrnAccess() {
	}

	/** full constructor */
	public TrnAccess(MstUser mstUser, TrnMid trnMid, Timestamp compltime,
			Timestamp crttim, String crtusr, Timestamp updtim, String updusr) {
		this.mstUser = mstUser;
		this.trnMid = trnMid;
		this.compltime = compltime;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MstUser getMstUser() {
		return this.mstUser;
	}

	public void setMstUser(MstUser mstUser) {
		this.mstUser = mstUser;
	}

	public TrnMid getTrnMid() {
		return this.trnMid;
	}

	public void setTrnMid(TrnMid trnMid) {
		this.trnMid = trnMid;
	}

	public Timestamp getCompltime() {
		return this.compltime;
	}

	public void setCompltime(Timestamp compltime) {
		this.compltime = compltime;
	}

	public Timestamp getCrttim() {
		return this.crttim;
	}

	public void setCrttim(Timestamp crttim) {
		this.crttim = crttim;
	}

	public String getCrtusr() {
		return this.crtusr;
	}

	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}

	public Timestamp getUpdtim() {
		return this.updtim;
	}

	public void setUpdtim(Timestamp updtim) {
		this.updtim = updtim;
	}

	public String getUpdusr() {
		return this.updusr;
	}

	public void setUpdusr(String updusr) {
		this.updusr = updusr;
	}

	public void copy(TrnAccess target) {
		this.mstUser = target.mstUser;
		this.trnMid = target.trnMid;
		this.compltime = target.compltime;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;
		
	}

}