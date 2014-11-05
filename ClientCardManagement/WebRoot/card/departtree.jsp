<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test='needSearchURL!="0"'>
	<script type="text/javascript">
	
	
	$(".company").each( function() {
		var $company = $(this);
		$($company).click( function() {
			partRefresh("jbsxBox", {
				"comjnam" : $($company).html(),
				"name" : ""
			}, "card/FuzzyCardSearchAction");

		});
	});
	$(".depart").each( function() {
		var $depart = $(this);
		$(this).click( function() {
			partRefresh("jbsxBox", {
				"comjnam" : $($depart).attr('rel'),
				"depart" : $($depart).html(),
				
			}, "card/FuzzyCardSearchAction");
			
		});
	});
	$(".clerk").each( function() {
		var $clerk = $(this);
		$(this).click( function() {
		partRefresh("jbsxBox", {
				"uid" : $($clerk).attr('rel'),
			}, "card/GetCardByIdAction");
		});
	});
	
</script>
</s:if>

<div <s:if test='needSearchURL=="0"'>layoutH="1"</s:if>>
	<s:iterator value="trees">
		<!--						//下面的trees即为各个公司的根节点-->
		<s:iterator value="trees" var="root">

			<ul class="tree treeFolder collapse">
				<li>
					<a class="company" href="javascript">${name}</a>
					<s:set name="company" value='%{name}'></s:set>
					<!--									//部门结点-->
					<s:iterator value="list">
						<ul>
							<li>
								<a
									class=<s:if test="!isLeaf">"depart" rel='<s:property value="#company"/>'</s:if>
									<s:else>"clerk" rel="${id}"</s:else> href="javascript">${name}</a>

								<s:if test="!isLeaf">
									<ul>
										<!--												职员-->
										<s:iterator value="list">
											<li>
												<a class="clerk" href="javascript" rel="${id}">${name}</a>
											</li>
										</s:iterator>
									</ul>
								</s:if>

							</li>
						</ul>
					</s:iterator>
				</li>

			</ul>


		</s:iterator>
	</s:iterator>
</div>
