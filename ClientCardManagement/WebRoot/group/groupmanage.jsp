<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>test</title>
	</head>
	<body>
		<form id="pagerForm" method="post"
			action="group/GroupManageAction">
			<input type="hidden" name="pageNum" value="1" />
			<input type="hidden" name="numPerPage" value="${numPerPage}"/>
		</form>
			<div class="panelBar">

				<ul class="toolBar">
					<li><h1>所有组信息</h1></li>
					
					<li class="line">
						line
					</li>

				</ul>
			</div>
			<table class="table" width="100%" layoutH="180" rel="jbsxBoxZu">
				<thead>
					<tr>
						<th>
							组名
						</th>
						<th>
							表示顺序
						</th>
						<th>
							父组名
						</th>
						<th>
							组备考
						</th>
						<th>
							所有者
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="targetList" status="st">
						<tr target="sid_user" rel="${groupid}">
							<td>
								${groupnam}
							</td>
							<td>
								${orderdis}
							</td>
							<td>
								${prgroupid}
							</td>
							<td>
								${groupnote}
							</td>
							<td>
								${mstUser.usernam}
							</td>
						
						</tr>
					</s:iterator>

				</tbody>
			</table>
			<div class="panelBar" >
				<div class="pages">
					<span>显示</span>
					<select class="combox" name="numPerPage" 
						onchange="navTabPageBreak({numPerPage:this.value},'jbsxBoxZu')">
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
					<span>条，共${totalCount}条</span>
				</div>
				

				<div class="pagination" rel="jbsxBoxZu"
					totalCount="${totalCount}" numPerPage="${numPerPage}"
					pageNumShown="${pageNumShown}" currentPage="${pageNum}"></div>

			</div>

	</body>
</html>