<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>test</title>
	<script src="resource/js/util.js" type="text/javascript" />	
	<script src="resource/js/jquery.form.min.js" type="text/javascript" />

<script language='javascript'>
	$(function() { 
    	var imgPath="resource/UploadImages/";
    	$('#backjsonForm').ajaxForm({ 
        	dataType:  'json', 
        	success:   function(data){   	
        	$("#backimg").attr("src",imgPath+data["imageFileName"]);
        	alert(data["imageFileName"]);
        	$("#back").val(data["imageFileName"]);
        } 
    	}); 
    	$('#frontjsonForm').ajaxForm({ 
        	dataType:  'json', 
        	success:   function(data){   	
        	$("#frontimg").attr("src",imgPath+data["imageFileName"]);
        } 
    	}); 
	});

			$('#submit').click(
				function() {
				return duoduoNavTabSearch($('#form'),
						'card/GenerateCardAction', '我的名片');
			});

</script>
	</head>
	<body>
		<div class="page unitBox" layoutH="1">
			<div class="pageFormContent">
				<div style="margin-right: 320px; overflow: auto;">
					<form method="post" action="card/GenerateCardAction"
						class="pageForm required-validate" id="form">


						<div class="tabs" currentIndex="0" eventType="click">
							<div class="tabsHeader">
								<div class="tabsHeaderContent">
									<ul>
										<li>
											<a href="javascript:;"><span>名片信息</span> </a>
										</li>
										<li>
											<a href="javascript:;"><span>住址（1）</span> </a>
										</li>
										<li>
											<a href="javascript:;"><span>住址（2）</span> </a>
										</li>
										<li>
											<a href="javascript:;"><span>个人信息</span> </a>
										</li>
										<li>
											<a href="javascript:;"><span>公司信息</span> </a>
										</li>
										<li>
											<a href="javascript:;"><span>权限设置</span> </a>
										</li>
									</ul>
								</div>
							</div>
							<div class="tabsContent" style="height: 80%;">
								<!-- 选项卡面板1 -->
								<div layouth="97" class="pageFormContent"
									style="height: 244px; overflow: auto;">
									<h2 class="contentTitle">
										名片基本信息
									</h2>
									<p>
										<label>
											名片正面路径：
										</label>
										<input type="file" class="valid">
										<input type="text" id="front" name="trnMid.midfront" value="">
									</p>
									<p>
										<label>
											名片反面路径：
										</label>
										<input type="file" class="valid">
										<input type="hidden" id="back" name="trnMid.midback" value="boy.jpg">
									</p>

									<p>
										<label>
											创建者（~~测试用~~）：
										</label>
										<input type="text" size="30" class="required textInput"
											name="trnMid.crtusr">
									</p>

									<p>
										<label>
											拥有者（~~测试用~~）：
										</label>
										<input type="text" size="30" class="textInput"
											name="trnMid.owuserid">
									</p>
									<p>
										<label>
											公司名称：
										</label>
										<input type="text" alt="请输入公司名称" size="30"
											class="required textInput" name="trnNc.comjnam"
											id="trnNc.comjnam">
										<label for="trnNc.comjnam" class="alt"
											style="width: 188px; top: 5px; left: 130px; opacity: 1; display: none;">
											请输入公司名称
										</label>
									</p>
									<p>
										<label>
											公司名称（拼音）：
										</label>
										<input type="text" size="30" class="textInput"
											name="trnNc.comjnamkn">
									</p>
									<p>
										<label>
											公司名称（英文）：
										</label>
										<input type="text" size="30" class="textInput"
											name="trnNc.comenam">
									</p>
									<p>
										<label>
											部门名称：
										</label>
										<input type="text" size="30" class="required textInput"
											name="trnNc.postnam">
									</p>
									<p>
										<label>
											职务：
										</label>
										<input type="text" size="30" class="required textInput"
											name="trnNc.offposi">
									</p>
									<p>
										<label>
											姓名：
										</label>
										<input type="text" size="30" class="required textInput"
											alt="请输入您的姓名" name="trnNc.firstnam" id="trnNc.firstnam">
										<label class="alt" for="trnNc.firstnam"
											style="width: 128px; top: 5px; left: 130px; opacity: 1;">
											请输入姓名
										</label>
									</p>
									<p>
										<label>
											姓名（拼音）：
										</label>
										<input type="text" size="30" class="textInput" alt="请输入您的姓"
											name="trnNc.firstnamkn" id="trnNc.firstnamkn">
										<label class="alt" for="trnNc.firstnamkn"
											style="width: 128px; top: 5px; left: 130px; opacity: 1;">
											请输入您的姓名拼音
										</label>
									</p>

								</div>
								<!-- 选项卡面板2 -->
								<div layouth="97" class="pageFormContent"
									style="height: 244px; overflow: auto;">
									<h2 class="contentTitle">
										住址1
									</h2>
									<dl class="nowrap">
										<dt>
											邮政编码：
										</dt>
										<dd>
											<input type="text" size="30" class="textInput"
												name="trnNc.postalnum1">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											住址：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.adsadmindiv1"
												class="textInput">
										</dd>
									</dl>

									<dl class="nowrap">
										<dt>
											电话1：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.telfist1"
												class="textInput">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											电话2：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.telsecd1"
												class="textInput">
										</dd>
									</dl>
									<div class="divider"></div>

									<dl class="nowrap">
										<dt>
											手机：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.mobiletel1"
												class="textInput">
										</dd>
									</dl>

									<div class="divider"></div>

									<dl class="nowrap">
										<dt>
											传真：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.fax1"
												class="textInput">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											电子邮件：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.email1"
												class="textInput">
										</dd>
									</dl>

									<div class="divider"></div>
									<dl class="nowrap">
										<dt>
											URL：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.url1"
												class="textInput">
										</dd>
									</dl>
								</div>

								<!-- 选项卡面板3 -->
								<div layouth="97" class="pageFormContent"
									style="height: 244px; overflow: auto;">
									<h2 class="contentTitle">
										住址2
									</h2>

									<dl class="nowrap">
										<dt>
											邮政编码：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.postalnum2"
												class="textInput">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											住址：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.adsadmindiv2"
												class="textInput">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											电话1：
										</dt>
										<dd>
											<input type="text" name="trnNc.telfist2" class="textInput"
												size="30" alt="请输入您的电话" />
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											电话2：
										</dt>
										<dd>
											<input type="text" name="trnNc.telsecd2" class="textInput"
												size="30" alt="请输入您的电话" />
										</dd>
									</dl>
									<div class="divider"></div>

									<dl class="nowrap">
										<dt>
											手机：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.mobiletel2"
												class="textInput">
										</dd>
									</dl>

									<div class="divider"></div>

									<dl class="nowrap">
										<dt>
											传真：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.fax2"
												class="textInput">
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											电子邮件：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.email2"
												class="textInput">
										</dd>
									</dl>

									<div class="divider"></div>
									<dl class="nowrap">
										<dt>
											URL：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.url2"
												class="textInput">
										</dd>
									</dl>
								</div>
								<!-- 选项卡面板4 -->
								<div layouth="97" class="pageFormContent"
									style="height: 244px; overflow: auto;">
									<h2 class="contentTitle">
										个人信息
									</h2>
									<dl class="nowrap">
										<dt>
											性别：
										</dt>
										<dd>
											<select class="textInput" name="trnNc.sexkub" width="30">
												<option value="">
													==请选择==
												</option>
												<option value="A">
													男
												</option>
												<option value="B">
													女
												</option>
											</select>
											<span class="unit">性</span>
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											血型：
										</dt>
										<dd>
											<select class="textInput" name="trnNc.blodkub">
												<option value="">
													==请选择==
												</option>
												<option value="A">
													A
												</option>
												<option value="B">
													B
												</option>
												<option value="AB">
													AB
												</option>
												<option value="O">
													O
												</option>
												<option value="其他">
													其他
												</option>
											</select>
											<span class="unit">型</span>
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											职业：
										</dt>
										<dd>
											<input type="text" name="trnNc.jobkub" size="30"
												class="textInput" />
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											出生日期：
										</dt>
										<dd>
											<input type="text" size="30" class="date textInput" name="">
											<a href="javascript:;" class="inputDateButton">选择</a>
										</dd>
									</dl>

									<dl class="nowrap">
										<dt>
											备忘录：
										</dt>
										<dd>
											<textarea name="trnNc.memo" cols="80" rows="3"></textarea>
										</dd>
									</dl>

								</div>
								<!-- 选项卡面板5 -->
								<div class="pageFormContent nowrap" layoutH="97">
									<h2 class="contentTitle">
										公司信息
									</h2>
									<dl>
										<dt>
											所属行业名：
										</dt>
										<dd>
											<input type="text" name="trnNc.bustypnam" size="30"
												class="textInput" />
										</dd>
									</dl>

									<dl>
										<dt>
											成立日期：
										</dt>
										<dd>
											<input type="text" size="30" class="date textInput"
												name="trnNc.fondym">
											<a href="javascript:;" class="inputDateButton">选择</a>
										</dd>
									</dl>

									<dl>
										<dt>
											资金数：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.capital"
												class="number" />
										</dd>
									</dl>
									<dl>
										<dt>
											员工数：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.emplonum"
												class="digits" />
										</dd>
									</dl>
									<dl>
										<dt>
											证券代码（数字）：
										</dt>
										<dd>
											<input type="text" alt="请输入数字" size="30"
												class="digits textInput" name="trnNc.bondcode" id="code">
											<label for="code" class="alt"
												style="width: 188px; top: 5px; left: 130px; opacity: 1;">
												请输入数字
											</label>
										</dd>
									</dl>

									<dl class="nowrap">
										<dt>
											法人代表姓名：
										</dt>
										<dd>
											<input type="text" size="30" name="trnNc.reptannam"
												class="textInput">
										</dd>
									</dl>

									<div class="divider"></div>
								</div>
								<!-- 选项卡面板6 -->
								<div class="pageFormContent nowrap" layoutH="97">
									<h2 class="contentTitle">
										权限设置
									</h2>

									<dl class="nowrap">
										<dt>
											公开：
										</dt>
										<dd>
											<select class="textInput" name="trnMid.sharekub" width="30">
												<option value="">
													==请选择==
												</option>
												<option value="0">
													共有
												</option>
												<option value="1" selected="selected">
													非公有
												</option>
											</select>
										</dd>
									</dl>
									<dl class="nowrap">
										<dt>
											重要度：
										</dt>
										<dd>
											<select class="textInput" name="trnNc.imptantkub" width="30">
												<option value="">
													==请选择==
												</option>
												<option value="1">
													非常重要
												</option>
												<option value="2">
													比较重要
												</option>
												<option value="3">
													重要
												</option>
											</select>
										</dd>
									</dl>

									<dl class="nowrap">
										<dt>
											关系：
										</dt>
										<dd>
											<select class="textInput" name="trnNc.relationkub">
												<option value="">
													==请选择==
												</option>
												<option value="1">
													朋友
												</option>
												<option value="2">
													亲属
												</option>
												<option value="3">
													同事
												</option>
											</select>
										</dd>
									</dl>

									<div class="divider"></div>
								</div>
								<div class="tabsFooter">
									<div class="tabsFooterContent"></div>
								</div>
							</div>
						</div>

						<div class="formBar">
							<ul>
								<li>
									<label>
										<input type="checkbox" value="0" name="trnMid.owbusflg">
										设为自己的名片
									</label>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit" id="submit">
												生成名片
											</button>
										</div>
									</div>
								</li>
								<li>
									<div class="button">
										<div class="buttonContent">
											<button type="reset" class="close">
												重置
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
			<div style="position: absolute; top: 10px; right: 10px; width:310px;">
				<table border="1"  width="320px">
					<tr><td height="40" align="center">
					<font color="red">名片正面图片</font></td></tr>
					<tr><td>		
						<s:form id="frontjsonForm" action ="testFolder/fileUpload" method ="post" enctype ="multipart/form-data" target="hidden_frame">
       	 				<input type="file" name="myFile"><input type="submit" value="上传" />
       	 				<iframe id="hidden_frame" name="hidden_frame" style="display:none"></iframe>
						</s:form>
					</td></tr>
					<tr><td>
						<img id="frontimg" width="310px" height="200px" src="resource/img/baby.jpg" />
					</td></tr>
					<tr><td height="40" align="center"><font color="red">名片反面图片</font></td></tr>
					<tr><td>
						<s:form id="backjsonForm" action ="testFolder/fileUpload" method ="post" enctype ="multipart/form-data" target="hidden_frame">
       	 				<input type="file" name="myFile"><input type="submit" value="上传" />  	 	
       	 				<iframe id="hidden_frame" name="hidden_frame" style="display:none"></iframe>
						</s:form>
					</td></tr>
					<tr><td>
						<img id="backimg" width="310px" height="200px" src="resource/img/baby.jpg" />
					</td></tr>
				</table>
			</div>
			</div>
		</div>
	</body>
</html>