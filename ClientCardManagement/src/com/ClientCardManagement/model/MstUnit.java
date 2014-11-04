package com.ClientCardManagement.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * MstUnit entity. @author MyEclipse Persistence Tools
 */

public class MstUnit implements java.io.Serializable {

	// Fields

	private Long unitid;
	private String unitnam;
	private Boolean sharekub;
	private Short orderdis;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;
	private Set mstUnitUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public MstUnit() {
	}

	/** minimal constructor */
	public MstUnit(String unitnam, Boolean sharekub, Short orderdis,
			String crtusr, String updusr) {
		this.unitnam = unitnam;
		this.sharekub = sharekub;
		this.orderdis = orderdis;
		this.crtusr = crtusr;
		this.updusr = updusr;
	}

	/** full constructor */
	public MstUnit(String unitnam, Boolean sharekub, Short orderdis,
			Timestamp crttim, String crtusr, Timestamp updtim, String updusr,
			Set mstUnitUsers) {
		this.unitnam = unitnam;
		this.sharekub = sharekub;
		this.orderdis = orderdis;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
		this.mstUnitUsers = mstUnitUsers;
	}

	// Property accessors

	public Long getUnitid() {
		return this.unitid;
	}

	public void setUnitid(Long unitid) {
		this.unitid = unitid;
	}

	public String getUnitnam() {
		return this.unitnam;
	}

	public void setUnitnam(String unitnam) {
		this.unitnam = unitnam;
	}

	public Boolean getSharekub() {
		return this.sharekub;
	}

	public void setSharekub(Boolean sharekub) {
		this.sharekub = sharekub;
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

	public Set getMstUnitUsers() {
		return this.mstUnitUsers;
	}

	public void setMstUnitUsers(Set mstUnitUsers) {
		this.mstUnitUsers = mstUnitUsers;
	}

}