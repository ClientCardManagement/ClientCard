<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="pageContent">
	
	<form method="post" action="card/SaveGroupManageAction" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">

			<div class="unit">
				<label>组名：</label>
				<input type="text" name="target.groupnam" size="30" class="required" maxlength="20" value="${target.groupnam}"/>
			</div>
			<div class="unit">
				<label>父组名：</label>
				
			
				<s:if test='""!=uid&&null!=uid'>
					<select class="combox" name="target.prgroupid" class="required">
					<option value="0">------</option>
						<s:iterator value="targetList" status="st">
							<s:if test="groupid==target.groupid"> </s:if>
							<s:else>
								<option value="${groupid }"
									<s:if test="groupid==target.prgroupid">selected="selected"</s:if>>
										${groupnam}
							</option>
							</s:else>
						</s:iterator>
					</select>
				</s:if>
				<s:else>
					<select class="combox" name="target.prgroupid" class="required"">
					<option value="0">------</option>
						<s:iterator value="targetList" status="st">
							<option value="${groupid }">
								${groupnam}
							</option>
						</s:iterator>
					</select>
				</s:else>
			</div>
			<div class="unit">
				<label>表示顺序：</label>
				<input type="text" name="target.orderdis" size="30" class="digits" maxlength="4" value="${target.orderdis}"/>
			</div>
			<div class="unit">
				<label>组备考：</label>
				<input type="text" name="target.groupnote" size="30" maxlength="20" value="${target.groupnote}"/>
			</div>
			<div class="unit">
				<label>所有者：</label>
				<input type="text" readonly="readonly" size="30" value=<s:property value="#session.username" /> />
			</div>
			<input type="hidden" name="uid" value="${uid}"/>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>

