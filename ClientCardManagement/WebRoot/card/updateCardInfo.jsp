<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String imgPath = "http://localhost:8080/ClientCardManagement/resource/UploadImages/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>test</title>
	<script src="resource/js/util.js" type="text/javascript" />	
	<script language='javascript'> 
	function showItem(many, one){
		var sexkub=document.getElementById(many);
 		var sex=document.getElementById(one).value;
		for(var h=0;h<sexkub.options.length;h++){
   			if(sexkub.options[h].value==sex){
    		 	sexkub.options[h].selected=true;  
    		 	break;
    		}
		}
	}
	
		$('#submit').click(function(){
			return duoduoNavTabSearch($('#form'),'card/GenerateCardAction','我的名片');
		});	
    </script> 
	</head>
	<body>
		<form method="post" action="card/GenerateCardAction" class="pageForm required-validate"
			id="form">

<table border="1" width="98%">
    <tr >
	<td width="30%" height="80%">
        <table width="100%" height="100%" border="1">
            <tr>
                <td height="50" align="center">名片正面图片</td>
            </tr>
            <tr>
                <td><img width="300" height="200" src="resource/img/baby.jpg" /></td>
            </tr>
            <tr>
            	<td height="50" align="center">名片反面图片</td>
            </tr>
            <tr>
                 <td><img width="300" height="200" src="resource/img/boy.jpg"/></td>
            </tr> 		 
        </table>
	</td>
  	<td width="70%">
        <table width="100%" height="90%" border="0">
            <tr>
                <td>
                
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
							<input type="hidden" name="trnMid.midfront" value="${trnMid.midfront}">
						</p>
						<p>
							<label>
								名片反面路径：
							</label>
							<input type="file" class="valid">
							<input type="hidden" name="trnMid.midback" value="${trnMid.midback}">
						</p>
 
						<p>
							<label>
								创建者（~~测试用~~）：
							</label>
							<input type="text" size="30" class="required textInput" name="trnMid.crtusr" value="${trnMid.crtusr}">
						</p>

						<p>
							<label>
								公司名称：
							</label>
							<input type="text" alt="请输入公司名称"  size="30"
												class="required textInput" name="trnNc.comjnam" value="${target.comjnam}">
							<label for="trnNc.comjnam" class="alt"
								style="width: 188px; top: 5px; left: 130px; opacity: 1; display: none;">
								请输入公司名称
							</label>
						</p>
						<p>
							<label>
								公司名称（拼音）：
							</label>
							<input type="text" size="30" class="textInput" name="trnNc.comjnamkn" value="${target.comjnamkn}">
						</p>
						<p>
							<label>
								公司名称（英文）：
							</label>
							<input type="text" size="30" class="textInput" name="trnNc.comenam" value="${target.comenam}">
						</p>
						<p>
							<label>
								部门名称：
							</label>
							<input type="text" size="30" class="required textInput" name="trnNc.postnam" value="${target.postnam}">
						</p>
						<p>
							<label>
								职务：
							</label>
							<input type="text" size="30" class="required textInput" name="trnNc.offposi" value="${target.offposi}">
						</p>
						<p>
							<label>
								姓名：
							</label>
							<input type="text" size="30" class="required textInput" name="trnNc.firstnam" value="${target.firstnam}">
						</p>
						<p>
							<label>
								姓名（拼音）：
							</label>
							<input type="text" size="30" class="textInput"  name="trnNc.firstnamkn" value="${target.firstnamkn}">
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
								<input type="text" size="30" name="trnNc.postalnum1" class="textInput" value="${target.postalnum1}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								住址：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.adsadmindiv1" class="textInput" value="${target.adsadmindiv1}">
							</dd>
						</dl>

						<dl class="nowrap">
							<dt>
								电话1：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.telfist1" class="textInput" value="${target.telfist1}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								电话2：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.telsecd1" class="textInput" value="${target.telsecd1}">
							</dd>
						</dl>
						<div class="divider"></div>

						<dl class="nowrap">
							<dt>
								手机：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.mobiletel1" class="textInput" value="${target.mobiletel1}">
							</dd>
						</dl>

						<div class="divider"></div>

						<dl class="nowrap">
							<dt>
								传真：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.fax1" class="textInput" value="${target.fax1}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								电子邮件：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.email1" class="textInput" value="${target.email1}">
							</dd>
						</dl>

						<div class="divider"></div>
						<dl class="nowrap">
							<dt>
								URL：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.url1" class="textInput" value="${target.url1}">
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
								<input type="text" size="30" name="trnNc.postalnum2" class="textInput" value="${target.postalnum2}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								住址：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.adsadmindiv2" class="textInput" value="${target.adsadmindiv2}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								电话1：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.telfist2" class="textInput" value="${target.telfist2}" alt="请输入您的电话" />		
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								电话2：
							</dt>
							<dd>
								<input type="text" name="trnNc.telsecd2" class="textInput" value="${target.telsecd2}" size="30" alt="请输入您的电话" />		
							</dd>
						</dl>
						<div class="divider"></div>

						<dl class="nowrap">
							<dt>
								手机：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.mobiletel2" value="${target.mobiletel2}" class="textInput">
							</dd>
						</dl>

						<div class="divider"></div>

						<dl class="nowrap">
							<dt>
								传真：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.fax2" class="textInput" value="${target.fax2}">
							</dd>
						</dl>
						<dl class="nowrap">
							<dt>
								电子邮件：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.email2" class="textInput" value="${target.email2}">
							</dd>
						</dl>

						<div class="divider"></div>
						<dl class="nowrap">
							<dt>
								URL：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.url2" class="textInput" value="${target.url2}">
							</dd>
						</dl>
					</div>
					<!-- 选项卡面板4 -->
					<div layouth="97" class="pageFormContent"
						style="height: 244px; overflow: auto;">
						<h2 class="contentTitle">
							个人信息
						</h2>
<script language='javascript'> 
	showItem('trnNc.sexkub', 'sex');
</script> 
						<dl class="nowrap">
							<dt>
								性别：
							</dt>
							<dd>
							<input type="hidden" id="sex" value="${target.sexkub}"/>
							<select class="textInput" name="trnNc.sexkub" id="trnNc.sexkub">
								<option value="">
									==请选择==
								</option>
								<option value="1">
									男
								</option>
								<option value="0">
									女
								</option>			
							</select>
							<span class="unit">性</span>
							</dd>
						</dl>
<script language='javascript'> 
	showItem('trnNc.blodkub', 'bloodtype');
</script> 
						<dl class="nowrap">
							<dt>
								血型：
							</dt>
							<dd>
							<input type="hidden" id="bloodtype" value="${target.blodkub}"/>
							<select class="textInput" name="trnNc.blodkub" id="trnNc.blodkub">
								<option value="">
									==请选择==
								</option>
								<option value="1">
									A
								</option>
								<option value="2">
									B
								</option>
								<option value="3">
									AB
								</option>
								<option value="4">
									O
								</option>
								<option value="5">
									不明
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
								<input type="text" name="trnNc.jobkub" size="30" class="textInput" value="${target.jobkub}"  />			
							</dd>
						</dl>
						
						<dl class="nowrap">
							<dt>
								出生日期：
							</dt>
							<dd>
							
							<table>
								<tr>
								<td>
							<input type="hidden" id="sex" value="${target.sexkub}"/>
							<select class="textInput" name="trnNc.sexkub" id="trnNc.sexkub">
								<option value="">
									==请选择==
								</option>
								<%for(int i = 1920; i < 2013; i++){ %>
								<option value="<%=i%>">
									<%=i%>
								</option>
								<%} %>	 
							</select>
							<span class="unit">年</span></td>
								<td><input type="hidden" id="sex" value="${target.sexkub}"/>
							<select class="textInput" name="trnNc.sexkub" id="trnNc.sexkub">
								<option value="">
									==请选择==
								</option>
								<%for(int i = 1; i < 13; i++){ %>
								<option value="<%=i%>">
									<%=i%>
								</option>
								<%} %>	 	
							</select>
							<span class="unit">月</span></td>
								<td><input type="hidden" id="sex" value="${target.sexkub}"/>
							<select class="textInput" name="trnNc.sexkub" id="trnNc.sexkub">
								<option value="">
									==请选择==
								</option>
								<%for(int i = 1; i <= 31; i++){ %>
								<option value="<%=i%>">
									<%=i%>
								</option>
								<%} %>	 	
							</select>
							<span class="unit">日</span></td>
								</tr>
							</table>	 
						</dl>
						
						<dl class="nowrap">
							<dt>
								出生日期：
							</dt>
							<dd>
								<input type="text" size="30" class="date textInput" name="" value="">
								<a href="javascript:;" class="inputDateButton">选择</a>
							</dd>
						</dl>
			 
						<dl class="nowrap">
							<dt>
								备忘录：
							</dt>
							<dd>
								<textarea name="trnNc.memo" cols="80" rows="3" ><%="${target.memo}" %></textarea>
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
								<input type="text" name="trnNc.bustypnam" size="30" class="textInput" value="${target.bustypnam}" />
							</dd>
						</dl>
						
						<dl>
							<dt>
								成立日期：
							</dt>
							<dd>
								<input type="text" size="30" class="date textInput"
													name="trnNc.fondym" value="">
								<a href="javascript:;" class="inputDateButton">选择</a>
							</dd>
						</dl>
				
						<dl>
							<dt>
								资金数：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.capital" class="number" value="${target.capital}" />
							</dd>
						</dl>
						<dl>
							<dt>
								员工数：
							</dt>
							<dd>
								<input type="text" size="30" name="trnNc.emplonum" class="digits" value="${target.emplonum}" />
							</dd>
						</dl>
						<dl>
							<dt>
								证券代码（数字）：
							</dt>
							<dd>
								<input type="text" alt="请输入数字" size="30" class="digits textInput"
															name="trnNc.bondcode" id="code" value="${target.bondcode}">
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
								<input type="text" size="30" name="trnNc.reptannam" class="textInput" value="${target.reptannam}">
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
                
                
                
                
                
                </td>
            </tr>
        </table></td>
    </tr>
	<tr><td colspan="2" align="right"  height="20%">
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
			</div></td></tr>
</table>			
			
			
			
						
			
			
	
		</form>

	</body>
</html>