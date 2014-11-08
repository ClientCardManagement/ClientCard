package com.ClientCardManagement.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ClientCardManagement.model.GroupNc;
import com.ClientCardManagement.model.MstUser;
import com.ClientCardManagement.model.TrnGroup;
import com.ClientCardManagement.model.TrnNc;
import com.ClientCardManagement.service.GroupManageService;
import com.ClientCardManagement.service.TrnGroupNcService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class GroupManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6473149793260653311L;
	@Resource
	private GroupManageService service;
	@Resource
	private TrnGroupNcService trnGroupNcService;
	private List<TrnGroup> targetList;
	private List<TrnGroup> targetPra;
	private List<TrnGroup> targetChi;
	private TrnGroup target;

	private String navTabId="组管理";
	private String callbackType = "closeCurrent";
	private String forwardUrl = "";
	private String message;
	
	private String statusCode = "200";
	private String uid;
	private Long totalCount;
	private int numPerPage = 20;
	private int pageNumShown = 7;
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

	public List<TrnGroup> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<TrnGroup> targetList) {
		this.targetList = targetList;
	}

	public TrnGroup getTarget() {
		return target;
	}

	public void setTarget(TrnGroup target) {
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
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		boolean deleteable = true;


		//System.out.println(targetList.size());
		if (uid != null&&!uid.equals("")) {
			targetList = service.getList(((Long)session.get("userid")).toString());//
			for(TrnGroup tg : targetList){
				//System.out.println(tg.getPrgroupid());
				//System.out.println(uid);
				if(tg.getPrgroupid() != null){
					if(tg.getPrgroupid().toString().trim().equals(uid.trim())){
						deleteable = false;
						//System.out.println("no");
					}
				}
			}
			if(!deleteable){
				//System.out.println("组下有子组");
				this.statusCode="300";
				this.message = "当前组下有子组,不能删除";
			}else{
				List<GroupNc> trnNcList = trnGroupNcService.searchGroupCard(Long.valueOf(uid));
				if(trnNcList.size()!=0){
					deleteable = false;
					//System.out.println("组下有名片！");
					this.statusCode="300";
					this.message = "当前组下有名片,不能删除！";
				}
				
			}
			
		}
		if(deleteable){
			//System.out.println("ok");
			service.delete(uid);
			this.statusCode="200";
		}
		
		callbackType = "forward";
		return SUCCESS;
	}

	public String save() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		
		targetList = service.getList(((Long)session.get("userid")).toString());//为了得到组
		
		//System.out.println(session.get("userid"));
		MstUser mstUser = new MstUser();
		mstUser.setUserid((Long)session.get("userid"));
		target.setMstUser(mstUser);
		//System.out.println(target.getMstUser().getUserid());
		if(target.getPrgroupid()==0)
			target.setPrgroupid(null);
		if (uid == null || uid.equals("")) {		//保存组
			//System.out.println(target.getPrgroupid());
			boolean hasGroup = false;
			for(TrnGroup tg : targetList){
				if(tg.getGroupnam().equals(target.getGroupnam())){
					hasGroup = true;
					this.statusCode="300";
					this.message = "已存在该名称的组,请更改组名！";
				}
			}
			if(!hasGroup){
				service.save(target);
				this.statusCode="200";
				this.message = "添加成功！";
			}
		} else {									//更新组
			boolean hasGroupName = false;
			TrnGroup o = service.get(uid);
			o.copy(target);
			
			for(TrnGroup tg : targetList){
				
				if(!tg.getGroupid().equals(o.getGroupid()) && tg.getGroupnam().equals(o.getGroupnam())){
					hasGroupName = true;
					this.statusCode="300";
					this.message = "已存在该名称的组,请更改组名！";
				}
			}
			if(!hasGroupName){
				service.update(o);
				this.statusCode="200";
				this.message = "更新成功！";
			}
		}
		callbackType = "closeCurrent";
		return SUCCESS;
	}

	public String getForm() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		if (uid != null && !uid.equals("")) {
			target = service.get(uid);
		}
		

		targetList = service.getList(((Long)session.get("userid")).toString());//为了得到组

		//System.out.println(targetList.size());
		return SUCCESS;
	}
	
	public String getList() {
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		
		if (totalCount == null) {
			totalCount = service.totalNum(((Long)session.get("userid")).toString());
		}
		targetList = service.getList(((Long)session.get("userid")).toString(),(pageNum - 1) * numPerPage,
				numPerPage);
		
		targetPra = service.getPraList(((Long)session.get("userid")).toString());
		targetChi = service.getChiList(((Long)session.get("userid")).toString());
		return SUCCESS;
	}

	public List<TrnGroup> getTargetPra() {
		return targetPra;
	}

	public void setTargetPra(List<TrnGroup> targetPra) {
		this.targetPra = targetPra;
	}

	public List<TrnGroup> getTargetChi() {
		return targetChi;
	}

	public void setTargetChi(List<TrnGroup> targetChi) {
		this.targetChi = targetChi;
	}
	
}
