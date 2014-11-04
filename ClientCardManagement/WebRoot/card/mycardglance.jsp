<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<style type="text/css">
ul.rightTools {
	float: right;
	display: block;
}

ul.rightTools li {
	float: left;
	display: block;
	margin-left: 5px
}
</style>
<script type="text/javascript" src="resource/js/util.js" />
<script type="text/javascript">
	$( function() {
		partRefresh("myCardList", {}, "mycard/GetMyCardListAction");
		$.ajaxSettings.global = false;
		partRefresh("myDepartTree", {},
				"mycard/GetMyDepartTreeAction?needSearchURL='1'");
		$.ajaxSettings.global = true;
	})
	$("#search2").click( function() {;
		partRefresh("myCardList", {
			"comjnam" : $("#comjnam").val(),
			"depart" : $("#depart").val(),
			"name" : $("#name").val()
		}, "mycard/FuzzyCardSearchAction");
	});
</script>
<div class="pageContent" style="padding: 5px">

	<div class="panel" defH="40">
		<h1>
			职员名片
		</h1>

		<div class="searchBar">
			公司：
			<input id="comjnam" type="text" name="comjnam">
			
			部门：
			<input id="depart" type="text" name="depart">

			职员姓名：
			<input id="name" type="text" name="name">
			<ul class="rightTools">

				<li>
					<a id="search2" class="button" mask="true"><span>检索</span> </a>

				</li>
				<li>
					<a class="button" mask="true" href="mycard/GetMyCardListAction"
						target="ajax" rel="myCardList"><span>全部名片</span> </a>
				</li>

			</ul>
		</div>
	</div>

	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li>
						<a href="javascript:;"><span>我的名片</span> </a>
					</li>

				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
<!-- 
				<div id="myDepartTree" layoutH="146"
					style="float: left; display: block; overflow: auto; width: 180px; border: solid 1px #CCC; line-height: 21px; background: #fff">
				</div>
 -->
				<div id="myCardList" class="unitBox" style="margin-left: 186px;">
				</div>

			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>

</div>




