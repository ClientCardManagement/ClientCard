
function partRefresh(rel,data,URL){
	var rel = "#"+rel
	var $obj = $(rel);
	$obj.loadUrl(URL, data, function() {
				$obj.find("[layoutH]").layoutH();
			});
}

function duoduoNavTabSearch(form,actionURL, navTabId){
	
	var $form = $(form);
	if (form[DWZ.pageInfo.pageNum]) form[DWZ.pageInfo.pageNum].value = 1;
	navTab.openTab(navTabId,'blank.html',{title:navTabId,fresh:false,});
	navTab.reload(actionURL, {data: $form.serializeArray(), navTabId:navTabId});
	return false;
}
function getIds(id) {
	var ids = "";
	var selecter = "#"+id+" input:checked";
	$(selecter).each( function(i) {
		var val = $(this).val();
		ids += i == 0 ? val : "," + val;
	});
	return ids;
}
function dialogAction(element,
		event){
	
		var $this = $(element);
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
//		DWZ.debug(url);
//		if (!url.isFinishedTm()) {
//			alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
//			return false;
//		}
		$.pdialog.open(url, rel, title, options);
		
		return false;
	
}