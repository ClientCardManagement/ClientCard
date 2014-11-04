package com.ClientCardManagement.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TrnMid entity. @author MyEclipse Persistence Tools
 */

public class TrnMid implements java.io.Serializable {

	// Fields

	private Long midid;
	private String midfront;
	private String midback;
	private String busstatus;
	private Boolean midflg;
	private String owcopid;
	private String owuserid;
	private String sharekub;
	private Boolean owbusflg;
	private Long cotptcnt;
	private Long viwptcnt;
	private Boolean outputflg;
	private Short ippaternkub;
	private Short ipregoder;
	private Boolean ipnewflg;
	private Timestamp regtim;
	private Boolean delflg;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;
	

	// Constructors

	/** default constructor */
	public TrnMid() {
	}


	public TrnMid(String midfront, String midback, String busstatus,
			Boolean midflg, String owcopid, String owuserid, String sharekub,
			Boolean owbusflg, Long cotptcnt, Long viwptcnt, Boolean outputflg,
			Short ippaternkub, Short ipregoder, Boolean ipnewflg,
			Timestamp regtim, Boolean delflg, Timestamp crttim, String crtusr,
			Timestamp updtim, String updusr) {
		super();
		this.midfront = midfront;
		this.midback = midback;
		this.busstatus = busstatus;
		this.midflg = midflg;
		this.owcopid = owcopid;
		this.owuserid = owuserid;
		this.sharekub = sharekub;
		this.owbusflg = owbusflg;
		this.cotptcnt = cotptcnt;
		this.viwptcnt = viwptcnt;
		this.outputflg = outputflg;
		this.ippaternkub = ippaternkub;
		this.ipregoder = ipregoder;
		this.ipnewflg = ipnewflg;
		this.regtim = regtim;
		this.delflg = delflg;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}


	public Long getMidid() {
		return midid;
	}


	public void setMidid(Long midid) {
		this.midid = midid;
	}


	public String getMidfront() {
		return midfront;
	}


	public void setMidfront(String midfront) {
		this.midfront = midfront;
	}


	public String getMidback() {
		return midback;
	}


	public void setMidback(String midback) {
		this.midback = midback;
	}


	public String getBusstatus() {
		return busstatus;
	}


	public void setBusstatus(String busstatus) {
		this.busstatus = busstatus;
	}


	public Boolean getMidflg() {
		return midflg;
	}


	public void setMidflg(Boolean midflg) {
		this.midflg = midflg;
	}


	public String getOwcopid() {
		return owcopid;
	}


	public void setOwcopid(String owcopid) {
		this.owcopid = owcopid;
	}


	public String getOwuserid() {
		return owuserid;
	}


	public void setOwuserid(String owuserid) {
		this.owuserid = owuserid;
	}


	public String getSharekub() {
		return sharekub;
	}


	public void setSharekub(String sharekub) {
		this.sharekub = sharekub;
	}


	public Boolean getOwbusflg() {
		return owbusflg;
	}


	public void setOwbusflg(Boolean owbusflg) {
		this.owbusflg = owbusflg;
	}


	public Long getCotptcnt() {
		return cotptcnt;
	}


	public void setCotptcnt(Long cotptcnt) {
		this.cotptcnt = cotptcnt;
	}


	public Long getViwptcnt() {
		return viwptcnt;
	}


	public void setViwptcnt(Long viwptcnt) {
		this.viwptcnt = viwptcnt;
	}


	public Boolean getOutputflg() {
		return outputflg;
	}


	public void setOutputflg(Boolean outputflg) {
		this.outputflg = outputflg;
	}


	public Short getIppaternkub() {
		return ippaternkub;
	}


	public void setIppaternkub(Short ippaternkub) {
		this.ippaternkub = ippaternkub;
	}


	public Short getIpregoder() {
		return ipregoder;
	}


	public void setIpregoder(Short ipregoder) {
		this.ipregoder = ipregoder;
	}


	public Boolean getIpnewflg() {
		return ipnewflg;
	}


	public void setIpnewflg(Boolean ipnewflg) {
		this.ipnewflg = ipnewflg;
	}


	public Timestamp getRegtim() {
		return regtim;
	}


	public void setRegtim(Timestamp regtim) {
		this.regtim = regtim;
	}


	public Boolean getDelflg() {
		return delflg;
	}


	public void setDelflg(Boolean delflg) {
		this.delflg = delflg;
	}


	public Timestamp getCrttim() {
		return crttim;
	}


	public void setCrttim(Timestamp crttim) {
		this.crttim = crttim;
	}


	public String getCrtusr() {
		return crtusr;
	}


	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}


	public Timestamp getUpdtim() {
		return updtim;
	}


	public void setUpdtim(Timestamp updtim) {
		this.updtim = updtim;
	}


	public String getUpdusr() {
		return updusr;
	}


	public void setUpdusr(String updusr) {
		this.updusr = updusr;
	}
	
	public void copy(TrnMid target){
		this.midfront = target.midfront;
		this.midback = target.midback;
		this.busstatus = target.busstatus;
		this.midflg = target.midflg;
		this.owcopid = target.owcopid;
		this.owuserid = target.owuserid;
		this.sharekub = target.sharekub;
		this.owbusflg = target.owbusflg;
		this.cotptcnt = target.cotptcnt;
		this.viwptcnt = target.viwptcnt;
		this.outputflg = target.outputflg;
		this.ippaternkub = target.ippaternkub;
		this.ipregoder = target.ipregoder;
		this.ipnewflg = target.ipnewflg;
		this.regtim = target.regtim;
		this.delflg = target.delflg;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;	
	}

	
}