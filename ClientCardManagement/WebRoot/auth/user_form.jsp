<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
	<form method="post" action="auth/SaveUserAction"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>
					用户名：
				</label>
				<input name="target.usernam" class="required" type="text"
					value="${target.usernam}" />
			</p>
			<dl class="nowrap">
				<dt>
					密码：
				</dt>
				<dd>
					<input name="target.password" class="required" minlength="6"
						type="text" value="${target.password}" />

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


			<p>
				<label>
					所属用户组：
				</label>
				<select class="combox" name="target.userkub" class="required"">
					<option value="0">
						普通用户组
					</option>
					<option value="1"
						<s:if test="target.userkub==1"> selected="selected"</s:if>>
						管理员用户组
					</option>

				</select>
			</p>

			
			<input type="hidden" name="target.delflg" value="0" />
			<input type="hidden" name="target.crttim" value="${target.crttim}" />
			<input type="hidden" name="navTabId" value="用户管理" />
			<input type="hidden" name="uid" value="${uid}" />
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
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
