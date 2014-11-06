<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="resource/js/util.js" ></script>
<script type="text/javascript">
	
				$("#del").click( function(event) {
					var href = "card/DeleteTrnAccessAction";
					$this = $(this);
					$($this).removeAttr('href');
					var ids = getIds("table_body");
					if (ids != "") {
						var getHref = href + "?idsString=" + ids;
						$($this).attr('href', getHref);
						alertMsg.confirm("确定要删除吗?", {

               			 okCall: function(){
								$.ajax({
									type:'POST',
									url:getHref,
									dataType:"json",
									cache: false,
									success: MyOwnFunction,
									error: DWZ.ajaxError
								});
               			 	}
						});

					}else{
						alertMsg.warn('请选择要删除的记录！');
						return false;
					}
					event.preventDefault();
				});
</script>
		
		
		<form id="pagerForm" method="post"
			action=<s:if test="'false'==isSearchFlag">
						"card/card/GetListTrnAccessAction"</s:if>
			<s:else>
					"card/VisitLogSearchAction?usernam=${usernam}&comjnam=${comjnam}&finam=${finam}&begintime=${begintime}&endtime=${endtime}"
				</s:else>>
			<input type="hidden" name="pageNum" value="1" />
			<input type="hidden" name="numPerPage" value="${numPerPage}" />
		</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="card/VisitLogSearchAction" method="post">
	<div class="searchBar">
		<ul class="searchContent">
		
			<li>
				<label>访问者姓名：</label>
				<input type="text" name="usernam" value="${usernam}" size="10" maxlength="8" />
			</li>
			<li>
				<label>公司名：</label>
				<input type="text" name="comjnam" value="${comjnam}" maxlength="20" />
			</li>
			<li>
				<label>名片姓名：</label>
				<input type="text"  name="finam" value="${firstnam}${secdnam}"  />
				
			</li>
			<li>
					<label>访问时间段：</label>
					<input type="text" name="begintime" size="10"
						class="date textInput valid" datefmt="yyyy-MM-dd"
						mindate="1980-01-01" maxdate="2120-12-31"
						value="${begintime}" readonly="readonly" />至
				
					<input type="text" name="endtime" size="10"
						class="date textInput valid" datefmt="yyyy-MM-dd"
						mindate="1980-01-01" maxdate="2120-12-31"
						value="${endtime}" readonly="readonly" />
					
				</li>
		</ul>
		
		<div class="subBar">
			<ul>
				
				<li><div class="buttonActive"><div class="buttonContent" id="search"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
		
		<div class="pageContent">
			<div class="panelBar">
				<ul class="toolBar">
					<li>
						<a class="delete" id="del"
							title="确定要删除吗?"><span>删除</span> </a>
						<input type="hidden"  name="idsString" id="idsString" />
					</li>
					<li class="line">
						line
					</li>

				</ul>
			</div>
			<div class="jbsxBox">
			<table class="table" width="100%" layoutH="140" >
				<thead>
					<tr>
					<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
						<th>
							访问时间
						</th>
						<th>
							公司名
						</th>
						<th>
							访问名片
						</th>
						<th>
							访问者姓名
						</th>
	
					</tr>
				</thead>
				<tbody id="table_body">
					<s:iterator value="targetList" status="st">
						<tr target="sid_user" rel="${id}">
						<td><input name="ids" value="${id }" type="checkbox"></td>
							<td>
								${compltime}
							</td>
							<td>
								${comjnam}
							</td>
							<td>
								${firstnam}${secdnam}
							</td>
							<td>
								${mstUser.usernam}
							</td>
						
						</tr>
					</s:iterator>

				</tbody>
			</table>
			</div>
			<div class="panelBar" >
				<div class="pages">
					<span>显示</span>
					<select class="combox" name="numPerPage" 
						onchange="navTabPageBreak({numPerPage:this.value})">
						<option value="20">
							20
						</option>
						<option value="50">
							50
						</option>
						<option value="100">
							100
						</option>
						<option value="200">
							200
						</option>
					</select>
					<span>条，共${totalCount}条</span>
				</div>
				

				<div class="pagination" totalCount="${totalCount}"
					numPerPage="${numPerPage}" pageNumShown="${pageNumShown}"
					currentPage="${pageNum}">
				</div>

			</div>
		</div>

