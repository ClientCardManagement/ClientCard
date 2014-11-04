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
		partRefresh("jbsxBox", {}, "card/GetAllCardListAction");
		$.ajaxSettings.global = false;
		partRefresh("departtree", {},
				"card/GetDepartTreeAction?needSearchURL='1'");
		$.ajaxSettings.global = true;
	})
	$("#search").click( function() {
		
	//alert($("#scomjnam").val()+" - "+$("#sdepart").val()+" - "+$("#sname").val())
		partRefresh("jbsxBox", {
			"comjnam" : $("#scomjnam").val(),
			"depart" : $("#sdepart").val(),
			"name" : $("#sname").val()
		}, "card/FuzzyCardSearchAction");
	});
</script>
<div class="pageContent" style="padding: 5px">

	<div class="panel" defH="40">
		<h1>
			职员名片
		</h1>

		<div class="searchBar">
			公司：
			<input id="scomjnam" type="text" name="comjnam">
			部门：
			<input id="sdepart" type="text" name="depart">
			职员姓名：
			<input id="sname" type="text" name="name">
			<ul class="rightTools">

				<li>
					<a id="search" class="button" mask="true"><span>检索</span> </a>

				</li>
				<li>
					<a class="button" mask="true" href="card/GetAllCardListAction"
						target="ajax" rel="jbsxBox"><span>全部名片</span> </a>

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
						<a href="javascript:;"><span>名片一览</span> </a>
					</li>

				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
<!-- 
				<div id="departtree" layoutH="146"
					style="float: left; display: block; overflow: auto; width: 180px; border: solid 1px #CCC; line-height: 21px; background: #fff">
				</div>
-->
				<div id="jbsxBox" class="unitBox" style="margin-left: 186px;">

				</div>

			</div>


		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>

</div>




