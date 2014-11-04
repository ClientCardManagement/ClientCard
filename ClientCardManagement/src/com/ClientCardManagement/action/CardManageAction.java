package com.ClientCardManagement.action;

import java.util.ArrayList;
import java.util.Map;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.QueryService;
import com.ClientCardManagement.service.UserService;

import com.ClientCardManagement.service.TrnNcService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class CardManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private TrnNcService service;
	@Resource
	private QueryService queryService;
	@Resource
	private UserService userService;
	private List<TrnNc> targetList;
	private List<TrnGroup> groupList;
	private List<MstUser> userList;

	public List<TrnGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<TrnGroup> groupList) {
		this.groupList = groupList;
	}

	private TrnNc target;
	private String idsString;

	public String getIdsString() {
		return idsString;
	}

	public void setIdsString(String idsString) {
		this.idsString = idsString;
	}

	private String navTabId = "list";
	private String callbackType = "closeCurrent";
	private String forwardUrl = "";
	private String statusCode = "200";
	private String uid;
	private Long totalCount;
	private int numPerPage = 20;
	private int pageNumShown = 7;
	private int currentPage;
	private int pageNum = 1;// dwz分页使用
	private String isSearchFlag = "false";
	private String comjnam;
	private String depart;
	private String name;

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getIsSearchFlag() {
		return isSearchFlag;
	}

	public void setIsSearchFlag(String isSearchFlag) {
		this.isSearchFlag = isSearchFlag;
	}

	public String getComjnam() {
		return comjnam;
	}

	public void setComjnam(String comjnam) {
		this.comjnam = comjnam;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public List<TrnNc> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<TrnNc> targetList) {
		this.targetList = targetList;
	}

	public TrnNc getTarget() {
		return target;
	}

	public void setTarget(TrnNc target) {
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

	public String search() {
		isSearchFlag = "true";
		if (comjnam != null && !comjnam.equals("")) {
			comjnam = comjnam.trim();
		}
		if (name != null && !name.equals("")) {
			name = name.trim();
		}
		// totalCount = service.totalSearchNum(comjnam, name);
		// targetList = service.search(comjnam, name, (pageNum - 1) *
		// numPerPage,
		// numPerPage);
		query();
		return SUCCESS;
	}

	public void query() {

		List values = new ArrayList();
		// System.out.println(comjnam+" - "+depart+" - "+name);
		String hql = "from TrnNc as tn where tn.trnMid.sharekub = 0 and tn.comjnam like ?";
		if (comjnam != null) {
			comjnam = comjnam.trim();
		}
		values.add("%" + comjnam + "%");
		if (depart != null && !depart.equals("")) {
			depart = depart.trim();
			hql += " and postnam like ? ";
			values.add("%" + depart + "%");
		}
		if (name != null && !name.equals("")) {
			name = name.trim();
			hql += " and ( tn.firstnam like ? and tn.secdnam like  ? )";
			// hql += " and tn.secdnam like  ? ";
			values.add("[" + name + "]%");
			values.add("%[" + name + "]");
		}
		String order = " order by tn.comjnam, tn.firstnam, tn.secdnam,tn.id desc";
		String numHql = "select count(*) " + hql;
		hql += order;
		targetList = queryService.query(hql, values,
				(pageNum - 1) * numPerPage, numPerPage);
		totalCount = queryService.queryNum(numHql, values);
	}

	public String getCardById() {
		TrnNc o = service.get(uid);
		totalCount = 1L;
		targetList = new ArrayList<TrnNc>();
		targetList.add(o);
		return SUCCESS;
	}

	public String getList() {
		isSearchFlag = "false";
		if (totalCount == null) {
			totalCount = service.totalNum();
		}

		targetList = service.getList((pageNum - 1) * numPerPage, numPerPage);
		return SUCCESS;
	}

	public String getCardByIds() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		// System.out.println("ids:"+idsString);
		String[] ids = idsString.split(",");
		targetList = new ArrayList<TrnNc>();
		for (String id : ids) {
			TrnNc o = service.get(id);
			targetList.add(o);
		}
		
		return SUCCESS;

	}
	/*
	 * public void fillUserListWithTrnNcList(){ userList = new
	 * ArrayList<MstUser>(); TrnMid m = null; for(TrnNc o :targetList){ m =
	 * o.getTrnMid(); if(m!=null){ userList.add(userService.get(m.getCrtusr()));
	 * } } }
	 */
}
