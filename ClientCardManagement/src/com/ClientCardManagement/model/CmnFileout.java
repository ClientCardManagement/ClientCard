package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * CmnFileout entity. @author MyEclipse Persistence Tools
 */

public class CmnFileout implements java.io.Serializable {

	// Fields

	private String outfomid;
	private String outfomnam;
	private Short orderdis;
	private Boolean defatviwflg;
	private String itmfilpas;
	private Boolean itmoutflg;
	private String knchgkub;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;

	// Constructors

	/** default constructor */
	public CmnFileout() {
	}

	/** minimal constructor */
	public CmnFileout(String outfomnam, Boolean defatviwflg, String itmfilpas,
			Boolean itmoutflg, Timestamp crttim, String crtusr,
			Timestamp updtim, String updusr) {
		this.outfomnam = outfomnam;
		this.defatviwflg = defatviwflg;
		this.itmfilpas = itmfilpas;
		this.itmoutflg = itmoutflg;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	/** full constructor */
	public CmnFileout(String outfomnam, Short orderdis, Boolean defatviwflg,
			String itmfilpas, Boolean itmoutflg, String knchgkub,
			Timestamp crttim, String crtusr, Timestamp updtim, String updusr) {
		this.outfomnam = outfomnam;
		this.orderdis = orderdis;
		this.defatviwflg = defatviwflg;
		this.itmfilpas = itmfilpas;
		this.itmoutflg = itmoutflg;
		this.knchgkub = knchgkub;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
	}

	// Property accessors

	public String getOutfomid() {
		return this.outfomid;
	}

	public void setOutfomid(String outfomid) {
		this.outfomid = outfomid;
	}

	public String getOutfomnam() {
		return this.outfomnam;
	}

	public void setOutfomnam(String outfomnam) {
		this.outfomnam = outfomnam;
	}

	public Short getOrderdis() {
		return this.orderdis;
	}

	public void setOrderdis(Short orderdis) {
		this.orderdis = orderdis;
	}

	public Boolean getDefatviwflg() {
		return this.defatviwflg;
	}

	public void setDefatviwflg(Boolean defatviwflg) {
		this.defatviwflg = defatviwflg;
	}

	public String getItmfilpas() {
		return this.itmfilpas;
	}

	public void setItmfilpas(String itmfilpas) {
		this.itmfilpas = itmfilpas;
	}

	public Boolean getItmoutflg() {
		return this.itmoutflg;
	}

	public void setItmoutflg(Boolean itmoutflg) {
		this.itmoutflg = itmoutflg;
	}

	public String getKnchgkub() {
		return this.knchgkub;
	}

	public void setKnchgkub(String knchgkub) {
		this.knchgkub = knchgkub;
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