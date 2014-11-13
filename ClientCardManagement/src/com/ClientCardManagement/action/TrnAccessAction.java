package com.ClientCardManagement.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.AccessNc;
import com.ClientCardManagement.model.TrnAccess;
import com.ClientCardManagement.service.TrnAccessService;
import com.ClientCardManagement.util.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class TrnAccessAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private TrnAccessService service;
	private List<AccessNc> targetList;
	private TrnAccess target;	
	
	


	private String isSearchFlag = "false";
	private String usernam;
	private String comjnam;
	private String finam;
	private String scnam;
	private String begintime;
	private String endtime;
	private String idsString;


	
	public String getIdsString() {
		return idsString;
	}

	public void setIdsString(String idsString) {
		this.idsString = idsString;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getFinam() {
		return finam;
	}

	public void setFinam(String finam) {
		this.finam = finam;
	}

	public String getScnam() {
		return scnam;
	}

	public void setScnam(String scnam) {
		this.scnam = scnam;
	}

	public String getIsSearchFlag() {
		return isSearchFlag;
	}

	public void setIsSearchFlag(String isSearchFlag) {
		this.isSearchFlag = isSearchFlag;
	}

	public String getUsernam() {
		return usernam;
	}

	public void setUsernam(String usernam) {
		this.usernam = usernam;
	}

	public String getComjnam() {
		return comjnam;
	}

	public void setComjnam(String comjnam) {
		this.comjnam = comjnam;
	}

	private String navTabId = "list";
	private String callbackType = "closeCurrent";
	private String forwardUrl = "";
	private String statusCode = "200";
	private String uid;
	private Long totalCount;
	private int numPerPage = 20;
	private int pageNumShown = 10;
	private int currentPage;
	private int pageNum = 1;// dwz分页使用

	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPageNumShown() {
		return pageNumShown;
	}

	public void setPageNumShown(int pageNumShown) {
		this.pageNumShown = pageNumShown;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<AccessNc> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<AccessNc> targetList) {
		this.targetList = targetList;
	}

	public TrnAccess getTarget() {
		return target;
	}

	public void setTarget(TrnAccess target) {
		this.target = target;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String delete() {
		//System.out.println(idsString);
		if (idsString != null&&!idsString.equals("")) {
			String[] ids =  idsString.split(",");
			for(String id:ids){
				service.delete(id);
			}
		}
		navTabId = "";
		callbackType = "forward";
		return SUCCESS;
	}

	public String save() {
		if (uid == null || uid.equals("")) {
			service.save(target);
		} else {
			TrnAccess o = service.get(uid);
			o.copy(target);
			service.update(o);
		}
		callbackType = "closeCurrent";
		navTabId = "list";
		return SUCCESS;
	}

	public String getForm() {
		if (uid != null && !uid.equals("")) {
			target = service.get(uid);
		}
		return SUCCESS;
	}
	
	public String getList() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		
		if (totalCount == null) {
			totalCount = service.totalNum(((Long)session.get("userid")).toString());
		}
	
		targetList = service.getList(((Long)session.get("userid")).toString(),(pageNum - 1) * numPerPage,
				numPerPage );

		return SUCCESS;
	}
	
	public String search() {
		
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		
		isSearchFlag = "true";
		Date betime =null;
		Date entime =null;
		if (usernam != null && !usernam.equals("")) {
			usernam = usernam.trim();
		}
		if (begintime != null && !begintime.equals("")&&endtime != null && !endtime.equals("")) {
			betime=Date.valueOf(begintime);
			entime=DateUtil.getNextDate(Date.valueOf(endtime));
		}
		
		//System.out.println((((Long)session.get("userid")).toString())+"-"+usernam +"-"+"-"+comjnam+"-"+finam+"-"+scnam);
		//System.out.println("betime" + betime );
		//System.out.println("entime" + entime );
		totalCount = service.totalSearchNum(((Long)session.get("userid")).toString(),usernam,comjnam,finam,scnam,betime,entime);
		//System.out.println("totalCount" + totalCount );
		targetList = service.search(((Long)session.get("userid")).toString(),usernam,comjnam,finam,scnam,betime,entime, (pageNum - 1) * numPerPage,
				numPerPage);
		//System.out.println(targetList.get(0).getId()+targetList.get(0).getMstUser().getUsernam());
		return SUCCESS;
	}
}
