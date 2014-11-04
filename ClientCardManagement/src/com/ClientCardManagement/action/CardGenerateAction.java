package com.ClientCardManagement.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;

import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class CardGenerateAction extends ActionSupport {
	@Resource
	private CardService service;
	private TrnMid trnMid;
	private TrnNc trnNc;
	private String uid;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public TrnMid getTrnMid() {
		return trnMid;
	}
	public void setTrnMid(TrnMid trnMid) {
		this.trnMid = trnMid;
	}
	public TrnNc getTrnNc() {
		return trnNc;
	}
	public void setTrnNc(TrnNc trnNc) {
		this.trnNc = trnNc;
	}
	public String save(){
		if (uid == null || uid.equals("")) {
			service.save(trnMid, trnNc);
		} else {
			service.update(trnNc);
		}
		return SUCCESS;
	}
	
}
