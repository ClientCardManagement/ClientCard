<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>名片列表</title>
		<script type="text/javascript">
	function RefreshFunction() {
		partRefresh("myCardList", {}, "mycard/GetMyCardListAction");
	}

	$("#deleteAlot").click( function(event) {
		var href = "mycard/DeleteMyCardAction";
		$this = $(this);
		$($this).removeAttr('href');
		var ids = getIds("table_body_zhuge_1");

		if (ids != "") {
			var getHref = href + "?idsString=" + ids;
			$($this).attr('href', getHref);
			alertMsg.confirm("确定要删除吗?", {

				okCall : function() {
					$.ajax( {
						type : 'POST',
						url : getHref,
						dataType : "json",
						cache : false,
						success : RefreshFunction,
						error : DWZ.ajaxError
					});
				}
			});

		} else {
			alertMsg.warn('请选择要删除的记录！');
			return false;
		}
		event.preventDefault();
	});
	
</script>
	</head>
	<body>

		<form id="pagerForm" method="post"
			action=<s:if test="'false'==isSearchFlag">
						"mycard/GetMyCardListAction"</s:if>
			<s:else>
					"mycard/FuzzyCardSearchAction?comjnam=${comjnam}&depart=${depart}&name=${name}"
			</s:else>>
			<input type="hidden" name="pageNum" value="1" />
			<input type="hidden" name="numPerPage" value="${numPerPage}" />
		</form>
		<div class="pageContent"
			style="border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
			<div class="panelBar">

				<ul class="toolBar">

					<li>
						<a class="add" target="navTab" rel="名片生成"
							href="mycard/MyCardAction"> <span>添加名片</span> </a>
					</li>
					<li class="line">
						line
					</li>
					<li>
						<a target="navTab"
							href="mycard/GetFromMyCardAction?uid={sid_user}" class="edit"
							rel="修改名片"><span>修改名片</span> </a>
					</li>
					<li class="line">
						line
					</li>
					<li>
						<a class="delete" href="mycard/DeleteMyACardAction?uid={sid_user}"
							title="确定删除？" target="ajaxTodo" callback="RefreshFunction"> <span>删除名片</span> </a>
					</li>
					
					<li class="line">
						line
					</li>
					<li>
						<a id="deleteAlot" title="批量删除" class="delete" mask="true"
							href="card/GetCardByIdsAction" rel="add"><span>批量删除</span> </a>
							<input type="hidden" name="idsString" id="idsString" />
					</li>

				</ul>
			</div>
			<table class="table" width="99%" layoutH="240" rel="jbsxBox">
				<thead>
					<tr>
						<th width="30px">
							<input type="checkbox" group="ids" class="checkboxCtrl">
						</th>
						<th width="40px">
							
						</th>
						<th>
							公司名
						</th>
						<th>
							部门名
						</th>
						<th>
							职务
						</th>
						<th>
							姓名
						</th>
					</tr>
				</thead>

				<tbody id="table_body_zhuge_1">
					<s:iterator value="targetList" status="st">
						<tr target="sid_user" rel="${id}">
							<td width="30px">
								<center>
									<input class="ids" name="ids" type="checkbox" value="${id}" />
								</center>
							</td>
							<td width="40px">
								<center>
								<a href="mycard/ViewMyCardAction?uid=${id}&isScanFlag=true"
									target="navTab" title="名片详情" rel="名片详情"><img
										src="resource/img/card.gif" /> </a>
								</center>
							</td>
							<td>
								${comjnam}
							</td>
							<td>
								${postnam}
							</td>
							<td>
								${offposi}
							</td>
							<td>
								${firstnam}${secdnam}
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<div class="panelBar">
				<div class="pages">
					<span>显示</span>
					<select class="combox" name="numPerPage"
						onchange="navTabPageBreak({numPerPage:this.value}, 'myCardList')">
						<option value="20"
							<s:if test="'20'==numPerPage||20==numPerPage">
						selected="selected"</s:if>>
							20
						</option>
						<option value="50"
							<s:if test="'50'==numPerPage||50==numPerPage">
						selected="selected"</s:if>>
							50
						</option>
						<option value="100"
							<s:if test="'100'==numPerPage||100==numPerPage">
						selected="selected"</s:if>>
							100
						</option>
						<option value="200"
							<s:if test="'200'==numPerPage||200==numPerPage">
						selected="selected"</s:if>>
							200
						</option>
					</select>
					<span>条,</span><span>共${totalCount}条</span>
				</div>

				<div class="pagination" rel="myCardList" totalCount="${totalCount}"
					numPerPage="${numPerPage}" pageNumShown="${pageNumShown}"
					currentPage="${pageNum}">
				</div>

			</div>
		</div>
	</body>
</html>