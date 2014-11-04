package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * CmnMenu entity. @author MyEclipse Persistence Tools
 */

public class CmnMenu implements java.io.Serializable {

	// Fields

	private String meuid;
	private String meunam;
	private String prmenuid;
	private Boolean manmue;
	private Boolean dlpowset;
	private Boolean decdoset;
	private String url;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors

	/** default constructor */
	public CmnMenu() {
	}

	/** minimal constructor */
	public CmnMenu(Boolean manmue, Boolean dlpowset, Boolean decdoset,
			String crtusr, String updusr) {
		this.manmue = manmue;
		this.dlpowset = dlpowset;
		this.decdoset = decdoset;
		this.crtusr = crtusr;
		this.updusr = updusr;
	}

	/** full constructor */
	public CmnMenu(String meunam, String prmenuid, Boolean manmue,
			Boolean dlpowset, Boolean decdoset, String url, Timestamp crttim,
			String crtusr, Timestamp updtim, String updusr) {
		this.meunam = meunam;
		this.prmenuid = prmenuid;
		this.manmue = manmue;
		this.dlpowset = dlpowset;
		this.decdoset = decdoset;
		this.url = url;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	// Property accessors

	public String getMeuid() {
		return this.meuid;
	}

	public void setMeuid(String meuid) {
		this.meuid = meuid;
	}

	public String getMeunam() {
		return this.meunam;
	}

	public void setMeunam(String meunam) {
		this.meunam = meunam;
	}

	public String getPrmenuid() {
		return this.prmenuid;
	}

	public void setPrmenuid(String prmenuid) {
		this.prmenuid = prmenuid;
	}

	public Boolean getManmue() {
		return this.manmue;
	}

	public void setManmue(Boolean manmue) {
		this.manmue = manmue;
	}

	public Boolean getDlpowset() {
		return this.dlpowset;
	}

	public void setDlpowset(Boolean dlpowset) {
		this.dlpowset = dlpowset;
	}

	public Boolean getDecdoset() {
		return this.decdoset;
	}

	public void setDecdoset(Boolean decdoset) {
		this.decdoset = decdoset;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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