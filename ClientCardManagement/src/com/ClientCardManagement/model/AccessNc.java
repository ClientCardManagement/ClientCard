package com.ClientCardManagement.model;

import java.sql.Timestamp;

public class AccessNc {
		private Long id;
		private	MstUser mstUser;
		private Timestamp compltime;
		private String comjnam;
		private String firstnam;
		private String secdnam;
		
		
		public AccessNc(){
			
		}
		public AccessNc(Long id, MstUser mstUser, Timestamp compltime,
				String comjnam, String firstnam, String secdnam) {
			super();
			this.id = id;
			this.mstUser = mstUser;
			this.compltime = compltime;
			this.comjnam = comjnam;
			this.firstnam = firstnam;
			this.secdnam = secdnam;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public MstUser getMstUser() {
			return mstUser;
		}
		public void setMstUser(MstUser mstUser) {
			this.mstUser = mstUser;
		}
		public Timestamp getCompltime() {
			return compltime;
		}
		public void setCompltime(Timestamp compltime) {
			this.compltime = compltime;
		}
		public String getComjnam() {
			return comjnam;
		}
		public void setComjnam(String comjnam) {
			this.comjnam = comjnam;
		}
		public String getFirstnam() {
			return firstnam;
		}
		public void setFirstnam(String firstnam) {
			this.firstnam = firstnam;
		}
		public String getSecdnam() {
			return secdnam;
		}
		public void setSecdnam(String secdnam) {
			this.secdnam = secdnam;
		}
}
