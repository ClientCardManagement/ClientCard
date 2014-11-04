package com.ClientCardManagement.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * MstUser entity. @author MyEclipse Persistence Tools
 */

public class MstUser implements java.io.Serializable {

	// Fields

	private Long userid;
	private String usernam;
	private String password;
	private String uim;
	private String mailads;
	private Long defaultkey;
	private Integer logerrcnt;
	private Timestamp logintim;
	private String userkub;
	private String dwnlodauth;
	private Boolean userdecide;
	private Timestamp expirtndate;
	private Boolean delflg;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors
	public String toString() {
		return usernam;
	}

	/** default constructor */
	public MstUser() {
	}

	public MstUser(String usernam, String password, String uim, String mailads,
			Long defaultkey, Integer logerrcnt, Timestamp logintim,
			String userkub, String dwnlodauth, Boolean userdecide,
			Timestamp expirtndate, Boolean delflg, Timestamp crttim,
			String crtusr, Timestamp updtim, String updusr) {
		super();
		this.usernam = usernam;
		this.password = password;
		this.uim = uim;
		this.mailads = mailads;
		this.defaultkey = defaultkey;
		this.logerrcnt = logerrcnt;
		this.logintim = logintim;
		this.userkub = userkub;
		this.dwnlodauth = dwnlodauth;
		this.userdecide = userdecide;
		this.expirtndate = expirtndate;
		this.delflg = delflg;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsernam() {
		return usernam;
	}

	public void setUsernam(String usernam) {
		this.usernam = usernam;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUim() {
		return uim;
	}

	public void setUim(String uim) {
		this.uim = uim;
	}

	public String getMailads() {
		return mailads;
	}

	public void setMailads(String mailads) {
		this.mailads = mailads;
	}

	public Long getDefaultkey() {
		return defaultkey;
	}

	public void setDefaultkey(Long defaultkey) {
		this.defaultkey = defaultkey;
	}

	public Integer getLogerrcnt() {
		return logerrcnt;
	}

	public void setLogerrcnt(Integer logerrcnt) {
		this.logerrcnt = logerrcnt;
	}

	public Timestamp getLogintim() {
		return logintim;
	}

	public void setLogintim(Timestamp logintim) {
		this.logintim = logintim;
	}

	public String getUserkub() {
		return userkub;
	}

	public void setUserkub(String userkub) {
		this.userkub = userkub;
	}

	public String getDwnlodauth() {
		return dwnlodauth;
	}

	public void setDwnlodauth(String dwnlodauth) {
		this.dwnlodauth = dwnlodauth;
	}

	public Boolean getUserdecide() {
		return userdecide;
	}

	public void setUserdecide(Boolean userdecide) {
		this.userdecide = userdecide;
	}

	public Timestamp getExpirtndate() {
		return expirtndate;
	}

	public void setExpirtndate(Timestamp expirtndate) {
		this.expirtndate = expirtndate;
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

	public void copy(MstUser target) {

		this.usernam = target.usernam;
		this.password = target.password;
		this.uim = target.uim;
		this.mailads = target.mailads;
		this.defaultkey = target.defaultkey;
		this.logerrcnt = target.logerrcnt;
		this.logintim = target.logintim;
		this.userkub = target.userkub;
		this.dwnlodauth = target.dwnlodauth;
		this.userdecide = target.userdecide;
		this.expirtndate = target.expirtndate;
		this.delflg = target.delflg;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;
	}
	

}