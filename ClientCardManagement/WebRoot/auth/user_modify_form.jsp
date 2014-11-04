<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script src="resource/js/user.js" type="text/javascript"></script>

<div class="pageContent">
	<form method="post" action="auth/SaveUserModifyInforAciton"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">


			<p>
				<label>
					用户名：
				</label>
				<input name="target.usernam" class="required" type="text" readonly="readonly"
					value="<s:property value="#session.username" />" />
			</p>
			<dl class="nowrap">
				<dt>
					原密码：
				</dt>
				<dd>
					<input id="oldpassword" name="password" class="required alphanumeric" minlength="6"
						type="password" />

				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					新密码：
				</dt>
				<dd>
					<input id="newpassword" name="target.password" class="required alphanumeric" minlength="6"
						type="password"  />

				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					确认密码：
				</dt>
				<dd>
					<input name="passwordcheck" class="required alphanumeric" equalto="#newpassword" minlength="6"
						type="password"  />

				</dd>
			</dl>
			<dl class="nowrap">
				<dt>
					邮箱：
				</dt>
				<dd>
					<textarea name="target.mailads" class="email" cols="80" rows="2">${target.mailads}</textarea>

				</dd>
			</dl>


			
			<input type="hidden" name="navTabId" value="用户信息修改" />
			<input id="uid" type="hidden" name="uid"
				value="<s:property value="#session.userid" />" />
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div id="submitDiv" class="buttonDisabled">
						<div class="buttonContent">
							<button id="submit" disabled="disabled" type="submit">
								保存
							</button>
						</div>
					</div>
				</li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">
								取消
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
