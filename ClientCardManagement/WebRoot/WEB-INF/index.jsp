<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>客户名片管理系统</title>

<link href="resource/dwz-ria/themes/default/style.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="resource/dwz-ria/themes/css/core.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="resource/dwz-ria/themes/css/print.css" rel="stylesheet"
	type="text/css" media="print" />
<link href="resource/dwz-ria/uploadify/css/uploadify.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="resource/css/master.css" rel="stylesheet" type="text/css"
	media="screen" />
<!--[if IE]>
<link href="resource/dwz-ria/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="resource/dwz-ria/js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="resource/dwz-ria/js/jquery-1.7.2.min.js"
	type="text/javascript"></script>
<script src="resource/dwz-ria/js/jquery.cookie.js"
	type="text/javascript"></script>
<script src="resource/dwz-ria/js/jquery.validate.js"
	type="text/javascript"></script>
<script src="resource/dwz-ria/js/jquery.bgiframe.js"
	type="text/javascript"></script>
<script src="resource/dwz-ria/xheditor/xheditor-1.1.14-zh-cn.min.js"
	type="text/javascript"></script>
<script src="resource/dwz-ria/uploadify/scripts/jquery.uploadify.js"
	type="text/javascript"></script>


<script src="resource/dwz-ria/bin/dwz.min.js" type="text/javascript"></script>

<script src="resource/dwz-ria/js/dwz.regional.zh.js"
	type="text/javascript"></script>
<script src="resource/js/menu.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		DWZ.init("resource/dwz-ria/dwz.frag.xml", {
			loginUrl : "resource/dwz-ria/login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"resource/dwz-ria/login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "resource/dwz-ria/themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
		//$.ajaxSettings.global = false;
	});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">

				<div class="title_white">客户名片管理系统</div>
				<ul class="nav">
					<li><a><s:property value="#session.username" /> </a></li>
					<li><a href="logoutAction">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default">
						<div class="selected">蓝色</div></li>
					<li theme="green">
						<div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple">
						<div>紫色</div></li>
					<li theme="silver">
						<div>银色</div></li>
					<li theme="azure">
						<div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">

					<div class="accordionHeader">
						<h2>
							<span>Folder</span> 用户管理
						</h2>
					</div>
					<div class="accordionContent">

						<ul class="tree treeFolder collapse">
							<li><a
								href="auth/ModifyUserInforAction?uid=<s:property value="#session.userid" />"
								target="navTab" rel="用户信息修改">用户信息修改</a></li>

							<s:if test='#session.userkub=="1"'>
								<li><a href="auth/GetListUserAction" target="navTab"
									rel="用户管理">用户管理</a></li>
							</s:if>
						</ul>

					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span> 名片管理

						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder collapse">
							<li><a href="card/allcardglance.jsp" target="navTab"
								rel="名片一览">名片一览</a></li>
							<li><a href="mycard/MyCardAction" target="navTab" rel="名片生成">名片生成</a>
							</li>
							<li><a href="card/mycardglance.jsp" target="navTab"
								rel="我的名片">我的名片</a></li>
							<li><a href="card/GetDepartTreeAction" target="navTab" rel="公司部门视图">公司部门视图</a>
							</li>
						</ul>

					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span> 组管理
						</h2>
					</div>
					<div class="accordionContent">

						<ul class="tree treeFolder collapse">
							<li><a target="navTab" rel="组管理" href="card/GetListGroupManageAction">组管理</a></li>
						</ul>

					</div>
					<div class="accordionHeader">
						<h2>
							<span>Folder</span> 访问日志管理
						</h2>
					</div>
					<div class="accordionContent">

						<ul class="tree treeFolder collapse">
							<li><a target="navTab" rel="访问日志管理" href="card/GetListTrnAccessAction">访问日志管理</a>
							</li>
						</ul>

					</div>


				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span> </span> </a></li>
						</ul>
					</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a>
					</li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<p>
								<span>客户名片管理系统简介：</span>
							</p>
						</div>
						<div class="pageFormContent" layoutH="80"
							style="margin-right:230px">
							<pre style="margin:5px;line-height:2em;font-size:16px;">
			本系统为客户名片管理系统，项目的预期目标是实现一个B/S架构的名片管理系统。
			主要实现的是公司客户名片的管理。主要由名片管理、组管理、访问日志管理和公司部门视图等模块构成。
			本项目实施的意义是方便公司人员查找客户名片，提高工作效率
							</pre>
							<div class="divider"></div>
							<h2>问题反馈:</h2>
							<pre style="margin:5px;line-height:1.6em;font-size:15px;">
			如果遇到什么问题，请联系TEL：15651118488
					       Email：zhugexubin@163.com
					       QQ:385248936
					        </pre>

							<div class="divider"></div>
							<h2>有偿服务请联系:</h2>
							<pre style="margin:5px;line-height:1.4em;">
				定制化开发，公司培训，技术支持
				合作电话：010-52897073
				邮箱：support@dwzjs.com
					</pre>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2014</div>
</body>
</html>