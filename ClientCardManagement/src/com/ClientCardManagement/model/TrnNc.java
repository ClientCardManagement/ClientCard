package com.ClientCardManagement.model;

import java.sql.Timestamp;

/**
 * TrnNc entity. @author MyEclipse Persistence Tools
 */

public class TrnNc implements java.io.Serializable {

	// Fields

	private Long id;
	private TrnMid trnMid;
	private String busflg;
	private String comjnam;
	private String comenam;
	private String comjnamkn;
	private String postnam;
	private String offposi;
	private String firstnam;
	private String secdnam;
	private String firstnamkn;
	private String secdnamkn;
	private String postalnum1;
	private String adsadmindiv1;
	private String adstown1;
	private String adsstrtnum1;
	private String adsbuild1;
	private String telfist1;
	private String telsecd1;
	private String fax1;
	private String mobiletel1;
	private String email1;
	private String url1;
	private String postalnum2;
	private String adsadmindiv2;
	private String adstown2;
	private String adsstrtnum2;
	private String adsbuild2;
	private String telfist2;
	private String telsecd2;
	private String fax2;
	private String mobiletel2;
	private String email2;
	private String url2;
	private Short imptantkub;
	private String jobkub;
	private String relationkub;
	private Integer precision;
	private String sexkub;
	private String blodkub;
	private String birthdayy;
	private String birthdaym;
	private String birthdayd;
	private String memo;
	private Timestamp crttim;
	private String crtusr;
	private Timestamp updtim;
	private String updusr;
	private String bustypnam;
	private String fondym;
	private Integer capital;
	private Integer emplonum;
	private String bondcode;
	private String reptannam;

	// Constructors

	/** default constructor */
	public TrnNc() {
	}

	/** minimal constructor */
	public TrnNc(TrnMid trnMid, String busflg, String comjnam, String firstnam,
			String secdnam, String crtusr, String updusr) {
		this.trnMid = trnMid;
		this.busflg = busflg;
		this.comjnam = comjnam;
		this.firstnam = firstnam;
		this.secdnam = secdnam;
		this.crtusr = crtusr;
		this.updusr = updusr;
	}

	/** full constructor */
	public TrnNc(TrnMid trnMid, String busflg, String comjnam, String comenam,
			String comjnamkn, String postnam, String offposi, String firstnam,
			String secdnam, String firstnamkn, String secdnamkn,
			String postalnum1, String adsadmindiv1, String adstown1,
			String adsstrtnum1, String adsbuild1, String telfist1,
			String telsecd1, String fax1, String mobiletel1, String email1,
			String url1, String postalnum2, String adsadmindiv2,
			String adstown2, String adsstrtnum2, String adsbuild2,
			String telfist2, String telsecd2, String fax2, String mobiletel2,
			String email2, String url2, Short imptantkub, String jobkub,
			String relationkub, Integer precision, String sexkub,
			String blodkub, String birthdayy, String birthdaym,
			String birthdayd, String memo, Timestamp crttim, String crtusr,
			Timestamp updtim, String updusr, String bustypnam, String fondym,
			Integer capital, Integer emplonum, String bondcode, String reptannam) {
		this.trnMid = trnMid;
		this.busflg = busflg;
		this.comjnam = comjnam;
		this.comenam = comenam;
		this.comjnamkn = comjnamkn;
		this.postnam = postnam;
		this.offposi = offposi;
		this.firstnam = firstnam;
		this.secdnam = secdnam;
		this.firstnamkn = firstnamkn;
		this.secdnamkn = secdnamkn;
		this.postalnum1 = postalnum1;
		this.adsadmindiv1 = adsadmindiv1;
		this.adstown1 = adstown1;
		this.adsstrtnum1 = adsstrtnum1;
		this.adsbuild1 = adsbuild1;
		this.telfist1 = telfist1;
		this.telsecd1 = telsecd1;
		this.fax1 = fax1;
		this.mobiletel1 = mobiletel1;
		this.email1 = email1;
		this.url1 = url1;
		this.postalnum2 = postalnum2;
		this.adsadmindiv2 = adsadmindiv2;
		this.adstown2 = adstown2;
		this.adsstrtnum2 = adsstrtnum2;
		this.adsbuild2 = adsbuild2;
		this.telfist2 = telfist2;
		this.telsecd2 = telsecd2;
		this.fax2 = fax2;
		this.mobiletel2 = mobiletel2;
		this.email2 = email2;
		this.url2 = url2;
		this.imptantkub = imptantkub;
		this.jobkub = jobkub;
		this.relationkub = relationkub;
		this.precision = precision;
		this.sexkub = sexkub;
		this.blodkub = blodkub;
		this.birthdayy = birthdayy;
		this.birthdaym = birthdaym;
		this.birthdayd = birthdayd;
		this.memo = memo;
		this.crttim = crttim;
		this.crtusr = crtusr;
		this.updtim = updtim;
		this.updusr = updusr;
		this.bustypnam = bustypnam;
		this.fondym = fondym;
		this.capital = capital;
		this.emplonum = emplonum;
		this.bondcode = bondcode;
		this.reptannam = reptannam;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrnMid getTrnMid() {
		return this.trnMid;
	}

	public void setTrnMid(TrnMid trnMid) {
		this.trnMid = trnMid;
	}

	public String getBusflg() {
		return this.busflg;
	}

	public void setBusflg(String busflg) {
		this.busflg = busflg;
	}

	public String getComjnam() {
		return this.comjnam;
	}

	public void setComjnam(String comjnam) {
		this.comjnam = comjnam;
	}

	public String getComenam() {
		return this.comenam;
	}

	public void setComenam(String comenam) {
		this.comenam = comenam;
	}

	public String getComjnamkn() {
		return this.comjnamkn;
	}

	public void setComjnamkn(String comjnamkn) {
		this.comjnamkn = comjnamkn;
	}

	public String getPostnam() {
		return this.postnam;
	}

	public void setPostnam(String postnam) {
		this.postnam = postnam;
	}

	public String getOffposi() {
		return this.offposi;
	}

	public void setOffposi(String offposi) {
		this.offposi = offposi;
	}

	public String getFirstnam() {
		return this.firstnam;
	}

	public void setFirstnam(String firstnam) {
		this.firstnam = firstnam;
	}

	public String getSecdnam() {
		return this.secdnam;
	}

	public void setSecdnam(String secdnam) {
		this.secdnam = secdnam;
	}

	public String getFirstnamkn() {
		return this.firstnamkn;
	}

	public void setFirstnamkn(String firstnamkn) {
		this.firstnamkn = firstnamkn;
	}

	public String getSecdnamkn() {
		return this.secdnamkn;
	}

	public void setSecdnamkn(String secdnamkn) {
		this.secdnamkn = secdnamkn;
	}

	public String getPostalnum1() {
		return this.postalnum1;
	}

	public void setPostalnum1(String postalnum1) {
		this.postalnum1 = postalnum1;
	}

	public String getAdsadmindiv1() {
		return this.adsadmindiv1;
	}

	public void setAdsadmindiv1(String adsadmindiv1) {
		this.adsadmindiv1 = adsadmindiv1;
	}

	public String getAdstown1() {
		return this.adstown1;
	}

	public void setAdstown1(String adstown1) {
		this.adstown1 = adstown1;
	}

	public String getAdsstrtnum1() {
		return this.adsstrtnum1;
	}

	public void setAdsstrtnum1(String adsstrtnum1) {
		this.adsstrtnum1 = adsstrtnum1;
	}

	public String getAdsbuild1() {
		return this.adsbuild1;
	}

	public void setAdsbuild1(String adsbuild1) {
		this.adsbuild1 = adsbuild1;
	}

	public String getTelfist1() {
		return this.telfist1;
	}

	public void setTelfist1(String telfist1) {
		this.telfist1 = telfist1;
	}

	public String getTelsecd1() {
		return this.telsecd1;
	}

	public void setTelsecd1(String telsecd1) {
		this.telsecd1 = telsecd1;
	}

	public String getFax1() {
		return this.fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getMobiletel1() {
		return this.mobiletel1;
	}

	public void setMobiletel1(String mobiletel1) {
		this.mobiletel1 = mobiletel1;
	}

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getUrl1() {
		return this.url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getPostalnum2() {
		return this.postalnum2;
	}

	public void setPostalnum2(String postalnum2) {
		this.postalnum2 = postalnum2;
	}

	public String getAdsadmindiv2() {
		return this.adsadmindiv2;
	}

	public void setAdsadmindiv2(String adsadmindiv2) {
		this.adsadmindiv2 = adsadmindiv2;
	}

	public String getAdstown2() {
		return this.adstown2;
	}

	public void setAdstown2(String adstown2) {
		this.adstown2 = adstown2;
	}

	public String getAdsstrtnum2() {
		return this.adsstrtnum2;
	}

	public void setAdsstrtnum2(String adsstrtnum2) {
		this.adsstrtnum2 = adsstrtnum2;
	}

	public String getAdsbuild2() {
		return this.adsbuild2;
	}

	public void setAdsbuild2(String adsbuild2) {
		this.adsbuild2 = adsbuild2;
	}

	public String getTelfist2() {
		return this.telfist2;
	}

	public void setTelfist2(String telfist2) {
		this.telfist2 = telfist2;
	}

	public String getTelsecd2() {
		return this.telsecd2;
	}

	public void setTelsecd2(String telsecd2) {
		this.telsecd2 = telsecd2;
	}

	public String getFax2() {
		return this.fax2;
	}

	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}

	public String getMobiletel2() {
		return this.mobiletel2;
	}

	public void setMobiletel2(String mobiletel2) {
		this.mobiletel2 = mobiletel2;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getUrl2() {
		return this.url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public Short getImptantkub() {
		return this.imptantkub;
	}

	public void setImptantkub(Short imptantkub) {
		this.imptantkub = imptantkub;
	}

	public String getJobkub() {
		return this.jobkub;
	}

	public void setJobkub(String jobkub) {
		this.jobkub = jobkub;
	}

	public String getRelationkub() {
		return this.relationkub;
	}

	public void setRelationkub(String relationkub) {
		this.relationkub = relationkub;
	}

	public Integer getPrecision() {
		return this.precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public String getSexkub() {
		return this.sexkub;
	}

	public void setSexkub(String sexkub) {
		this.sexkub = sexkub;
	}

	public String getBlodkub() {
		return this.blodkub;
	}

	public void setBlodkub(String blodkub) {
		this.blodkub = blodkub;
	}

	public String getBirthdayy() {
		return this.birthdayy;
	}

	public void setBirthdayy(String birthdayy) {
		this.birthdayy = birthdayy;
	}

	public String getBirthdaym() {
		return this.birthdaym;
	}

	public void setBirthdaym(String birthdaym) {
		this.birthdaym = birthdaym;
	}

	public String getBirthdayd() {
		return this.birthdayd;
	}

	public void setBirthdayd(String birthdayd) {
		this.birthdayd = birthdayd;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getBustypnam() {
		return this.bustypnam;
	}

	public void setBustypnam(String bustypnam) {
		this.bustypnam = bustypnam;
	}

	public String getFondym() {
		return this.fondym;
	}

	public void setFondym(String fondym) {
		this.fondym = fondym;
	}

	public Integer getCapital() {
		return this.capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public Integer getEmplonum() {
		return this.emplonum;
	}

	public void setEmplonum(Integer emplonum) {
		this.emplonum = emplonum;
	}

	public String getBondcode() {
		return this.bondcode;
	}

	public void setBondcode(String bondcode) {
		this.bondcode = bondcode;
	}

	public String getReptannam() {
		return this.reptannam;
	}

	public void setReptannam(String reptannam) {
		this.reptannam = reptannam;
	}
	public String toString(){
		String result = "trnMid:"+trnMid+ "\tBUSFLG:"+busflg+"\tCOMJNAM:"+comjnam
		+"\tCOMENAM:"+comenam+"\tCOMJNAMKN:" +"POSTNAM,"+postnam+ "\nOFFPOSI,"+offposi+"\tFIRSTNAM,"
		+"\tSECDNAM,"+secdnam+"\tFIRSTNAMKN,"+firstnamkn+ "\tSECDNAMKN,"+secdnamkn+ "\nPOSTALNUM1,"+postalnum1
		+ "\tADSADMINDIV1:"+adsadmindiv1+ "\tADSTOWN1,"+adstown1 
		+"\nADSSTRTNUM1:"+ adsstrtnum1+"\tADSBUILD1:"+ adsbuild1+"\tTELFIST1,"+ telfist1+"\tTELSECD1," +telsecd1
		+"\nFAX1," + fax1+"MOBILETEL1,"+mobiletel1 +"\nEMAIL1:"+email1+ "\tURL1,"+url1+ "\tPOSTALNUM2,"+postalnum2
		+ "\nADSADMINDIV2,"+adsadmindiv2+ "\tADSTOWN2,"+adstown2+ "\tADSSTRTNUM2,"+adsstrtnum2 
		+"\nADSBUILD2:"+adsbuild2+ "\tTELFIST2:"+telfist2+ "\tTELSECD2,"+telsecd2+ "FAX2,"+fax2
		+ "\nMOBILETEL2,"+mobiletel2+  "EMAIL2," +email2+ "\tURL2,"+url2 
		+"\nIMPTANTKUB:"+imptantkub+ "\tJOBKUB:"+jobkub+ "\tRELATIONKUB:"+relationkub+ "\tPRECISION," 
		+precision+"\nSEXKUB:" +sexkub+"\tBLODKUB,"+blodkub +"\tBIRTHDAYY,"+birthdayy 
		+"\nBIRTHDAYM:"+birthdaym+ "\tBIRTHDAYD:"+ birthdayd+"\tMEMO:"+memo+ "\tCRTTIM:"+ crttim+"\tCRTUSR:"
		+ crtusr+"\tUPDTIM:"+updtim+ "\nUPDUSR,"+ updusr+"\tBUSTYPNAM,"+ bustypnam+"\tFONDYM,"+fondym
		+"\nCAPITAL:"+capital+ "\tEMPLONUM:"+emplonum+ "\tBONDCODE:"+bondcode +"\tREPTANNAM:"+reptannam;
		return result;
	}

	public void copy(TrnNc target) {
		// TODO Auto-generated method stub
		this.busflg = target.busflg;
		this.comjnam = target.comjnam;
		this.comenam = target.comenam;
		this.comjnamkn = target.comjnamkn;
		this.postnam = target.postnam;
		this.offposi = target.offposi;
		this.firstnam = target.firstnam;
		this.secdnam = target.secdnam;
		this.firstnamkn = target.firstnamkn;
		this.secdnamkn = target.secdnamkn;
		this.postalnum1 = target.postalnum1;
		this.adsadmindiv1 = target.adsadmindiv1;
		this.adstown1 = target.adstown1;
		this.adsstrtnum1 = target.adsstrtnum1;
		this.adsbuild1 = target.adsbuild1;
		this.telfist1 = target.telfist1;
		this.telsecd1 = target.telsecd1;
		this.fax1 = target.fax1;
		this.mobiletel1 = target.mobiletel1;
		this.email1 = target.email1;
		this.url1 = target.url1;
		this.postalnum2 = target.postalnum2;
		this.adsadmindiv2 = target.adsadmindiv2;
		this.adstown2 = target.adstown2;
		this.adsstrtnum2 = target.adsstrtnum2;
		this.adsbuild2 = target.adsbuild2;
		this.telfist2 = target.telfist2;
		this.telsecd2 = target.telsecd2;
		this.fax2 = target.fax2;
		this.mobiletel2 = target.mobiletel2;
		this.email2 = target.email2;
		this.url2 = target.url2;
		this.imptantkub = target.imptantkub;
		this.jobkub = target.jobkub;
		this.relationkub = target.relationkub;
		this.precision = target.precision;
		this.sexkub = target.sexkub;
		this.blodkub = target.blodkub;
		this.birthdayy = target.birthdayy;
		this.birthdaym = target.birthdaym;
		this.birthdayd = target.birthdayd;
		this.memo = target.memo;
		this.crttim = target.crttim;
		this.crtusr = target.crtusr;
		this.updtim = target.updtim;
		this.updusr = target.updusr;
		this.bustypnam = target.bustypnam;
		this.fondym = target.fondym;
		this.capital = target.capital;
		this.emplonum = target.emplonum;
		this.bondcode = target.bondcode;
		this.reptannam = target.reptannam;
	}
}