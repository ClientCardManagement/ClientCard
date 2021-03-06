<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>名片列表</title>
		<script type="text/javascript" src="resource/js/util.js"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<form id="pagerForm" method="post"
			action="card/SearchAllTrnGroupNcAction">
			<input type="hidden" name="pageNum" value="1" />
			<input type="hidden" name="numPerPage" value="${numPerPage}" />
		</form>
		<div class="pageContent"
			style="border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
			<div class="panelBar">

				<ul class="toolBar">
					<li><h1>组下所有名片</h1></li>
					
					<li class="line">
						line
					</li>

				</ul>
			</div>
			<table class="table" width="99%" layoutH="240" rel="jbsxBoxZu">

				<thead>
					<tr>
						
						<th>

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
				<tbody id="table_body">
					<s:iterator value="trnNcList" status="st">
						<tr target="sid_user" rel="${sid}">
							
							<td><center>
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