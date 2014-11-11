<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>追加到组</title>
		<script type="text/javascript">
			function choose(){
					var href = $("#form").attr('action');
					
					var ids = getIds("table_body2");
					if (ids != "") {
						var getHref = href + "?idsString=" + ids;
						$("#form").attr('action', getHref);					
					}
			}
		</script>
	</head>
	<body>
	
	
	<form id="form" method="post" action="group/SaveTrnGroupNcAction" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageContent" style="border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
			<table class="table" width="99%" layoutH="80" rel="jbsxBoxZu">

				<thead>
					<tr>
						<th>
							<input type="checkbox" group="ids" class="checkboxCtrl" checked="checked" >
						</th>
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
				<tbody id="table_body2">
					<s:iterator value="targetList" status="st">
						<tr target="sid_user" rel="${id}">
							<td>
								<input name="ids" type="checkbox" value="${id}" checked="checked"/>
							</td>
							<td>
							
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
		</div>
			
			<table cellspacing="10" width="100%" class="formBar">
				<tr>
					<td width="40%"><input type="radio" checked="checked"  />追加到已存在的组</td>
					<td width="40%">

					<select class="combox" name="groupid" class="required">
						<s:iterator value="groupList" status="st">
							<option value="${groupid }" >
								${groupnam }	
							</option>
						</s:iterator>
					</select>
					</td>
					<td width="20%"><div class="button"><div class="buttonContent"><button type="submit" onclick="choose()">追加</button></div></div></td>
				</tr>
			</table>
		
	</form>
	
	</body>
</html>