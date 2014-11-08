<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>名片列表</title>
		<script type="text/javascript" src="resource/js/util.js"></script>
		<script type="text/javascript">
	function MyOwnFunction() {
		partRefresh("jbsxBoxZu", {}, "card/SearchTrnGroupNcAction?groupid="
				+ $('#groupid').val());
	}

	$("#del").click( function(event) {
		var href = "card/DeleteTrnGroupNcAction";
		$this = $(this);
		$($this).removeAttr('href');
		var ids = getIds("table_body_suo");
		if (ids != "") {
			var getHref = href + "?idsString=" + ids;
			$($this).attr('href', getHref);
			alertMsg.confirm("确定要删除吗?", {

				okCall : function() {
					$.ajax({
						type : 'POST',
						url : getHref,
						dataType : "json",
						cache : false,
						success : MyOwnFunction,
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
			action="card/SearchTrnGroupNcAction?groupid=${groupid}">
			<input type="hidden" name="pageNum" value="1" />
			<input type="hidden" name="numPerPage" value="${numPerPage}" />
		</form>

		<div class="pageContent"
			style="border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
			<div class="panelBar">

				<ul class="toolBar">

					<li>

						<a class="delete" id="del"><span>删除</span> </a>
						<input type="hidden" name="idsString" id="idsString" />
					</li>


					<li class="line">
						line
					</li>

				</ul>
			</div>
			<table class="table" width="99%" layoutH="240" rel="jbsxBoxZu">

				<thead>
					<tr>
						<th width="30px">
							<center>
								<input type="checkbox" group="ids" class="checkboxCtrl">
							</center>
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
				<tbody id="table_body_suo">
					<s:iterator value="trnNcList" status="st">
						<tr target="sid_user" rel="${sid}">
							<td width="30px">
								<center>
									<input class="ids" name="ids" type="checkbox" value="${id}" />
								</center>
							</td>
							<td width="40px">
								<center>
									<a href="mycard/ViewMyCardAction?uid=${sid}&isScanFlag=true"
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
						onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBoxZu')">
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

				<div class="pagination" rel="jbsxBoxZu" totalCount="${totalCount}"
					numPerPage="${numPerPage}" pageNumShown="${pageNumShown}"
					currentPage="${pageNum}">
				</div>

			</div>
		</div>
	</body>
</html>