package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * TrnGroupNc entity. @author MyEclipse Persistence Tools
 */

public class TrnGroupNc implements java.io.Serializable {

	// Fields

	private Long id;
	private TrnGroup trnGroup;
	private TrnMid trnMid;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors

	/** default constructor */
	public TrnGroupNc() {
	}

	/** full constructor */
	public TrnGroupNc(TrnGroup trnGroup, TrnMid trnMid, Timestamp crttim,
			String crtusr, Timestamp updtim, String updusr) {
		this.trnGroup = trnGroup;
		this.trnMid = trnMid;
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

	public TrnGroup getTrnGroup() {
		return this.trnGroup;
	}

	public void setTrnGroup(TrnGroup trnGroup) {
		this.trnGroup = trnGroup;
	}

	public TrnMid getTrnMid() {
		return this.trnMid;
	}

	public void setTrnMid(TrnMid trnMid) {
		this.trnMid = trnMid;
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

	public void copy(TrnGroupNc target) {
		// TODO Auto-generated method stub
		this.trnGroup = target.trnGroup;
		this.trnMid = target.trnMid;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;
	}

}