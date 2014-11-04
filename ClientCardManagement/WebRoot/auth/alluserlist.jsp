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
			action=<s:if test="'false'==isSearchFlag">
									"auth/GetListUserAction"</s:if>
			<s:else>
								"auth/FuzzySearchAction?name=${name}&createTime=${createTime}&loginTime=${loginTime}"
							</s:else>>

			<input type="hidden" name="pageNum" />
			<input type="hidden" name="numPerPage" value="${numPerPage}" />
		</form>
		<div class="pageHeader">
			<form onsubmit="return navTabSearch(this);"
				action="auth/FuzzySearchAction" method="post">
				<div class="searchBar">

					<table class="searchContent">
						<tr>
							<td>
								用户名：
								<input id="name" type="text" name="name" value='${name}' />

							</td>
							<td>
								创建日期：
								<input type="text" name="createTime"
									class="date textInput valid readonly" datefmt="yyyy-MM-dd" readonly
									mindate="1980-01-01" maxdate="2120-12-31" value="${createTime}" />
							</td>
							<td>

							</td>
							<td>
								最后登录日期：
								<input type="text" name="loginTime" class="date textInput valid readonly"
									readonly datefmt="yyyy-MM-dd" mindate="1980-01-01" maxdate="2120-12-31"
									value="${loginTime}" />
							</td>

						</tr>
					</table>
					<div class="subBar">
						<ul>
							<li>
								<div class="buttonActive">
									<div class="buttonContent">
										<button type="submit">
											检索
										</button>
									</div>
								</div>
							</li>

						</ul>
					</div>
				</div>
			</form>
		</div>
		<div class="pageContent">
			<div class="panelBar">
				<ul class="toolBar">
					<li>
						<a class="add" href="auth/GetFromUserAction" target="navTab"
							rel="add"><span>添加</span> </a>
					</li>
					<li>
						<a class="delete" href="auth/DeleteUserAction?uid={sid_user}"
							target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
					</li>
					<li>
						<a class="edit" href="auth/GetFromUserAction?uid={sid_user}"
							target="navTab" rel="edit"><span>修改</span> </a>
					</li>
					<li class="line">
						line
					</li>

				</ul>
			</div>
			<table class="table" width="100%" layoutH="138">
				<thead>
					<tr>
						<th>
							用户名
						</th>
						<th width="108px">
							密码
						</th>
						<th>
							邮箱
						</th>
						<th>
							创建日期
						</th>
						<th>
							更新日期
						</th>
						<th>
							最后登录日期
						</th>

					</tr>
				</thead>
				<tbody>
					<s:iterator value="targetList" status="st">
						<tr target="sid_user" rel="${userid}">
							<td>
								${usernam}
							</td>
							<td>
								${password}
							</td>
							<td>
								${mailads}
							</td>
							<td>
								${crttim}
							</td>
							<td>
								${updtim}
							</td>
							<td>
								${logintim}
							</td>
						</tr>
					</s:iterator>

				</tbody>
			</table>
			<div class="panelBar">
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


				<div class="pagination" targetType="navTab"
					totalCount="${totalCount}" numPerPage="${numPerPage}"
					pageNumShown="${pageNumShown}" currentPage="${pageNum}"></div>

			</div>
		</div>

	</body>
</html>