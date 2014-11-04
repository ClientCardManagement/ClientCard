package com.ClientCardManagement.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.DepartNode;
import com.ClientCardManagement.model.DepartTree;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnAccess;
import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.CardService;

import com.ClientCardManagement.service.QueryService;
import com.ClientCardManagement.service.TrnMidService;
import com.ClientCardManagement.service.TrnNcService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class MyCardManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private TrnNcService trnNcService;
	@Resource
	private TrnMidService trnMidService;
	@Resource
	private CardService cardService;
	@Resource
	private QueryService queryService;
	private List<TrnNc> targetList;
	private TrnNc target;
	
	private TrnNc trnNc;
	private TrnMid trnMid;


	private String navTabId;
	private String callbackType = "closeCurrent";
	private String forwardUrl = "";
	private String statusCode = "200";
	private String uid;
	private Long totalCount;
	private int numPerPage = 20;
	private int pageNumShown = 10;
	private int currentPage;
	private int pageNum = 1;// dwz分页使用
	private String isSearchFlag="false";
	private String isScanFlag;
	private String comjnam;
	private String depart;
	private String name;
	private String username;
	private String idsString;

	public String getIdsString() {
		return idsString;
	}

	public void setIdsString(String idsString) {
		this.idsString = idsString;
	}

	private final List<String> imptantList 
		= Arrays.asList("==请选择==","非常重要","比较重要","一般重要","不重要");
	private final List<String> relationList
		= Arrays.asList("==请选择==","关键角色","合作伙伴","客户","供应商","交易方","支援方","承建商","合约预定人","家人",
						"同事","朋友","前辈/上司","后辈","外包方","协力方","其他");
	private final List<String> jobList 
		= Arrays.asList("==请选择==","营业","技术","宣传","创作","编辑","销售","事务人员","会计师","顾问","分析师","教职员","人事管理","市场","公务员","其他");
	private final List<String> monthList
		= Arrays.asList("==请选择==","1","2","3","4","5","6","7","8","9","10","11","12");
	
	private final List<String> dayList
	= Arrays.asList("==请选择==","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
			"24","25","26","27","28","29","30","31");
	
	private List<String> yearList = new ArrayList<String>(105);

	
	public MyCardManageAction() {
		super();
		// TODO Auto-generated constructor stub
		for(int i = 0; i < 105; i++){
			this.yearList.add(String.valueOf(i+1910));
		}
	}

	public String getIsScanFlag() {
		return isScanFlag;
	}

	public void setIsScanFlag(String isScanFlag) {
		this.isScanFlag = isScanFlag;
	}

	public List<String> getImptantList(){
		return this.imptantList;
	}
	
	public List<String> getRelationList(){
		return this.relationList;
	}
	
	public List<String> getJobList(){
		return this.jobList;
	}
	public List<String> getMonthList(){
		return this.monthList;
	}
	public List<String> getDayList(){
		return this.dayList;
	}
	public List<String> getYearList(){	
		return this.yearList;
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


	public String save(){
		
		if (uid == null || uid.equals("")) {
			cardService.save(trnMid, trnNc);
		} else {	
			TrnNc tn = trnNcService.get(uid);
			TrnMid tm = trnMidService.get(tn.getTrnMid().getMidid().toString());		
			tn.copy(trnNc);
			tm.copy(trnMid);
			trnMidService.update(tm);
			trnNcService.update(tn);
		}
		callbackType = "closeCurrent";
		navTabId = "我的名片";
		return SUCCESS;
	}

	public String delete() {
		
		if (idsString != null&&!idsString.equals("")) {
			String[] ids =  idsString.split(",");
			for(String id:ids){
				trnNcService.delete(id);
			}
		}
		navTabId = "";
		callbackType = "forward";
		return SUCCESS;
		
		
	}
	
	public String deleteA(){
		if (uid != null && !uid.equals("")) {
			trnNcService.delete(uid);
		}
		navTabId = "";
		callbackType = "forward";
		return SUCCESS;
	}
	
	public String search() {
		isSearchFlag = "true";
		if (comjnam != null && !comjnam.equals("")) {
			comjnam = comjnam.trim();
		}
		if(depart != null && !depart.equals("")){
			depart = depart.trim();
		}
		if (name != null && !name.equals("")) {
			name = name.trim();
		}
		query();
		return SUCCESS;
	}
	
	public void query() {
		ActionContext ctx = ActionContext.getContext();
		String userid = String.valueOf((ctx.getSession().get("userid")));
		List values = new ArrayList();
		String hql = "from TrnNc as tn where tn.trnMid.crtusr=?";
		values.add(userid);
		if (comjnam != null && !comjnam.equals("")) {
			comjnam = comjnam.trim();
			hql += "  and tn.comjnam like ?";
			values.add("%" + comjnam + "%");	
		}
		if (depart != null && !depart.equals("")) {
			depart = depart.trim();
			hql += " and postnam like ? ";
			values.add("%" + depart + "%");
		}
		if (name != null && !name.equals("")) {
			name = name.trim();
			hql += " and ( tn.firstnam like ? or tn.secdnam like ? )";
			values.add("[" + name + "]%");
			values.add("%[" + name + "]");
		}
		String order = " order by tn.comjnam, tn.firstnam, tn.secdnam,tn.id";
		String numHql = "select count(*) " + hql;
		hql += order;
		targetList = queryService.query(hql, values,
				(pageNum - 1) * numPerPage, numPerPage);
		totalCount = queryService.queryNum(numHql, values);
	}
	
	public String getForm() {
		
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		if (uid != null && !uid.equals("")) {

			target = trnNcService.get(uid);
			username = trnNcService.searchUsername(target.getTrnMid().getCrtusr());
		}
		return SUCCESS;
	}
	

	public String getCardById() {
		TrnNc o = trnNcService.get(uid);
		totalCount = 1L;
		targetList = new ArrayList<TrnNc>();
		targetList.add(o);
		return SUCCESS;
	}

	public String getMyList() {
		isSearchFlag = "false";
		if (totalCount == null) {
			totalCount = trnNcService.myTotalNum();
		}

		targetList = trnNcService.getMyList((pageNum - 1) * numPerPage, numPerPage);
		return SUCCESS;
	}

	
	public String redirect(){
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}
