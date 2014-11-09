<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
<script type="text/javascript" src="resource/js/util.js" /></script>

<script type="text/javascript" src="js/dtree.js"></script>

<script type="text/javascript">
	partRefresh("jbsxBoxZu", {}, "group/SearchAllTrnGroupNcAction");
</script>

<script type="text/javascript">
			  var i =0;
			   tree=new dTree('tree');
	           tree.add(0,-1,'');
			</script>
<s:iterator value="targetPra">
	<script type="text/javascript">		
		tree.add(${groupid},0,'${groupnam}','javascript','${groupnote}','${groupid}');       
	</script>
</s:iterator>
<s:iterator value="targetChi">
	<script type="text/javascript">		
		tree.add(${groupid},${prgroupid},'${groupnam}','javascript','${groupnote}','${groupid}');       
	</script>
</s:iterator>
<script type="text/javascript"> 
	         	document.getElementById("tree").innerHTML=tree;
	         	$(".node,.nodeSel").each(function(){
	         		var node = $(this);
	         		$(node).click(function(){
	         			$('#groupname').val($(this).html());
	         			$('#groupid').val($(this).attr('target'));
	         			$('#groupid').attr('rel',$("#groupid").val());
	         			
	         			
	        	 		$('#delete').attr("title","确定要删除吗?");
	        	 		$('#delete').attr("href","group/DeleteGroupManageAction?uid="+$('#groupid').val());
	         			
	         			$('#delete').removeAttr('class');
	         			$('#delete').addClass('button');
	         			
	         			$('#update').attr("href","group/GetFromGroupManageAction?uid="+$('#groupid').val());
	         			$('#update').removeAttr('class');
	         			$('#update').addClass('button');
	         			
	         			partRefresh("jbsxBoxZu", {}, "group/SearchTrnGroupNcAction?groupid="+$('#groupid').val());
	         			return false;	
	         		})
	         	})
				$('#delete').each(function(){
			      $(this).click(function(event){
			      if($('#groupid').val()=="")return false;
			            var $this = $(this);
			            var title = $this.attr("title");
			            if (title) {
			                  alertMsg.confirm(title, {
			                        okCall: function(){
			                              ajaxTodo($this.attr("href"));
			                        }
			                  });
			           	 } else {
			                  ajaxTodo($this.attr("href"));
			            	}
			            	event.preventDefault()
			      		});
					});
					
				$('#update').each(function(){
			      	$(this).click(function(event){
			      		if($('#groupid').val()=="")return false;
			      		var $this = $(this);
						var title = $this.attr("title") || $this.text();
						var rel = $this.attr("rel") || "_blank";
						var options = {};
						var w = $this.attr("width");
						var h = $this.attr("height");
						if (w) options.width = w;
						if (h) options.height = h;
						options.max = eval($this.attr("max") || "false");
						options.mask = eval($this.attr("mask") || "false");
						options.maxable = eval($this.attr("maxable") || "true");
						options.minable = eval($this.attr("minable") || "true");
						options.fresh = eval($this.attr("fresh") || "true");
						options.resizable = eval($this.attr("resizable") || "true");
						options.drawable = eval($this.attr("drawable") || "true");
						options.close = eval($this.attr("close") || "");
						options.param = $this.attr("param") || "";
			
						var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
						DWZ.debug(url);
						if (!url.isFinishedTm()) {
							alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
							return false;
						}
						$.pdialog.open(url, rel, title, options);
						
						return false;
			      	});
			      })
	       	</script>


<div class="pageContent" style="padding: 5px">
	<div class="panel" defH="25">
		<h1>
			组管理
		</h1>
		<div>
			组名：
			<input type="text" id="groupname" readonly="readonly" />
			<input type="hidden" id="groupid" target="sid_user" value=""/>
			<ul class="rightTools">
				<li>
					<a class="button" href="group/GetFromGroupManageAction" mask="true"
						target="dialog" rel="add"><span>新建组</span> </a>
				</li>
				<li>
					<a class="buttonDisabled"  id="delete"><span>删除组</span> </a>
				</li>
				<li>
					<a class="buttonDisabled" mask="true" rel="edit"
					id="update"><span>更新组信息</span>
					</a>
				</li>
				<li>
					<a class="button" href="group/GroupManageAction" target="ajax"
						rel="jbsxBoxZu"><span>查看所有组</span> </a>
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
						<a href="javascript:;"><span>组信息</span> </a>
					</li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>

				<div class="dtree" layoutH="140" id="tree"
					style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">

				</div>

				<div id="jbsxBoxZu" class="unitBox" style="margin-left: 246px;">
				</div>

			</div>

		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>

</div>


