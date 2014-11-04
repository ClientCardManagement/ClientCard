package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * MstUnitUser entity. @author MyEclipse Persistence Tools
 */

public class MstUnitUser implements java.io.Serializable {

	// Fields

	private Long id;
	private MstUser mstUser;
	private MstUnit mstUnit;
	private Short orderdis;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors

	/** default constructor */
	public MstUnitUser() {
	}

	/** full constructor */
	public MstUnitUser(MstUser mstUser, MstUnit mstUnit, Short orderdis,
			Timestamp crttim, String crtusr, Timestamp updtim, String updusr) {
		this.mstUser = mstUser;
		this.mstUnit = mstUnit;
		this.orderdis = orderdis;
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

	public MstUnit getMstUnit() {
		return this.mstUnit;
	}

	public void setMstUnit(MstUnit mstUnit) {
		this.mstUnit = mstUnit;
	}

	public Short getOrderdis() {
		return this.orderdis;
	}

	public void setOrderdis(Short orderdis) {
		this.orderdis = orderdis;
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

}