package com.ClientCardManagement.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.GroupNc;
import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnGroupNc;
import com.ClientCardManagement.model.TrnMid;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.GroupManageService;
import com.ClientCardManagement.service.TrnGroupNcService;
import com.ClientCardManagement.service.TrnNcService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class TrnGroupNcAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private TrnGroupNcService service;
	@Resource
	private GroupManageService groupManageService;
	@Resource
	private TrnNcService trnNcService;
	private List<TrnGroupNc> targetList;
	private TrnGroupNc target;
	private String idsString;
	private String groupid;
	private List<GroupNc> trnNcList;

	public List<GroupNc> getTrnNcList() {
		return trnNcList;
	}

	public void setTrnNcList(List<GroupNc> trnNcList) {
		this.trnNcList = trnNcList;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getIdsString() {
		return idsString;
	}

	public void setIdsString(String idsString) {
		this.idsString = idsString;
	}

	private String navTabId="组管理";
	private String callbackType = "closeCurrent";
	private String forwardUrl = "";
	private String statusCode = "200";
	private String message;
	private String uid;
	private Long totalCount;
	private int numPerPage = 20;
	private int pageNumShown = 10;
	private int currentPage;
	private int pageNum = 1;// dwz分页使用

	public String getMessage() {
		return message;
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

	public List<TrnGroupNc> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<TrnGroupNc> targetList) {
		this.targetList = targetList;
	}

	public TrnGroupNc getTarget() {
		return target;
	}

	public void setTarget(TrnGroupNc target) {
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
		//System.out.println("111111");
		//System.out.println(idsString);
		if (idsString != null&&!idsString.equals("")) {
			String[] ids =  idsString.split(",");
			for(String id:ids){
				service.delete(id);
			}
		}
		callbackType = "forward";
		return SUCCESS;
	}

	public String save() {
		//System.out.println("ids"+idsString);
		String[] ids =  idsString.split(",");
		
		TrnGroup trnGroup = new TrnGroup();//外键是对象
		trnGroup = groupManageService.get(groupid);
		TrnMid trnMid = new TrnMid();
		trnNcList =service.searchGroupCard(Long.valueOf(trnGroup.getGroupid()));//得到该组下的所有名片
		
		boolean hasMid;
		
		
		for(String uid:ids){
			trnMid = trnNcService.get(uid).getTrnMid();
			//System.out.println("id"+trnMid.getMidid());
			hasMid = false;
			if(trnNcList.size()!=0){
				for(GroupNc tn : trnNcList){
					if(tn.getTrnMid().getMidid().equals(trnMid.getMidid())){
						hasMid = true;
					}
				}
			}
			if(!hasMid){
				TrnGroupNc o = new TrnGroupNc();
				
				o.setTrnMid(trnMid);
				o.setTrnGroup(trnGroup);
				service.save(o);	
				this.statusCode="200";
				this.message="追加成功！";
			}
		}
		callbackType = "closeCurrent";
		return SUCCESS;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getForm() {
		if (uid != null && !uid.equals("")) {
			target = service.get(uid);
		}
		return SUCCESS;
	}
	
	public String getList() {
		
		if (totalCount == null) {
			totalCount = service.totalNum();
		}
		targetList = service.getList((pageNum - 1) * numPerPage,
				numPerPage);
	
		return SUCCESS;
	}

	public String searchGroupCard() {
		
		//System.out.println(groupid);
		if(totalCount == null){
			totalCount = service.searchGroupCardNum(Long.valueOf(groupid));
		}
		trnNcList = service.searchGroupCard(Long.valueOf(groupid),(pageNum - 1) * numPerPage,
					numPerPage);
		
		return SUCCESS;
	}
	
	public String searchAllGroupCard() {
		
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		List<TrnGroup> trnGroupList = groupManageService.getList(((Long)session.get("userid")).toString());
		List<GroupNc> trnnclist;
		trnNcList = new ArrayList<GroupNc>();
		totalCount=0L;
		//System.out.println("--trnGroupList.size---"+trnGroupList.size());
		for(TrnGroup trnGroup : trnGroupList){
			
			Long totalcount = service.searchGroupCardNum(Long.valueOf(trnGroup.getGroupid()));
			if(totalcount == 0){
				totalCount += totalcount;
			}else{
				totalCount += totalcount;
				trnnclist =service.searchGroupCard(Long.valueOf(trnGroup.getGroupid()));
				//System.out.println(".trnNcList.size..."+trnnclist.size());

				trnNcList.addAll(trnnclist);
				//System.out.println(".trnNcList.size..."+trnNcList.size());	
			}
		}
		//System.out.println("页数"+pageNum );
		//System.out.println("页数2"+numPerPage);
		if(pageNum*numPerPage < trnNcList.size())
			trnNcList = trnNcList.subList((pageNum - 1) * numPerPage,pageNum*numPerPage);
		else
			trnNcList = trnNcList.subList((pageNum - 1) * numPerPage,trnNcList.size());
		return SUCCESS;
	}
	
}
