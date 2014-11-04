package com.ClientCardManagement.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.service.UserService;
import com.ClientCardManagement.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private UserService service;
	private List<MstUser> targetList;
	private MstUser target;

	private String navTabId;
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
	private String name;
	private String createTime;
	private String loginTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getIsSearchFlag() {
		return isSearchFlag;
	}

	public void setIsSearchFlag(String isSearchFlag) {
		this.isSearchFlag = isSearchFlag;
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

	public List<MstUser> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<MstUser> targetList) {
		this.targetList = targetList;
	}

	public MstUser getTarget() {
		return target;
	}

	public void setTarget(MstUser target) {
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
		if (uid != null && !uid.equals("")) {
			service.delete(uid);
		}
		navTabId = "";
		callbackType = "forward";
		return SUCCESS;
	}

	public String save() {
		if (uid == null || uid.equals("")) {
			service.save(target);
		} else {
			MstUser o = service.get(uid);
			o.copy(target);
			service.update(o);
		}
		callbackType = "closeCurrent";
		return SUCCESS;
	}

	public String modifyUserInfo() {
		MstUser o = service.get(uid);
		o.setUsernam(target.getUsernam());
		o.setPassword(target.getPassword());
		o.setMailads(target.getMailads());
		service.update(o);
		return SUCCESS;
	}

	public String getForm() {
		if (uid != null && !uid.equals("")) {
			target = service.get(uid);
		}
		return SUCCESS;
	}

	public String search() {
		isSearchFlag = "true";
		query();
		return SUCCESS;
	}

	public void query() {
		List values = new ArrayList();
		String hql = "from MstUser where  usernam like ? ";

		values.add("%" + name + "%");

		if (createTime != null && !createTime.equals("")) {
			Date start = Date.valueOf(createTime);
			Date startEnd = DateUtil.getNextDate(start);
			
			hql += " and crttim >= ? and crttim < ? ";
			values.add(start);
			values.add(startEnd);
		}
		if (loginTime != null && !loginTime.equals("")) {
			Date login = Date.valueOf(loginTime);
			Date loginEnd = DateUtil.getNextDate(login);
			
			hql += " and logintim >= ? and logintim < ?";
			values.add(login);
			values.add(loginEnd);
		}

		String order = " order by userid, crttim, updtim,logintim";
		String numHql = "select count(*) " + hql;
		hql += order;
		targetList = service.query(hql, values, (pageNum - 1) * numPerPage,
				numPerPage);
		totalCount = service.queryNum(numHql, values);
	}

	public String getList() {
		isSearchFlag = "false";
		if (totalCount == null) {
			totalCount = service.totalNum();
		}
		targetList = service.getList((pageNum - 1) * numPerPage, numPerPage);
		return SUCCESS;
	}
}
