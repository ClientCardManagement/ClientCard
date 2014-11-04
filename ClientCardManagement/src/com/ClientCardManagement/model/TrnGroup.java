package com.ClientCardManagement.model;

import java.sql.Timestamp;


/**
 * TrnGroup entity. @author MyEclipse Persistence Tools
 */

public class TrnGroup implements java.io.Serializable {

	// Fields

	private Long groupid;
	private MstUser mstUser;
	private String groupnam;
	private Long prgroupid;
	private String groupnote;
	private String copid;
	private Boolean shareflg;
	private Integer orderdis;
	private Timestamp crttim;
	private Long crtusr;
	private Timestamp updtim;
	private String updusr;

	
	// Constructors

	/** default constructor */
	public TrnGroup() {
	}

	/** minimal constructor */
	public TrnGroup(MstUser mstUser, String groupnam, String copid,
			Boolean shareflg, Timestamp crttim, Long crtusr, Timestamp updtim,
			String updusr) {
		this.mstUser = mstUser;
		this.groupnam = groupnam;
		this.copid = copid;
		this.shareflg = shareflg;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	/** full constructor */
	public TrnGroup(MstUser mstUser, String groupnam, Long prgroupid,
			String groupnote, String copid, Boolean shareflg, Integer orderdis,
			Timestamp crttim, Long crtusr, Timestamp updtim, String updusr) {
		this.mstUser = mstUser;
		this.groupnam = groupnam;
		this.prgroupid = prgroupid;
		this.groupnote = groupnote;
		this.copid = copid;
		this.shareflg = shareflg;
		this.orderdis = orderdis;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	// Property accessors

	public Long getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public MstUser getMstUser() {
		return this.mstUser;
	}

	public void setMstUser(MstUser mstUser) {
		this.mstUser = mstUser;
	}

	public String getGroupnam() {
		return this.groupnam;
	}

	public void setGroupnam(String groupnam) {
		this.groupnam = groupnam;
	}

	public Long getPrgroupid() {
		return this.prgroupid;
	}

	public void setPrgroupid(Long prgroupid) {
		this.prgroupid = prgroupid;
	}

	public String getGroupnote() {
		return this.groupnote;
	}

	public void setGroupnote(String groupnote) {
		this.groupnote = groupnote;
	}

	public String getCopid() {
		return this.copid;
	}

	public void setCopid(String copid) {
		this.copid = copid;
	}

	public Boolean getShareflg() {
		return this.shareflg;
	}

	public void setShareflg(Boolean shareflg) {
		this.shareflg = shareflg;
	}

	public Integer getOrderdis() {
		return this.orderdis;
	}

	public void setOrderdis(Integer orderdis) {
		this.orderdis = orderdis;
	}

	public Timestamp getCrttim() {
		return this.crttim;
	}

	public void setCrttim(Timestamp crttim) {
		this.crttim = crttim;
	}

	public Long getCrtusr() {
		return this.crtusr;
	}

	public void setCrtusr(Long crtusr) {
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

	public void copy(TrnGroup target) {
		// TODO Auto-generated method stub
		this.mstUser = target.mstUser;
		this.groupnam = target.groupnam;
		this.prgroupid = target.prgroupid;
		this.groupnote = target.groupnote;
		this.copid = target.copid;
		this.shareflg = target.shareflg;
		this.orderdis = target.orderdis;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;
	}
}